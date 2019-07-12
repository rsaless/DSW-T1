import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../../services/api.service';
import { Teatro } from '../../models/teatro'
import { Promocao } from 'src/app/models/promocao';
import {MatDialog, MatDialogRef, MatDialogConfig} from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';
import { JWTService } from 'src/app/services/jwt.service';

@Component({
  selector: 'app-teatro-detalhes',
  templateUrl: './teatro-detalhes.component.html',
  styleUrls: ['./teatro-detalhes.component.css']
})
export class TeatroDetalhesComponent implements OnInit {

  teatro: Teatro = {
    id: '',
    nome: '',
    username: '',
    password: '',
    cidade: '',
    cnpj: '',
  };
  isLoadingResults = true;
  promocoes: Promocao[] = [];

  constructor(
    private route: ActivatedRoute, 
    private api: ApiService, 
    private router: Router,
    private dialog: MatDialog,
    private jwt: JWTService
  ) { }

  async getData(id) {
    this.teatro = await this.api.getTeatro(id).toPromise();
    this.promocoes = await this.api.promocoesPorTeatro(this.teatro.cnpj).toPromise();
    this.isLoadingResults = false;
    console.debug('No issues, I will wait until promise is resolved..');
  }
  ngOnInit() {
    this.getData(this.route.snapshot.params['id']);
  }

  async tentaDeletar(id, cnpj){
    this.promocoes = await this.api.promocoesPorTeatro(cnpj).toPromise(); 
    if (this.promocoes.length != 0 ) this.openDialog(id)
    else this.deleteTeatro(id);
  }

  esvaziaTeatro(promocoes){
    promocoes.forEach(promocao => {
      this.api.deletePromocao(promocao.id);
    });
    console.log("promocoes apagadas")
  }

  deleteTeatro(id) {
    this.isLoadingResults = true;
    this.api.deleteTeatro(id)
      .subscribe(res => {
          this.isLoadingResults = false;
          this.router.navigate(['/teatros']);
        }, (err) => {
          console.log(err);
          this.isLoadingResults = false;
        }
      );
      console.log("teatro apagado")
  }

  openDialog(id) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.data = {
        teatro: this.teatro,
        promocoes: this.promocoes
    };

    const dialogRef = this.dialog.open(DialogComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(
      async data => {
        if (data) {
          await this.esvaziaTeatro(this.promocoes);
          this.deleteTeatro(id);
        }
      }
    ); 

  }
}
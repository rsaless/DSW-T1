import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../../services/api.service';
import { Site } from '../../models/site'
import { Teatro } from '../../models/teatro'
import { Promocao } from '../../models/promocao'

@Component({
  selector: 'app-promocao-detalhes',
  templateUrl: './promocao-detalhes.component.html',
  styleUrls: ['./promocao-detalhes.component.css']
})
export class PromocaoDetalhesComponent implements OnInit {

  promocao: Promocao = { 
    id: '',
    nome_peca: '',
    preco: null,
    dia_hora: new Date(),
    site: new Site(),
    teatro: new Teatro(),
  };
  isLoadingResults = true;

  constructor(
    private route: ActivatedRoute, 
    private api: ApiService, 
    private router: Router
  ) { }

  async getData(id) {
    this.promocao = await this.api.getPromocao(id).toPromise();
    this.isLoadingResults = false;
    console.debug('No issues, I will wait until promise is resolved..');
  }
  ngOnInit() {
    this.getData(this.route.snapshot.params['id']);
  }
  deletePromocao(id) {
    this.isLoadingResults = true;
    this.api.deletePromocao(id)
      .subscribe(res => {
          this.isLoadingResults = false;
          this.router.navigate(['/promocoes']);
        }, (err) => {
          console.log(err);
          this.isLoadingResults = false;
        }
      );
  }



}

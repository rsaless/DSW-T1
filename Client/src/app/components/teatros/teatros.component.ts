import { Component, OnInit } from '@angular/core';
import { ApiService } from "../../services/api.service";
import { Teatro } from '../../models/teatro';

@Component({
  selector: 'app-teatros',
  templateUrl: './teatros.component.html',
  styleUrls: ['./teatros.component.css']
})
export class TeatrosComponent implements OnInit {

  displayedColumns: string[] = ['nome', 'username', 'cidade', 'cnpj'];
  teatros: Teatro[] = [];
  isLoadingResults = true;
  query: string = '';

  constructor(private api: ApiService) { }

  ngOnInit() {
    this.getData();
  }

  async getData() {
    this.teatros = await this.api.getTeatros().toPromise();
    this.isLoadingResults = false;
    console.debug('No issues, I will wait until promise is resolved..');
  }

  async atualizarTabela() {
    this.isLoadingResults = true;
    this.teatros = await this.api.teatrosPorCidade(this.query).toPromise();
    this.isLoadingResults = false;
  }



}

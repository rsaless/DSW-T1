import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { Site } from '../../models/site';
import { Teatro } from '../../models/teatro';

@Component({
  selector: 'app-promocao-cadastro',
  templateUrl: './promocao-cadastro.component.html',
  styleUrls: ['./promocao-cadastro.component.css']
})
export class PromocaoCadastroComponent implements OnInit {

  promocaoForm: FormGroup;
  sites: Site[];
  teatros: Teatro[];
  isLoadingResults = false;

  constructor(
    private router: Router, 
    private api: ApiService, 
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.promocaoForm = this.formBuilder.group({
      nome_peca: [null, Validators.required],
      preco: [0.01, Validators.required],
      cnpj: [null, Validators.required],
      dia_hora: [null, Validators.required],
      nome_site: [null, Validators.required],
      site: [null, Validators.required],
      teatro: [null, Validators.required]
    });
    this.getData();
  }

  async getData() {
    this.sites = await this.api.getSites().toPromise();
    this.teatros = await this.api.getTeatros().toPromise();
    this.isLoadingResults = false;
    console.debug('No issues, I will wait until promise is resolved..');
  }

  onFormSubmit(form: NgForm) {
    this.isLoadingResults = true;
    this.api.addPromocao(form)
      .subscribe(res => {
        let id = res['id'];
        this.isLoadingResults = false;
        this.router.navigate(['/promocao-detalhes', id]);
      }, (err) => {
        console.log(err);
        this.isLoadingResults = false;
      });
  }



}

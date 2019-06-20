import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { Teatro } from 'src/app/models/teatro';

@Component({
  selector: 'app-teatro-edicao',
  templateUrl: './teatro-edicao.component.html',
  styleUrls: ['./teatro-edicao.component.css']
})
export class TeatroEdicaoComponent implements OnInit {

  teatroForm: FormGroup;
  id: string = '';
  isLoadingResults = true;

  constructor(
    private router: Router, 
    private route: ActivatedRoute, 
    private api: ApiService, 
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.isLoadingResults = true;
    this.teatroForm = this.formBuilder.group({
      nome: [null, Validators.required],
      email: [null, Validators.required],
      senha: [null, Validators.required],
      cidade: [null, Validators.required],
      cnpj: [null, Validators.required],
    });
    this.getData(this.route.snapshot.params['id']);
  }

  onFormSubmit(form:NgForm) {
    this.isLoadingResults = true;
    this.api.updateTeatro(this.id, form)
      .subscribe(res => {
          let id = res['id'];
          this.isLoadingResults = false;
          this.router.navigate(['/teatro-detalhes', id]);
        }, (err) => {
          console.log(err);
          this.isLoadingResults = false;
        }
      );
      
  }

  async getData(id) {
    let teatro: Teatro = await this.api.getTeatro(id).toPromise();
    this.id = teatro.id;
    this.teatroForm.setValue({
      nome: teatro.nome,
      email: teatro.email,
      senha: teatro.senha,
      cidade: teatro.cidade,
      cnpj: teatro.cnpj
    });
    this.isLoadingResults = false;
    console.debug('No issues, I will wait until promise is resolved..');
  }

  teatroDetalhes() {
    this.router.navigate(['/teatro-detalhes', this.id]);
  }

}

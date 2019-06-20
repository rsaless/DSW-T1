import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiService } from '../../services/api.service';
import { Site } from '../../models/site'

@Component({
  selector: 'app-site-detalhes',
  templateUrl: './site-detalhes.component.html',
  styleUrls: ['./site-detalhes.component.css']
})
export class SiteDetalhesComponent implements OnInit {

  site: Site = {
    id: '',
    nome: '',
    email: '',
    senha: '',
    url: '',
    telefone: null
  };
  isLoadingResults = true;

  constructor(
    private route: ActivatedRoute, 
    private api: ApiService, 
    private router: Router
  ) { }

  async getData(id) {
    this.site = await this.api.getSite(id).toPromise();
    this.isLoadingResults = false;
    console.debug('No issues, I will wait until promise is resolved..');
  }
  ngOnInit() {
    this.getData(this.route.snapshot.params['id']);
  }
  deleteSite(id) {
    this.isLoadingResults = true;
    this.api.deleteSite(id)
      .subscribe(res => {
          this.isLoadingResults = false;
          this.router.navigate(['/sites']);
        }, (err) => {
          console.log(err);
          this.isLoadingResults = false;
        }
      );
  }

}

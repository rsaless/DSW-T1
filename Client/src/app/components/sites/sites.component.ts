import { Component, OnInit } from '@angular/core';
import { ApiService } from "../../services/api.service";
import { Site } from '../../models/site';

@Component({
  selector: 'app-sites',
  templateUrl: './sites.component.html',
  styleUrls: ['./sites.component.css']
})
export class SitesComponent implements OnInit {

  displayedColumns: string[] = ['nome', 'email', 'url', 'telefone'];
  sites: Site[] = [];
  isLoadingResults = true;

  constructor(private api: ApiService) { }

  ngOnInit() {
    this.getData();
  }

  async getData() {
    this.sites = await this.api.getSites().toPromise();
    this.isLoadingResults = false;
    console.debug('No issues, I will wait until promise is resolved..');
  }


}

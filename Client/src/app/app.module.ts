import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { JwtModule } from '@auth0/angular-jwt';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSelectModule } from '@angular/material/select';

import {
  MatInputModule,
  MatPaginatorModule,
  MatProgressSpinnerModule,
  MatSortModule,
  MatTableModule,
  MatIconModule,
  MatButtonModule,
  MatCardModule,
  MatFormFieldModule,
  MatDialogModule
} from "@angular/material";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlertComponent } from './components/alert/alert.component';
import { Authentication } from './models/Authentication';
import { LoginComponent } from './components/login/login.component';

import { SitesComponent } from './components/sites/sites.component';
import { SiteCadastroComponent } from './components/site-cadastro/site-cadastro.component';
import { SiteDetalhesComponent } from './components/site-detalhes/site-detalhes.component';
import { SiteEdicaoComponent } from './components/site-edicao/site-edicao.component';
import { TeatroDetalhesComponent } from './components/teatro-detalhes/teatro-detalhes.component';
import { TeatroEdicaoComponent } from './components/teatro-edicao/teatro-edicao.component';
import { TeatroCadastroComponent } from './components/teatro-cadastro/teatro-cadastro.component';
import { TeatrosComponent } from './components/teatros/teatros.component';
import { PromocaoCadastroComponent } from './components/promocao-cadastro/promocao-cadastro.component';
import { PromocaoDetalhesComponent } from './components/promocao-detalhes/promocao-detalhes.component';
import { PromocaoEdicaoComponent } from './components/promocao-edicao/promocao-edicao.component';
import { PromocoesComponent } from './components/promocoes/promocoes.component';
import { PromocoesSiteComponent } from './components/promocoes-site/promocoes-site.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { DialogComponent } from './components/dialog/dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    SitesComponent,
    SiteCadastroComponent,
    SiteDetalhesComponent,
    SiteEdicaoComponent,
    TeatroDetalhesComponent,
    TeatroEdicaoComponent,
    TeatroCadastroComponent,
    TeatrosComponent,
    PromocaoCadastroComponent,
    PromocaoDetalhesComponent,
    PromocaoEdicaoComponent,
    PromocoesComponent,
    PromocoesSiteComponent,
    NavbarComponent,
    AlertComponent,
    LoginComponent,
    DialogComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatProgressSpinnerModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatSelectModule,
    MatFormFieldModule,
    MatDialogModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: function tokenGetter() {
          return localStorage.getItem('access_token');
        },
        whitelistedDomains: ['localhost:8090'],
        blacklistedRoutes: [
          'http://localhost:8090/ServerT3/api/login',
          'http://localhost:8090/ServerT3/oauth/access_token'
        ]
      }
    })
  ],  
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [DialogComponent]
})
export class AppModule { }

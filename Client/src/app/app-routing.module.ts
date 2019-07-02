import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SitesComponent } from './components/sites/sites.component';
import { SiteDetalhesComponent } from './components/site-detalhes/site-detalhes.component';
import { SiteCadastroComponent } from './components/site-cadastro/site-cadastro.component';
import { SiteEdicaoComponent } from './components/site-edicao/site-edicao.component';
import { TeatrosComponent } from './components/teatros/teatros.component';
import { TeatroDetalhesComponent } from './components/teatro-detalhes/teatro-detalhes.component';
import { TeatroCadastroComponent } from './components/teatro-cadastro/teatro-cadastro.component';
import { TeatroEdicaoComponent } from './components/teatro-edicao/teatro-edicao.component';
import { PromocoesComponent } from './components/promocoes/promocoes.component';
import { PromocaoDetalhesComponent } from './components/promocao-detalhes/promocao-detalhes.component';
import { PromocaoCadastroComponent } from './components/promocao-cadastro/promocao-cadastro.component';
import { PromocaoEdicaoComponent } from './components/promocao-edicao/promocao-edicao.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './helpers/auth-guard';
import { PromocaoGuard } from './helpers/promocao-guard';
import { OwnerGuard } from './helpers/owner-guard';

const routes: Routes = [
  {path: 'sites', component: SitesComponent, data: {title: 'Lista de Sites'}},
  {path: 'teatros', component: TeatrosComponent, data: {title: 'Lista de Teatros'}},
  {path: 'promocoes', component: PromocoesComponent, data: {title: 'Lista de Promoções'}},
  
  {path: 'site-detalhes/:id', component: SiteDetalhesComponent, data: {title: 'Detalhes do Site'}},
  {path: 'teatro-detalhes/:id', component: TeatroDetalhesComponent, data: {title: 'Detalhes do Teatro'}},
  {path: 'promocao-detalhes/:id', component: PromocaoDetalhesComponent, data: {title: 'Detalhes da Promoção'}},
  
  {path: 'site-cadastro', component: SiteCadastroComponent, canActivate: [AuthGuard], data: {title: 'Cadastro Site'}},
  {path: 'teatro-cadastro', component: TeatroCadastroComponent, canActivate: [AuthGuard], data: {title: 'Cadastro Teatro'}},
  {path: 'promocao-cadastro', component: PromocaoCadastroComponent, canActivate: [PromocaoGuard], data: {title: 'Cadastro Promoção'}},
  
  {path: 'site-edicao/:id', component: SiteEdicaoComponent, canActivate: [OwnerGuard], data: {title: 'Edição Site'}},
  {path: 'teatro-edicao/:id', component: TeatroEdicaoComponent, canActivate: [OwnerGuard], data: {title: 'Edição Teatro'}},
  {path: 'promocao-edicao/:id', component: PromocaoEdicaoComponent, canActivate: [OwnerGuard], data: {title: 'Edição Promoção'}},
  
  {path: 'login', component: LoginComponent, data: { title: 'Login' }},
  {path: '', redirectTo: '/', pathMatch: 'full'}
];
  

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

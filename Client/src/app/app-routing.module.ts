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

const routes: Routes = [
  {path: 'sites', component: SitesComponent, canActivate: [AuthGuard], data: {title: 'Lista de Sites'}},
  {path: 'site-detalhes/:id', component: SiteDetalhesComponent, canActivate: [AuthGuard], data: {title: 'Detalhes do Site'}},
  {path: 'site-cadastro', component: SiteCadastroComponent, canActivate: [AuthGuard], data: {title: 'Cadastro Site'}},
  {path: 'site-edicao/:id', component: SiteEdicaoComponent, canActivate: [AuthGuard], data: {title: 'Edição Site'}},
  {path: 'teatros', component: TeatrosComponent, canActivate: [AuthGuard], data: {title: 'Lista de Teatros'}},
  {path: 'teatro-detalhes/:id', component: TeatroDetalhesComponent, canActivate: [AuthGuard], data: {title: 'Detalhes do Teatro'}},
  {path: 'teatro-cadastro', component: TeatroCadastroComponent, canActivate: [AuthGuard], data: {title: 'Cadastro Teatro'}},
  {path: 'teatro-edicao/:id', component: TeatroEdicaoComponent, canActivate: [AuthGuard], data: {title: 'Edição Teatro'}},
  {path: 'promocoes', component: PromocoesComponent, canActivate: [AuthGuard], data: {title: 'Lista de Promoções'}},
  {path: 'promocao-detalhes/:id', component: PromocaoDetalhesComponent, canActivate: [AuthGuard], data: {title: 'Detalhes da Promoção'}},
  {path: 'promocao-cadastro', component: PromocaoCadastroComponent, canActivate: [AuthGuard], data: {title: 'Cadastro Promoção'}},
  {path: 'promocao-edicao/:id', component: PromocaoEdicaoComponent, canActivate: [AuthGuard], data: {title: 'Edição Promoção'}},
  {path: 'login', component: LoginComponent, data: { title: 'Login' }},
  {path: '', redirectTo: '/', pathMatch: 'full'}
];
  

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

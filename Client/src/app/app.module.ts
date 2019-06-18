import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SitesComponent } from './components/sites/sites.component';
import { SiteCadastroComponent } from './components/site-cadastro/site-cadastro.component';

@NgModule({
  declarations: [
    AppComponent,
    SitesComponent,
    SiteCadastroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

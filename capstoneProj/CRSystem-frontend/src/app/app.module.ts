import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from "@angular/common/http";
import { RouterModule, Routes } from "@angular/router";
import { FormsModule } from "@angular/forms";

import { AppComponent } from './app.component';
import { ListAdminComponent } from './components/list-admin/list-admin.component';
import { AddAdminComponent } from './components/add-admin/add-admin.component';

const routers: Routes = [
  {path: 'admin', component: ListAdminComponent},
  {path: 'addadmin', component: AddAdminComponent},
  {path: 'editadmin/:id', component: AddAdminComponent},
  {path: '', redirectTo: 'admin', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ListAdminComponent,
    AddAdminComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routers)
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

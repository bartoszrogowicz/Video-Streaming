import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {AuthComponent} from "./auth/auth.component";
import {AppComponent} from "./app.component";
import {AuthService} from "./auth/auth.service";
import {AuthGuard} from "./auth/auth.guard";
import {StreamsListComponent} from "./streams/streams-list/streams-list.component";
import {StreamsEditComponent} from "./streams/streams-edit/streams-edit.component";
import {StreamsCreateComponent} from "./streams/streams-create/streams-create.component";

const routes: Routes = [

  {path: 'login', component: AuthComponent},
  {path: 'streams', component: StreamsListComponent},
  {path: 'streams/edit/:id', component: StreamsEditComponent},
  {path: 'streams/create', component: StreamsCreateComponent}
  //path: '',
  //children: []
];



@NgModule({
  imports: [
    CommonModule,
    [RouterModule.forRoot(routes)]
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
export const routingComponents = [AuthComponent]

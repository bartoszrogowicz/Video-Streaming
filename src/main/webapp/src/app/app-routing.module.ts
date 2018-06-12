import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {AuthComponent} from "./auth/auth.component";
import {AppComponent} from "./app.component";
import {AuthService} from "./auth/auth.service";
import {AuthGuard} from "./auth/auth.guard";
import {StreamsListComponent} from "./streams/streams-list/streams-list.component";

const routes: Routes = [

  {path: 'login', component: AuthComponent},
  {path: 'streams', component: StreamsListComponent}
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

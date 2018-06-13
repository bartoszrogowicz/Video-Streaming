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
import {StreamGuard} from "./streams/stream.guard";

const routes: Routes = [

  {path: 'login', component: AuthComponent, canActivate: [AuthGuard]},
  {path: 'streams', component: StreamsListComponent, canActivate: [StreamGuard]},
  {path: 'streams/edit/:id', component: StreamsEditComponent, canActivate: [StreamGuard]},
  {path: 'streams/create', component: StreamsCreateComponent, canActivate: [StreamGuard] }
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

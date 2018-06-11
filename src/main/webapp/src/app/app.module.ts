import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MainViewComponent } from './main-view/main-view.component';
import { StreamsComponent } from './streams/streams.component';
import {StreamService} from "./streams/stream.service";
import {HttpClientModule} from '@angular/common/http';
import {AuthService} from "./auth/auth.service";
import { AuthComponent } from './auth/auth.component';
import {AppRoutingModule, routingComponents} from './app-routing.module';
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AppComponent,
    MainViewComponent,
    StreamsComponent,
    AuthComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [StreamService, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }

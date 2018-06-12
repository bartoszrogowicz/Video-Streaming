import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MainViewComponent } from './main-view/main-view.component';
import { StreamsComponent } from './streams/streams.component';
import {StreamService} from "./streams/stream.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AuthService} from "./auth/auth.service";
import { AuthComponent } from './auth/auth.component';
import {AppRoutingModule, routingComponents} from './app-routing.module';
import {FormsModule} from "@angular/forms";
import {AuthInterceptor} from "./auth/auth.interceptor";
import { StreamsListComponent } from './streams/streams-list/streams-list.component';
import { StreamsCreateComponent } from './streams/streams-create/streams-create.component';


@NgModule({
  declarations: [
    AppComponent,
    MainViewComponent,
    StreamsComponent,
    AuthComponent,
    StreamsListComponent,
    StreamsCreateComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [StreamService, AuthService
   /* {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
     }*/
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }

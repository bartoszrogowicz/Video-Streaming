import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MainViewComponent } from './main-view/main-view.component';
import { StreamsComponent } from './streams/streams.component';
import {StreamService} from "./streams/stream.service";
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    MainViewComponent,
    StreamsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [StreamService],
  bootstrap: [AppComponent]
})
export class AppModule { }

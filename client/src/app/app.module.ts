import { BrowserModule }    from '@angular/platform-browser';
import { NgModule }         from '@angular/core';
import { HttpModule }       from "@angular/http";

import { AppComponent }     from './app.component';
import { PingComponent }    from './ping.component';
import { HomepageComponent }    from './homepage.component';
import { AboutComponent }    from './about.component';
import { ServicesComponent }    from './services.component';

import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    PingComponent,
    HomepageComponent,
    AboutComponent,
    ServicesComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule
  ],
    providers: [
      PingComponent
    ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";
import { FormsModule } from '@angular/forms';


import {NgbModule} from '@ng-bootstrap/ng-bootstrap';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { ServiceInvokeComponent } from './service-invoke/service-invoke.component';

import { AuthService } from './services/auth.service'
import { MicroservicioBaseService } from './services/microservicio-base.service'


import { AuthInterceptor } from "./interceptors/auth-interceptor";
import { AuthGuard } from "./guards/auth-guard"

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    ServiceInvokeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    AuthService, 
    MicroservicioBaseService,
    AuthGuard,
    {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

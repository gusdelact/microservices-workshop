import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {ServiceInvokeComponent} from './service-invoke/service-invoke.component'
import {SignInComponent} from './sign-in/sign-in.component'

import { AuthGuard } from './guards/auth-guard'


const routes: Routes = [
    { path: 'sign-in', component: SignInComponent },
    { path: '', redirectTo: 'service-invoke', pathMatch: 'full' },
    { path: 'service-invoke', component: ServiceInvokeComponent, canActivate: [AuthGuard] }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

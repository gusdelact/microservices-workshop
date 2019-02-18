import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../services/auth.service'
import { NotificationsService } from '../services/notifications.service'


@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  username: string = 'john.carnell'
  password: string = 'password1'

  constructor( private authService:AuthService, 
    private notificationsService:NotificationsService,
    private router: Router) { }

  ngOnInit() {
  }

  signIn(){
    this.authService.signIn(this.username,this.password).subscribe(
      data=> {
        let authorization = this.authService.getCurrentAuthorization();
        console.log("Authentication object: " + JSON.stringify(this.authService.getCurrentAuthorization()))
        if(authorization){
          this.notificationsService.success('Welcome!')
          this.router.navigate(['/']);
        }else{
          this.notificationsService.warn('Please, try again')
        }
      })
  }

}

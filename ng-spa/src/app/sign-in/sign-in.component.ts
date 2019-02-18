import { Component, OnInit } from '@angular/core';

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

  constructor( private authService:AuthService, private notificationsService:NotificationsService) { }

  ngOnInit() {
  }

  signIn(){
    this.authService.signIn(this.username,this.password).subscribe(
      data=> {
        console.log("Authentication object: " + JSON.stringify(this.authService.getCurrentAuthorization()))
        this.notificationsService.add({'type':'success', 'text':'Welcome!'})
      }, 
      err => {
        this.notificationsService.add({'type':'danger', 'text':err.message})
      })
  }

}

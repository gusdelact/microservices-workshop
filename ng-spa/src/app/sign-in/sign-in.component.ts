import { Component, OnInit } from '@angular/core';

import { AuthService } from '../services/auth.service'

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  username: string = 'john.carnell'
  password: string = 'password1'

  constructor( private authService:AuthService) { }

  ngOnInit() {
  }

  signIn(){
    this.authService.signIn(this.username,this.password).subscribe(
      data=> {
        console.log("Authentication object: " + JSON.stringify(this.authService.getCurrentAuthorization()))
      }, 
      err => {
        //Invoke notification services
        
        console.log(err)
      })
  }

}

import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


 const authServiceUrl = 'https://zuulsvr-v4-0.127.0.0.1.nip.io/api/' 
 
 const tokenUrl = authServiceUrl + 'a/auth/oauth/token'
 const userUrl = authServiceUrl + 'a/auth/user'

@Injectable({
  providedIn: 'root'
})
export class AuthService {

 

  constructor(private http: HttpClient) { }
  
  currentUser
  
  getCurrentUser(){
    return this.currentUser;
  }
  
  signIn(username:string, password: string){
    
    console.log("AuthService: " + username)
    
    
    var body = {'username': username, 'password': password, 'grant-type': 'password'}
    var headers = new HttpHeaders({
      'Authorization': 'Basic YXBsaWNhY2lvbjp1bnNlY3JldG8=',
      'Content-Type': 'application/x-www-form-urlencoded',
      'Accept': 'application/json',
      'x-test-anchor':'fck-u-anchor'
    })
     console.log(headers)
    
    return this.http.post(tokenUrl,body)
    
  }
  
}

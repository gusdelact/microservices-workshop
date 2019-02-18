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
  
  private authorization
  
  getCurrentAuthorization(){
    return this.authorization;
  }
  
  signIn(username:string, password: string){
    
    //console.log("AuthService: " + username)
    
    
    var params = {'username': username, 'password': password, 'grant_type': 'password'}
    var headers = new HttpHeaders({
      'Authorization': 'Basic YXBsaWNhY2lvbjp1bnNlY3JldG8=',
      'Content-Type': 'application/x-www-form-urlencoded',
      'Accept': 'application/json',
      'x-test-anchor':'fck-u-anchor'
    })
    //console.log(headers.keys())

    let r = this.http.post(tokenUrl,null,{headers:headers, params: params})

    r.subscribe( data =>{
      this.authorization = data;
    })

    return r
    
  }
  
}

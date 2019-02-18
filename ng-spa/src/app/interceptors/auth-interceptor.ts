import { Injectable } from "@angular/core";
import { HttpRequest, HttpResponse, HttpHeaders, HttpHandler, HttpEvent, HttpInterceptor } from "@angular/common/http";

import { Observable } from "rxjs";
import { AuthService } from "../services/auth.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(private authService: AuthService){}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>{
        
        //console.log("Request headers: " + request.headers.keys());

        //let user = this.authService.getCurrentUser();
        //const headers = new HttpHeaders({
        //});

        //const _request = request.clone({headers});
        //console.log("Request params: " + request.params.keys());
        return next.handle(request);
    }


}
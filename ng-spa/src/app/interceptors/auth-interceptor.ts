import { Injectable } from "@angular/core";
import { HttpRequest, HttpResponse, HttpHeaders, HttpHandler, HttpEvent, HttpInterceptor } from "@angular/common/http";

import { Observable } from "rxjs";
import { AuthService } from "../services/auth.service";
import { NotificationsService} from "../services/notifications.service"

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(private authService: AuthService,
        private notificationsService: NotificationsService){}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>{
        
        //console.log("Request headers: " + request.headers.keys());

        //let user = this.authService.getCurrentUser();
        //const headers = new HttpHeaders({
        //});

        //const _request = request.clone({headers});
        //console.log("Request params: " + request.params.keys());
        let _request = request
        let authorization = this.authService.getCurrentAuthorization();
        

        if(authorization){
            console.log(JSON.stringify(authorization))
            let new_headers = request.headers.append('Authorization', 'Bearer ' + authorization['access_token'])
            _request = request.clone({headers: new_headers})
        }

        //console.log(JSON.stringify(JSON.stringify(_request)))

        let response = next.handle(_request)
        response.subscribe(data =>{}, error =>{
            this.notificationsService.error(error.message)
        })

        return response;
    }


}
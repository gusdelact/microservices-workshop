import { Injectable } from '@angular/core';
import { AuthService } from "../services/auth.service";
import { Router, CanActivate } from '@angular/router';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(
        private authService: AuthService,
        private router: Router) { }

    canActivate() {
        if (this.authService.getCurrentAuthorization()) {
        //     logged in so return true
            return true;
        }

        // not logged in so redirect to login page
        this.router.navigate(['/sign-in']);
        return false;
    }
}
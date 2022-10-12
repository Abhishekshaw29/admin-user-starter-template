import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class UsergaurdGuard implements CanActivate {
  constructor(private login:LoginService,private routes:Router){
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      if( this.login.isLoggedIn() && this.login.getUserRole()=="USER"){
        return true;
      }
        this.routes.navigate([`/login`]);
        return false;
    }
  }

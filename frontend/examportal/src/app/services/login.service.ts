import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient,private routes:Router) { }

  public LoginStatusSubject = new Subject<Boolean>();

  //generate token
  public generateToken(loginData: any) {
    return this.http.post(`${baseUrl}/generate-token`, loginData);

  }

  //login user : set token in localstorage
  public loginUser(token: any) {
    localStorage.setItem('token', token);
    return true;
  }
  //islogin: user is logged in or not
  public isLoggedIn() {
    let tokenStr = localStorage.getItem("token")
    if (tokenStr == undefined || tokenStr == '' || tokenStr == null) {
      return false;
    }
    else {
      return true;
    }
  }
  // Logout : remove token from local storage
  public logout() {
    localStorage.removeItem('user');
    localStorage.removeItem('token');
    return true;
  }
  // get token 
  public getToken() {
    return localStorage.getItem('token');
  }
  //SetUserDetails
  public setUser(user:any){
    localStorage.setItem('user',JSON.stringify(user));
  }
  //getUserDetails
  public getUser(){
   let userStr =  localStorage.getItem('user');
   if(userStr!=null){
    return JSON.parse(userStr);
   }else{
    this.logout();
    return null;
   }
  }
  //getuserAuthority
  public getUserRole(){
    let user = this.getUser()
    return user.authorities[0].authority;
  }

  //getcurrentuser
  public getCurrentUser(){
    let user:any = this.http.get(`${baseUrl}/current-user`);
    return user;
  }

}

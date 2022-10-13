import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  username:any=null
  public setMessage(data:any){
    this.username=data;
  }
  public getMessage(){
    return this.username;
  }
  //create user
  public addUser(user:any){
    return this.http.post(`${baseUrl}/user/`,user);
  }
  //see all user
  public allUser(){
    return this.http.get(`${baseUrl}/user/alluser`);
  }
}

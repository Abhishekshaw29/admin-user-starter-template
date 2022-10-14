import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  isLoggedIn=false;
  user:any=null;
  constructor(public login:LoginService,private routes:Router,private userService:UserService) { }

  ngOnInit(): void {
    this.isLoggedIn=this.login.isLoggedIn();
    this.user=this.login.getUser();
    this.userService.setMessage(this.user)
    this.login.LoginStatusSubject.asObservable().subscribe({
      next:(data)=>{
        this.isLoggedIn=this.login.isLoggedIn();
        this.user=this.login.getUser();
        this.userService.setMessage(this.user)
      }
  });
  }
  public logout(){
    this.login.logout();
    this.routes.navigate(['/']);
    location.reload();
  }
  public getUser(){
    this.routes.navigate([`/profile`]);
    setTimeout(() => {
      window.location.reload();
    }, 1000);
    
  }

}

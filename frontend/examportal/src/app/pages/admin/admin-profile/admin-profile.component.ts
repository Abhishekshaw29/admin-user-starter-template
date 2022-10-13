import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {

  isLoggedIn=false;
  user:any=null;
  constructor(private login:LoginService,private userService:UserService) { }
  ngOnInit(): void {
     this.isLoggedIn=this.login.isLoggedIn();
    this.user=this.userService.getMessage();
    this.login.LoginStatusSubject.asObservable().subscribe({
      next:(data)=>{
        this.isLoggedIn=this.login.isLoggedIn();
        this.user=this.userService.getMessage();
      }
  });
  
  }


}

// this.isLoggedIn=this.login.isLoggedIn();
//     this.user=this.login.getUser();
//     this.login.LoginStatusSubject.asObservable().subscribe({
//       next:(data)=>{
//         this.isLoggedIn=this.login.isLoggedIn();
//         this.user=this.login.getUser();
//       }
//   });
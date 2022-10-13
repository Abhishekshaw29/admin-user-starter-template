import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {

  constructor(private login:LoginService,private routes:Router,private user:UserService) { }
  users:any;
  ngOnInit(): void {
   
    if(this.login.isLoggedIn()){
    this.user.allUser().subscribe({
      next:(data)=>{
        this.users=data;
      },
      error:(e)=>{
        console.log(e);
      }
    })
  }
  else{
    this.routes.navigate([``]);
  }
  }
  public showUser(userdata:any){
    this.user.setMessage(userdata);
    this.routes.navigate([`/profile`]);
  }

  public deleteUser(username:any){
    
  }
  


}

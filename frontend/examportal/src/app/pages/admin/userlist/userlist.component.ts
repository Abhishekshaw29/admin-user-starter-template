import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {

  constructor(private login:LoginService,private user:UserService) { }
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
  }
  


}

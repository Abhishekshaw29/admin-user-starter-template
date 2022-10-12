import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  loginData={
    username:'',
    password:''
  }

  constructor(private snack:MatSnackBar,private login:LoginService) { }

  ngOnInit(): void {
  }

  formSubmit(){
    if(this.loginData.username.trim()=='' || this.loginData.username==null){
      this.snack.open("username is required !!",'ok',{
        duration:3000,
      });
      return;
    }
    if(this.loginData.password.trim()=='' || this.loginData.password==null){
      this.snack.open("password is required !!",'ok',{
        duration:3000,
      });
      return;
    }
    //request server to generate token
    this.login.generateToken(this.loginData).subscribe({
      next:(data:any)=>{
        console.log("login success");
        // console.log(data);
        
        //login --> save in local storage
        this.login.loginUser(data.token);
        this.login.getCurrentUser().subscribe({
          next:(data:any)=>{
            this.login.setUser(data)
            console.log(data);
            //redirect after login based on role
            //redirect ----ADMIN
            //redirct ----- USER
          }
        });
          


      },
      error:(e)=>{
        console.log("login error")
        console.log(e);
      }
    })


    }

}

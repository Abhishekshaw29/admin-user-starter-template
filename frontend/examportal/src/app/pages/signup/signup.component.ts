import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService: UserService, private router: Router,private snack:MatSnackBar) { }

  public user = {
    userName: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
    profile: '',
  }

  ngOnInit(): void {
  }
  formSubmit() {
    if (this.user == null || this.user.userName == null) {
      this.snack.open("username is required",'ok',{
        duration:3000
      });
      return;
    }
    //userservice call
    else {
      this.userService.addUser(this.user).subscribe({
        next: (data:any) => {
          console.log(data);
          Swal.fire('Successfully done !!','user id is - ' + data.id,'success');
          return this.router.navigate([`/`]);

        },
        error: (e) => {
          this.snack.open("error occured !!",'ok',{
            duration:3000
          });
          console.log(e);
        }
      })
    }

  }

}

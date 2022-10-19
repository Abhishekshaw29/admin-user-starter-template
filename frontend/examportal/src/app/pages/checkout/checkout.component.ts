import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PackagesService } from 'src/app/services/packages.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
onSubmit(){
  this.packageService.bookPackages(localStorage.getItem('userId'),this.package.id).subscribe({
    next:(data)=>{
      console.log(data);
    }
  });
  Swal.fire(
    'BOOKED!',
    'SEE YOU IN TRIP!',
    'success'
  )
  setTimeout(() => {
    this.router.navigate(['/']);
  }, 2000);
 
}

  constructor(private router:Router
    ,private packageService:PackagesService,private userService:UserService) { }
  package:any
  user:any
  ngOnInit(): void {
    this.package=this.packageService.getMessage();
    this.user = JSON.parse(localStorage.getItem('user') || '{}');
    console.log(this.user);
  }
}

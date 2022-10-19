import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PackagesService } from 'src/app/services/packages.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  pack:any
  constructor(private packageService:PackagesService,private router:Router) { }
  userId:any

  ngOnInit(): void {
    this.userId=localStorage.getItem("userId");
    this.packageService.getUserBookings(this.userId).subscribe({
      next:(data)=>{
        if(data!=null || data!=undefined)
        this.pack=data
        else{
          Swal.fire('NO BOOKING YET','BOOK SOMETHING')
          this.router.navigate(['/packages']);
        }
      },
    });

  }

}

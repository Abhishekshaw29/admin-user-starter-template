import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { PackagesService } from 'src/app/services/packages.service';

@Component({
  selector: 'app-packages',
  templateUrl: './packages.component.html',
  styleUrls: ['./packages.component.css']
})
export class PackagesComponent implements OnInit {
  packageList:any
  constructor(private router:Router
    ,private loginService:LoginService
    ,private packagesService:PackagesService) { }

  ngOnInit(): void {
    if(!this.loginService.isLoggedIn()){
      this.loginService.logout();
      this.router.navigate(['']);
    }
    else{
      this.packagesService.getAllPackages().subscribe({
        next:(data)=>{
          this.packageList=data;
        },
        error:(e)=>{
          console.log(e);
        }
      });
    }
  }

  public checkoutPage(packs:any){
    this.packagesService.setMessage(packs);
    this.router.navigate(['/checkout']);
  }
}

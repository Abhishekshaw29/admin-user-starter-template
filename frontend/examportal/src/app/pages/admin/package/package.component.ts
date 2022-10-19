import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { PackagesService } from 'src/app/services/packages.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-package',
  templateUrl: './package.component.html',
  styleUrls: ['./package.component.css']
})
export class PackageComponent implements OnInit {
  public packages = {
    packagename: '',
    startpoint: '',
    destination: '',
    date: '',
    price: '',
    photo: 'https://res.cloudinary.com/dxssqb6l8/image/upload/v1605293736/james-wheeler_xqmq2y.jpg',
    ticketCount: '',
    description: '',
    duration: ''
  }
  packageList: any
  constructor(private router: Router
    , private loginService: LoginService
    , private packagesService: PackagesService,
    private snack: MatSnackBar) { }

  ngOnInit(): void {
    var x = document.getElementById("myDIV");
    x!.style.display = "none";

    if (!this.loginService.isLoggedIn()) {
      this.loginService.logout();
      this.router.navigate(['']);
    }
    else {
      this.packagesService.getAllPackages().subscribe({
        next: (data) => {
          this.packageList = data;

        },
        error: (e) => {
          this.snack.open("Something Went Wrong!!!", 'ok');
          console.log(e);
        }
      });
    }
  }
  public formSubmit() {
    this.packagesService.createPackage(this.packages).subscribe({
      next: (data) => {

      },
      error: (e) => {
        console.log(e);
      }

    });
    Swal.fire({
      title: 'Package Added Successfully',
      width: 600,
      padding: '3em',
      color: '#716add',
      background: '#fff url(/images/trees.png)',
      backdrop: `
        rgba(0,0,123,0.4)
        url('https://sweetalert2.github.io/images/nyan-cat.gif')
        left top
        no-repeat
      `
    })
    setTimeout(() => {
      window.location.reload();
    }, 3000);
  
  }

  public makeSpace() {
    var x = document.getElementById("myDIV");
    if (x!.style.display === "none") {
      x!.style.display = "block";
    } else {
      x!.style.display = "none";
    }
  }
  public deletePackage(id: any) {

    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        )
      }
      this.packagesService.deletePackage(id).subscribe({
        error(err) {
          console.log(err);
        }
      });
      setTimeout(() => {
        location.reload();
      }, 3000);
    })
  }
}

import { Component, OnInit } from '@angular/core';
import { Router, Routes } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private login:LoginService,private routes:Router) { }

  ngOnInit(): void {
    if(!this.login.isLoggedIn()){
      this.routes.navigate([``]);
    }
  }

}

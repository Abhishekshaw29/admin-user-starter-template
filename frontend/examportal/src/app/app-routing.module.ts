import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './pages/about/about.component';
import { AdminProfileComponent } from './pages/admin/admin-profile/admin-profile.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { PackageComponent } from './pages/admin/package/package.component';
import { UserlistComponent } from './pages/admin/userlist/userlist.component';
import { BlogComponent } from './pages/blog/blog.component';
import { BookedComponent } from './pages/booked/booked.component';
import { CheckoutComponent } from './pages/checkout/checkout.component';
import { ContactComponent } from './pages/contact/contact.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { PackagesComponent } from './pages/packages/packages.component';
import { SignupComponent } from './pages/signup/signup.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { AdmingaurdGuard } from './services/admingaurd.guard';
import { UsergaurdGuard } from './services/usergaurd.guard';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent,
    pathMatch:'full'
  },
  {
    path: 'signup',
    component: SignupComponent,
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full',
  },
  {
    path:'admin',
    component:DashboardComponent,
    pathMatch:'full',
  },
  {
    path:'user',
    component:UserDashboardComponent,
    pathMatch:'full',
    canActivate:[UsergaurdGuard]
  },
  {
    path:'profile',
    component:AdminProfileComponent,
    canActivate:[AdmingaurdGuard],
    pathMatch:'full',
  },
  {
    path:'users',
    component:UserlistComponent,
    pathMatch:'full',
    canActivate:[AdmingaurdGuard]
  },
  {
    path:'package',
    component:PackageComponent,
    pathMatch:'full',
    canActivate:[AdmingaurdGuard]
  },
  {
    path:'packages',
    component:PackagesComponent,
    pathMatch:'full',
  },
  {
    path:'blog',
    component:BlogComponent,
    pathMatch:'full',
    
  },
  {
    path:'about',
    component:AboutComponent,
    pathMatch:'full',
    
  },
  {
    path:'contact',
    component:ContactComponent,
    pathMatch:'full',
    
  },
  {
    path:'checkout',
    component:CheckoutComponent,
    pathMatch:'full',
  },
  {
    path:'booked',
    component:BookedComponent,
    pathMatch:'full',
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

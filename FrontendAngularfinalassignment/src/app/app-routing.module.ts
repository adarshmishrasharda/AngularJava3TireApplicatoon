import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SearchComponent } from './pages/search/search.component';
import { SignupComponent } from './pages/signup/signup.component';
import { UserdashboardComponent } from './pages/user/userdashboard/userdashboard.component';


const routes: Routes = [
  {
    path:'',
    component:HomeComponent,
    pathMatch:'full',
  },

  {
    path:'signup',
    component:SignupComponent,
    pathMatch:'full',

  },
  {
    path:'login',
    component:LoginComponent,
    pathMatch:'full',
  },
  {
    path:'search',
    component:SearchComponent,
    pathMatch:'full',
  },
  {
    path:'admin',
    component:DashboardComponent,
    pathMatch:'full',
    //canActivate:[AdminGuard],
  },
  {
    path:'details/:id',
    component:UserdashboardComponent,
    pathMatch:'full'
    //canActivate:[NormalGuard]
  }



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

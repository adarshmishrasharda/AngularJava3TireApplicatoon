import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {



  isLoggedIn=false;
  user:any;


  constructor(public login:LoginService,private route:Router) { }

  ngOnInit(): void {
    this.isLoggedIn=this.login.isLoggedIn();
    console.log("navbar onint function excuted ",this.isLoggedIn);
    this.user=this.login.getUser();
    this.login.loginStatusSubject.asObservable().subscribe(data=>{
      this.isLoggedIn=this.login.isLoggedIn();
      this.user=this.login.getUser();
    })
  }

  public logout()
  {
    this.login.logout();
    //window.location.reload();
    this.isLoggedIn=false;
    this.user=null;
    this.route.navigate(['login']);
   
    

  }

}

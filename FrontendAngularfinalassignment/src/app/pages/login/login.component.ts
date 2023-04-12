import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  logindata={
    username:'',
    password:''

  }

  constructor(private snak:MatSnackBar,private login:LoginService,private route:Router) { }

  ngOnInit(): void {
  }


  formSubmit()
  {
    console.log("form submitted");


    if(this.logindata.username.trim()=='' || this.logindata.username==null)
    {
      this.snak.open("username is required",'',{
        duration:3000,
      });
      return ;

    }
    
    if(this.logindata.password.trim()=='' || this.logindata.password==null)
    {
      this.snak.open("password is required",'',{
        duration:3000,
      });
      return ;

    }
    //request server to generate token

    this.login.generateToken(this.logindata).subscribe(
      (data:any)=>{
        console.log('success');
        console.log(data);
        //login...
        this.login.loginUser(data.token);
        this.login.getCurrentUser().subscribe(
          (user:any)=>{
            this.login.setUser(user);
            console.log(user);

            this.route.navigate(['admin']);
            this.login.loginStatusSubject.next(true);

            //rediract ...ADMIN then on admin dashboard
            //rediract ...NORMAL then on NORMAL dashboard
            // if(this.login.getUserRole()=="ADMIN")
            // {
            //   //go to admin dashboard
            //   //window.location.href='/admin';
            //   this.route.navigate(['admin']);
            //   this.login.loginStatusSubject.next(true);

            // }
            // else if(this.login.getUserRole()=="NORMAL")
            // {
            //   //normal user dashboard
            //   //window.location.href='/user';

            //   this.route.navigate(['user']);
            //   this.login.loginStatusSubject.next(true);


            // }
            //  else{
            //    this.login.logout();
             
            //  }


          }

        );

      },
      (error)=>{
        console.log('error !');
        console.log(error);
        this.snak.open("Invalid details !! try again",'',
        {duration:3000,})
      }
    );


  }

}

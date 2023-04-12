import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService: UserService, private snak:  MatSnackBar ) { }

  ngOnInit(): void {
  }

  public user = {
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
    pincode:''

  }


  formSubmit() {

    //alert('submit')
    console.log(this.user);
    //validation of form filed
    if (this.user.username == '' || this.user.username == null) {
     // alert('user is required');
     this.snak.open("user name is required",'ok',{
       duration:3000,
       verticalPosition:'top',

     });
      return;
    }

    //add user:UserService
    this.userService.addUser(this.user).subscribe(
      (data :any )=> {
        console.log(data);
        //alert('success');
        Swal.fire('Successfully done !!','User id is'+data.id,'success' );

      },
      (error) => {

        //errot
        console.log(error);
        //alert('something went wrong');
        // this.snak.open('something went wrong !!','',{
        //   duration:3000,
        //   verticalPosition:'top',
        // })
        Swal.fire('Something Went Wrong, Registration not Successfull !!','','error' );



      }
    );
  }





}

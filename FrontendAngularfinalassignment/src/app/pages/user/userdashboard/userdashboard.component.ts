import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { ProductserviceService } from 'src/app/services/productservice.service';
import { DashboardComponent } from '../../admin/dashboard/dashboard.component';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {

  productdata:any;
  imageSrc:any;
  testStr:any;
  pincode:any
  

  constructor(private productserv:ProductserviceService,
    private route:ActivatedRoute,private sanitizer:DomSanitizer,private snak:MatSnackBar) { }

  ngOnInit(): void {

   this.getdetails();


  }


  public getdetails()
  {
    console.log("value of id in details page is"+this.route.snapshot.params['id']);

     this.productserv.getdetailsById(this.route.snapshot.params['id']).subscribe( (res)=>{
      console.log(res);
      this.productdata=res;
      //console.log("the value of image data is"+this.productdata.productimage);
     
      let objectURL = 'data:image/png;base64,' + this.productdata.productimage;
      this.imageSrc = this.sanitizer.bypassSecurityTrustUrl(objectURL);
     })
    

  }

  @ViewChild('fondovalor') fondovalor:ElementRef | undefined;

  public checkDeliverability()
  {
    const valueInput = this.fondovalor?.nativeElement.value;
    console.log(valueInput);
    //var value1=Number(valueInput);

    let pin=this.productdata.pincode;
    console.log(pin)
    let flag=false;
    for( let data of pin)
    {
      
      const cmpdata=data.pincode;
      //var value2=Number(cmpdata)
      console.log("for loop excuted",cmpdata);
      if(valueInput===cmpdata)
      {
        flag=true;
        console.log("success we deliver at your location",'',"success");
        // this.snak.open("We Deliver at your Location",'',
        // {duration:5000,verticalPosition:'top',})
        Swal.fire('We Deliver at your Location!!','','success');
        //return
      }
     
    }
    if(!flag)
    {
      Swal.fire('Sorry! We currently not Delivering at your Location!!','','error');


    }


  }

}

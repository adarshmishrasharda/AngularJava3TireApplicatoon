import { Byte } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { Router } from '@angular/router';

import { ProductserviceService } from 'src/app/services/productservice.service';
import { MatTableDataSource } from '@angular/material/table';







@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {


 // ProductData: ProductData[] | undefined;
  readData: any | undefined;
  imageSrc: any;
  testStr!: { 'testString': string; };
  imgSrc: any;

  searchdata: any;
  sortLTH:any;
  sortHTL:any;

  testStrin: any
  testStri: any
  constructor(private productservice: ProductserviceService, private sanitizer: DomSanitizer, private route: Router) { }

  ngOnInit(): void {
    this.getAllData();
  }

  dataSource:any;






  getAllData() {
    this.productservice.getAllProductData().subscribe((res) => {
      console.log(res, "product data is==>");

      this.readData = res;
      this.dataSource=new MatTableDataSource(this.readData);

      // for (let data of this.readData) {
      //   this.testStr = data.productimage;
        
      //   console.log("image is", data.productimage);
      //   // let objectURL = 'data:image/png;base64,' + this.testStr;
      //   // this.imageSrc = this.sanitizer.bypassSecurityTrustUrl(objectURL);
      //   // this.readData.add(this.imageSrc);

      // }
      console.log("after image added readdata is",this.readData);
      console.log()

      // let objectURL = 'data:image/png;base64,' + this.testStr;
      // this.imageSrc = this.sanitizer.bypassSecurityTrustUrl(objectURL);

      // this.testStrin=await this.testStri;
      //console.log("image valus is"+this.testStr);

      // this.imgSrc.setAttribute("src", URL.createObjectURL(this.testStrin));
     
      //this.imageSrc=this.sanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' 
      //  + this.testStr.testString);
      //console.log("the value of imgser is"+this.imageSrc);

      // if(res.length>0)
      // {
      //   console.log("data found has some length")
      //   this.readData=res.data;

      // }


    })

  }

  public search() {
    console.log("dashboard search button clicked");
    // this.route.navigate(['search']);
    this.productservice.getSearchData(this.searchdata).subscribe((res) => {
      console.log(res, "search data is==>");

      this.readData = res;
      for (let data of this.readData) {
        this.testStr = data.productimage;
        //console.log("image is", data.productimage);
        // let objectURL = 'data:image/png;base64,' + this.testStr;
        // this.imageSrc = this.sanitizer.bypassSecurityTrustUrl(objectURL);
        // this.readData.add(this.imageSrc);

      }
      //console.log("after image added readdata is",this.readData);


      let objectURL = 'data:image/png;base64,' + this.testStr;
      this.imageSrc = this.sanitizer.bypassSecurityTrustUrl(objectURL);
      //this.readData.add(this.imageSrc);


      // this.testStrin=await this.testStri;
      //console.log("image valus is"+this.testStr);

      // this.imgSrc.setAttribute("src", URL.createObjectURL(this.testStrin));
      // let objectURL = 'data:image/png;base64,' + this.testStr;
      // this.imageSrc = this.sanitizer.bypassSecurityTrustUrl(objectURL);
    })
  }


  public sortData(data:any)
  {
    let seldata=data.target.value;
   // console.log("if sort data worikin"+seldata);
   
    if(seldata==='lth')
    {

      console.log("data selected lth");
      let newdata=this.readData.sort((a: { price: number; },b: { price: number; })=> a.price-b.price);
      this.readData=newdata;


    }
    else{
      console.log("data selected htl");
      let newdata=this.readData.sort((a: { price: number; },b: { price: number; })=> b.price-a.price);
      this.readData=newdata;
    }
   
    
  }

  

  public showDetails(id:any)
  {
    console.log("edit data is"+id);
    this.route.navigate(['details/'+id]);

  }

  // applyFilter(filtervalue:string)
  // {
  //   this.dataSource.filter=filtervalue.trim().toLowerCase();
  // }


  getImage(image:any)
  {
    console.log("this is product image",image);


    let objectURL = 'data:image/png;base64,' + image;
    this.imageSrc = this.sanitizer.bypassSecurityTrustUrl(objectURL);


  }
}

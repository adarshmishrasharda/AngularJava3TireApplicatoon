import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

  constructor(private http:HttpClient) { }




  public getAllProductData()
  {
    return this.http.get(`${baseUrl}/product/getall`);

  }


  public getSearchData(searchdata:any)
  {
    console.log("search data si"+searchdata);
    
    return this.http.get(`${baseUrl}/product/search/`+searchdata);
  }


  public getdetailsById(id:any)
  {
    return this.http.get(`${baseUrl}/product/`+id);
  }


}

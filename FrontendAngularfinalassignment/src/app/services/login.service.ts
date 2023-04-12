import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  public loginStatusSubject = new Subject<boolean>();

  constructor(private http:HttpClient) { }


  //generate token
  public generateToken(logindata:any)
  {
    console.log("going to get token");
    return this.http.post(`${baseUrl}/generate-token`,logindata);
  }

  //login user:set token in local stroage
  public loginUser(token:any)
  {
    localStorage.setItem('token',token);
    //this.loginStatusSubject.next(true);
    return true;


  }

  //is login : user is login or not
  public isLoggedIn()
  {
    let tokenStr=localStorage.getItem("token");
    console.log("islogged in function in login serveice"+tokenStr);
    if(tokenStr==undefined || tokenStr==''|| tokenStr==null)
    {
      return false;
    }
    return true
  }
  //logout: remove token from local stroage
  public logout()
  {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;

  }

  //get token 
  public getToken()
  {
    return localStorage.getItem('token');
  }


  //set user details
  public  setUser(user:any)
  {
    localStorage.setItem("user",JSON.stringify(user))
  }


  //getUser
  public getUser()
  {
    let userStr =localStorage.getItem("user");
    if(userStr!=null)
    {
      return JSON.parse(userStr);
    }
    else{
      this.logout();
      return null;
    }

  }

  //getUserRole
  // public getUserRole()
  // {
  //   let user=this.getUser();
  //   return user.authorities[0].authority;
  // }

  //current user details
  public getCurrentUser()
  {

    return this.http.get(`${baseUrl}/current-user`);
  }


}

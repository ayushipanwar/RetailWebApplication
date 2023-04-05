import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  signupApiUrl='http://localhost:8083';
  loginApiUrl='http://localhost:8092';
  payLoad:any;
  cartId :any;
  constructor(private httpClient:HttpClient,private router:Router) {

   }
   signup(data:any)
   {
    console.log(data);
 return this.httpClient.post(this.signupApiUrl +"/user/signup" ,data,{
   headers:new HttpHeaders().set('Content-Type', 'application/json')})
 }
 
 login(data:any)
 {
  console.log(data.email);
  localStorage.setItem("email",data.email);
  this.httpClient.get(this.signupApiUrl+"/user/getCartId/"+data.email).subscribe((res)=>{
    this.cartId=res;
    console.log(this.cartId);
    localStorage.setItem("hello","!");
    localStorage.setItem("cartId",this.cartId);
  });
 
   return this.httpClient.post(this.loginApiUrl +"/user/login" ,data,{
   headers:new HttpHeaders().set('Content-Type', 'application/json')})
   }
logged()
{
 const token = localStorage.getItem('token');
 return token;
}




}



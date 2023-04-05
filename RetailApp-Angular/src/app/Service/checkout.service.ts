import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {
checkOutUrls ='http://localhost:9090';
  constructor(private httpClient:HttpClient) { }


  placeOrder(data:any)
  {
    console.log("Int he place orde", data)
return this.httpClient.post(this.checkOutUrls+"/checkout/add", data,{
   headers:new HttpHeaders().set('Content-Type', 'application/json')
 })
  }
}

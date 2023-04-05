import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartApi='http://localhost:8087';

public cartItemList:any;


  constructor(private httpClient:HttpClient) { 

  }
  getUserCart(id:any)
{
    return this.cartItemList=this.cartItemList=this.httpClient.get(this.cartApi + "/cart/getUserCart/"+id);
} 

add(item:any)
{
  item['prod_quantity'] = 1;
  item['total'] = item.prod_price;
  item['userId'] = localStorage.getItem("cartId");
  console.log(localStorage.getItem("cartId"));
return this.httpClient.post(this.cartApi+"/cart/add/" ,item,{
  headers:new HttpHeaders().set('Content-Type', 'application/json')
})
}
addItems(data:any, id:any)
{
return this.httpClient.post(this.cartApi+"/add/cart/"+id ,data,{
  headers:new HttpHeaders().set('Content-Type', 'application/json')
})
}

deleteCartItems(cartItemId:any)
{
  return this.httpClient.get(this.cartApi+"/cart/deleteCartItem/"+cartItemId );
}

totalAmountCart()
{ var totam=0;
  this.cartItemList.map((a:any)=>{
totam+= a.prod_price;
  })
 return totam;
}




}

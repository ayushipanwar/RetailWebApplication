import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable, Output } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CatalogService {
  
list=new EventEmitter<any>();
name:any;
productS:any;
 catUrl='http://localhost:8085';
 prodUrl='http://localhost:8084';
searchUrl='http://localhost:9093';
  constructor(private httpClient:HttpClient) { }

  category()
  {
   return this.httpClient.get(this.catUrl + "/category/getCategories")
  }

  getProductByCategory(id:any)
  {
    return this.httpClient.get(this.catUrl + "/category/getCategoryProducts/"+id);
  }
  getAllCategoryProducts()
  {
    return this.httpClient.get(this.prodUrl + "/product/view");
  }

  searchByName(name:any)
{
  console.log(name);
  this.name = name;
  // this.httpClient.get(this.searchUrl+ "/product/search/
 console.log(this.list.emit(name));

 return  this.httpClient.get(this.searchUrl+ "/product/search/"+name);
}
getname()
{
  console.log( "hello", this.name);
}
}

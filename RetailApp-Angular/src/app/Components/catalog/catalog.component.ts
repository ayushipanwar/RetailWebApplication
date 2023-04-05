import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { CartService } from 'src/app/Service/cart.service';
import { CatalogService } from 'src/app/Service/catalog.service';
import { SnackbarService } from 'src/app/Service/snackbar.service';

import { UserService } from 'src/app/Service/user.service';
import { GlobalConstants } from 'src/app/shared/GlobalConstrants';
import { ProductMapper } from 'src/app/shared/ProductMapper';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.scss']
})
export class CatalogComponent implements OnInit {
  // @Output()showCategory = new EventEmitter<any>();

list:any;

  cartItems:any;
  flag:any=false;
  responseMessage:any;
  product: ProductMapper = new ProductMapper;
  @Output()productItem=new EventEmitter<any>();
  data: any;
  arr: Array<{
    categoryId: 0,
    title: "",
    image: ""
  }> = [];
  public productList: any;
  public productWrapper: ProductMapper[] = [];
  constructor(private userService:UserService, private catalogService: CatalogService, private cartService:CartService, private sncakBarService :SnackbarService) {
    this.getAllCategories();
  
  }
  ngOnInit(): void {


//{prod_name:String, prod_desc:String,prod_image:String,prod_price:String}[]
this.catalogService.list.subscribe((list:any)=>{
  this.list = list;
  //console.log(list);
})





    this.getAllProduct();
    this.productList=this.catalogService.productS;
    const token:any = localStorage.getItem('token');
 
    if(token)
    {
      this.flag=true;

    }
    else{
      this.flag =false;
    }
  }
  // ngOnChanges()
  // {
  //   this.productList=this.catalogService.productS;
  // }

  getAllCategories() {
    this.catalogService.category().subscribe((response: any) => {
      this.data = response;
      //this.productWrapper = response;
      console.log(response);

      this.arr.push(...response);
      console.log(this.arr);
    }, (error: any) => {
      console.log(error);
    });
  }


  productCatgeory(id: any) {
    console.log(id);

    this.catalogService.getProductByCategory(id).subscribe((response: any) => {
      this.productList = response;
      this.productWrapper = response;
      console.log(this.productList);
    }, (error: any) => {
      console.log(error);
    })
  }
  getAllProduct() {
    this.catalogService.getAllCategoryProducts().subscribe((response: any) => {
      this.productList = response;
      this.productWrapper= response;
      console.log(this.data);
    }, (error: any) => {
      console.log(error);
    })
  }


 //cart
 addToCart(item:any)
 {
  if(this.flag === false)
  {
   this.sncakBarService.openSnackBar("Pls First Login","error");
  }
  else{
 this.cartService.add(item).subscribe((res:any)=>{
  console.log(res);
this.responseMessage= res?.message;
 },(error)=>{
  console.log(error);
  console.log(error.error)
  if(error.error)
  {
    this.responseMessage = error.error;
  }
  else{
    this.responseMessage = GlobalConstants.genricError;
  }
  this.sncakBarService.openSnackBar(this.responseMessage,"error");
  
 }
 
 );

}
 }

//  getUserCartItems(id:any)
// {
//   this.cartService.getUserCart(id).subscribe((res)=>{
//     this.cartItems=res;
//     console.log(this.cartItems);
//   })
// }

}

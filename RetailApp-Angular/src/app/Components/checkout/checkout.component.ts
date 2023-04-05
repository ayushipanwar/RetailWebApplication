import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormGroup,FormControlName, Validators } from '@angular/forms';
import { MatDialog,MatDialogConfig,MatDialogRef } from '@angular/material/dialog';
import { CartService } from 'src/app/Service/cart.service';
import { CheckoutService } from 'src/app/Service/checkout.service';
import { SnackbarService } from 'src/app/Service/snackbar.service';
import { GlobalConstants } from 'src/app/shared/GlobalConstrants';
import { PaymentComponent } from '../payment/payment.component';
@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent {
deliveryDetail:any=FormGroup;
cartItems:any;
totalAmount:any =0;


  constructor(public dialogref:MatDialogRef<CheckoutComponent>, private dialog:MatDialog,private formBuilder :FormBuilder, private cartService:CartService,private checkOutService :CheckoutService,private snackBarService:SnackbarService)
  {
    
  }


  payment()
  {
    const dialogConfig = new MatDialogConfig();
     dialogConfig.width = "600px";
     dialogConfig.height="500px";
     this.dialog.open(PaymentComponent,dialogConfig);
  }

  ngOnInit(): void {
 
   this.deliveryDetail = this.formBuilder.group({
       name:[null,[Validators.required]],
      contactNumber:[null,[Validators.required]],
       address:[null,[Validators.required]],
       city:[null,[Validators.required]],
      // state:[''],
       pinCode:[null,[Validators.required]]
 
     })
     this.getData();
 this.totalAmount =this.grandAmount();
  
  }

  ngOnChanges()
  {
    let grandTotal =0;
    this.cartItems.map((a:any)=>{
      let num= (+a.prod_price);
      
      console.log(a.prod_price);
      
      grandTotal =grandTotal+num;
    })
    
   
  }
  grandAmount()
  {
    let grandTotal =0;
    this.cartItems.map((a:any)=>{
      let num= (+a.prod_price);
      
      console.log(a.prod_price);
      
      grandTotal =grandTotal+num;
    })
    
    console.log(grandTotal);
 return grandTotal;
  }




handleSubmit()
{
  var formData = this.deliveryDetail.value;
  console.log(formData);
   var data={
 name:formData.name,
contactNumber:formData.contactNumber,
 address:formData.address,
 pinCode:formData.pinCode,
 city:formData.city,
 userId:localStorage.getItem("cartId")
 }
   console.log(localStorage.getItem("cartId"));
   console.log(data);;
   this.checkOutService.placeOrder(data).subscribe((res:any)=>{
   
this.snackBarService.openSnackBar("U re RIght",GlobalConstants.genricError);
console.log(res?.message);
   },(error)=>{
    console.log(error);
    this.snackBarService.openSnackBar(error?.error.message,GlobalConstants.genricError);
   })
   this.dialogref.close()
this.payment();
}

getData()
{
  this.cartService.getUserCart(localStorage.getItem('cartId')).subscribe((res)=>{
    this.cartItems = res;
    console.log(res);
    this.cartItems.map((a:any)=>{
      this.totalAmount += +a.prod_price;})
  })
 
}

}

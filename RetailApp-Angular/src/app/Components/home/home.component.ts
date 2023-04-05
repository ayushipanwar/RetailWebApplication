import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { CartService } from 'src/app/Service/cart.service';
import { UserService } from 'src/app/Service/user.service';
import { LoginComponent } from '../login/login.component';
import { SignUpComponent } from '../sign-up/sign-up.component';
import jwt_Decode from 'jwt-decode';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CatalogService } from 'src/app/Service/catalog.service';
import { SnackbarService } from 'src/app/Service/snackbar.service';
import { GlobalConstants } from 'src/app/shared/GlobalConstrants';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent  implements OnInit{
productList:any;
flag:any = false;
tokenValid:any;
inputForm:any=FormGroup;

  constructor( private snackBarService:SnackbarService ,private formBuilder:FormBuilder, private catalogService:CatalogService, private dialog:MatDialog, private userService:UserService)
  {
    // this.productList = this.cartService.cartItemList;
    // console.log(this.productList.length)
  }


checkTokenValidity()
{
  const token:any = localStorage.getItem('token');
  console.log(token);
const expiry = (JSON.parse(atob(token.split('.')[1]))).exp;
console.log(expiry);
if(expiry * 1000 < Date.now())
{
  localStorage.clear();
}
var number;
return  this.tokenValid = expiry * 1000 > Date.now();
}

 


  ngOnInit()
  {
   
this.inputForm = this.formBuilder.group({
  input:[null,[Validators.required]]
})

    console.log(this.checkTokenValidity())

    const token:any = localStorage.getItem('token');
 
    if(token)
    {
      this.flag=true;

    }
    else{
      this.flag =false;
    }
    }
  handleSignupAction()
  {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = "550px";
    
    this.dialog.open(SignUpComponent,dialogConfig);
  }
  handleLoginAction()
  {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.width = "400px";
    
    this.dialog.open(LoginComponent,dialogConfig);
  }
  handleSubmit()
  {
    var data = this.inputForm.value;
    
    console.log(data.input);
   var name = data.input;
     this.catalogService.searchByName(name)
    //  .subscribe((res:any)=>{
    //   console.log(res);

    //   if(res?.error)
    //   {
    //     this.snackBarService.openSnackBar(res?.error,GlobalConstants.genricError);
    //   }
    //   },)

  }

  logoutAction()
  {
    localStorage.clear();
    this.reloadCurrentPage();
  }

  reloadCurrentPage() {
    window.location.reload();
   }

}



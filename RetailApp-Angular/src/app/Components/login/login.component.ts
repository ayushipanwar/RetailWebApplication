import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { SnackbarService } from 'src/app/Service/snackbar.service';

import { UserService } from 'src/app/Service/user.service';
import { GlobalConstants } from 'src/app/shared/GlobalConstrants';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  hide = true;
  loginForm:any = FormGroup;
  responseMessage:any;
    constructor(private formBuilder:FormBuilder,private router:Router,private sncakBarService:SnackbarService,
      private userService:UserService,
      public dialogRef:MatDialogRef<LoginComponent>,
     )
       { }
  
    ngOnInit(): void {
      this.loginForm = this.formBuilder.group({
        email:[null,[Validators.required, Validators.pattern(GlobalConstants.emailRegex)]],
        password:[null,[Validators.required]]
        
      })
  
      }
     
      handleSubmit()
      {
      var formData = this.loginForm.value;
      var data={
        email:formData.email,
        password:formData.password
      }
      this.userService.login(data).subscribe((response:any)=>{
        this.dialogRef.close();
      localStorage.setItem('token',response.token);//saving jwt token to localSorage in inspect
      //this.router.navigate(['/']);
      this.reloadCurrentPage();
      
      },(error)=>{
  if(error.error?.message)
  {
    this.responseMessage = error.error?.message;
  }
  else{
    this.responseMessage = GlobalConstants.genricError;
  }
  this.sncakBarService.openSnackBar(this.responseMessage,"error");
  
      }
      );
      this.responseMessage="Logged in succesfully";
      this.sncakBarService.openSnackBar(this.responseMessage,"error");
      }
  
      reloadCurrentPage() {
        window.location.reload();
       }

}

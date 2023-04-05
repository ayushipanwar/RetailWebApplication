import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { SnackbarService } from 'src/app/Service/snackbar.service';

import { UserService } from 'src/app/Service/user.service';
import { GlobalConstants } from 'src/app/shared/GlobalConstrants';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent  {

  
  password = true;
  confirmPassword = true;
  signupForm:any = FormGroup
  responseMessage:any;
  constructor(private formBuilder:FormBuilder, private router:Router,
    private userService:UserService,
   private snackBarService:SnackbarService,
    public dialogRef:MatDialogRef<SignUpComponent>){ }

  ngOnInit(): void {
    this.signupForm = this.formBuilder.group({
      name:[null,[Validators.required,Validators.pattern(GlobalConstants.nameRegex)]],
      email:[null,[Validators.required,Validators.pattern(GlobalConstants.emailRegex)]],
      contactNumber:[null, [Validators.required, Validators.pattern(GlobalConstants.contactNumberRegex)]],
      password:[null,[Validators.required]],
      confirmPassword:[null,[Validators.required]]
      
    })
  }

  validateSubmit()
  {

    if(this.signupForm.controls['password'].value != this.signupForm.controls['confirmPassword'].value)
    {
      return true;
    }
    else{
      return false
    }

  }


  handleSubmit()//when someone hit signup it will come here and all the data will be fetched in data
  {
    var formData = this.signupForm.value;
    var data = {
      name:formData.name,
      email:formData.email,
      contactNumber:formData.contactNumber,
      password:formData.password
    }
    //now the data will 
    this.userService.signup(data).subscribe((response:any)=>{
      this.dialogRef.close();
      this.responseMessage = response?.message;
      this.snackBarService.openSnackBar(this.responseMessage,"");
      // this.router.navigate(['/'])
    },(error)=>{
      if(error.error?.message)
      {
        this.responseMessage = error.error?.message;
      }
      else{
        this.responseMessage = GlobalConstants.genricError;
      }
      this.snackBarService.openSnackBar(this.responseMessage,GlobalConstants.error);
    })
  }



}

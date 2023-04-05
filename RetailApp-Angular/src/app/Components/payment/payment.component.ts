import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent {

  constructor(public dialogRef:MatDialogRef<PaymentComponent>){}

  Paymentclose()
  {
    this.dialogRef.close();
  }
}

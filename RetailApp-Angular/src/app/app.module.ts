import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatDialogModule} from '@angular/material/dialog';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './Components/home/home.component';
import { SearchComponent } from './Components/search/search.component';
import { CatalogComponent } from './Components/catalog/catalog.component';
import { HttpClientModule } from '@angular/common/http';
import { CartComponent } from './Components/cart/cart.component';
import { ProductComponent } from './Components/product/product.component';
import { CheckoutComponent } from './Components/checkout/checkout.component';
import { LoginComponent } from './Components/login/login.component';
//import { SihnUpComponent } from './Components/sihn-up/sihn-up.component';
import { SignUpComponent } from './Components/sign-up/sign-up.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MaterialModule } from './shared/material-module';
import { SnackbarService } from './Service/snackbar.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PaymentComponent } from './Components/payment/payment.component';
import { FooterComponent } from './Components/footer/footer.component';
import { HeaderComponent } from './Components/header/header.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SearchComponent,
    CatalogComponent,
    CartComponent,
    ProductComponent,
    CheckoutComponent,
    LoginComponent,
    SignUpComponent,
    PaymentComponent,
    FooterComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatDialogModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatFormFieldModule,
    MaterialModule,
    BrowserAnimationsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

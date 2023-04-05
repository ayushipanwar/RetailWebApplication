import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './Components/cart/cart.component';
import { CatalogComponent } from './Components/catalog/catalog.component';
import { CheckoutComponent } from './Components/checkout/checkout.component';
import { HeaderComponent } from './Components/header/header.component';
import { LoginComponent } from './Components/login/login.component';
import { PaymentComponent } from './Components/payment/payment.component';
import { SearchComponent } from './Components/search/search.component';
import { SignUpComponent } from './Components/sign-up/sign-up.component';

const routes: Routes = [
  {path:'',redirectTo:'catalog',pathMatch:'full'},
  {path:'catalog',component:CatalogComponent},
  {path:'cart', component:CartComponent},
  {path:'checkout', component:CheckoutComponent},
  {path:'login', component:LoginComponent},
  {path:'signup', component:SignUpComponent},
  {path:'payment', component:PaymentComponent},
  {path:'search', component:SearchComponent},
{path:'header',component:HeaderComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Component } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  constructor(private router:Router, private dialog:MatDialog) {
  }

  logout()
  {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data ={
      message:'Logout',
      confirmation:true
    }

      localStorage.clear();
      this.router.navigate(['/']);
    }

 
}

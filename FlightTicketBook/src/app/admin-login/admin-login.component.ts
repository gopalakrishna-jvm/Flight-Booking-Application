import { Component, OnInit } from '@angular/core';
import { Admin } from '../Entity/admin';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {

  admin: Admin = new Admin();
  dataBaseDetails!: Admin;
  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.admin);
    this.adminService.getAdmin(this.admin).subscribe(data => {
      this.dataBaseDetails = data;
      this.checkDetails(this.dataBaseDetails);
    });
  }

  checkDetails(dataBaseadmin: Admin) {
    if (dataBaseadmin.password == this.admin.password) {
      alert("login seccuss");
    } else {
      alert("please enter currect password");
    }
  }
}

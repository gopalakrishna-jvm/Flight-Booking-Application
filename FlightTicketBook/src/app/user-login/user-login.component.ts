import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../Entity/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  user: User = new User();
  dataBaseUser! :User;

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
  }

  onSubmit() {
    this.userService.getUser(this.user.mail).subscribe(data =>{
      this.dataBaseUser =data;
      console.log("data base details : " + this.dataBaseUser);
    })
    console.log(this.user +"user Entered details");
    this.checkDetails(this.dataBaseUser);
  }
  onSignUp(){
    this.router.navigate(['user-registar'])
  }
  checkDetails(dataBaseUser : User){
    if(dataBaseUser.password==this.user.password){
      alert("login seccuss");
    }else{
      alert("please enter currect password");
    }
  }

}

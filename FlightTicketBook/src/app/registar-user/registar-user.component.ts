import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../Entity/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-registar-user',
  templateUrl: './registar-user.component.html',
  styleUrls: ['./registar-user.component.css']
})
export class RegistarUserComponent implements OnInit {

  user: User = new User();
  existingUser ! : User;
  registaredUser !: User;
  constructor(private userService: UserService , private router: Router) { }

  ngOnInit(): void {
  }
  onSubmit() {
    console.log(this.user)
    this.checkPaasword(this.user);
    this.checkDuplicate(this.user.mail);
   // 
  }

  // form validation
  checkPaasword(user: User) {
    if (user.password != user.reEnterPassword) {
      alert("passsword and re-enter password should match");
    }
    if (!user.mail.trim().endsWith("@gmail.com")) {

      alert("mail id should end with @gmail.com");
    }
  }
  saveUser(user: User) {
    this.userService.save(user).subscribe(data => {
      this.registaredUser = data;
      alert("User registation success, id : " + this.registaredUser.id);
      this.router.navigate(['user-login']);
    })
  }

  checkDuplicate(mail : string){
    this.userService.getUser(mail).subscribe(data =>{
      this.existingUser =data;
      if(this.existingUser== null){
        this.saveUser(this.user);
      }else{
        alert("please provide another mail ")
      }
    })
  }
}

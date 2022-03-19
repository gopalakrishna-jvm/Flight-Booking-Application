import { Component, OnInit } from '@angular/core';
import { User } from '../Entity/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-registar-user',
  templateUrl: './registar-user.component.html',
  styleUrls: ['./registar-user.component.css']
})
export class RegistarUserComponent implements OnInit {

  user : User =new User();
  constructor(private userService : UserService) { }

  ngOnInit(): void {
  }
  onSubmit(){

  }
}

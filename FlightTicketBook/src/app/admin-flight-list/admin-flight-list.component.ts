import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Flight } from '../Entity/flight';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-admin-flight-list',
  templateUrl: './admin-flight-list.component.html',
  styleUrls: ['./admin-flight-list.component.css']
})
export class AdminFlightListComponent implements OnInit {
  flights ! : Flight[];
  constructor(private adminService : AdminService ,private router : Router) { }

  ngOnInit(): void {
  }
  editFlight(flightNo: String) {
    this.router.navigate(['edit-flight', flightNo])
  }

}

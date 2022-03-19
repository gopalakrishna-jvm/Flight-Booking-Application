import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SearchDetails } from '../Entity/search-details';
import { UserService } from '../services/user.service';


@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {

  flights!: any;

  //flight : Flight =new Flight();
  searchDetails: SearchDetails = new SearchDetails();

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    // this.searchFlight();
  }

  searchFlight() {
    this.userService.searchFlight(this.searchDetails.departureFrom, this.searchDetails.arrivalTo, this.searchDetails.departureDate).subscribe(data => {
      this.flights = data;
      console.log(this.flights);
    })
    
  }
 

  onSubmit() {
    console.log(this.searchDetails);
    this.searchFlight();
  }

  TicketBooking(flightNo: string) {
    this.router.navigate(['ticket-booking', flightNo])
  }


}

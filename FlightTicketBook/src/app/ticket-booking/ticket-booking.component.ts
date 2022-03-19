import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Passenger } from '../Entity/passenger';
import { Ticket } from '../Entity/ticket';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-ticket-booking',
  templateUrl: './ticket-booking.component.html',
  styleUrls: ['./ticket-booking.component.css']
})
export class TicketBookingComponent implements OnInit {

  passenger: Passenger =new Passenger();
  passengers : Array<Passenger>= [];
  ticket! : Ticket;
 
  flightNo! : string;

  constructor(private userService : UserService,private route : ActivatedRoute) { }

  ngOnInit(): void {

   
  }

  onSubmit(){
    this.flightNo =this.route.snapshot.params['flightNo'];
    this.userService.bookFlight( this.passenger , this.flightNo).subscribe( data =>{
      console.log(data);
      this.ticket =data;
      alert('ticket booking success , ticket pnr :' +  this.ticket.pnr);
    },
    error => console.log(error));
  }
  onAdd(){
    console.log(this.passenger)
    this.passengers.push(this.passenger);
    alert('passenger added succussfuly click ok to add new passanger')
    console.log(this.passengers)
  }
}

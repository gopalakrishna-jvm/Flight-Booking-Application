import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FlightListComponent } from './flight-list/flight-list.component';
import { TicketBookingComponent } from './ticket-booking/ticket-booking.component';

const routes: Routes = [
  { path: '', redirectTo: 'flight-search', pathMatch: 'full' },
  { path: 'flight-search', component: FlightListComponent },
  { path: 'ticket-booking/:flightNo', component: TicketBookingComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

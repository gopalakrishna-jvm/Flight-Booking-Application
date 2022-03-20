import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminAddFlightComponent } from './admin-add-flight/admin-add-flight.component';
import { AdminFlightListComponent } from './admin-flight-list/admin-flight-list.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { EditFlightComponent } from './edit-flight/edit-flight.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { RegistarUserComponent } from './registar-user/registar-user.component';
import { TicketBookingComponent } from './ticket-booking/ticket-booking.component';
import { UserHistoryComponent } from './user-history/user-history.component';
import { UserLoginComponent } from './user-login/user-login.component';



const routes: Routes = [
  { path: '', redirectTo: 'flight-search', pathMatch: 'full' },
  { path: 'flight-search', component: FlightListComponent },
  { path: 'ticket-booking/:flightNo', component: TicketBookingComponent },
  { path : 'admin-login', component : AdminLoginComponent},
  { path :'user-login' , component : UserLoginComponent},
  {path : 'user-registar' , component : RegistarUserComponent},
  {path : 'user-history' , component : UserHistoryComponent},
  {path : 'add-flight' , component : AdminAddFlightComponent},
  {path : 'add-flight/admin-flight-list' , component : AdminFlightListComponent},
  {path : 'edit-flight' ,component : EditFlightComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { RegistarUserComponent } from './registar-user/registar-user.component';
import { TicketBookingComponent } from './ticket-booking/ticket-booking.component';
import { UserLoginComponent } from './user-login/user-login.component';



const routes: Routes = [
  { path: '', redirectTo: 'flight-search', pathMatch: 'full' },
  { path: 'flight-search', component: FlightListComponent },
  { path: 'ticket-booking/:flightNo', component: TicketBookingComponent },
  { path : 'admin-login', component : AdminLoginComponent},
  { path :'user-login' , component : UserLoginComponent},
  {path : 'user-registar' , component : RegistarUserComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

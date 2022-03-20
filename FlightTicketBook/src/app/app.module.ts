import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FlightListComponent } from './flight-list/flight-list.component';
import { TicketBookingComponent } from './ticket-booking/ticket-booking.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { RegistarUserComponent } from './registar-user/registar-user.component';
import { UserHistoryComponent } from './user-history/user-history.component';
import { AdminAddFlightComponent } from './admin-add-flight/admin-add-flight.component';
import { AdminFlightListComponent } from './admin-flight-list/admin-flight-list.component';
import { EditFlightComponent } from './edit-flight/edit-flight.component';

@NgModule({
  declarations: [
    AppComponent,
    FlightListComponent,
    TicketBookingComponent,
    AdminLoginComponent,
    UserLoginComponent,
    RegistarUserComponent,
    UserHistoryComponent,
    AdminAddFlightComponent,
    AdminFlightListComponent,
    EditFlightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

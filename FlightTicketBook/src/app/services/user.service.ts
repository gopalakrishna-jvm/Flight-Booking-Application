import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Flight } from '../Entity/flight';
import { Passenger } from '../Entity/passenger';
import { SearchDetails } from '../Entity/search-details';
import { Ticket } from '../Entity/ticket';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  private baseURL = "http://localhost:8082/flight/";

  searchFlight(departureFrom: String, arrivalTo: String, departureDate: String) {
    return this.httpClient.post(this.baseURL + "search?" + "flightDeparture=" + departureFrom + "&flightArrival=" + arrivalTo + "&departureDate=" + departureDate, {
      headers: {
        "content-type": 'application/json'
      }
    });
  }
  
  bookFlight(passengers : Passenger ,flightNo : String) : Observable<any>{
   return this.httpClient.post(`${this.baseURL+"booking"}/${flightNo}`, passengers)
  }



}

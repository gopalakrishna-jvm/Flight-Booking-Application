import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../Entity/admin';
import { Flight } from '../Entity/flight';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient: HttpClient) { }

  private adminUrl = "http://localhost:8082/flight/admin/login";
  getAdmin(admin: Admin): Observable<any> {
    return this.httpClient.post(`${this.adminUrl}`, admin);
  }
  private addFlightURL = "http://localhost:8082/flight/airline/inventory/add";
  addFlight(flight: Flight): Observable<any> {
    return this.httpClient.post(`${this.addFlightURL}`, flight);
  }
  private getFlightUrl="http://localhost:8082/flight/airline";
  getFlightById( flightNo: String) : Observable<any>{
    return this.httpClient.get(`${this.getFlightUrl}/${flightNo}`);
  }
}

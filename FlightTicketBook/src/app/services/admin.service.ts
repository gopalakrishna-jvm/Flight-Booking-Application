import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin } from '../Entity/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private httpClient: HttpClient) { }

     private adminUrl ="http://localhost:8082/flight/admin/login";
     
     getAdmin(admin : Admin) : Observable<any> {
     return this.httpClient.post(`${this.adminUrl}`,admin);
  }
}

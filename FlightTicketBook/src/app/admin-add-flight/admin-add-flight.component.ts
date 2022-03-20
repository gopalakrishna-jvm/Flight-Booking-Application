import { Component, OnInit } from '@angular/core';
import { Flight } from '../Entity/flight';
import { AdminService } from '../services/admin.service';

@Component({
  selector: 'app-admin-add-flight',
  templateUrl: './admin-add-flight.component.html',
  styleUrls: ['./admin-add-flight.component.css']
})
export class AdminAddFlightComponent implements OnInit {

  flight : Flight =new Flight();
  createdFlightDetails! : Flight;
  existingFlight ! :Flight;

  constructor(private adminService : AdminService ) { }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.flight)
    this.checkDuplicate(this.flight.flightNo);
  }

  checkDuplicate(flightNo : String){
    this.adminService.getFlightById(flightNo).subscribe(data =>{
      this.existingFlight=data;
      console.log("exigesting flight : "+this.existingFlight)
      if(this.existingFlight==null){
        this.adminService.addFlight(this.flight).subscribe(data =>{
          this.createdFlightDetails =data;
          alert("Flight added success");
        })
      }else{
        alert("already flight exigesting with flight no : "+flightNo);
      }

    })
  }
}

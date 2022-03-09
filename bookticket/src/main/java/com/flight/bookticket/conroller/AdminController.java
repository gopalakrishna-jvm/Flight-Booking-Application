package com.flight.bookticket.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.bookticket.modal.Admin;
import com.flight.bookticket.modal.Flight;
import com.flight.bookticket.services.AdminServiceImpl;

@RestController
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    @PostMapping("/flight/airline/inventory/add")
    public Flight addFlight(@RequestBody Flight flight){return adminService.addFlight(flight);}

    @PostMapping("/flight/admin/login")
    public Admin login(@RequestBody Admin admin) {
        return adminService.login(admin);
    }

    @PutMapping("/flight/admin/status")
    public String changeStatus(@RequestParam(value ="flightNo") String flightNo,@RequestParam(value ="status") String status){
      return adminService.changeStatus(flightNo,status);
    }

}

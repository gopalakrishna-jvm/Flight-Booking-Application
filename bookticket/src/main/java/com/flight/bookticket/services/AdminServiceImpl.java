package com.flight.bookticket.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flight.bookticket.modal.Admin;
import com.flight.bookticket.modal.Flight;
import com.flight.bookticket.repository.AdminRepository;
import com.flight.bookticket.repository.FlightRepository;

@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    AdminRepository adminRepository;

    public  Flight addFlight(Flight flight){return flightRepository.save(flight);}

    public Admin login(Admin admin) {
        Optional<Admin> admin2= Optional.ofNullable(adminRepository.findByAdminName(admin.getName()));
        if (!admin2.isPresent()) {
            return new Admin();
        }
        Admin admin1= admin2.get();
        if (admin1.getPassword().equals(admin.getPassword())){
            return admin1;
        }
        return new Admin();
    }

    public String changeStatus(String flightNo,String status){
        Optional<Flight> flightCheck = Optional.ofNullable(flightRepository.findByFlightNo(flightNo));
        if (!flightCheck.isPresent()){
            return "Flight not present";
        }
        Flight flight = flightRepository.findByFlightNo(flightNo);
        flight.setStatus(status);
        flightRepository.save(flight);
        return  "status changed";
    }
}
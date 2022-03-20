package com.flight.bookticket.services;

import com.flight.bookticket.modal.Admin;
import com.flight.bookticket.modal.Flight;

public interface AdminService {

    public Admin login(Admin admin);
    public Flight addFlight(Flight flight);
    public String changeStatus(String flightNo,String status);
    public Flight getFlight(String flightNo);
}
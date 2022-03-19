package com.flight.bookticket.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.flight.bookticket.modal.Ticket;
import com.flight.bookticket.modal.Flight;
import com.flight.bookticket.modal.Passenger;
import com.flight.bookticket.modal.User;

public interface UserService {
    public List<Flight> search(String flightDeparture, String flightArrival , String departureDate);
    
    public Ticket bookFlight(String flightNo, Passenger passengers);
    
    public User registar(User user);
    
    public Ticket findByPnr(@PathVariable(value = "pnr") String pnr);
    
    public List<Ticket> findByMail(String emailId);
    
    public Ticket cancelTicket(String pnr);
}
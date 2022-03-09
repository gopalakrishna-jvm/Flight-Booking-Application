package com.flight.bookticket.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.flight.bookticket.modal.Booking;
import com.flight.bookticket.modal.Flight;
import com.flight.bookticket.modal.Passenger;
import com.flight.bookticket.modal.User;

public interface UserService {
    public List<Flight> search(String flightDeparture, String flightArrival);
    
    public Optional<Booking> userBookFlight(String flightNo, Passenger passenger);
    
    public User userRegistration(User user);
    
    public Booking findByPnr(@PathVariable(value = "pnr") String pnr);
    
    public List<Booking> findByMail(String emailId);
    
    public Booking deleteByPnr(String pnr);
}
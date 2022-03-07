package com.flight.bookticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.bookticket.admin.entity.Flight;
import com.flight.bookticket.entity.Ticket;
import com.flight.bookticket.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;

	@GetMapping("/flight/search")
	public List<Flight> searchFlight(@RequestBody Flight flight) {
		return userService.getFlights(flight);
		
	}
	
	@PostMapping("/flight/book/{flightNumber}")
	public ResponseEntity<?> bookFlight(@PathVariable int flightNumber , @RequestBody Ticket ticket){
		return null;
		
	}
	@GetMapping("/flight/ticket/{pnr}")
	public Ticket getTicket(@PathVariable int pnr) {
		return null;
		
	}
	
	@GetMapping("/flight/booking/history/{mailId}")
	public List<Ticket> getTicket(@PathVariable String mailId) {
		return null;
		
	}
	@PutMapping("/flight/booking/cancle/{pnr}")
	public Ticket cancleTicket(@PathVariable int pnr) {
		return null;
		
	}
}

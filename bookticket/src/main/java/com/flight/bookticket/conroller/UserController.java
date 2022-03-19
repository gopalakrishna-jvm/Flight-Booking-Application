package com.flight.bookticket.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.bookticket.modal.Flight;
import com.flight.bookticket.modal.Passenger;
import com.flight.bookticket.modal.Ticket;
import com.flight.bookticket.modal.User;
import com.flight.bookticket.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value ="/flight/search")
	public ResponseEntity<?> search(@RequestParam String flightDeparture, @RequestParam String flightArrival ,  @RequestParam String departureDate) {
		return new ResponseEntity<List<Flight>>(userService.search(flightDeparture, flightArrival , departureDate), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/flight/booking/{flightNo}")
	public ResponseEntity<?> bookFlight(@PathVariable(name = "flightNo") String flightNo,
			@RequestBody Passenger passengers) {
		return new ResponseEntity<Ticket>(userService.bookFlight(flightNo, passengers), HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/flight/airline/registar")
	public ResponseEntity<?> registration(@RequestBody User user) {
		return new ResponseEntity<User>(userService.registar(user), HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/flight/airline/registar/{mail}")
	public ResponseEntity<User> getByMail(@PathVariable(name = "mail") String mail) {
		return new ResponseEntity<User>(userService.getUser(mail), HttpStatus.OK);
	}

	@GetMapping(value = "/flight/ticket/{pnr}", consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"content-type=application/json" })
	public ResponseEntity<?> findByPnr(@PathVariable(value = "pnr") String pnr) {
		return new ResponseEntity<Ticket>(userService.findByPnr(pnr), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/flight/booking/history/{emailId}", consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"content-type=application/json" })
	public ResponseEntity<?> findByMail(@PathVariable(value = "emailId") String emailId) {
		return new ResponseEntity<List<Ticket>>(userService.findByMail(emailId), HttpStatus.OK);
	}

	@DeleteMapping(value = "/flight/booking/cancel/{pnr}", consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"content-type=application/json" })
	public ResponseEntity<?> cancelTicket(@PathVariable(value = "pnr") String pnr) {
		return new ResponseEntity<Ticket>(userService.cancelTicket(pnr), HttpStatus.OK);
	}
}
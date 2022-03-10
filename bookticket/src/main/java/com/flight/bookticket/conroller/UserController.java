package com.flight.bookticket.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	@GetMapping(value = "/flight/search", consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"content-type=application/json" })
	public ResponseEntity<?> search(@RequestParam String flightDeparture, @RequestParam String flightArrival) {
		return new ResponseEntity<List<Flight>>(userService.search(flightDeparture, flightArrival), HttpStatus.OK);
	}

	@PostMapping(value = "/flight/booking/{flightNo}", consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"content-type=application/json" })
	public ResponseEntity<?> bookFlight(@PathVariable(name = "flightNo") String flightNo,
			@RequestBody Passenger passenger) {
		return new ResponseEntity<Ticket>(userService.bookFlight(flightNo, passenger), HttpStatus.CREATED);
	}

	@PostMapping(value = "/flight/airline/UserRegister", consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"content-type=application/json" })
	public ResponseEntity<?> registration(@RequestBody User user) {
		return new ResponseEntity<User>(userService.registar(user), HttpStatus.CREATED);
	}

	@GetMapping(value = "/flight/ticket/{pnr}", consumes = MediaType.APPLICATION_JSON_VALUE, headers = {
			"content-type=application/json" })
	public ResponseEntity<?> findByPnr(@PathVariable(value = "pnr") String pnr) {
		return new ResponseEntity<Ticket>(userService.findByPnr(pnr), HttpStatus.OK);
	}

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
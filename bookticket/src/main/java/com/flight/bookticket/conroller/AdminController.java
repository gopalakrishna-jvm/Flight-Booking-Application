package com.flight.bookticket.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.bookticket.modal.Admin;
import com.flight.bookticket.modal.Flight;
import com.flight.bookticket.services.AdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	AdminService adminService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/flight/airline/inventory/add")
	public ResponseEntity<?> addFlight(@RequestBody Flight flight) {
		return new ResponseEntity<Flight>(adminService.addFlight(flight), HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/flight/admin/login")
	public ResponseEntity<?> login(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.login(admin), HttpStatus.ACCEPTED);
	}

	@PutMapping("/flight/admin/status")
	public ResponseEntity<?> changeStatus(@RequestParam(value = "flightNo") String flightNo,
			@RequestParam(value = "status") String status) {
		return new ResponseEntity<String>(adminService.changeStatus(flightNo, status), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/flight/airline/{flightNo}")
	public ResponseEntity<?> getFlight(@PathVariable(name = "flightNo") String flightNo) {
		return new ResponseEntity<Flight>(adminService.getFlight(flightNo), HttpStatus.OK);
	}

}

package com.flight.bookticket.conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.bookticket.modal.Admin;
import com.flight.bookticket.modal.Flight;
import com.flight.bookticket.services.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping(value = "/flight/airline/inventory/add", headers = {
			"content-type=application/json" })
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

}

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

	public Flight addFlight(Flight flight) {
		return flightRepository.save(flight);
	}
	
	public Flight getFlight (String flightNo) {
		
		return flightRepository.findByFlightNo(flightNo);
	}

	public Admin login(Admin admin) {
		if (admin != null) {
			Admin credentials = adminRepository.findByAdminName(admin.getName());
			if (credentials != null) {
				if (credentials.getPassword().equals(admin.getPassword()))
					return credentials;
			}
		}
		return new Admin();
	}

	public String changeStatus(String flightNo, String status) {

		if (flightNo != null) {
			Flight flight = flightRepository.findByFlightNo(flightNo);
			if (flight != null) {
				flight.setStatus(status);
				flightRepository.save(flight);
				return "status changed";
			}
			return "Flight not present";
		}
		return "Flight number should not be null";
	}
}
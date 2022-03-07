package com.flight.bookticket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.flight.bookticket.admin.entity.Flight;
import com.flight.bookticket.repository.IAdminRepository;
import com.flight.bookticket.repository.IUserRepository;

public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IAdminRepository adminRepository;

	public List<Flight> getFlights(Flight flight) {
		List<Flight> flights = new ArrayList();
		if (flight.getFlightNumber() != 0) {
			Flight searchedFlight = adminRepository.getById(flight.getFlightNumber());
			flights.add(searchedFlight);
		}

		if (flight.getFromPlace() != null && flight.getToPlace() != null) {

			List<Flight> allFlights = adminRepository.findAll();
			for (Flight eachFlight : allFlights) {
				if (eachFlight.getFromPlace() == flight.getFromPlace()
						&& eachFlight.getToPlace() == flight.getToPlace()) {
					flights.add(eachFlight);
				}
			}
		}

		return flights;
	}
}

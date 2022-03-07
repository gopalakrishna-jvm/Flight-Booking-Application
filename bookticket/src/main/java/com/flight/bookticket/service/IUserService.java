package com.flight.bookticket.service;

import java.util.List;

import com.flight.bookticket.admin.entity.Flight;

public interface IUserService {
	public List<Flight> getFlights(Flight flight);
}

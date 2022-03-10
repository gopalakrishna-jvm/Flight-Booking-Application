package com.flight.bookticket.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.flight.bookticket.modal.Ticket;
import com.flight.bookticket.modal.Flight;
import com.flight.bookticket.modal.Passenger;
import com.flight.bookticket.modal.User;
import com.flight.bookticket.repository.BookingRepository;
import com.flight.bookticket.repository.FlightRepository;
import com.flight.bookticket.repository.PassengerRepository;
import com.flight.bookticket.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookingRepository bookingRepository;
	@Autowired
	PassengerRepository passengerRepository;

	public List<Flight> search(String flightDeparture, String flightArrival) {
		return flightRepository.findByDeparture(flightDeparture, flightArrival);
	}

	public Ticket bookFlight(String flightNo, Passenger passenger) {

		if (flightNo != null && flightRepository.findByFlightNo(flightNo) != null) {

			String pnr = genaratePnr();
			passenger.setPnr(pnr);
			passengerRepository.save(passenger);
			Ticket ticket = new Ticket();
			ticket.setFlightNo(flightNo);
			ticket.setPnr(pnr);
			ticket.setUserMail(passenger.getBookingMail());
			bookingRepository.save(ticket);
			return ticket;
		}
		return new Ticket();

	}

	public User registar(User user) {
		return userRepository.save(user);
	}

	public Ticket findByPnr(@PathVariable(value = "pnr") String pnr) {
		return bookingRepository.findByPnr(pnr);
	}

	public List<Ticket> findByMail(String emailId) {
		return bookingRepository.findByEmail(emailId);
	}

	public Ticket cancelTicket(String pnr) {
		Ticket ticket = bookingRepository.findByPnr(pnr);
		bookingRepository.delete(ticket);
		return ticket;
	}
	// General methods

	private String genaratePnr() {
		StringBuffer pnr = new StringBuffer();
		pnr.append(new Random().nextInt(1000000));
		return pnr.toString();
	}
}
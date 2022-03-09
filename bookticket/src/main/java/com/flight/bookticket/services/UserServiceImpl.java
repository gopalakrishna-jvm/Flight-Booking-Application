package com.flight.bookticket.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.flight.bookticket.modal.Booking;
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
    PnrGenerator pnrGenerator;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    PassengerRepository passengerRepository;

    public List<Flight> search(String flightDeparture,String flightArrival){
        return flightRepository.findByDeparture(flightDeparture,flightArrival);
    }

    public Optional<Booking> userBookFlight(String flightNo,Passenger passenger){
        System.out.println("FlightId"+flightNo);
        System.out.println("Passenger"+passenger.getBookingMail());
        Optional<Flight> checkFlight= Optional.ofNullable(flightRepository.findByFlightNo(flightNo));
        if (!checkFlight.isPresent())
            return Optional.of(new Booking());
        String pnr = pnrGenerator.getPnr();
        passenger.setPnr(pnr);
        passengerRepository.save(passenger);
        Booking booking= new Booking();
        booking.setFlightNo(flightNo);
        booking.setPnr(pnr);
        booking.setUserEmail(passenger.getBookingMail());
        bookingRepository.save(booking);
        return Optional.of(booking);
    }

    public User userRegistration(User user){
        return userRepository.save(user);
    }

    public Booking findByPnr(@PathVariable(value = "pnr") String pnr){
        return bookingRepository.findByPnr(pnr);
    }

    public List<Booking> findByMail(String emailId){
        return  bookingRepository.findByEmail(emailId);
    }

    public Booking deleteByPnr(String pnr){
        Booking booking = bookingRepository.findByPnr(pnr);
        bookingRepository.delete(booking);
        return booking;
    }
}
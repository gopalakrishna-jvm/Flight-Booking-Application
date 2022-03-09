package com.flight.bookticket.conroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.bookticket.modal.Booking;
import com.flight.bookticket.modal.Flight;
import com.flight.bookticket.modal.Passenger;
import com.flight.bookticket.modal.User;
import com.flight.bookticket.services.UserServiceImpl;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/flight/search")
    public List<Flight> search(@RequestParam String flightDeparture,@RequestParam String flightArrival){
       return userService.search(flightDeparture,flightArrival);
    }

    @PostMapping("/flight/booking/{flightNo}")
    public Optional<Booking> userBookFlight(@PathVariable(name ="flightNo") String flightNo,@RequestBody Passenger passenger){
      return userService.userBookFlight(flightNo,passenger);
    }

    @PostMapping("/flight/airline/UserRegister")
    public User userRegistration(@RequestBody User user){
        return userService.userRegistration(user);
    }


    @GetMapping("/flight/ticket/{pnr}")
    public Booking findByPnr(@PathVariable(value = "pnr") String pnr){
        return userService.findByPnr(pnr);
    }

    @GetMapping("/flight/booking/history/{emailId}")
    public List<Booking> findByMail(@PathVariable(value = "emailId") String emailId){
        return  userService.findByMail(emailId);
    }

    @DeleteMapping("/flight/booking/cancel/{pnr}")
    public Booking deleteByPnr( @PathVariable(value = "pnr") String pnr){
       return userService.deleteByPnr(pnr);
    }
}
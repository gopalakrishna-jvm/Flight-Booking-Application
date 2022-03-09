package com.flight.bookticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.bookticket.modal.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
}
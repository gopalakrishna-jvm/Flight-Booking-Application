package com.flight.bookticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.bookticket.admin.entity.Flight;
import com.flight.bookticket.entity.Ticket;

public interface IAdminRepository extends JpaRepository<Flight, Integer>{

}

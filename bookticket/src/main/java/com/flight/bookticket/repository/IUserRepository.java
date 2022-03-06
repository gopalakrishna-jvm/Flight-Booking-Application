package com.flight.bookticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.bookticket.entity.Ticket;

public interface IUserRepository extends JpaRepository<Ticket, Integer> {

}

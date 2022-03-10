package com.flight.bookticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flight.bookticket.modal.Ticket;

public interface BookingRepository extends JpaRepository<Ticket,Integer> {

    @Query(value = "select a from Ticket a where a.pnr = :pnr")
    Ticket findByPnr(@Param(value = "pnr") String pnr);

    @Query(value = "select a from Ticket a where a.userEmail = :userEmail")
    List<Ticket> findByEmail(@Param(value = "userEmail") String userEmail);


}

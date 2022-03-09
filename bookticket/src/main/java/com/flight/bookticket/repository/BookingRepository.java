package com.flight.bookticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flight.bookticket.modal.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

    @Query(value = "select a from Booking a where a.pnr = :pnr")
    Booking findByPnr(@Param(value = "pnr") String pnr);

    @Query(value = "select a from Booking a where a.userEmail = :userEmail")
    List<Booking> findByEmail(@Param(value = "userEmail") String userEmail);


}
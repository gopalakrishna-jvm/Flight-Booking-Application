package com.flight.bookticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.bookticket.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
package com.flight.bookticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.flight.bookticket.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	
	  @Query(value = "select a from User a where a.mail = :mail")
      User findByMail(@Param(value ="mail") String mail);
}
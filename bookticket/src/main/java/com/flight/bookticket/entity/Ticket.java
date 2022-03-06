package com.flight.bookticket.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pnr;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String mailId;
	private int numberOfSeats;
	@Column(nullable=false)
	private List<Passenger> passengers;
	
	private Flight flight;
	
	private boolean status;
	private BigDecimal price;

	public Ticket(int pnr, String name, String mailId, int numberOfSeats, List<Passenger> passengers) {
		super();
		this.pnr = pnr;
		this.name = name;
		this.mailId = mailId;
		this.numberOfSeats = numberOfSeats;
		this.passengers = passengers;
	}

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

}

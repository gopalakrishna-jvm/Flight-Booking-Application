package com.flight.bookticket.admin.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightNumber;
	@Column(nullable = false)
	private String airline;
	@Column(nullable = false)
	private String fromPlace;
	@Column(nullable = false)
	private String toPlace;
	@Column(nullable = false)
	private Date startDateTime;
	@Column(nullable = false)
	private Date endDateTime;
	private ScheduledDays scheduledDays;
	private InstrumentUsed instrumentUsed;
	private int bussinessClassSeats;
	private int genaralSeats;
	private BigDecimal ticketPrice;

	public Flight() {
	}

	public Flight(int flightNumber, String airline, String fromPlace, String toPlace, Date startDateTime,
			Date endDateTime, ScheduledDays scheduledDays, InstrumentUsed instrumentUsed, int bussinessClassSeats,
			int genaralSeats, BigDecimal ticketPrice) {
		super();
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.scheduledDays = scheduledDays;
		this.instrumentUsed = instrumentUsed;
		this.bussinessClassSeats = bussinessClassSeats;
		this.genaralSeats = genaralSeats;
		this.ticketPrice = ticketPrice;
	}

	public InstrumentUsed getInstrumentUsed() {
		return instrumentUsed;
	}

	public void setInstrumentUsed(InstrumentUsed instrumentUsed) {
		this.instrumentUsed = instrumentUsed;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public ScheduledDays getScheduledDays() {
		return scheduledDays;
	}

	public void setScheduledDays(ScheduledDays scheduledDays) {
		this.scheduledDays = scheduledDays;
	}

	public int getBussinessClassSeats() {
		return bussinessClassSeats;
	}

	public void setBussinessClassSeats(int bussinessClassSeats) {
		this.bussinessClassSeats = bussinessClassSeats;
	}

	public int getGenaralSeats() {
		return genaralSeats;
	}

	public void setGenaralSeats(int genaralSeats) {
		this.genaralSeats = genaralSeats;
	}

	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}

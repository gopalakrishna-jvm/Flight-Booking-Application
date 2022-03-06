package com.flight.bookticket.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Flight {

	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;
	@Column(nullable = false)
	private Date date;
	@Column(nullable = false)
	private String source;
	@Column(nullable = false)
	private String destrination;

	public Flight(String name, int number, Date date, String source, String destrination) {
		this.name = name;
		this.number = number;
		this.date = date;
		this.source = source;
		this.destrination = destrination;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestrination() {
		return destrination;
	}

	public void setDestrination(String destrination) {
		this.destrination = destrination;
	}

}

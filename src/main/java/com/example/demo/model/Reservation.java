package com.example.demo.model;

import java.util.Date;
import java.util.List;

public class Reservation {
	
	private int reservationId;
	private List<TravelService> availedServiceList;
	private Date departureDate;
	private List<Customer> customers;
	
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public List<TravelService> getAvailedServiceList() {
		return availedServiceList;
	}
	public void setAvailedServiceList(List<TravelService> availedServiceList) {
		this.availedServiceList = availedServiceList;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	

}

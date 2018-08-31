package com.example.demo.model;

import java.util.Date;
import java.util.List;

public class ServiceFee {
	
	private int serviceFeeId;
	private float amount;
	private List<TravelService> service;
	private Date startDate;
	
	
	public int getServiceFeeId() {
		return serviceFeeId;
	}
	public void setServiceFeeId(int serviceFeeId) {
		this.serviceFeeId = serviceFeeId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public List<TravelService> getService() {
		return service;
	}
	public void setService(List<TravelService> service) {
		this.service = service;
	}
	
	
	
}

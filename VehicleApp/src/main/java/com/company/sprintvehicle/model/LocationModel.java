package com.company.sprintvehicle.model;

import java.util.List;

import com.company.sprintvehicle.entity.CarDetail;
import com.company.sprintvehicle.entity.Customer;

public class LocationModel {

	private int id;
	private String city;
	private String state;
	private int pin;
	private List<CarDetail> carDetails;
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public List<CarDetail> getCarDetails() {
		return carDetails;
	}

	public void setCarDetails(List<CarDetail> carDetails) {
		this.carDetails = carDetails;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}

package com.company.sprintvehicle.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "locationGenerator")
	@SequenceGenerator(name = "locationGenerator", sequenceName = "location_sequence", initialValue = 1, allocationSize = 1)
	private int id;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private int pin;
	
	
	@OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
	private List<CarDetail> carDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
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

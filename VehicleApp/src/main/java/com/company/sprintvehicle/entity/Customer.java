package com.company.sprintvehicle.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerGenerator")
	@SequenceGenerator(name = "customerGenerator", sequenceName = "customer_sequence", initialValue = 1, allocationSize = 1)
	private int id;
	@Column
	private String name;
	
	@OneToOne(mappedBy = "customer", cascade=CascadeType.ALL)
	private Location location;
	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private CarDetail carDetails;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public CarDetail getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(CarDetail carDetails) {
		this.carDetails = carDetails;
	}
	
	
	
	
}

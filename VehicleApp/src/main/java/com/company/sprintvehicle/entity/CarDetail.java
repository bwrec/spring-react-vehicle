package com.company.sprintvehicle.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cardetail")
public class CarDetail {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carDetailGenerator")
	@SequenceGenerator(name = "carDetailGenerator", sequenceName = "carDetail_sequence", initialValue = 1, allocationSize = 1)
	private int id;
	@Column
	private String carModel;
	@Column
	private int carNumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location")
	private Location location;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}

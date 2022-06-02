package com.company.sprintvehicle.model;

import com.company.sprintvehicle.entity.CarDetail;
import com.company.sprintvehicle.entity.Location;

public class CustomerModel {

	private int id;
	private String name;
	private Location location;
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

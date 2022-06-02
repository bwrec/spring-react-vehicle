package com.company.sprintvehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.sprintvehicle.entity.Location;
import com.company.sprintvehicle.model.CarDetailModel;
import com.company.sprintvehicle.model.CustomerModel;
import com.company.sprintvehicle.model.LocationModel;
import com.company.sprintvehicle.service.CarDetailService;
import com.company.sprintvehicle.service.CustomerService;
import com.company.sprintvehicle.service.LocationService;

@RestController
public class SprintVehicleController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CarDetailService carDetailService;
	@Autowired
	private LocationService locationService;

	//to get car at particular location
	@GetMapping(value= "/getCarAtLocation", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarDetailModel> getCarAtLocation(@RequestBody Location location){
		try {
			return ResponseEntity.ok(carDetailService.getCarAtLocation(location));
		} catch (Exception e) {

		}
		return null;
	}
	
	//For registering cars to a particular location
	@PostMapping(value = "/createCarDetail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarDetailModel> createCarDetail(@RequestBody CarDetailModel carDetail) {
		return ResponseEntity.ok(carDetailService.saveCarDetail(carDetail));
	}
		//For updating car details
	@PutMapping(value = "/updateCarDetail", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarDetailModel> updateCustomer(@RequestBody CarDetailModel customer) {
		return ResponseEntity.ok(carDetailService.updateCarDetail(customer));
	}

	//For deleting cars
	@DeleteMapping(value = "/deleteCarDetail/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> deleteCarDetail(@PathVariable("id") int id) {
		return ResponseEntity.ok(carDetailService.delete(id));
	}
	
	//-------------- Other Methods ---------------
	@GetMapping(value = "/getCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerModel>> getCustomers() {
		try {
			return ResponseEntity.ok(customerService.getCustomers());
		} catch (Exception e) {

		}
		return null;
	}

	@PostMapping(value = "/createCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerModel Customer) {
		return ResponseEntity.ok(customerService.saveCustomer(Customer));
	}

	@PutMapping(value = "/updateCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerModel> updateCustomer(@RequestBody CustomerModel Customer) {
		return ResponseEntity.ok(customerService.updateCustomer(Customer));
	}

	@GetMapping(value = "/getCarDetail", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CarDetailModel>> getCarDetails() {
		try {
			return ResponseEntity.ok(carDetailService.getCarDetails());
		} catch (Exception e) {

		}
		return null;
	}

	@GetMapping(value = "/getLocation", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LocationModel>> getLocations() {
		try {
			return ResponseEntity.ok(locationService.getLocations());
		} catch (Exception e) {

		}
		return null;
	}

	@PostMapping(value = "/createLocation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LocationModel> createLocation(@RequestBody LocationModel location) {
		return ResponseEntity.ok(locationService.saveLocation(location));
	}

	@PutMapping(value = "/updateLocation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LocationModel> updateLocation(@RequestBody LocationModel location) {
		return ResponseEntity.ok(locationService.updateLocation(location));
	}

	@DeleteMapping(value = "/deleteLocation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> deleteLocation(@PathVariable("id") int id) {
		return ResponseEntity.ok(locationService.delete(id));
	}
}

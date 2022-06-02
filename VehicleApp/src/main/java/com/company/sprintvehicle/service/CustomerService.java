package com.company.sprintvehicle.service;

import java.util.List;

import com.company.sprintvehicle.model.CustomerModel;

public interface CustomerService {

	public List<CustomerModel> getCustomers();
	
	public CustomerModel saveCustomer(CustomerModel customer);
	
	public CustomerModel updateCustomer(CustomerModel customer);
	
	public int delete(int id);
}

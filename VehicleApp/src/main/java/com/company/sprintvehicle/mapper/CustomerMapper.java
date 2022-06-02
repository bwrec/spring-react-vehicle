package com.company.sprintvehicle.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.company.sprintvehicle.entity.Customer;
import com.company.sprintvehicle.model.CustomerModel;

@Component
public class CustomerMapper {

	public Customer mapDtotoEnity(CustomerModel customer) {
		Customer customerEntity=new Customer();
		customerEntity.setName(customer.getName());
		customerEntity.setLocation(customer.getLocation());
		customerEntity.setCarDetails(customer.getCarDetails());
		return customerEntity;
	}
	
	public CustomerModel mapEntitytoDto(Customer customer) {
		CustomerModel customerModel=new CustomerModel();
		BeanUtils.copyProperties(customer, customerModel);
		return customerModel;
	}
}

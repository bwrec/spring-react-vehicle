package com.company.sprintvehicle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.sprintvehicle.dao.CustomerRepository;
import com.company.sprintvehicle.entity.Customer;
import com.company.sprintvehicle.mapper.CustomerMapper;
import com.company.sprintvehicle.model.CustomerModel;
import com.company.sprintvehicle.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<CustomerModel> getCustomers() {
		List<CustomerModel> customerModelList = null;
		List<Customer> customerList = customerRepository.findAll();
		if (customerList.size() > 0) {
			customerModelList = new ArrayList<>();
		}
		for (Customer customer : customerList) {
			customerModelList.add(customerMapper.mapEntitytoDto(customer));
		}
		return customerModelList;
	}

	@Override
	public CustomerModel saveCustomer(CustomerModel customer) {
		Customer customerEntity = customerRepository.save(customerMapper.mapDtotoEnity(customer));
		return customerMapper.mapEntitytoDto(customerEntity);
	}

	@Override
	public CustomerModel updateCustomer(CustomerModel customer) {
		Customer customerEntity=customerRepository.findById(customer.getId());
		customerEntity.setName(customer.getName());
		customerEntity.setLocation(customer.getLocation());
		customerEntity.setCarDetails(customer.getCarDetails());
		customerEntity=customerRepository.save(customerEntity);
		return customerMapper.mapEntitytoDto(customerEntity);
	}

	@Override
	public int delete(int id) {
		try {
			customerRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}

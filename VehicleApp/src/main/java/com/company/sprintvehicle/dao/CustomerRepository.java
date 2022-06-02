package com.company.sprintvehicle.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.sprintvehicle.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	public List<Customer> findAll();
	
	public Customer save(Customer customerInfo);
	
	public void deleteById(int id);

	public Customer findById(int id);
}

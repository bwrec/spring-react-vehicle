package com.company.sprintvehicle.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.sprintvehicle.entity.CarDetail;
import com.company.sprintvehicle.entity.Location;

@Repository
public interface CarDetailRepository extends JpaRepository<CarDetail, Integer> {

	public List<CarDetail> findAll();
	
	public CarDetail save(CarDetail carDetail);
	
	public void deleteById(int id);

	public CarDetail findById(int id);
	
	public CarDetail findByLocation(Location location);
}

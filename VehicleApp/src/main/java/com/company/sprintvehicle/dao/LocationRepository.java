package com.company.sprintvehicle.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.sprintvehicle.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

	public List<Location> findAll();
	
	public Location save(Location location);
	
	public void deleteById(int id);

	public Location findById(int id);
}

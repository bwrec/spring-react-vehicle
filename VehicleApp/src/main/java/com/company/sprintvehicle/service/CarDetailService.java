package com.company.sprintvehicle.service;

import java.util.List;

import com.company.sprintvehicle.entity.Location;
import com.company.sprintvehicle.model.CarDetailModel;

public interface CarDetailService {

	public List<CarDetailModel> getCarDetails();
	
	public CarDetailModel saveCarDetail(CarDetailModel carDetail);
	
	public CarDetailModel updateCarDetail(CarDetailModel carDetail);
	
	public int delete(int id);

	public CarDetailModel getCarAtLocation(Location location);
}

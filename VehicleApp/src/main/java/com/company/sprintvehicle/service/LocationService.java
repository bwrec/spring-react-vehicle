package com.company.sprintvehicle.service;

import java.util.List;

import com.company.sprintvehicle.model.LocationModel;

public interface LocationService {

	public List<LocationModel> getLocations();
	
	public LocationModel saveLocation(LocationModel location);
	
	public LocationModel updateLocation(LocationModel location);
	
	public int delete(int id);
}

package com.company.sprintvehicle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.sprintvehicle.dao.LocationRepository;
import com.company.sprintvehicle.entity.Location;
import com.company.sprintvehicle.mapper.LocationMapper;
import com.company.sprintvehicle.model.LocationModel;
import com.company.sprintvehicle.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationMapper locationMapper;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public List<LocationModel> getLocations() {
		List<LocationModel> locationModelList = null;
		List<Location> locationList = locationRepository.findAll();
		if (locationList.size() > 0) {
			locationModelList = new ArrayList<>();
		}
		for (Location location : locationList) {
			locationModelList.add(locationMapper.mapEntitytoDto(location));
		}
		return locationModelList;
	}

	@Override
	public LocationModel saveLocation(LocationModel location) {
		Location locationEntity = locationRepository.save(locationMapper.mapDtotoEnity(location));
		return locationMapper.mapEntitytoDto(locationEntity);
	}

	@Override
	public LocationModel updateLocation(LocationModel location) {
		Location locationEntity=locationRepository.findById(location.getId());
		locationEntity.setCity(location.getCity());
		locationEntity.setState(location.getState());
		locationEntity.setPin(location.getPin());
		locationEntity.setCarDetails(location.getCarDetails());
		locationEntity.setCustomer(location.getCustomer());
		return locationMapper.mapEntitytoDto(locationEntity);
	}

	@Override
	public int delete(int id) {
		try {
			locationRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}

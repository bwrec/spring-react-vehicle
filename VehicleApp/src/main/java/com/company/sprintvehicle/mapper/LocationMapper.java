package com.company.sprintvehicle.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.company.sprintvehicle.entity.Location;
import com.company.sprintvehicle.model.LocationModel;

@Component
public class LocationMapper {

	public Location mapDtotoEnity(LocationModel location) {
		Location locationEntity=new Location();
		locationEntity.setCity(location.getCity());
		locationEntity.setState(location.getState());
		locationEntity.setPin(location.getPin());
		locationEntity.setCarDetails(location.getCarDetails());
		locationEntity.setCustomer(location.getCustomer());
		return locationEntity;
	}
	
	public LocationModel mapEntitytoDto(Location Location) {
		LocationModel locationModel=new LocationModel();
		BeanUtils.copyProperties(Location, locationModel);
		return locationModel;
	}
	
}

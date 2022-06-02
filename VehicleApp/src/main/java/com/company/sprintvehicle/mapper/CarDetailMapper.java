package com.company.sprintvehicle.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.company.sprintvehicle.entity.CarDetail;
import com.company.sprintvehicle.model.CarDetailModel;

@Component
public class CarDetailMapper {

	public CarDetail mapDtotoEnity(CarDetailModel carDetail) {
		CarDetail carDetailEntity=new CarDetail();
		carDetailEntity.setCarModel(carDetail.getCarModel());
		carDetailEntity.setCarNumber(carDetail.getCarNumber());
		carDetailEntity.setLocation(carDetail.getLocation());
		carDetailEntity.setCustomer(carDetail.getCustomer());
		return carDetailEntity;
	}
	
	public CarDetailModel mapEntitytoDto(CarDetail carDetail) {
		CarDetailModel carDetailModel=new CarDetailModel();
		BeanUtils.copyProperties(carDetail, carDetailModel);
		return carDetailModel;
	}
}

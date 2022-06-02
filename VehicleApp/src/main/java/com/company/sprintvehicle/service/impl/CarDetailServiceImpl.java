package com.company.sprintvehicle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.sprintvehicle.dao.CarDetailRepository;
import com.company.sprintvehicle.entity.CarDetail;
import com.company.sprintvehicle.entity.Location;
import com.company.sprintvehicle.mapper.CarDetailMapper;
import com.company.sprintvehicle.model.CarDetailModel;
import com.company.sprintvehicle.service.CarDetailService;

@Service
public class CarDetailServiceImpl implements CarDetailService {

	@Autowired
	private CarDetailMapper carDetailMapper;
	
	@Autowired
	private CarDetailRepository carDetailRepository;
	
	@Override
	public CarDetailModel getCarAtLocation(Location location) {
		CarDetailModel carDetailModel;
		CarDetail carDetail = carDetailRepository.findByLocation(location);
		carDetailModel = carDetailMapper.mapEntitytoDto(carDetail);
		return carDetailModel;
	}
	
	@Override
	public List<CarDetailModel> getCarDetails() {
		List<CarDetailModel> carDetailModelList = null;
		List<CarDetail> carDetailList = carDetailRepository.findAll();
		if (carDetailList.size() > 0) {
			carDetailModelList = new ArrayList<>();
		}
		for (CarDetail carDetail : carDetailList) {
			carDetailModelList.add(carDetailMapper.mapEntitytoDto(carDetail));
		}
		return carDetailModelList;
	}

	@Override
	public CarDetailModel saveCarDetail(CarDetailModel carDetail) {
		CarDetail carDetailEntity = carDetailRepository.save(carDetailMapper.mapDtotoEnity(carDetail));
		return carDetailMapper.mapEntitytoDto(carDetailEntity);
	}

	@Override
	public CarDetailModel updateCarDetail(CarDetailModel carDetail) {
		CarDetail carDetailEntity=carDetailRepository.findById(carDetail.getId());
		carDetailEntity.setCarModel(carDetail.getCarModel());
		carDetailEntity.setCarNumber(carDetail.getCarNumber());
		carDetailEntity.setLocation(carDetail.getLocation());
		carDetailEntity.setCustomer(carDetail.getCustomer());
		return carDetailMapper.mapEntitytoDto(carDetailEntity);
	}

	@Override
	public int delete(int id) {
		try {
			carDetailRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}

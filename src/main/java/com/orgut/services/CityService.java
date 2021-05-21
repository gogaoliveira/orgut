package com.orgut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgut.entities.City;
import com.orgut.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repo;
	
	public List<City> findByState(Integer stateId) {
		return repo.findCity(stateId);
	}
}

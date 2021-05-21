package com.orgut.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgut.entities.Andress;
import com.orgut.repositories.AndressRepository;

@Service
public class AndressService {
	
	@Autowired
	private AndressRepository repo;
	
	public List<Andress> findAll(){
		return repo.findAll();
	}
	

}

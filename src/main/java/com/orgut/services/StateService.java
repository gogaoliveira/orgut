package com.orgut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgut.entities.State;
import com.orgut.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository repo;
	
	public List<State> findAll(){
		return repo.findAllByOrderByName();
	}
}

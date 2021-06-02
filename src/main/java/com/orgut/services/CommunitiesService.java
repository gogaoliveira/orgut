package com.orgut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.orgut.entities.Communities;
import com.orgut.repositories.CommunitiesRepository;
import com.orgut.services.exceptions.ObjectNotFoundException;



@Service
public class CommunitiesService {
	
	@Autowired
	private CommunitiesRepository repo;
	
	public List<Communities> findAll() {
		return repo.findAll();
	}
	
	public Communities find(Integer id) {
		Optional<Communities> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found! id: " + id + ", type: " + Communities.class.getName()));
	}
	
	public Page<Communities> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	
}

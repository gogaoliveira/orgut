package com.orgut.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orgut.entities.City;
import com.orgut.entities.State;
import com.orgut.services.CityService;
import com.orgut.services.StateService;

@RestController
@CrossOrigin
@RequestMapping(value = "/states")
public class StateResource {

	@Autowired
	private StateService service;
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<State>> findAll(){
		List<State> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{stateId}/cities", method = RequestMethod.GET)
	public ResponseEntity<List<City>> findCities(@PathVariable Integer stateId){
		List<City> list = cityService.findByState(stateId);
		return ResponseEntity.ok().body(list);
	}
}

package com.orgut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgut.entities.Person;
import com.orgut.repositories.PersonRepository;
import com.orgut.services.exceptions.ObjectNotFoundException;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repo;
	
	public List<Person> findAll(){
		return repo.findAll();
	}
	
	public Person findTestimonial(Integer id) {
		Optional<Person> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! id: " +id + ", type: " + Person.class.getName()));
	}
	

}

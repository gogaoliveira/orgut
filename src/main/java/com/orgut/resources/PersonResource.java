package com.orgut.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orgut.dto.PersonDTO;
import com.orgut.entities.Person;
import com.orgut.services.PersonService;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource {

	@Autowired
	private PersonService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PersonDTO>> findAll(){
		List<Person> list = service.findAll();
		List<PersonDTO> listDto = list.stream().map(obj -> new PersonDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	@RequestMapping(value = "/{personId}", method = RequestMethod.GET)
	public ResponseEntity<Person> findPerson(@PathVariable Integer personId){
		Person list = service.findTestimonial(personId);
		return ResponseEntity.ok().body(list);	
	}
}

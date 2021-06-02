package com.orgut.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.orgut.dto.PersonDTO;
import com.orgut.dto.PersonNewDTO;
import com.orgut.entities.Person;
import com.orgut.services.PersonService;

@RestController
@CrossOrigin
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
	
	@RequestMapping(value = "/picture", method = RequestMethod.POST)
	public ResponseEntity<Void> uploadProfilePicture(@RequestParam (name="file") MultipartFile file){
		URI uri = service.uploadProfilePicture(file);
		return ResponseEntity.created(uri).build();
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PersonNewDTO objDto){
		Person obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
}

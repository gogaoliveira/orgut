package com.orgut.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orgut.entities.Testimonials;
import com.orgut.services.TestimonialsService;

@RestController
@RequestMapping(value = "/testimonials")
public class TestimonialsResource {

	@Autowired
	private TestimonialsService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Testimonials>> findAll(){
		List<Testimonials> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{testimonialId}", method = RequestMethod.GET)
	public ResponseEntity<Testimonials> findTestimonials(@PathVariable Integer testimonialId){
		Testimonials list = service.findTestimonial(testimonialId);
		return ResponseEntity.ok().body(list);	
	}
}

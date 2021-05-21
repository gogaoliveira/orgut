package com.orgut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orgut.entities.Testimonials;
import com.orgut.repositories.TestimonialsRepository;
import com.orgut.services.exceptions.ObjectNotFoundException;

@Service
public class TestimonialsService {
	
	@Autowired
	private TestimonialsRepository repo;
	
	public List<Testimonials> findAll(){
		return repo.findAll();
	}
	
	public Testimonials findTestimonial(Integer id) {
		Optional<Testimonials> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! id: " +id + ", type: " + Testimonials.class.getName()));
	}
	

}

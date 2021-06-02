package com.orgut.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.orgut.dto.PersonNewDTO;
import com.orgut.entities.Person;
import com.orgut.repositories.PersonRepository;
import com.orgut.services.exceptions.ObjectNotFoundException;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repo;
	
	@Autowired
	private S3Service s3service;
	
	@Autowired
	private ImageService imageService;
	
	@Value("${img.prefix.client.profile}")
	private String prefix;
		
	
	public List<Person> findAll(){
		return repo.findAll();
	}
	
	public Person findTestimonial(Integer id) {
		Optional<Person> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! id: " +id + ", type: " + Person.class.getName()));
	}
	
	@Transactional
	public Person insert(Person obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public URI uploadProfilePicture(MultipartFile multipartFile) {
		
		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		String fileName= prefix + "12" +".jpg";
		
		return s3service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
	}

	public Person fromDTO(PersonNewDTO objDto) {
		Person ps = new Person(null, objDto.getName(), objDto.getHere_for(), objDto.getBirthday(), objDto.getChildren(), objDto.getEmail(), objDto.getActivies());
		return ps;
	}
	
	public Page<Person> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	
	

}

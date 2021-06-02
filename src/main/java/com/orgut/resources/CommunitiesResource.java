package com.orgut.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orgut.dto.CommunitiesDTO;
import com.orgut.entities.Communities;
import com.orgut.services.CommunitiesService;

@RestController
@CrossOrigin
@RequestMapping(value = "/communities")
public class CommunitiesResource {

	@Autowired
	private CommunitiesService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CommunitiesDTO>> findAll() {
		List<Communities> list = service.findAll();
		List<CommunitiesDTO> listDto = list.stream().map(obj -> new CommunitiesDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Communities> findCommunities(@PathVariable Integer id) {
		Communities list = service.find(id);
		return ResponseEntity.ok().body(list);
	}
}

package com.orgut.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CommunitiesDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue = "3") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue = "name" )String OrderBy,
			@RequestParam(value="direction", defaultValue = "ASC") String direction){
		Page<Communities> list = service.findPage(page, linesPerPage, OrderBy, direction);
		Page<CommunitiesDTO> listDto = list.map(obj -> new CommunitiesDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}

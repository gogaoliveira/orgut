package com.orgut.dto;

import java.io.Serializable;

import com.orgut.entities.Person;

public class PersonDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;

	
	public PersonDTO() {
	}
	
	public PersonDTO(Person obj) {
		id = obj.getId();
		name = obj.getName();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}

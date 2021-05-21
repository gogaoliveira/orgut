package com.orgut.dto;

import java.io.Serializable;
import java.util.Date;

import com.orgut.entities.Person;

public class PersonDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String here_for;
	private Date birthday;
	private String children;
	private String email;
	private String activies;
	
	public PersonDTO() {
	}
	
	public PersonDTO(Person obj) {
		id = obj.getId();
		name = obj.getName();
		here_for = obj.getHere_for();
		birthday = obj.getBirthday();
		children = obj.getChildren();
		email = obj.getEmail();
		activies = obj.getActivies();
		
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

	public String getHere_for() {
		return here_for;
	}

	public void setHere_for(String here_for) {
		this.here_for = here_for;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActivies() {
		return activies;
	}

	public void setActivies(String activies) {
		this.activies = activies;
	}
	
	
}

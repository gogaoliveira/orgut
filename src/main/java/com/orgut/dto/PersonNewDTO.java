package com.orgut.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class PersonNewDTO {

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho precisa ser de 5 a 120 caracteres")
	private String name;
	
	private String here_for;
	private Date birthday;
	private String children;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "email inválido")
	private String email;
	private String activies;
	
	public PersonNewDTO() {
		
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

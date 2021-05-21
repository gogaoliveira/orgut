package com.orgut.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Testimonials implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "person_submit_id")
	private Person person_submit;
	
	@ManyToOne
	@JoinColumn(name = "person_receive_id")
	private Person person_receive;
	
	public Testimonials() {
	}

	public Testimonials(Integer id, String text, Person person_submit, Person person_receive) {
		super();
		this.id = id;
		this.text = text;
		this.person_submit = person_submit;
		this.person_receive = person_receive;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Person getPerson_submit() {
		return person_submit;
	}

	public void setPerson_submit(Person person_submit) {
		this.person_submit = person_submit;
	}

	public Person getPerson_receive() {
		return person_receive;
	}

	public void setPerson_receive(Person person_receive) {
		this.person_receive = person_receive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Testimonials other = (Testimonials) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}

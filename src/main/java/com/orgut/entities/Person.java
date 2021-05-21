package com.orgut.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String here_for;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	private String children;
	private String email;
	private String activies;

	@ManyToMany(mappedBy = "persons")
	private List<Communities> communities = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "person_submit")
	private List<Testimonials> testimonials_submit;
	
	@JsonIgnore
	@OneToMany(mappedBy = "person_receive")
	private List<Testimonials> testimonials_receive;
	
	@OneToMany(mappedBy = "person")
	private List<Andress> andress = new ArrayList<>();
	
	public Person() {
	}

	public Person( Integer id, String name, String here_for, Date birthday, String children, String email, String activies) {
		super();
		this.id = id;
		this.name = name;
		this.here_for = here_for;
		this.birthday = birthday;
		this.children = children;
		this.email = email;
		this.activies = activies;
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

	public List<Communities> getCommunities() {
		return communities;
	}

	public void setCommunities(List<Communities> communities) {
		this.communities = communities;
	}

	public List<Testimonials> getTestimonials_submit() {
		return testimonials_submit;
	}

	public void setTestimonials_submit(List<Testimonials> testimonials) {
		this.testimonials_submit = testimonials;
	}

	public List<Testimonials> getTestimonials_receive() {
		return testimonials_receive;
	}

	public void setTestimonials_receive(List<Testimonials> testimonials_receive) {
		this.testimonials_receive = testimonials_receive;
	}
 
	public List<Andress> getAndress() {
		return andress;
	}

	public void setAndress(List<Andress> andress) {
		this.andress = andress;
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
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}

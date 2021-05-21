package com.orgut.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orgut.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}

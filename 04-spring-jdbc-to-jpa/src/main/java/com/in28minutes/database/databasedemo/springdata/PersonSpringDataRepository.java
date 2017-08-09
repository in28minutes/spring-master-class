package com.in28minutes.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository
public interface PersonSpringDataRepository 
				extends JpaRepository<Person, Integer>{
}

package com.demo.restful.service;


import java.util.List;

import com.demo.restful.model.Person;


public interface PersonService {
	
	public Person createPerson(Person person);
	
	public Person updatePerson(int id,Person person); 

    public Person getPerson(int id);

    public void deletePerson(int id);
    
    public List<Person> getAllPersons();

}

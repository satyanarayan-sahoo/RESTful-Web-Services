package com.demo.restful.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.restful.model.Person;
import com.demo.restful.repository.PersonRepository;


@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepo;

	@Override
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}
	
	@Override
	public Person updatePerson(int id,Person person) {
		Person p = personRepo.getOne(id);
	    p.setName(person.getName());
		p.setAge(person.getAge());
		return personRepo.save(p);
	}
	
	@Override
	public Person getPerson(int id) {
		return personRepo.getOne(id);
	}

	@Override
	public void deletePerson(int id) {
		personRepo.deleteById(id);
	}
	
	@Override
	public List<Person> getAllPersons() {
		return personRepo.findAll();
	}

}//class

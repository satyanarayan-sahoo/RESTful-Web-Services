package com.demo.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.restful.model.Person;
import com.demo.restful.service.PersonService;

import io.swagger.annotations.Api;

@Api(description = "REST Apis related to Person Entity!!!!")
@RestController
@RequestMapping(value = "/person",produces = MediaType.APPLICATION_JSON_VALUE)
class PersonController {
	
	@Autowired
	private PersonService personService;
	
	/* POST
	 * http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/addPerson
	 * {
	    "name":"Raja Babu",
	    "age":"23"
       }*/
	@PostMapping(value = "/addPerson")
	public Person createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
	
	
	/* PUT
	 * http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/updateDetails/43
	 * {  
	       "name":"Laxmidhar Rout",
	       "age":"24"
       }
    */
	@PutMapping(value = "/updateDetails/{id}")
	public Person updatePersonDetails(@PathVariable int id,@RequestBody Person person) {
		return personService.updatePerson(id,person);
	}
	
	/* GET
	 * http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/getPerson/41
	 *  */
	@GetMapping(value = "/getPerson/{id}")
	public Person getPersonById(@PathVariable int id) {
		return personService.getPerson(id);
	}
	
	/* DELETE
	 * http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/deletePerson/42
	 * */
	@DeleteMapping(value = "/deletePerson/{id}")
	public void deletePerson(@PathVariable int id) {
		personService.deletePerson(id);
	}
	
	/* GET
	 * http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/persons
	 * */
	@GetMapping(value = "/persons")
	public List<Person> findAllPerson() {
		return personService.getAllPersons();
	}
	
}//class

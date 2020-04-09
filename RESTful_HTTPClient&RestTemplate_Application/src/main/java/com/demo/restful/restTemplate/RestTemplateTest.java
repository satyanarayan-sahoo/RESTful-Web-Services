package com.demo.restful.restTemplate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.demo.restful.model.Person;

public class RestTemplateTest {

	public static void main(String[] args) throws Exception {
		demoGetRESTAPI();
		demoPostRESTAPI();
		demoPutRESTAPI();
		demoDeleteRESTAPI();
	}//main
	
	public static void demoGetRESTAPI() throws Exception {
		
		final String uri = "http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/getPerson/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "105");
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class, params);
		System.out.println(result);
	}
	
	public static void demoPostRESTAPI() throws Exception {
		
		final String uri = "http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/addPerson";
		
		Person person = new Person();
		person.setAge(54);
		person.setName("Salman Khan");
		
		RestTemplate restTemplate = new RestTemplate();
		Person p = restTemplate.postForObject(uri, person, Person.class);
		System.out.println(p);
	}
	
	public static void demoPutRESTAPI() throws Exception {
		
		final String uri = "http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/updateDetails/{id}";
		
		Person person = new Person();
		person.setAge(40);
		person.setName("Prabhas");
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "115");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(uri, person, params);
	}
	
	public static void demoDeleteRESTAPI() throws Exception {
		
		final String uri = "http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/deletePerson/{id}";
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "116");
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, params);
	}
	
}//class

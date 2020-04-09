package com.demo.restful.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.demo.restful.model.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HttpClientTest {

	public static void main(String[] args) throws Exception {
		demoGetRESTAPI();
		demoPostRESTAPI();
		demoPutRESTAPI();
		demoDeleteRESTAPI();
	}//main
	
	public static void demoGetRESTAPI() throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		
		final String uri = "http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/getPerson/105";
		try {
			HttpGet httpGet = new HttpGet(uri);
			httpGet.addHeader("accept", "application/json");
			
			HttpResponse httpResponse= httpClient.execute(httpGet);
			
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + statusCode);
			}//if
			
			HttpEntity entity= httpResponse.getEntity();
			String apiOutput = EntityUtils.toString(entity);
			
			System.out.println(apiOutput);
			
			//Convert Json Object to java
			Gson gson = new Gson();
			Person person = gson.fromJson(apiOutput, Person.class);
			
			System.out.println(person.getId());
			System.out.println(person.getName());
			System.out.println(person.getAge());
		} finally {
			httpClient.getConnectionManager().shutdown();
		}//finally
		
	}//demoGetRESTAPI()
	
	public static void demoPostRESTAPI() throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		
		Person person = new Person();
		person.setAge(45);
		person.setName("Mahesh Babu");
		
		//Convert java object to Json
		Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
		String jsonStr = gson.toJson(person);
	    
	    final String uri = "http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/addPerson";
	    
	    try {
			HttpPost httpPost = new HttpPost(uri);
			httpPost.addHeader("content-type", "application/json");
			
			StringEntity entity = new StringEntity(jsonStr);
			httpPost.setEntity(entity);
			
			HttpResponse httpResponse = httpClient.execute(httpPost);
			
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + statusCode);
			}//if
		} finally {
			httpClient.getConnectionManager().shutdown();
		}//finally
	}//demoPostRESTAPI()
	
	public static void demoPutRESTAPI() throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		
		final String uri = "http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/updateDetails/118";
		
		Person person = new Person();
		person.setAge(57);
		person.setName("Tom Cruse");
		
		//Convert java object to Json
		Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
		String jsonStr = gson.toJson(person);
		System.out.println(jsonStr);
		
		try {
			HttpPut httpPut = new HttpPut(uri);
			httpPut.setHeader("content-type", "application/json");
			
			StringEntity entity = new StringEntity(jsonStr);
			httpPut.setEntity(entity);
			
			HttpResponse httpResponse = httpClient.execute(httpPut);
			
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + statusCode);
			}//if
			
		}finally {
			httpClient.getConnectionManager().shutdown();
		}//finally
		
	}//demoPutRESTAPI()
	
	public static void demoDeleteRESTAPI() throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		
		final String uri = "http://localhost:9439/RESTful_HTTPClient&RestTemplate_App/person/deletePerson/117";
		
		try {
			HttpDelete httpDelete = new HttpDelete(uri);
			
			HttpResponse httpResponse = httpClient.execute(httpDelete);
			
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + statusCode);
			}
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
	}//demoDeleteRESTAPI()

}//class

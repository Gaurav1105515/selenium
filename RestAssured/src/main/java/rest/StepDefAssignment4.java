package rest;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class StepDefAssignment4 {
	Response response;
	@Given("API For foreign exchange")
	public void api_For_foreign_exchange() throws Throwable {
		 RestAssured.baseURI="https://api.ratesapi.io";
	    
	}

	@When("pass the correct information")
	public void pass_the_correct_information() throws Throwable {
		//request object
		RequestSpecification httpRequest=RestAssured.given();
		//Response object
		 response=httpRequest.request(Method.GET,"/api/latest?base=USD");
	}

	@Then("check the response  received")
	public void check_the_response_received() throws Throwable {
		int statuscode=response.getStatusCode();
		
		System.out.println("Status Code : " + statuscode);
		//validate the response code
		Assert.assertEquals(200, statuscode);
		//Assert.assertTrue(statuscode==200);
		
		//validate the status line
		String statusline=response.getStatusLine();
		System.out.println(statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		  ResponseBody body=response.getBody();
		 String bodyAsString = body.asString();
		   Assert.assertTrue(bodyAsString.contains("ID"));
		   response.prettyPrint();
		

		 
		}
	   
	}





package rest;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefAssignment3 {
	Response response;
	@Given("API for latest foreign exchange")
	public void api_for_latest_foreign_exchange()  throws Throwable{
		RestAssured.baseURI = "https://api.ratesapi.io";
	    
	}

	@When("Enter correct information")
	public void enter_correct_information() throws Throwable {
		//response object
		response = RestAssured.get("/api/latest");
	    
	}

	@Then("Check for positive response code received")
	public void check_for_positive_response_code_received() throws Throwable {
		int statuscode=response.getStatusCode();
		System.out.println("Status Code : " + statuscode);
		//validate the response code
		Assert.assertEquals(200, statuscode);
		//log
		response= RestAssured.given().
				log().all().
				when().get("/api/latest").
				then().
				log().all().assertThat().statusCode(200).extract().response();
				
				
	  
	}






}

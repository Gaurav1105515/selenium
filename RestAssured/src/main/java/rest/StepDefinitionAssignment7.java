package rest;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitionAssignment7 {
	Response response;
	@Test
	@Given("API  for latest foreign EXCHANGE")
	public void api_for_latest_foreign_EXCHANGE() throws Throwable {
		RestAssured.baseURI="https://api.ratesapi.io";
	   
	}
@Test
	@When("enters the future date")
	public void enters_the_future_date() throws Throwable {
	response=RestAssured.given().get("/api/2022-13-06");
	  
	}
@Test
	@Then("validate the response code outcomes")
	public void validate_the_response_code_outcomes() throws Throwable {
	int StatusCode=response.getStatusCode();
	
	System.out.println("Response Code : "+StatusCode);
	
	response = RestAssured.given().
			
			log().all().get("/api/2022-13-06").
            then().
            assertThat().statusCode(400).log().all().extract().response();
	}

}

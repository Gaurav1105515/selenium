package rest;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinitionAssignment6 {
	Response response;
	@Test
	@Given("API  for latest foreign exchange")
	public void api_for_latest_foreign_exchange() throws Throwable {
		RestAssured.baseURI="https://api.ratesapi.io";

	}

	@Test
	@When("enters the valid Information")
	public void enters_the_valid_Information() throws Throwable {
		//request object
		RequestSpecification httpRequest=RestAssured.given();
		//Response object
		 response=httpRequest.request(Method.GET,"/api");

	}

	@Test
	@Then("Check the response status code received")
	public void check_the_response_status_code_received() throws Throwable {
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 400);
		//for status line
		String statusline=response.getStatusLine();
		System.out.println(statusline);
		Assert.assertTrue(statusline.contains("HTTP/1.1 400 Bad Request"));
	}

}

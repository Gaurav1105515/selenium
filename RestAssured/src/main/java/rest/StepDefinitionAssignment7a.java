package rest;

import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinitionAssignment7a {
	Response response;

	@Test
	@Given("API  for LATEST foreign EXCHANGE")
	public void api_for_LATEST_foreign_EXCHANGE() {
		RestAssured.baseURI = "https://api.ratesapi.io";

	}

	@Test
	@When("put the crrect Information")
	public void put_the_crrect_Information() {
		response = RestAssured.given().get("/api/2020-18-06");

	}

	@Test
	@Then("check for valid response status code")
	public void check_for_valid_response_status_code() {
		//status code
		int StatusCode = response.getStatusCode();

		System.out.println("Response Code : " + StatusCode);
		Assert.assertEquals(StatusCode, 400);
		//status line
		String statusline=response.getStatusLine();
		
		Assert.assertTrue(statusline.contains("HTTP/1.1 400 Bad Request"));
		System.out.println(statusline);

	}
}

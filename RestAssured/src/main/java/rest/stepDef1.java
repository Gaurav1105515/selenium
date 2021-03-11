package rest;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class stepDef1 {
	Response response;

@Given("API for foreign exchange")
public void api_for_foreign_exchange() throws Throwable {
	RestAssured.baseURI = "https://api.ratesapi.io";
   
}

@When("posted with correct information")
public void posted_with_correct_information() throws Throwable {
	response = RestAssured.get("/api/latest");
   
}

@Then("validate positive response code received")
public void validate_positive_response_code_received() throws Throwable {
	int statuscode=response.getStatusCode();
	System.out.println("Status Code : " + statuscode);
	Assert.assertEquals(200, statuscode);
   
}

}

package rest;

import org.junit.Assert;
import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition5 {
	Response response;
@Test
@Given("API For foreign Exchange")
public void api_For_foreign_Exchange()  throws Throwable{
	RestAssured.baseURI="https://api.ratesapi.io";
    
}
@Test
@When("Posted With correct Information")
public void posted_With_correct_Information() throws Throwable {
	//response = RestAssured.get("/api/");
	//request object
			RequestSpecification httpRequest=RestAssured.given();
			//Response object
			 response=httpRequest.request(Method.GET,"/api/");
  
}
@Test
@Then("validate  the positive response code received")
public void validate_the_positive_response_code_received() throws Throwable {
	int Statuscode=response.getStatusCode();
	System.out.println(Statuscode);
	Assert.assertTrue(Statuscode!=200);

	RestAssured.given().headers("content-Type","appication/json").get("/api/").
	then().assertThat().statusCode(400).log().all();
   
}
	

}


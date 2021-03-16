package rest;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StepDefinitionAssignment8 {
	Response response;

	@DataProvider(name = "Date")
	public Object[][] provider() {

		Object[][] data = new Object[2][3];

		data[0][0] = "2012";
		data[0][1] = "05";
		data[0][2] = "22";

		data[1][0] = "2020";
		data[1][1] = "06";
		data[1][2] = "14";
		return data;
	}

	@Test
	@Given("API FOR FOREIGN EXCHANGE")
	public void api_FOR_FOREIGN_EXCHANGE() throws Throwable {
		 RestAssured.baseURI="https://api.ratesapi.io";
	}

	@Test(dataProvider="Date")
	@When("fetch the values from dataprovider")
	public void fetch_the_values_from_dataprovider(String year,String mon,String day) throws Throwable {
		response=RestAssured.get("/api/"+year+"-"+mon+"-"+day);

	}

	@Test
	@Then("check the valid outcomes")
	public void check_the_valid_outcomes() throws Throwable {
		int code=response.getStatusCode();
		Assert.assertEquals(code,200);
		System.out.println(code);

		 String statusLine=response.statusLine();
		    System.out.println(statusLine);
		   Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}

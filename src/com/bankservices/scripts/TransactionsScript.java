package com.bankservices.scripts;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class TransactionsScript {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://parabank.parasoft.com/parabank/services/bank";
	}
	
	@Test
	public void TC01_verifyValidTransaction()
	{
		given()
		.contentType(ContentType.JSON)
		
		.when()
				.get("/transactions/{transactionid}", 13588 )
			
		.then()
				.statusCode(200)
				.body("parameters.name", is(13588));
				.body("parameters.accountId", is(13122));
				.body("parameters.type", contains("Credit"));
				.body("parameters.date", is("2017-08-09T00:00:00-07:00"));
				.body("parameters.amount", is(1000.00));
				.body("parameters.description", contains("Funds Transfer Received"));
				
				

	}
	
	@Test
	public void TC02_verifyInvalidTransaction()
	{
		given()
		.contentType(ContentType.JSON)
		
		.when()
				.get("/transactions/{transactionid}", 1358)
			
		.then()
				.statusCode(404)
				.body("responses.description", contains("Could not find transaction #"));
	}

}
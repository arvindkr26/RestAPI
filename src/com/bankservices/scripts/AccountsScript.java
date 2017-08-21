package com.bankservices.scripts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;

import io.restassured.RestAssured;

public class AccountsScript {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://parabank.parasoft.com/parabank/services/bank";
	}
	
	@Test
	public void TC01_verifyAccountTransactions()
	{
		given()
		.contentType(ContentType.JSON)
		
		.when()
				.get("/accounts/{accountId}/transactions", 12345 )
			
		.then()
				.statusCode(200)
				.body("parameters.id", is(12700));
				.body("parameters.accountId", is(12345));
				.body("parameters.type", contains("Credit"));
				.body("parameters.date", is("2017-08-09T00:00:00-07:00"));
				.body("parameters.amount", is(1000.00));
				.body("parameters.description", contains("Funds Transfer Received"));
			

	}
	
	@Test
	public void TC02_verifyAccountTransactionsInvalidID()
	{
		given()
		.contentType(ContentType.JSON)
		
		.when()
				.get("/accounts/{accountId}/transactions", 1234 )
			
		.then()
				.statusCode(404)
				.body("parameters.description", contains(" Message "));
			

	}

}

package com.bankservices.scripts;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
//import static com.jayway.restassured.RestAssured.*;
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
		String id = given()
		.contentType(ContentType.JSON)
		.pathParam("id", id)
		
		.when()
				.get("/transactions/{transactionid}")
			
		.then()
				.statusCode(200)
				.body("transactionId", is());

	}
	
	@Test
	public void TC02_verifyInvalidTransaction()
	{
		String id = given()
		.contentType(ContentType.JSON)
		.pathParam("id", id)
		
		.when()
				.get("/transactions/{transactionid}")
			
		.then()
				.statusCode(200)
				.body("message", is("Could not find transaction"));
	}

}

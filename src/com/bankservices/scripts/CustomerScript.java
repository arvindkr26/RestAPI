package com.bankservices.scripts;

import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bankservices.model.Customer;
import com.jayway.restassured.http.ContentType;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class CustomerScript {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://parabank.parasoft.com/parabank/services/bank";
	}
	
	@Test
	public void TC01_postCustomerSellPositon()
	{
		Customer customer=new Customer(12212, 12345, 12345, 20000, 300);
		
		given()
			.contentType(ContentType.JSON)
			.body(customer)
			
		.when()
			.post("/customers/{customerId}/sellPosition",12212)
			
		.then()
			.statusCode(200)
			.body("customerId", is(customer.setcustomerId()))
			.body("accountId", is(customer.setaccountId()))
			.body("positionId", is(customer.setpositionId()))
			.body("shares", is(customer.setshares()))
			.body("pricePerShare", is(customer.setpricePerShare()));		

	}
	
	@Test
	public void TC02_postCustomerBuyPositon()
	{
		Customer customer1=new Customer(12212, 12345, "Tester", "TTT", 20000, 300);
		
		given()
			.contentType(ContentType.JSON)
			.body(customer1)
			
		.when()
			.post("/customers/{customerId}/buyPosition",12212)
			
		.then()
			.statusCode(200)
			.body("customerId", is(customer1.setcustomerId()))
			.body("accountId", is(customer1.setaccountId()))
			.body("name", is(customer1.setName()))
			.body("symbol", is(customer1.setSymbol()))
			.body("shares", is(customer1.setshares()));
			.body("pricePerShare", is(customer1.setpricePerShare()));

	}

}

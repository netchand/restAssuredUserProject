package com.employeeapi.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class GET_Single_Employee_Record extends TestBase{
	@BeforeClass
	void getAllEmployess() throws InterruptedException
	{
		logger.info("*********Get one user record*********");
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/users/"+userID);
		Thread.sleep(2000);
	}
	
	@Test
	void checkResponseBody()
	{
		logger.info("*********Check response Body*********");
		String responseBody=response.getBody().asString();
		logger.info("Response Body:"+responseBody);
		Assert.assertEquals(responseBody.contains(userID),true);
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********Finished Get All employess test*********");
	}
}

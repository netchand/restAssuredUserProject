package com.employeeapi.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class Delete_user_Record extends TestBase {
	
	@BeforeClass
	void deleteUserRecord() throws InterruptedException
	{
		logger.info("*********Delete user record*********");
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/users");
		//first fetch the first id from the DB and delete the record
		JsonPath jsonPathEvaluator=response.jsonPath();
		String fetchedUserID=jsonPathEvaluator.get("[0].id");
		response=httpRequest.request(Method.DELETE,"/delete/"+fetchedUserID);
		
		Thread.sleep(2000);
		
		}
	
	@Test
	void checkResponseBody()
	{
		String responseBody=response.getBody().asString();
		Assert.assertEquals(responseBody.contains("successfully! deleted Records"),true);
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********Finished Get All employess test*********");
	}
}

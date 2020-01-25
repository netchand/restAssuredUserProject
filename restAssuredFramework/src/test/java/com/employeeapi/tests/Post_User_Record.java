package com.employeeapi.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Post_User_Record extends TestBase {
	
	String userFirstName=RestUtils.userFirstName();
	String userLastName=RestUtils.userLastName();
	String userEmailID=RestUtils.userEmailID();
	String userID=RestUtils.userID();
	String userAvatar=RestUtils.userAvatar();
	
	
	@BeforeClass
	void createUser() throws InterruptedException
	{
		logger.info("*********Post user Record*********");
		
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest=RestAssured.given();
		//response=httpRequest.request(Method.GET,"/users/"+userID);
		
		JSONObject requestParams=new JSONObject();
		requestParams.put("id", userID);
		requestParams.put("first_name", userFirstName);
		requestParams.put("last_name", userLastName);
		requestParams.put("email", userEmailID);
		requestParams.put("avatar", userAvatar);
		
		
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.POST,"/create");
		Thread.sleep(3000);
	}
	
	@Test
	void checkResponseBody()
	{
		String responseBody=response.getBody().asString();
		Assert.assertEquals(responseBody.contains(userFirstName),true);
		Assert.assertEquals(responseBody.contains(userLastName),true);
		Assert.assertEquals(responseBody.contains(userEmailID),true);
		Assert.assertEquals(responseBody.contains(userID),true);
		Assert.assertEquals(responseBody.contains(userAvatar),true);
		
	}
	//chk status line,code,header->refer get all employee
	@AfterClass
	void tearDown()
	{
		logger.info("*********Finished Get All employess test*********");
	}
}

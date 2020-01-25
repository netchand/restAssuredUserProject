package com.employeeapi.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Get_All_Employees extends TestBase {
	
	
	@BeforeClass
	void getAllEmployess() throws InterruptedException
	{
		logger.info("*********Get All Employess*********");
		RestAssured.baseURI="https://reqres.in/api";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/users");
		Thread.sleep(2000);
	}
	
	@Test
	void checkResponseBody()
	{
		logger.info("*********Check response Body*********");
		String responseBody=response.getBody().asString();
		logger.info("Response Body:"+responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("*********Check status Body*********");
		int statusCode=response.getStatusCode();
		logger.info("status code:"+statusCode);
		Assert.assertEquals(statusCode,200);
	}
	
	@Test
	void checkResponseTime()
	{
		logger.info("*********Check Response time *********");
		long responseTime=response.getTime();
		logger.info("status code:"+responseTime);
		
		if(responseTime>2000)
			logger.warn("Response time is greater than 2000");
		Assert.assertTrue(responseTime<2000);
	}
	
	@Test
	void checkStatusLine()
	{
		logger.info("*********Check status Line*********");
		String statusLine=response.getStatusLine();
		logger.info("status line:"+statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
	}
	
	@Test
	void checkContentType()
	{
		logger.info("*********Check Content Type*********");
		String contentType=response.header("Content-Type");
		logger.info("Content type"+contentType);
		Assert.assertEquals(contentType,"application/json; charset=utf-8");
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********Finished Get All employess test*********");
	}
	
	
}

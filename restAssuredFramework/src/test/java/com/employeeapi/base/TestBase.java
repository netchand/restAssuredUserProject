package com.employeeapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String userID="5";//hard coded-input for GEt details of single employee and update employee
	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger=Logger.getLogger("EmployeeRestAPI");//employeerestapi is a project name/any other name
		PropertyConfigurator.configure("Log4j.properties");//path of log4j.properties since its present inside the project itself
		logger.setLevel(Level.DEBUG);
	}
	
}

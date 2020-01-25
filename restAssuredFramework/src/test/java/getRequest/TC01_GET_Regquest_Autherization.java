package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_GET_Regquest_Autherization {
	@Test
	public void Autherization()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/autentication/CheckForAuthentication/";
		
		//Basic authentication
		PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
		
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		
		RestAssured.authentication=authscheme;
		
		//Request object 
		RequestSpecification httpRequest=RestAssured.given();
		//response object
		Response response=httpRequest.request(Method.GET,"/");
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("response body is :"+responseBody);
		
		//status code
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode,200);//in vedio as per teaching
		
		
		
		
		
		
	}

}

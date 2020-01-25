package getRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_POST_Request {
	
	@Test
	public void Registration()
	{
		
		//specifiy base URI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		//Request object 
		RequestSpecification httpRequest=RestAssured.given();
		//response object
		//request payload sending along with post request
		JSONObject requestParams=new JSONObject();
		requestParams.put("FirstName","netJohnTom");
		requestParams.put("LastName","netXYZ");
		requestParams.put("UserName","JohnTom");
		requestParams.put("Password","JohnTom");
		requestParams.put("Email","JohnTom@gmail.com");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());//attach above data to request
		
		Response response=httpRequest.request(Method.POST,"/register");
		//print response in console window
		
		String responseBody=response.getBody().asString();
		System.out.println("response body is :"+responseBody);
		//status code validation
		int statusCode=response.getStatusCode();
		System.out.println("Status code:"+statusCode);
		Assert.assertEquals(statusCode,201);
		//status line verification
		String successCode=response.jsonPath().get("SuccessCode");
				Assert.assertEquals(successCode,"OPERATION_SUCCESS");
		
	}

	

}

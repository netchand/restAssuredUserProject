package getRequest;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC_GET_Request {

	@Test
	public void getWeatherDetails()
	{
		
		//specifiy base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		//Request object 
		RequestSpecification httpRequest=RestAssured.given();
		//response object
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		//print response in console window
		
		String responseBody=response.getBody().asString();
		System.out.println("response body is :"+responseBody);
		//validate json response body
		Assert.assertEquals(responseBody.contains("Hyderabad"),true);//if u r using small h then it fails
		
		//status code validation
		int statuscode=response.getStatusCode();
		Assert.assertEquals(200,statuscode);
		//status line verification
		String statusLine=response.getStatusLine();
		Assert.assertEquals("HTTP/1.1 200 OK",statusLine);
		//to validate the response header
		String contentEncoding=response.header("Content-Encoding");
		System.out.println("content encoding header:"+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
		//get all the headers
		
		Headers allHeader=response.headers();
		for(Header header:allHeader)
		{
			System.out.println(header.getName()+ " "+header.getValue());
	
		}
		
		//vlidate each(node) value of json response body(verify all the fields)
		JsonPath jsonpath=response.jsonPath();
		
		String city=jsonpath.get("City");//returns city value
		System.out.println("city is :"+city);
		System.out.println(jsonpath.get("Temperature"));
		System.out.println(jsonpath.get("Humidity"));
		System.out.println(jsonpath.get("WeatherDescription"));
		System.out.println(jsonpath.get("WindSpeed"));
		System.out.println(jsonpath.get("WindDirectionDegree"));
		
		
	}
}

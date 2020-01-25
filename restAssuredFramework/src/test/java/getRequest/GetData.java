package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class GetData {
	@Test
	public void testResponseCode()
	{
		//Response response=RestAssured.get("https://reqres.in/api/users");
		
		//int code=response.getStatusCode();
		
		int code=get("https://reqres.in/api/users").getStatusCode();
		System.out.println("Status code :"+code);
		Assert.assertEquals(code,200);
	}
	@Test
	public void testBody()
	{
		Response response=RestAssured.get("https://reqres.in/api/users");
	
		String data=response.asString();
		//or use below line when use static import
		String data1=get("https://reqres.in/api/users").asString();
		long time=get("https://reqres.in/api/users").getTime();
		System.out.println("data :"+data);
		System.out.println("response time:"+response.getTime());
	}
	
}

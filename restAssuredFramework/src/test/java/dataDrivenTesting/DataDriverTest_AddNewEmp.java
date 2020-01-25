package dataDrivenTesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriverTest_AddNewEmp {
	
	@Test(dataProvider="empdataprovider")
	void postNewEmployees(String empname,String empage,String empsalary)
	{
		//specifiy base URI
				RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/create";//this is not working change to some good working uri
				//Request object 
				RequestSpecification httpRequest=RestAssured.given();
				//data which need to be sent along with post request
				
				JSONObject requestParams=new JSONObject();
				requestParams.put("name", "empname");
				requestParams.put("salary", "empsalary");
				requestParams.put("age", "empage");
				
				httpRequest.header("Content-Type","application/json");
				
				//add json body to rrquest
				httpRequest.body(requestParams.toJSONString());
				//post request need to be sent
				Response response=httpRequest.request(Method.POST,"/create");
				
				//caputure response body to perform validations
		
		  String responseBody=response.getBody().asString();
		  Assert.assertEquals(responseBody.contains("empname"),true);
		  Assert.assertEquals(responseBody.contains("empsalary"),true);
		  Assert.assertEquals(responseBody.contains("empage"),true);
		 
			
			int statusCode=response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
	}

	@DataProvider(name="empdataprovider")
	public String[][] getEmpData() throws IOException
	{	
		//String path="C:/Users/netchand/eclipse-workspace/restAssuredFramework/src/test/java/dataDrivenTesting/empData.xlsx";
		String path=System.getProperty("user.dir")+"/src/test/java/dataDrivenTesting/empData.xlsx";
	    int rownum=	XLUtils.getRowCount(path, "sheet1");
		int colnum=XLUtils.getCellCount(path,"sheet1", 1);
		
		String empData[][]=new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				empData[i-1][j]=XLUtils.getCellData(path, "sheet1", i,j);
			}
		}
		
		
		//String empdata[][]= {{"xyz","2345","34"},{"xyvbz","256345","39"},{"rtsxyz","122345","32"}};
		return(empData);
	}
}

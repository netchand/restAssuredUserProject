package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String userFirstName()
	{
		String generatedFirstName=RandomStringUtils.randomAlphabetic(1);
		return("TejasGowda"+generatedFirstName);
	}
	public static String userLastName()
	{
		String generatedLastName=RandomStringUtils.randomAlphabetic(1);
		return("L"+generatedLastName);
	}
	public static String userEmailID()
	{
		String generatedEmailID=RandomStringUtils.randomAlphabetic(1);
		return(generatedEmailID+"TEjas@.com");
	}
	public static String userAvatar()
	{
		String generatedAvatar=RandomStringUtils.randomAlphabetic(1);
		return(generatedAvatar+"https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg");
	}
	
	public static String userID()
	{
		String generatedID=RandomStringUtils.randomNumeric(2);
		return(generatedID);
	}
	

}

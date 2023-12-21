package com.mystore.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.MyAccountPage;

public class TC_002_DataProviderTest_HashMap extends BaseClass{
	
	
	@Test(dataProvider = "MyData")
	public void VerifyLoginTest(HashMap<String, String> map) throws IOException {
		
		System.out.println("VerifyLoginTest execution started");
		logger.info("VerifyLoginTest execution started");
		
		IndexPage indexpage=new IndexPage(driver);
		indexpage.click_SignIn();
		System.out.println("Clicking on SignIn Link");
		logger.info("Clicking on SignIn Link");
		
		MyAccountPage myaccount=new MyAccountPage(driver);
		myaccount.signInWithEmail(map.get("email"));
		System.out.println("Enter Registered email id");
		logger.info("Enter Registered email id");
		
		myaccount.signInWithPassword(map.get("password"));
		System.out.println("Enter Registered password");
		logger.info("Enter Registered password");
		
		myaccount.click_SignInButton();
		System.out.println("Submit details for sign In");
		logger.info("Submit details for sign In");
		
		String profileName=myaccount.VerifyProfileName();
		
		if(profileName.equalsIgnoreCase(map.get("username"))) {
			
			System.out.println("User Logged in successfully");
			logger.info("User Logged in successfully");
			Assert.assertTrue(true);
			
		}
		else {
			
			System.out.println("User login failed");
			logger.info("User login failed");
			takeScreenshot(driver, "VerifyLoginTest");
			Assert.assertTrue(false);
				
		}
		
		System.out.println("VerifyLoginTest execution finished");
		logger.info("VerifyLoginTest execution finished");
	}
	
	
	@DataProvider(name="MyData")
	public Object[][] getData() {
		
		
		HashMap<String, String> map1=new HashMap<String, String>();
		map1.put("email", "Test99@gmail.com");
		map1.put("password", "Test@123");
		map1.put("username", "Matin Shaikh");
		
		 
		HashMap<String, String> map2=new HashMap<String, String>();
		map2.put("email", "Test79@gmail.com");
		map2.put("password", "Test@123");
		map2.put("username", "Test Khan");
		
		return new Object[][] {
			
			{map1},{map2}
			
		};
		
		
		
	}
	
	
	
	
	
	
	
	

}

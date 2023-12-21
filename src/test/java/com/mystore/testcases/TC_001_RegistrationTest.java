package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.MyAccountCreationPage;
import com.mystore.pageobjects.MyAccountPage;

public class TC_001_RegistrationTest extends BaseClass{

	
	
	@Test(enabled = false)
	public void MyAccountTest() throws InterruptedException {
		
		
		IndexPage indexpage=new IndexPage(driver);
		indexpage.click_SignIn();
		logger.info("Clicking on SignIn Link");
		
		MyAccountPage myaccount=new MyAccountPage(driver);
		myaccount.enterEmailAddress("Test79@gmail.com");
		logger.info("Entering email address");
		
		myaccount.click_CreateAccount();
		logger.info("Clicking on create account");
		
		MyAccountCreationPage creation=new MyAccountCreationPage(driver);
		creation.selectGender();
		logger.info("Select gender");
		
		creation.enterFirstName("Test");
		logger.info("Entering first name");
		
		
		creation.enterLastName("Khan");
		logger.info("Entering last name");
		
		creation.enterPassword("Test@123");
		logger.info("Entering password");
		
		creation.clickRegister();
		logger.info("Clicking on register button");
		
		Thread.sleep(5000);
		
		String profileName=myaccount.VerifyProfileName();
		Assert.assertEquals(profileName, "Test Khan");
		logger.info("Test case passed");
		
	}
	
	@Test
	public void VerifyLoginTest() throws IOException {
		
		logger.info("VerifyLoginTest execution started");
		
		IndexPage indexpage=new IndexPage(driver);
		indexpage.click_SignIn();
		logger.info("Clicking on SignIn Link");
		
		MyAccountPage myaccount=new MyAccountPage(driver);
		myaccount.signInWithEmail("Test79@gmail.com");
		logger.info("Enter Registered email id");
		
		myaccount.signInWithPassword("Test@123");
		logger.info("Enter Registered password");
		
		myaccount.click_SignInButton();
		logger.info("Submit details for sign In");
		
		String profileName=myaccount.VerifyProfileName();
		
		if(profileName.equalsIgnoreCase("Man")) {
			
			logger.info("User Logged in successfully");
			Assert.assertTrue(true);
			
		}
		else {
			
			
			logger.info("User login failed");
			takeScreenshot(driver, "VerifyLoginTest");
			Assert.assertTrue(false);
				
		}
		
		logger.info("VerifyLoginTest execution finished");
	}
	
	
	
}

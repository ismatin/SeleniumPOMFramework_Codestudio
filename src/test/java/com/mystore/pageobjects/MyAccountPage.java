package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;

	public MyAccountPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath="//input[@id='email_create']")
	WebElement emailText;

	@FindBy(xpath="//span[normalize-space()='Create an account']")
	WebElement createAccountBtn;

	@FindBy(xpath="//a[@class='account']//span")
	WebElement profileName;


	// Registered user
	@FindBy(id="email")
	WebElement email;


	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(xpath="//span[normalize-space()='Sign in']")
	WebElement signInButton;
	

	public void enterEmailAddress(String email) {

		emailText.sendKeys(email);
	}


	public void click_CreateAccount() {

		createAccountBtn.click();
	}

	public String VerifyProfileName() {

		String name=profileName.getText();
		return name;
	}


	// Registered user
	public void signInWithEmail(String emailid) {

		email.sendKeys(emailid);
	}

	public void signInWithPassword(String pwd) {

		password.sendKeys(pwd);
	}

	
	public void click_SignInButton() {
		
		signInButton.click();
		
	}


}

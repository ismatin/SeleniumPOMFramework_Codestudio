package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountCreationPage {

	WebDriver driver;

	public MyAccountCreationPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="id_gender1")
	WebElement Mr;

	@FindBy(id="customer_firstname")
	WebElement firstName;

	@FindBy(id="customer_lastname")
	WebElement lastName;

	@FindBy(id="email")
	WebElement email;

	@FindBy(id="passwd")
	WebElement password;

	@FindBy(xpath="//span[normalize-space()='Register']")
	WebElement register;


	public void selectGender() {

		Mr.click();
	}

	public void enterFirstName(String firstname) {

		firstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {

		lastName.sendKeys(lastname);
	}

	public void enterPassword(String pwd) {
		
		password.sendKeys(pwd);
	}
	
	public void clickRegister() {
		
		register.click();
	}









}

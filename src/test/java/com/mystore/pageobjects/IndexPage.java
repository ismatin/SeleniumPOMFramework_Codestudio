package com.mystore.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class IndexPage {

	//****************************Initialize WebDriver:************************
	WebDriver driver;


	// ******************************Constructor:******************************

	public IndexPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// ******************************Page Objects:******************************

	@FindBy(xpath="//a[normalize-space()='Sign in']")
	WebElement signinLink;

	// ******************************Action Methods:*****************************

	public void click_SignIn() {

		signinLink.click();

	}




}

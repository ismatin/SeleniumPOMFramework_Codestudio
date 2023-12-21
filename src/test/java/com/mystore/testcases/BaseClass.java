package com.mystore.testcases;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import com.mystore.utilities.ReadConfig;

public class BaseClass {
	
	// Access baseurl and browser
	ReadConfig readconfig=new ReadConfig();
	String url=readconfig.getBaseUrl();
	String browser=readconfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeMethod
	public void setup() {
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			
			driver=new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			
			driver=new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();

	
		logger = LogManager.getLogger("MyStoreV1");
		// Import these packages for the above logger
		//import org.apache.logging.log4j.LogManager;
		//import org.apache.logging.log4j.Logger;
				
		driver.get(url);
		logger.info("Opening URL");
		
	}

	@AfterMethod
	public void tearDown() {
		
		//driver.close();
		//driver.quit();
	}
	
	
	public void takeScreenshot(WebDriver driver, String testname) throws IOException {
		
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		
		// Call getScreenshotAs to create img file
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest=new File(System.getProperty("user.dir")+"\\Screenshots\\"+testname+".png");
		
		// Store screenshot at Screenshots folder
		FileUtils.copyFile(src, dest);
		
	}
	
	
}

package com.mystore.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener implements ITestListener{
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport() {
		
		ReadConfig readconfig=new ReadConfig();
		
		// Create date format
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		
		// Report with timestamp
		String reportName="MyTestReport_"+timestamp+".html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\"+reportName);
		
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		// Add system info
		reports.setSystemInfo("OS", "Windows 12");
		reports.setSystemInfo("Browser", readconfig.getBrowser()); // accessing browser name from properties file
		reports.setSystemInfo("QA", "Matin Shaikh");
		
		
		// Set report name
		htmlReporter.config().setReportName("AutomationReport");
		htmlReporter.config().setDocumentTitle("ExtentReport");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}

	public void onTestStart(ITestResult result) {
		
		configureReport();
	}

	public void onTestSuccess(ITestResult result) {
		
		
		System.out.println(result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Test case passed"+result.getName(), ExtentColor.GREEN));
	
		
	}

	public void onTestFailure(ITestResult result) {
		
		// result.getName()--> returns test case name
		System.out.println("Name of the test case failed:"+result.getName()); 
		
		// Create entry in the extent report for the failed test case
		test =reports.createTest(result.getName());
		test.log(Status.FAIL, result.getName());
		
		// Add exception to the report
		test.log(Status.FAIL, result.getThrowable());
		
		// Add screenshot to the report
		// Here we stored screenshot in Screenshots folder
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		test.addScreenCaptureFromPath(screenshotPath);
		
		
		
	}	

	public void onTestSkipped(ITestResult result) {
	
		
		System.out.println("Name of the skipped test case:"+result.getName());
		test =reports.createTest("Name of the skipped test case:"+result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Skipped test case:"+result.getName(), ExtentColor.YELLOW));
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
		
		
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		reports.flush(); // When flush method calls, all info will be written to extent report
	}

}

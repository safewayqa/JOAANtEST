package com.qa.Listeners;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.qa.Listeners.*;
import com.qa.base.BaseTestDriver;
import com.qa.reports.ExtentReportt;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListeners implements ITestListener {

	
	
	
	public void onTestFailure(ITestResult result) {
		
		if(result.getThrowable()!=null) {
			
			StringWriter sw=new StringWriter();
			PrintWriter pw=new PrintWriter(sw);
			result.getThrowable().printStackTrace(pw);
			System.out.println(sw.toString());	
		}
		
		
		  BaseTestDriver base=new BaseTestDriver(); 
		  File file=base.gerDriver().getScreenshotAs(OutputType.FILE);
		  
		  Map<String, String> params=new HashMap<String, String>();
		  params=result.getTestContext().getCurrentXmlTest().getAllParameters();
		  String imagePath="Screenshots"+File.separator+params.get("platformName")+ "_"+ params.get("platformVersion")+ "_"+ params.get("deviceName")
		                      +File.separator+base.getDateTime()+File.separator+result.getTestClass().getRealClass().getSimpleName()
		                      + File.separator + result.getName() + ".png";
		  
		  String completeImagePath=System.getProperty("user.dir") +File.separator +imagePath;
		  
		  
		  try { 
			  FileUtils.copyFile(file, new File(imagePath));
			  Reporter.log("This is the sample screen buddy");
			  Reporter.log("<a href='"+completeImagePath+"'> <img src='"+completeImagePath+"' height='100' width='100'/></a>");
			  } catch (IOException e) {
				  e.printStackTrace();
		 }

		//  ExtentReportt.getTest().log(Status.FAIL, "Test Failed");
		  
		  try {
			ExtentReportt.getTest().fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(completeImagePath).build());
			ExtentReportt.getTest().fail(result.getThrowable());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
	@Override 
    public void onTestStart(ITestResult result) {
    	ExtentReportt.startTest(result.getName(), result.getMethod().getDescription());
    
    }
       
    @Override 
    public void onTestSuccess(ITestResult iTestResult) {
    	ExtentReportt.getTest().log(Status.PASS, "Test Passed");
    }
 
    @Override 	 
    public void onTestSkipped(ITestResult iTestResult) {
    	
    	ExtentReportt.getTest().log(Status.SKIP, "Test Skipped");
    }
    @Override 
    public void onFinish(ITestContext iTestContext) {
    	ExtentReportt.getReporter().flush();
    }
    
    
    
    
	@Override 
    public void onStart(ITestContext iTestContext) {
		
    }
 
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
       
    }

	
}
package com.qa.reports;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportt {
	static ExtentReports extent;
	final static String filepath="Extent.html";
	static Map<Integer, ExtentTest> extentTestMap = new HashMap();
	
	public synchronized static ExtentReports getReporter() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		if(extent==null) {
		ExtentSparkReporter html=new ExtentSparkReporter(path);
		html.config().setReportName("JOAAN_APP_Automation_Report");
		html.config().setTheme(Theme.STANDARD);
		 extent=new ExtentReports();	
		extent.attachReporter(html);
	}
 return extent;
}
	   public static synchronized ExtentTest getTest() {
	        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	    }

	  

	    public static synchronized ExtentTest startTest(String testName, String desc) {
	        ExtentTest test = getReporter().createTest(testName, desc);
	        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

	        return test;
	    }
}

package com.qa.base;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.aspectj.weaver.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import qa.utils.*;
public class Noframe {
 
	public static   AppiumDriver<MobileElement> driver;
	static  TestUtils utilss;
	
	

  @Test
  public void beforeTest() throws MalformedURLException, InterruptedException {
	  
	  
	  
	   utilss=new TestUtils();
	  
	  DesiredCapabilities cap= new DesiredCapabilities();
	  
	  cap.setCapability("deviceName", "Rafi");
	  cap.setCapability("platformName", "Android");
	  cap.setCapability("platformVersion", "9.0");
	  cap.setCapability("udid", "5cdaec1e");
	  cap.setCapability("appPackage", "com.fifthfinger.clients.joann");
	  cap.setCapability("appActivity", "com.joann.android.MainActivity");
	  
	  URL url=new URL("http://127.0.0.1:4723/wd/hub");
	   driver=new AndroidDriver<MobileElement>(url,cap);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
	
	  
	  driver.findElement(By.id("com.fifthfinger.clients.joann:id/textViewSkip")).click();
	  driver.findElement(By.id("com.fifthfinger.clients.joann:id/doItLaterButton")).click();
	  driver.findElement(By.xpath("//android.widget.EditText[@text='Search stores & online']")).sendKeys("masks");
	  driver.findElement(By.xpath("//android.widget.TextView[@index='3']")).click();
	  Thread.sleep(4000);
	List<MobileElement> size=  driver.findElements(By.xpath("//*[@class='android.widget.ImageView']"));
		System.out.println("size value is"+size);
		Thread.sleep(4000);
		try {
		size.get(8).click();
		System.out.println("value--- 8");
		}catch(Exception e) {
			size.get(9).click();
			System.out.println("value--- 9");
		}
		
		
		driver.findElement(By.id("com.fifthfinger.clients.joann:id/buttonAddToMyBag")).click();
		driver.findElements(By.xpath("//*[@class='android.widget.EditText']")).get(1).sendKeys("Rafi");
		
		driver.findElements(By.xpath("//*[@class='android.widget.EditText']")).get(2).sendKeys("Mohammed");
		
		driver.findElements(By.xpath("//*[@class='android.widget.EditText']")).get(3).sendKeys("generate@gmail.com");
		
		driver.findElements(By.xpath("//*[@class='android.widget.EditText']")).get(4).sendKeys("11111111111");
		/*
		 * driver.findElement(By.id("com.fifthfinger.clients.joann:id/textViewSkip")).
		 * click();
		 * 
		 * 
		 * driver.findElement(By.id(
		 * "com.fifthfinger.clients.joann:id/buttonCreateAccount")).click();
		 * 
		 * 
		 * driver.findElement(By.xpath(
		 * "//android.widget.LinearLayout[1]/android.widget.EditText[1]")).sendKeys(
		 * "Rafi");
		 * 
		 * driver.findElement(By.xpath(
		 * "//android.widget.LinearLayout[2]/android.widget.EditText[1]")).sendKeys(
		 * "mohammed"); driver.findElement(By.xpath(
		 * "//android.widget.LinearLayout[3]/android.widget.EditText[1]")).sendKeys(
		 * "rafi@gmail.com"); driver.navigate().back(); driver.findElement(By.xpath(
		 * "//android.widget.LinearLayout[4]/android.widget.EditText[1]")).sendKeys(
		 * "6143125660"); driver.navigate().back(); driver.findElement(By.xpath(
		 * "//android.widget.LinearLayout[5]/android.widget.EditText[1]")).sendKeys(
		 * "Ascena1234$"); driver.navigate().back(); driver.findElement(By.xpath(
		 * "//android.widget.LinearLayout[6]/android.widget.EditText[1]")).sendKeys(
		 * "Ascena1234$");
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * driver.findElement(By.id("com.fifthfinger.clients.joann:id/buttonSubmit")).
		 * click();
		 * 
		 */
	  
  }

 
  
 // @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}

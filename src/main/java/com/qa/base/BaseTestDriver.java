package com.qa.base;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import qa.utils.TestUtils;
public class BaseTestDriver {
 
	public static   AppiumDriver<MobileElement> driver;
	public static  TestUtils utilss;
	public static  Properties pros;
	InputStream inputstream;
	InputStream Stringsis; 
	public static String dateTime;
	public static Actions action;
	public static HashMap<String, String> stringss=new HashMap<String, String>();
	
	
	public BaseTestDriver() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
@Parameters({"deviceName","udid","platformName","platformVersion"})
  @BeforeMethod
  public void beforeTest(String deviceName, String udid,String platformName, String platformVersion ) throws IOException {
	
	try {
	utilss=new TestUtils();
    dateTime=utilss.getDateTime();
       String propFileName="config.properties";
	   pros=new Properties();
	   inputstream=getClass().getClassLoader().getResourceAsStream(propFileName);
	   pros.load(inputstream);
	     
	   String xmlFileName="Strings/strings.xml";
	   Stringsis=getClass().getClassLoader().getResourceAsStream(xmlFileName);
	   stringss=utilss.parseStringXML(Stringsis);
	     
	    
	  
	  DesiredCapabilities cap= new DesiredCapabilities();	  
	  cap.setCapability("deviceName", deviceName);
	  cap.setCapability("platformName", platformName);
	  cap.setCapability("platformVersion",platformVersion );
	  cap.setCapability("udid", udid);
	  cap.setCapability("appPackage", pros.getProperty("appPackage"));
	  cap.setCapability("appActivity", pros.getProperty("appActivity"));
	  cap.setCapability("noReset", true);
	  cap.setCapability("fullRest", false);
	 
	  URL url=new URL(pros.getProperty("appiumurl"));
	   driver=new AndroidDriver<MobileElement>(url,cap);
	//   ((InteractsWithApps) driver).resetApp();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}catch(Exception e) {
		e.printStackTrace();
	}
		finally {
				if(inputstream !=null) {
				inputstream.close();
			}
				if(stringss !=null) {
					Stringsis.close();
				}
		}	  
  }

  public void waitforVisibility(MobileElement e) {
	  
	  WebDriverWait wait=new WebDriverWait(driver, 40);
	  wait.until(ExpectedConditions.visibilityOf(e));
	  
  }
  
  public void waitelementToBeClickable(MobileElement e) {
	  
	  WebDriverWait wait=new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.elementToBeClickable(e));
	  
  }
  
  public void click(MobileElement e) {
	  waitforVisibility(e);
	  e.click();
  }
   
  public void clickElement(MobileElement e) {
	  waitelementToBeClickable(e);
	  e.click();
  }
  
  public void IsEnabled(MobileElement e) {
	  waitforVisibility(e);
	  e.isEnabled();
	  
  }
  public void sendkeys(MobileElement e, String text) {
	  waitforVisibility(e);	  
//	 e.sendKeys(text);
	 e.sendKeys(text);
  }
  
  public void keboardHide() {
	  try {
	  driver.hideKeyboard();
	  }catch(Exception e) {
		  
	  }
  }
  
 
  
  public String getAttribute(MobileElement e, String attribute) {
	  waitforVisibility(e);	  
	return  e.getAttribute(attribute);
  }
  
  public String getAttributetext(MobileElement e, String attribute) {
	  waitforVisibility(e);	  
	return  e.getText();
  }
  public String getErrTxt(MobileElement e, String msg) {
	  waitforVisibility(e);	  
	  return e.getAttribute(msg);
  }
  
  
  
  public void backNavigation() {
	  driver.navigate().back();
	  
  }
  public void forwardNavigation() {
	  driver.navigate().forward();
  }
  
  public void actions(MobileElement e,AndroidKey AndroidKey) {
	  ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey));
	  
  }
  

//** Finding the element and scrolling "UP and DOWN" ***//

	public static void scrollToElement(MobileElement e, String direction) {
		for (int i = 0; i <= 3; i++) {
			if (isDisplayed(e)) {
				break;
			} else {
				if (direction.equalsIgnoreCase("up")) {

					utilss.ScrollDownUp(driver, "up");

				} else {
					utilss.ScrollDownUp(driver, "down");

				}
			}
		}

	}

	public static boolean isDisplayed(final MobileElement e) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			return wait.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {

					if (e.isDisplayed()) {
						return true;
					} else {
						return false;
					}
				}

			});
		} catch (Exception ex) {
			return false;
		}
	}		   
	//******* TestUtils element is End***********
  public void closeApp() {
	  ((InteractsWithApps) driver).closeApp();
  }
  
	/*
	 * public void launchApp() { ((InteractsWithApps) driver).closeApp();
	 * ((InteractsWithApps) driver).launchApp(); }
	 */
	
 @AfterTest
  public void afterTest() {
		/*
		 * ((InteractsWithApps) driver).closeApp(); ((InteractsWithApps)
		 * driver).closeApp();
		 */
	 driver.quit();
  }

  public AppiumDriver gerDriver() {
	  return driver;
  }
  public String getDateTime() {
	  return dateTime;
  }
}

package com.qa.test;

import org.testng.annotations.Test;
import org.testng.internal.Utils;

import com.google.common.collect.ImmutableMap;
import com.qa.base.BaseTestDriver;
import com.qa.pages.BillingPage;
import com.qa.pages.CartPage;
import com.qa.pages.GuestUserPage;
import com.qa.pages.HomePage;
import com.qa.pages.PDPPage;
import com.qa.pages.PLPPage;
import com.qa.pages.PlaceOrder;
import com.qa.pages.RegisterUserPage;
import com.qa.pages.ShippingPage;

import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import qa.utils.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class GuestUserTest extends BaseTestDriver {
  
  public static GuestUserPage guestuserpage;
  public static HomePage homepageobjects;
 public static  JSONObject loginuserdata;
 public static PDPPage pdppages;
 public static RegisterUserPage regesteruserpage;
 public static PLPPage plppage;
 public static CartPage cartpage;
 public static ShippingPage shippingpage;
 public static BillingPage billingpage;
   InputStream datais;
 public static PlaceOrder placeorder;
   
   @BeforeClass
  public void beforeClass() throws IOException {
	
	  try {
		
		  String datafileName="data/userdata.json";
		  datais=getClass().getClassLoader().getResourceAsStream(datafileName);
		  JSONTokener tokener=new JSONTokener(datais);
		   loginuserdata=new JSONObject(tokener);
	  }catch(Exception e) {
		  e.printStackTrace();
	  }finally {
		  if(datais !=null) {
			  datais.close();
		  }
	  }
	 
  }

  @AfterClass
  public void afterClass() {
	
	   
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("Rafi");
	  guestuserpage=new GuestUserPage();
	  pdppages=new PDPPage();
	  homepageobjects =new HomePage();
	  regesteruserpage=new RegisterUserPage();
	  plppage =new PLPPage();
	  cartpage=new CartPage();
	  shippingpage=new ShippingPage();
	  billingpage=new BillingPage();
	  placeorder=new PlaceOrder();
	  
  }

	
	 	 

 // @Test(priority=1)
  public void createProfile() throws Exception {
		
	  guestuserpage.skping();
	  guestuserpage.clickCreate(); 
	  guestuserpage.Fnames(loginuserdata.getJSONObject("createUserdata").getString("cfname"));
	  guestuserpage.Lnames(loginuserdata.getJSONObject("createUserdata").getString("cfname"));
	  guestuserpage.email(loginuserdata.getJSONObject("createUserdata").getString("cemail"));
		
		
		  guestuserpage.phone(loginuserdata.getJSONObject("createUserdata").getString("cphone"));
		  
		  guestuserpage.pwd(loginuserdata.getJSONObject("createUserdata").getString("cpwd"));
		 
		  guestuserpage.cnpwd(loginuserdata.getJSONObject("createUserdata").getString("cnpwd"));
		 
		  guestuserpage.checkBox();
		/*
		 * String Actual= guestuserpage.getErrTxt();
		 * System.out.println("Actual is"+Actual); String
		 * Expected=stringss.get("Joann_TC_Conditions");
		 * System.out.println("Expected is"+Expected); Assert.assertEquals(Actual,
		 * Expected);
		 */
		
		guestuserpage.submit();
//		  singinpage.remindMeLater();
		 
		 
	  
  }
  
  @Test(priority=1)
  public void signInUser() throws Exception {

//	  guestuserpage.skping();
	  homepageobjects.Home_More_click();
	  regesteruserpage.SignBtn1();
//	  guestuserpage.signinBtn();
	  regesteruserpage.RuserName(loginuserdata.getJSONObject("Logindata").getString("cusername"));
	  utilss.log().info("user name is rafi");
	  regesteruserpage.Rpassword(loginuserdata.getJSONObject("Logindata").getString("cpassword"));
	  guestuserpage.submit();
	  homepageobjects.HomeBtnClick();
//	  guestuserpage.search("lamp");
	  homepageobjects.Searchdata("tap");
	  
	  
	  homepageobjects.Suggestionselect();
	  plppage.AddtoBag();
	
	cartpage.MiniBagClick();

	String dd=cartpage.Countvalue("text");	
	int Items= Integer.parseInt(dd);
	Assert.assertFalse(Items<0);
	cartpage.ShipType("Home");
	cartpage.PromoCodeApply("RAFITEST");
	cartpage.Checkout_shoppage();
	
	System.out.println("ship");
	

	String amout=shippingpage.TotalAmount("text").substring(1);
	double total= Double.parseDouble(amout);
	
	System.out.println(total);
	Assert.assertFalse(total<0);
	shippingpage.Continue_Payment();
	billingpage.CVV();
	billingpage.ReviewORder();
	System.out.println("Rafi");
	placeorder.OrderNumber("Text");

	
	  
	  System.out.println("Good luck");
  }
//  @Test(priority=2)
  public void Ordernumber() throws Exception {
	  Thread.sleep(4000);
//	  driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='More']")).click();
	  Thread.sleep(5000);
//	  driver.findElement(By.xpath("//android.widget.TextView[@text='SIGN IN']")).click();
	  
	  Thread.sleep(5000);
//	  guestuserpage.signUserName(loginuserdata.getJSONObject("Logindata").getString("cusername"));
	//  utilss.log().info("user name is rafi");
	 // guestuserpage.signUserPwd(loginuserdata.getJSONObject("Logindata").getString("cpassword"));
	 // guestuserpage.submit();
	  driver.findElement(By.xpath("//android.widget.TextView[@text='Home']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("com.joann.android:id/textViewNavRight")).click();
	//  guestuserpage.search("9726837");
	  Thread.sleep(2000);
	  System.out.println("Rafi");
	  driver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE TO CHECKOUT']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text='CONTINUE TO PAYMENT']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("com.joann.android:id/fieldInput")).sendKeys("123");
//	  driver.navigate().back();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.TextView[@text='REVIEW ORDER']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("com.joann.android:id/checkoutButton")).click();
	  Thread.sleep(2000);
	List<MobileElement> ee=  driver.findElements(By.id("com.joann.android:id/orderNumberText"));
	for(int i=0; i<=8; i++) {
	 String order= ee.get(i).getText();
	 System.out.println("Order Number is"+order);
  }
} 
//  @Test(priority=3)
  public void guestUser() throws Exception {
	
//	  guestuserpage.skping();
//	  guestuserpage.skipnow();
	  try {
	  driver.findElement(By.id("android:id/button1")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id(" com.android.packageinstaller:id/permission_deny_button")).click();
	  }catch(Exception e) {
	//  guestuserpage.search("BOX\n");
	  guestuserpage.search("9726837");
	  Thread.sleep(2000);
	  Dimension dim = driver.manage().window().getSize();
	  driver.executeScript("mobile:performEditorAction",ImmutableMap.of("action","search"));
		int x = dim.getWidth() / 2;
		int starty = 0;
		int endy = 0;

		
			starty = (int) (dim.getHeight() * 0.8);
			endy = (int) (dim.getHeight() * 0.2);
			
		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(x, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(x, endy))
				.release().perform();
	  driver.executeScript("mobile:performEditorAction",ImmutableMap.of("action","search"));
	  guestuserpage.clicksuggestitem();
	  Thread.sleep(4000);
	  pdppages.plpList();
	  pdppages.addtoBagBtn();
	  Thread.sleep(3000);
	  pdppages.viewBagBtn();
	  pdppages.continueToCheckoutBtn(); 
	  

		/*
		 * pdppages.continueToCheckoutBtn(); pdppages.continueasGuestBtn();
		 * pdppages.minicarBtn(); pdppages.createAccountBtn();
		 * guestuserpage.Fnames(loginuserdata.getJSONObject("createUserdata").getString(
		 * "cfname"));
		 * guestuserpage.Lnames(loginuserdata.getJSONObject("createUserdata").getString(
		 * "clname"));
		 * guestuserpage.email(loginuserdata.getJSONObject("createUserdata").getString(
		 * "cemail"));
		 * 
		 * backNavigation();
		 * guestuserpage.phone(loginuserdata.getJSONObject("createUserdata").getString(
		 * "cphone")); backNavigation();
		 * guestuserpage.pwd(loginuserdata.getJSONObject("createUserdata").getString(
		 * "cpwd")); backNavigation();
		 * guestuserpage.cnpwd(loginuserdata.getJSONObject("createUserdata").getString(
		 * "cnpwd")); backNavigation(); guestuserpage.checkBox();
		 * guestuserpage.submit();
		 */  
	  
//	  ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	  guestuserpage.Fnames(loginuserdata.getJSONObject("ShippingDetails").getString("shipFname"));
	 guestuserpage.Lnames(loginuserdata.getJSONObject("ShippingDetails").getString("shipLname"));
	guestuserpage.shippingAddress(loginuserdata.getJSONObject("ShippingDetails").getString("shipAdress"));
	guestuserpage.zipCode(loginuserdata.getJSONObject("ShippingDetails").getString("shipZipcode"));
  }
  
}
}
package com.qa.pages;

import java.util.List;

import org.openqa.selenium.Keys;

import com.qa.base.BaseTestDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import qa.utils.TestUtils;

public class GuestUserPage extends BaseTestDriver {
	
 	  
	  @AndroidFindBy(id="com.fifthfinger.clients.joann:id/textViewSkip")
		public MobileElement skip;	
	
	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/buttonCreateAccount")
	public MobileElement CreateBtn;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.EditText[1]")
	public MobileElement Fname;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[2]/android.widget.EditText[1]")
	public MobileElement Lname;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[3]/android.widget.EditText[1]")
	public MobileElement Email;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[4]/android.widget.EditText[1]")
	public MobileElement Phone;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[5]/android.widget.EditText[1]")
	public MobileElement Password;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[5]/android.widget.EditText[1]")
	public MobileElement Password1;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[6]/android.widget.EditText[1]")
	public MobileElement Cpassword;
	@AndroidFindBy(xpath="//android.widget.LinearLayout[5]/android.widget.EditText[1]")
	public MobileElement Cpassword1;

	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/checkBoxTerms")
	public MobileElement checkbox;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='SUBMIT']")
	public MobileElement Submitbtn;
	
	
	
	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/buttonSignIn")
	public MobileElement signinbtn;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.EditText[1]")
	public MobileElement signusername;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[2]/android.widget.EditText[1]")
	public MobileElement signuserpwd;
	
	//*************************
	
	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/doItLaterButton")
	public MobileElement skipnow;
	
	//Searchproduct ***
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search stores & online']")
	public MobileElement search;
	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/editText")
	public MobileElement searchenter;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search']")
	public MobileElement searchdata;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Suggested Searches']")
	public MobileElement suggest;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@index='3']")
	public MobileElement suggest1;
	
//Shipping address
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[3]/android.widget.EditText[1]")
	public MobileElement shippingAddress;
	
	@AndroidFindBy(xpath="//android.widget.EditText[6]")
	public MobileElement zipCode1;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[5]/android.widget.EditText[1]")
	public MobileElement zipCode;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[4]/android.widget.LinearLayout[2]/android.widget.EditText")
	public MobileElement State;
	
	
	
	
	
	
	public GuestUserPage skping() {
		utilss.log().info("Clicked on the Skiped button");
		click(skip);
		return new GuestUserPage();
	}
	
	public GuestUserPage clickCreate() {
		utilss.log().info("clicked on the Create button");
		click(CreateBtn);
		return new GuestUserPage();
	}
	
	public GuestUserPage Fnames(String sname) {		
		click(Fname);
		sendkeys(Fname,sname);
		keboardHide();
		return new GuestUserPage();
	}
	
	public GuestUserPage Lnames(String lname) {		
		click(Lname);
		sendkeys(Lname,lname);
		keboardHide();
		return new GuestUserPage();
	}
	
	public GuestUserPage email(String email) {		
		click(Email);
		sendkeys(Email,email);
		keboardHide();
		return new GuestUserPage();
	}
	
	public GuestUserPage phone(String phone) {		
		
		sendkeys(Phone,phone);
		keboardHide();
		return new GuestUserPage();
	}
	
	public GuestUserPage pwd(String paswd) {		
	try {
		sendkeys(Password,paswd);
		keboardHide();
	}catch(Exception e) {
		sendkeys(Password1,paswd);
		keboardHide();
	}
		return new GuestUserPage();
	}
	
	public GuestUserPage cnpwd(String cnpwsd) {		
		try {
		sendkeys(Cpassword,cnpwsd);
		keboardHide();
		}catch(Exception e) {
			System.out.println("Option two");
			sendkeys(Cpassword1,cnpwsd);
			keboardHide();
		}
		return new GuestUserPage();
	}
	
	public GuestUserPage shippingAddress(String address) {
		click(shippingAddress);
		sendkeys(shippingAddress,address);
		keboardHide();
		return new GuestUserPage();
	}
	
	public GuestUserPage zipCode(String code) {
		try {
		click(zipCode);
		sendkeys(zipCode,code);
		keboardHide();
		}catch(Exception e) {
			click(zipCode1);
			sendkeys(zipCode1,code);
			keboardHide();
		}
		return new GuestUserPage();
	}
	public GuestUserPage state(String state) {
		click(State);
		sendkeys(State,state);
//		keboardHide();
		return new GuestUserPage();
	}
	public GuestUserPage submit() {		
		
		click(Submitbtn);
		return new GuestUserPage();
	}
	
	public GuestUserPage checkBox() {	
		scrollToElement(checkbox,"up");
		click(checkbox);
		return new GuestUserPage();
	}
	public GuestUserPage signinBtn() {
		click(signinbtn);
		return new GuestUserPage();
	}
	
	public GuestUserPage signUserName(String susername) {		
		sendkeys(signusername,susername);
		utilss.log().info("username"+susername);
		return new GuestUserPage();
	}
	public GuestUserPage signUserPwd(String spassword) {		
		sendkeys(signuserpwd,spassword);
		utilss.log().info("password"+spassword);
		return new GuestUserPage();
	}
	
	public String getErrTxt() {
		return getAttribute(checkbox, "text");
				
	}
	
	public GuestUserPage skipnow() {
		click(skipnow);
		return new GuestUserPage();
	}
	public GuestUserPage search(String item) {
		click(search);
		sendkeys(searchenter,item);
		
		
	return new GuestUserPage();
	}
	
	public GuestUserPage clicksuggestitem() {
		
		click(suggest1);
		
	return new GuestUserPage();
	}
	
		
}

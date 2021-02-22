package com.qa.pages;



import com.qa.base.BaseTestDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegisterUserPage  extends BaseTestDriver{
	
	
@AndroidFindBy(id="com.joann.android:id/buttonSignIn")
public MobileElement SigninBtn1;

@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.EditText[1]")
public MobileElement signusername;

@AndroidFindBy(xpath="//android.widget.LinearLayout[2]/android.widget.EditText[1]")
public MobileElement signuserpwd;

@AndroidFindBy(xpath="//android.widget.TextView[@text='SUBMIT']")
public MobileElement Submitbtn;




public void SignBtn1() {
	clickElement(SigninBtn1);
}


public RegisterUserPage RuserName(String Rusername) {
//	click(signuserpwd);
	sendkeys(signusername, Rusername);
	return new RegisterUserPage();
}
	
public RegisterUserPage Rpassword(String Rpassword) {
//	click(signuserpwd);
	sendkeys(signuserpwd, Rpassword);
	return new RegisterUserPage();
}

}

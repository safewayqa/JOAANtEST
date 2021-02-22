package com.qa.pages;

import com.qa.base.BaseTestDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BillingPage extends BaseTestDriver{

	
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[3]/android.widget.RadioGroup/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.EditText")
	public MobileElement CVV;
	
	@AndroidFindBy(id="//com.joann.android:id/continueButton")
	public MobileElement ReviewOrderBtn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='REVIEW ORDER']")
	public MobileElement ReviewOrderBtn1;
	
	public BillingPage CVV() throws Exception{
				
		sendkeys(CVV,"1234");
			return new BillingPage();
		}
	
	public PlaceOrder ReviewORder() throws Exception{
	//	click(CVV);
		Thread.sleep(2000);
		clickElement(ReviewOrderBtn1);
		return new PlaceOrder();
	}
}

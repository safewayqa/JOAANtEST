package com.qa.pages;

import com.qa.base.BaseTestDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ShippingPage extends BaseTestDriver{
	
	@AndroidFindBy(id="com.joann.android:id/totalText")
	public MobileElement TotalAmount;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='CONTINUE TO PAYMENT']")
	public MobileElement ContinuetoPayment;
	
	
	public String TotalAmount(String counts) {
		return 	getAttributetext(TotalAmount, counts);
		
	}
	
	public BillingPage Continue_Payment() throws Exception {
		Thread.sleep(2000);
		click(ContinuetoPayment);
		return new BillingPage();
	}

}

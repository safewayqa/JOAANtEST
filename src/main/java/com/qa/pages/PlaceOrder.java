package com.qa.pages;

import com.qa.base.BaseTestDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PlaceOrder extends BaseTestDriver {
	
	
	@AndroidFindBy(id="com.joann.android:id/checkoutButton")
	public MobileElement PlaceBtn;
	
	@AndroidFindBy(id="com.joann.android:id/orderNumberText")
	public MobileElement OrderNumber;

	
	
	public PlaceOrder OrderNumber(String ordernumber) {
		
		click(PlaceBtn);
	String Ordernumber=	getAttributetext(PlaceBtn,ordernumber);
	System.out.println("Ordernumber is"+Ordernumber);
		return this;
	}
	
}

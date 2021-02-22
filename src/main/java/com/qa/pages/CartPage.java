package com.qa.pages;

import com.qa.base.BaseTestDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage extends BaseTestDriver {

	@AndroidFindBy(id="com.joann.android:id/textViewNavRight")
	public MobileElement Minibag;
	
	@AndroidFindBy(xpath="//android.widget.TextSwitcher/android.widget.TextView")
	public MobileElement count;
	
	@AndroidFindBy(id="com.joann.android:id/radioButtonHome")
	public MobileElement ShipToHome;
	
	@AndroidFindBy(id="com.joann.android:id/radioButtonStore")
	public MobileElement StorePickup;	
	
	@AndroidFindBy(id="com.joann.android:id/fieldInput")
	public MobileElement PromoCode;
	
	@AndroidFindBy(id="com.joann.android:id/applyPromoButton")
	public MobileElement ApplyBtn;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='CONTINUE TO CHECKOUT']")
	public MobileElement CheckoutBtn_shoppage;
	
	@AndroidFindBy(id="com.joann.android:id/viewBagButton")
	public MobileElement ViewBag;
	
	
	
	/*
	 * public CartPage MiniBag(String counts) {
	 * 
	 * String count=getAttributetext(Minibag, counts); int
	 * countt=Integer.parseInt(count); System.out.println(countt);
	 * if(String.valueOf(counts) != null) return new CartPage(); return null;
	 * 
	 * }
	 */
	public CartPage MiniBagClick() {
//		IsEnabled(ViewBag);
		
		click(ViewBag);		
		return new CartPage();
		
	}
	
	public String Countvalue(String counts) {
		IsEnabled(count);
		return 	getAttributetext(count, counts);
		
	}
	
	public CartPage ShipType(String type) {
		switch(type) {
		case "Home":
			click(ShipToHome);
			break;
		case "BOPIS":
			click(StorePickup);
			break;
		}
		
		return new CartPage();
		
	}
	
	public CartPage PromoCodeApply(String promocode) throws Exception {
		Thread.sleep(2000);
		utilss.log().info("User scrolling down to enter the promocode");
		scrollToElement(PromoCode,"up");
		sendkeys(PromoCode,promocode);
		click(ApplyBtn);
		return new CartPage();
		
		}
	
	public ShippingPage Checkout_shoppage() {
		utilss.log().info("User clicked on Checkout Button");
		clickElement(CheckoutBtn_shoppage);
		return new ShippingPage();
	}
	
}

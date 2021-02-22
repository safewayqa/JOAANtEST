package com.qa.pages;

import com.qa.base.BaseTestDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PDPPage extends BaseTestDriver{
	
	
	
	@AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.ImageView")
	public MobileElement PLPlist1;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[contains(@resource-id,'com.fifthfinger.clients.joann:id/imageViewProduct') and@index='1']")
	public MobileElement plpimage;
	
	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/radioButtonHome")
	public MobileElement shipmentBtn;
	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/radioButtonStore")
	public MobileElement storetBtn;
	
	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/buttonAddToMyBag")
	public MobileElement addtoBabBtn;
	

	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/viewBagButton")
	public MobileElement veiwBagBtn;
	
	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/checkoutButton")
	public MobileElement continueToCheckoutBtn;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[contains(@resource-id,'com.fifthfinger.clients.joann:id/checkoutButton') and@index='2']")
	public MobileElement continueToCheckoutBtn2;
	
	
	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/textViewNavRight")
	public MobileElement minicart;
	
	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/checkoutButton")
	public MobileElement continueasGuestBtn;
	
	@AndroidFindBy(id="com.fifthfinger.clients.joann:id/createAccountButton")
	public MobileElement createAccountBtn;
	
	
	public PDPPage plpList() throws Exception {
		click(PLPlist1);
		return new PDPPage();
	}
	
	public PDPPage addtoBagBtn() {
		click(shipmentBtn);
		scrollToElement(addtoBabBtn,"up");
	//	click(storetBtn);
	//	click(shipmentBtn);
		click(addtoBabBtn);
		return new PDPPage();		
	}
	
	public PDPPage viewBagBtn() {
		click(veiwBagBtn);
		return new PDPPage();
	}
	
	public PDPPage continueToCheckoutBtn() throws Exception {
		clickElement(continueToCheckoutBtn);
		Thread.sleep(1000);
		click(continueToCheckoutBtn2);
		return new PDPPage();
	}
	
	public PDPPage continueasGuestBtn() {
		clickElement(continueasGuestBtn);
		System.out.println("clicked--continueasGuestBtn");
		return new PDPPage();
	}
	
	
	public PDPPage minicarBtn() {
		click(minicart);
		return new PDPPage();
	}
	
	public PDPPage createAccountBtn() {
		click(createAccountBtn);
		return new PDPPage();
	}
}

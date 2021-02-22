package com.qa.pages;

import com.qa.base.BaseTestDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class PLPPage extends BaseTestDriver{

	
	@AndroidFindBy(id="com.joann.android:id/buttonAdd")
	public MobileElement AddtoBag;
	
	
public PLPPage AddtoBag() throws Exception {
	try {
		Thread.sleep(1000);
	clickElement(AddtoBag);
	
	}catch(Exception e) {
		Thread.sleep(1000);
		scrollToElement(AddtoBag,"up");
		click(AddtoBag);
	}
	return new PLPPage();
}

}

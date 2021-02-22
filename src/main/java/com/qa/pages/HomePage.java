package com.qa.pages;

import com.qa.base.BaseTestDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BaseTestDriver {
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='More']")
	public MobileElement Home_More;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Home']")
	public MobileElement Home_Btn;
	
	
	@AndroidFindBy(id="com.joann.android:id/searchInput")
	public MobileElement Searchtext;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search']")
	public MobileElement searchdata;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@index='3']")
	public MobileElement suggest1;
	
	
	
	
public HomePage Home_More_click() {
	
	click(Home_More);
	return new HomePage();
}
public HomePage HomeBtnClick() {
	
	click(Home_Btn);
	return new HomePage();
}

public HomePage Searchdata(String data) {
	click(Searchtext);
	sendkeys(searchdata, data);
	return new HomePage();
}
public PLPPage Suggestionselect() {
	
	click(suggest1);
	return new PLPPage();
	
}

}
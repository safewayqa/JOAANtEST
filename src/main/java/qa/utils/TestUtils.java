package qa.utils;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.qa.base.BaseTestDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestUtils {

	static AndroidDriver<MobileElement> driver;

	public void ScrollDownUp(AppiumDriver<MobileElement> driver, String direction) {

		Dimension dim = driver.manage().window().getSize();

		int x = dim.getWidth() / 2;
		int starty = 0;
		int endy = 0;

		switch (direction) {

		case "up":
			starty = (int) (dim.getHeight() * 0.8);
			endy = (int) (dim.getHeight() * 0.2);
			break;

		case "down":
			starty = (int) (dim.getHeight() * 0.2);
			endy = (int) (dim.getHeight() * 0.8);

			break;
		}
		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(x, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(x, endy))
				.release().perform();

	}

	public String getDateTime() {

		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd-HH--mm-ss");
		Date date = new Date();
		System.out.println(dateformat.format(date));
		return dateformat.format(date);
	}

	public Logger log() {
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());

	}
	
	
	public HashMap<String, String> parseStringXML(InputStream file) throws Exception{
		
		HashMap<String, String> stringmap=new HashMap<String, String>();
		//Get Document Builder
		DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();
		DocumentBuilder builder= factory.newDocumentBuilder();
		
		//Build Document
		org.w3c.dom.Document document=builder.parse(file);
		
		//Normalize the XML structure ; its just to import !!
		document.getDocumentElement().normalize();
		
		//Here comes the root node
		Element root=document.getDocumentElement();
		
		//Get all elements
		NodeList nlist=document.getElementsByTagName("string");
		
		for(int temp=0; temp<nlist.getLength(); temp++) {
			
			Node node=nlist.item(temp);
			//just a separator
			if(node.getNodeType()==Node.ELEMENT_NODE) {
				
				Element element= (Element)node;
				//store each element key value in map
				stringmap.put(element.getAttribute("name"), element.getTextContent());
			}
		}return stringmap;
	}
}


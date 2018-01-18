package com.redbox.testscripts;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.appium.model.ConfigurationLibrary;

public class Sample {
static IOSDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigurationLibrary.deviceName);
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("udid",ConfigurationLibrary.UD_ID);
		capabilities.setCapability("platformVersion", ConfigurationLibrary.platform_version);
		capabilities.setCapability("bundleId", ConfigurationLibrary.Bundle_Id);
	    capabilities.setCapability("noReset","true");
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
	int siz2=driver.findElements(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell")).size();
	
	System.out.println(siz2);	
	
	for(int i=1;i<siz2;i++)
	{
	String titleSummary=driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]//XCUIElementTypeStaticText[3]")).getAttribute("label");
	System.out.println(titleSummary);
	
	}
		
		
		
		
		
		
		
		
		
		
		
		
/*		
		*//**driver.findElement(By.name("Manage Location")).click();
		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name='Redbox']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name='Redbox']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")).sendKeys("Newyork");
		driver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Search");
		//List<MobileElement> test=   driver.findElements(By.xpath("//XCUIElementTypeTable"));
		System.out.println(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='LocationCell']")).getSize());
		//XCUIElementTypeButton[@name="Map Handle"]**//*
		//System.out.println(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[1]"))).getText();
		//XCUIElementTypeCell[@name="TitleCollectionViewCell"]
		//System.out.println(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[4]")).getText());
		//driver.findElement(By.name("Browse All")).click();
	//	new TouchAction(driver).press(300,75).waitAction(10000).moveTo(-50,0).release().perform();//Duration.ofMillis(0)).moveTo(-50,0).release().perform()
		//new TouchAction(driver).press(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[1]"))).moveTo(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[2]"))).release().perform();
	
		List<MobileElement> test= driver.findElements(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])"));
		
		LinkedHashSet hashSet = new LinkedHashSet();
	
		WebElement slider =  driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleReelCell'])[1]/XCUIElementTypeCollectionView"));
	//	WebElement slider1 =  driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleReelCell'])[2]/XCUIElementTypeCollectionView"));
		System.out.println(test.size());
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    LinkedHashSet<String> hashSetNew = new LinkedHashSet<String>();
//		HashMap<String, String> scrollObject = new HashMap<String, String>();
		 LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
//		
//		 
//		scrollObject.put("direction", "down");			
//		scrollObject.put("element", ((RemoteWebElement) slider).getId());
//		js.executeScript("mobile: scroll", scrollObject);
//		js.executeScript("mobile: scroll", scrollObject);
		for(int i=0;i<7;i++){
			map.put(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[1]")).getAttribute("label"),driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[1]")).getAttribute("value"));
			map.put(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[2]")).getAttribute("label"),driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[2]")).getAttribute("value"));
			map.put(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[3]")).getAttribute("label"),driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[3]")).getAttribute("value"));
			//System.out.println(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[1]")).getAttribute("label"));
			//System.out.println(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[1]")).getAttribute("value"));
			Set<String> keys = map.keySet();
			
			Iterator<String> keyIter = keys.iterator();
			while (keyIter.hasNext()) {
		        String key = keyIter.next();
		        String value = map.get(key);

		      //  System.out.println(key + "\t" + value);

		       // String nextValue = map.get(key);
		      //  hashSetNew.add(value);
//		        if (value.equals(nextValue)) {
//		            map.remove(key);
//		        }
		        
		    }
		//	 System.out.println(map);
			//			hashSet.add(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[4]")).getAttribute("label"));
//			hashSet.add(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[5]")).getAttribute("label"));
//			hashSet.add(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[6]")).getAttribute("label"));
//			
//			System.out.println(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[1]")).getAttribute("label"));
//			System.out.println(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[2]")).getAttribute("label"));
//			System.out.println(driver.findElement(By.xpath("(//XCUIElementTypeCell[@name='TitleCollectionViewCell'])[3]")).getAttribute("label"));
		
			HashMap<String, String> scrollObject1 = new HashMap<String, String>();
			scrollObject1.put("direction", "right");			
			scrollObject1.put("element", ((RemoteWebElement) slider).getId());
			js.executeScript("mobile: scroll", scrollObject1);
		}
		Set<Entry<String, String>> entrySet = map.entrySet();
		ArrayList<Entry<String, String>> listOfEntry = new ArrayList<Entry<String,String>>(entrySet);

		 System.out.println("***************Final List***************");
		  System.out.println(listOfEntry);  
		  System.out.println("***************Final List***************");
		//System.out.println("\n "+hashSet);
		//ßSystem.out.println("\n "+hashSet.size());
*/	

	}

}

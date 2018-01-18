///Keeping Ascending order in Hold

package com.appium.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.remote.HideKeyboardStrategy;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.model.ExtLogger;

public class LocationsPage {
private ExtLogger log = new ExtLogger(LocationsPage.class.toString());
WebDriverWait wait;
IOSDriver<MobileElement> driver;
MorePage more;
HomePage homePage;

public LocationsPage(AppiumDriver<MobileElement> driver) {
PageFactory.initElements(new AppiumFieldDecorator(driver), this);
this.driver = (IOSDriver<MobileElement>) driver;
wait = new WebDriverWait(driver, 100); 
 } 
LinkedList<String> titleNames = new LinkedList<String>();
@iOSFindBy(name="Map Handle")
public WebElement mapHandle;


@iOSFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell")
public List<WebElement> LocationCell;

@iOSFindBy(xpath="//XCUIElementTypeApplication[@name='Redbox']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable")
public WebElement locationCellScroll;

@iOSFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell")
public List<WebElement> TtileCells;

@iOSFindBy(name="Browse all Boxes")
public WebElement browseAllBoxes;

public List<String> displayOfTitleDetails()
{
	System.out.println("###########TtileCells.size()####3"+TtileCells.size()); 
for(int i=1;i<TtileCells.size();i++)
{
String titleSummary=driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]//XCUIElementTypeStaticText[2]")).getAttribute("label");

System.out.println("################3"+titleSummary); 
titleNames.add(titleSummary);
}
return titleNames; 
}

public void mapHandle(){
	mapHandle.click();
}

public void clickBrowseAllBoxes(){
	wait.until(ExpectedConditions.visibilityOf(browseAllBoxes));
	browseAllBoxes.click();
}
public boolean browseAllBoxesVisibility() 
{   boolean browseAllBoxesz = true;
	
try{
	if(browseAllBoxes.getAttribute("enabled").equals(true)){
		browseAllBoxesz= true;
	}
}catch(Exception e){
	browseAllBoxesz=false;
}
return browseAllBoxesz;
}
public void scrollLocations() throws InterruptedException{
	//scrollLocationsSwipe();
//	scrollLocations(sliderLocation);

	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	mapHandle.click();
	System.out.println("######&&&&&&&&&#####"+LocationCell.size());
	int locationNumber=0;
	for(;locationNumber<LocationCell.size();locationNumber++){
		
		System.out.println(""+LocationCell.get(locationNumber).findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+locationNumber+"]//XCUIElementTypeStaticText[3]")).getAttribute("label"));	
		
		
			
	}
//    HashMap<String, String> scrollObject1 = new HashMap<String, String>();
//	scrollObject1.put("direction", "down");			
//	scrollObject1.put("element", ((RemoteWebElement) locationCellScroll).getId());
//	js1.executeScript("mobile: scroll", scrollObject1);
	}
  }
  


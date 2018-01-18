package com.appium.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
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

public class SerachPage {
private ExtLogger log = new ExtLogger(SerachPage.class.toString());
WebDriverWait wait;
IOSDriver<MobileElement> driver;
MorePage more;
HomePage homePage;

public SerachPage(AppiumDriver<MobileElement> driver) {
PageFactory.initElements(new AppiumFieldDecorator(driver), this);
this.driver = (IOSDriver<MobileElement>) driver;
wait = new WebDriverWait(driver, 100); 

} 
/*Elements in FabTray screen*/
@iOSFindBy(xpath="//XCUIElementTypeApplication[@name='Redbox']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]")
public WebElement serachBar;


@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='LocationCell'])[1]")
public List<WebElement> scrollableView;

@iOSFindBy(name="locateIcon")
public WebElement locationIcon;

@iOSFindBy(name="Map Handle")
public WebElement mapHandle;



@iOSFindBy(xpath="//XCUIElementTypeApplication[@name='Redbox']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable")
public WebElement locationCellScroll;

@iOSFindBy(name="Browsing all Boxes")
public WebElement browsingAllBoxes;
@iOSFindBy(name="Show Map")
public WebElement showMap;

@iOSFindBy(name="Search")
public WebElement searchIcon;
@iOSFindBy(xpath="//XCUIElementTypeApplication[@name='Redbox']/XCUIElementTypeWindow[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeKeyboard")
public WebElement keyBoard;

@iOSFindBy(xpath="//XCUIElementTypeNavigationBar[@name='redbox']/XCUIElementTypeButton[1]")
private WebElement searchElement;

@iOSFindBy(name="No results found.")
private WebElement noResultFound;

@iOSFindBy(name="Ok")
private WebElement noResultFoundOK;


@iOSFindBy(xpath="//XCUIElementTypeApplication[@name='Redbox']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable")
private WebElement sliderLocation;


@iOSFindBy(name="LocationCell")
private WebElement Location;

@iOSFindBy(name="Show Map")
private WebElement showMaps;


@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='LocationCell'])[1]")
private WebElement LocationOne;

@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='LocationCell'])[2]")
private WebElement LocationTwo;

@iOSFindBy(xpath="(//XCUIElementTypeCell[@name='LocationCell'])[3]")
private WebElement LocationThree;

@iOSFindBy(name="BROWSE")
public WebElement selectButton;

@iOSFindBy(name="LocationCell")
public List<WebElement> LocationCell;

@iOSFindBy(xpath="(//LocationCell[2]//XCUIElementTypeButton[@name='Select'])")
private WebElement LocationCellOne;


//@iOSFindBy(xpath="(//XCUIElementTypeButton[@name='Select'])[1]")
//public WebElement selectLocationButton;

@iOSFindBy(name="Select")
public WebElement selectLocationButton;


@iOSFindBy(name="Directions")
public WebElement locationDirections;

@iOSFindBy(name="delete")
public WebElement deleteKeysPress;


@iOSFindBy(name="Manage Location")
public WebElement locationIconHomePage;

LinkedHashSet<String> hashSet = new LinkedHashSet<String>();
/*Display of Elements*/
public boolean isLocationIconDisplayed() {
wait.until(ExpectedConditions.visibilityOf(locationIcon));
log.stepLog("Location icon displayed");
return locationIcon.isDisplayed();
}
public boolean isMapHandle() {
wait.until(ExpectedConditions.visibilityOf(mapHandle));
log.stepLog("Map Handle icon displayed");
return mapHandle.isDisplayed();
}
public boolean isBrowsingAllBoxesDisplayed() {
wait.until(ExpectedConditions.visibilityOf(browsingAllBoxes));
log.stepLog("Browsing All Boxes link displayed  ");
return browsingAllBoxes.isDisplayed();
}
public boolean isShowMapDisplayed() {
wait.until(ExpectedConditions.visibilityOf(showMap));
log.stepLog("show Map link displayed as ");
return showMap.isDisplayed();
}
public boolean isSearchDisplayed() {
wait.until(ExpectedConditions.visibilityOf(searchIcon));
log.stepLog("search Icon displayed  ");
return searchIcon.isDisplayed();
}
public boolean isKeyboardDisplayed() {
wait.until(ExpectedConditions.visibilityOf(keyBoard));
log.stepLog("keyBoard displayed  ");
return keyBoard.isDisplayed();
}
/*Method for elements*/
public void sreachIconClick()
{
wait.until(ExpectedConditions.visibilityOf(searchIcon));
searchIcon.click(); 




}
public void clearSearchField(String string){
	searchElement.click();
	for(int i=0;i<string.length();i++)
	deleteKeysPress.click();
}



public void searchIconSendText(String location){
	
	searchElement.sendKeys(location);
	
	driver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Search");
}
/*Method for Getting attribute*/
public String getAttribute(String attribute, WebElement element)
{
	return element.getAttribute(attribute);
	
}
public void scrollLocations(WebElement sliderLocation)
{

	
	for(int i=0;i<7;i++)
	{
		JavascriptExecutor jsNew = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");			
		scrollObject.put("element", ((RemoteWebElement) sliderLocation).getId());
		jsNew.executeScript("mobile: scroll", scrollObject);
		
	}
}

public void scrollLocationsSwipe(){
	for(int i=0;i<4;i++)
	{
	List<MobileElement> list1= driver.findElements(By.xpath("//XCUIElementTypeApplication[@name='Redbox']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTable'])"));
	     Iterator<MobileElement> j=list1.iterator();
	     while(j.hasNext())
	     {
	    MobileElement row =j.next();
	    System.out.println(row.getText());
	     }
	 
	  Dimension size = driver.manage().window().getSize();
	    int starty = (int) (size.height * 0.80);
	     int endy = (int) (size.height * 0.20);
	  int startx = size.width / 2;
	  driver.swipe(startx, starty, startx, endy, 2000);
	  
	}
}

public void scrollAfterMapHandle(){
	mapHandle.click();
}

public void deleteKeyPressKeyboard(){
	wait.until(ExpectedConditions.visibilityOf(deleteKeysPress));
	deleteKeysPress.click();
}
public void clickLocationButton(){
	wait.until(ExpectedConditions.visibilityOf(selectLocationButton));
	selectLocationButton.click();
}

public boolean isDirectionButtonPresent(){
			
		wait.until(ExpectedConditions.visibilityOf(locationDirections));
		return locationDirections.isDisplayed();			
	
}

public boolean isSelectButton(){
	
	wait.until(ExpectedConditions.visibilityOf(selectLocationButton));

	return selectLocationButton.isDisplayed();			

}

public boolean noResultFound(){
	wait.until(ExpectedConditions.visibilityOf(noResultFound));

	return noResultFound.isDisplayed();	
}

public void noResultFoundClick(){
	
    noResultFoundOK.click();	
}

public void showMapClicked(){
	
    showMap.click();	
}

public boolean locationIconHomePageSelected() throws InterruptedException
{    

	if(locationIconHomePage.getAttribute("value") !=null)
		return true;
	else
	return false;
}
public boolean checkSelectButtonofSelectedLoc(){
	boolean buttonExistance = true;
	try{
		if(LocationCell.get(0).findElement(By.name("Select")).isDisplayed())
			buttonExistance= true;
	}catch(Exception e){
		buttonExistance= false;
		
	}
	return buttonExistance;
}

public int favoriteLocationAtTop(){
	boolean locationCellNumber = false;
	int locationNumber=0;
	for(;locationNumber<LocationCell.size();locationNumber++){
		try{
			if(LocationCell.get(locationNumber).findElement(By.name("Select")).isDisplayed())
				
				locationCellNumber=false;
		}catch(Exception e){
			locationCellNumber=true;
			break;
			
		}
		
			
	}
	
	return locationNumber;
}

public boolean defaultLocationDisplayedAfterSettingLocation(){
	boolean defaultLocationDisplayedAfterSettingLocation = false;
	try{
			if(LocationCell.get(0).getAttribute("value").equals("Shop and Save, 5 Tower Ln,  Suite 1527. Outdoor"))
				 defaultLocationDisplayedAfterSettingLocation=true;
		  }catch(Exception e){
			  defaultLocationDisplayedAfterSettingLocation=false;
			}
		
		return defaultLocationDisplayedAfterSettingLocation;
}

public void mapCursorHandle(){
	mapHandle.click();
}

public void scrollMaps() throws InterruptedException{
	//scrollLocationsSwipe();
//	scrollLocations(sliderLocation);
	 boolean locationFound = true;
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	mapHandle.click();
	System.out.println(""+LocationCell.size());
	for(int i=0;i<7;i++){
	while(locationFound!=false){
	for(int j=0;i<LocationCell.size();i++){
		System.out.println(LocationCell.get(i).getAttribute("value"));
	       if(LocationCell.get(i).getAttribute("value").equals("Shop and Save, 5 Tower Ln,  Suite 1527. Outdoor")){
	    	   
	    	   LocationCell.get(i).click();
	    	   locationFound=false;
	    	  return;
	       }}
	if(locationFound==false)break;
	
	HashMap<String, String> scrollObject1 = new HashMap<String, String>();
	scrollObject1.put("direction", "down");			
	scrollObject1.put("element", ((RemoteWebElement) locationCellScroll).getId());
	js1.executeScript("mobile: scroll", scrollObject1);
	}
    Thread.sleep(10000);
   }
  }

public void directscrollMaps() throws InterruptedException{
	//scrollLocationsSwipe();
//	scrollLocations(sliderLocation);
	 boolean locationFound = true;
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	mapHandle.click();
	System.out.println(""+LocationCell.size());
	for(int i=0;i<7;i++){
	while(locationFound!=false){
	for(int j=0;i<LocationCell.size();i++){
		System.out.println(LocationCell.get(i).getAttribute("value"));
	       if(LocationCell.get(i).getAttribute("value").equals("Shop and Save, 5 Tower Ln,  Suite 1527. Outdoor")){
	    	
	    	   LocationCell.get(i).findElement(By.name("Select")).click();
	    	   locationFound=false;
	    	  return;
	       }}
	if(locationFound==false)break;
	
	HashMap<String, String> scrollObject1 = new HashMap<String, String>();
	scrollObject1.put("direction", "down");			
	scrollObject1.put("element", ((RemoteWebElement) locationCellScroll).getId());
	js1.executeScript("mobile: scroll", scrollObject1);
	}
    Thread.sleep(10000);
   }
  }
}

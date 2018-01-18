package com.appium.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.model.ExtLogger;
import com.sun.jna.platform.win32.COM.TypeLibUtil.IsName;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSFindBys;

/**
 * 
 * @author macadmin
 *
 */
public class TitleDetailsScreenPage {
	private ExtLogger log = new ExtLogger(TitleDetailsScreenPage.class.toString());
	WebDriverWait wait;
	IOSDriver<MobileElement> driver;
	MorePage more;
	List<String> titleNames = new ArrayList<String>();

	public TitleDetailsScreenPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = (IOSDriver<MobileElement>) driver;
		wait = new WebDriverWait(driver, 100);
	}	

	/*Elements in Login screen*/
	
	@iOSFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeStaticText")
	public List<WebElement> titleText;
	
	@iOSFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell")
	public List<WebElement> TtileCells;
	
	@iOSFindBy(name="Redbox.TitleDetailView")
	public WebElement titleViewScreen;
	
	/*Display of Elements*/
	public boolean isTitleTextDisplayed(){
		wait.until(ExpectedConditions.visibilityOf(titleViewScreen));
		log.stepLog("Title screen displayed");
		return titleViewScreen.isDisplayed();
	}
	public boolean isTitleTextDisplayed1(){
		wait.until(ExpectedConditions.visibilityOf(titleViewScreen));
		log.stepLog("Title screen displayed");
		return titleViewScreen.isDisplayed();
	}
	/*Methods for Elements*/	
	public void storingTitleText(){
		
		for(int i=1;i<titleText.size();i++)
		{
		String titleName=driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeStaticText["+i+"]")).getAttribute("label");
		log.stepLog( titleName+" displayed");
		titleNames.add(titleName);
		}
		
	}
	public List<String> displayOfTitleDetails()
	{
		storingTitleText();		
		for(int i=1;i<TtileCells.size();i++)
		{
			String titleSummary=driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]//XCUIElementTypeStaticText[1]")).getAttribute("label");
			log.stepLog( titleSummary+" displayed");	
			titleNames.add(titleSummary);
			}
			return titleNames;	
		}

	
}














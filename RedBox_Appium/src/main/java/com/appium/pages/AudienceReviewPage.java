package com.appium.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.model.CommonLibrary;
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
public class AudienceReviewPage {
	private ExtLogger log = new ExtLogger(AudienceReviewPage.class.toString());
	WebDriverWait wait;
	IOSDriver<MobileElement> driver;
	MorePage more;
	List<String> reviewDetails = new ArrayList<String>();
	CommonLibrary comlib;

	public AudienceReviewPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = (IOSDriver<MobileElement>) driver;
		wait = new WebDriverWait(driver, 100);
	}	

	/*Elements in Login screen*/
	
	@iOSFindBy(name="Reviews")
	public WebElement reviewTitle;
	
	@iOSFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeCell")
	public List<WebElement> TtileCells;
	
	@iOSFindBy(xpath="//XCUIElementTypeTable/XCUIElementTypeStaticText")
	public List<WebElement> staticText;
	
	@iOSFindBy(name="Item")
	public WebElement itemIcon;
	
	@iOSFindBy(name="Back")
	public WebElement backButton;
	
	/*Display of Elements*/
	public boolean isItemIconDisplayed(){
		wait.until(ExpectedConditions.visibilityOf(itemIcon));
		log.stepLog("item Icon displayed");
		return itemIcon.isDisplayed();
	}
	public boolean isBackButtonDisplayed(){
		wait.until(ExpectedConditions.visibilityOf(backButton));
		log.stepLog("Back Button displayed");
		return backButton.isDisplayed();
	}
	public boolean isReviewTitleDisplayed(){
		wait.until(ExpectedConditions.visibilityOf(reviewTitle));
		log.stepLog("Review screen displayed");
		return reviewTitle.isDisplayed();
	}
	/*Methods for Elements*/	
	
	public String displayOfAudienceReview()
	{
		String audienceReviews = null;
		for(int i=1;i<=TtileCells.size();i++)
		{
			audienceReviews=driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]//XCUIElementTypeStaticText[3]")).getAttribute("label");
			log.stepLog( audienceReviews+" Review Comments displayed");	
			
			}
			return audienceReviews;
		}
	public List<String> displayOfAudienceReviewDetails()
	{
		for(int i=1;i<=staticText.size();i++)
		{
			String audienceReview=driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeStaticText["+i+"]")).getAttribute("label");
			log.stepLog( audienceReview);	
			reviewDetails.add(audienceReview);
			}
			return reviewDetails;
		}

		
	public void clickOnReviewComments()
	{
	int sizes=TtileCells.size();
		for(int i=1;i<=sizes;i++)
		{
			String titleSummary=driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]//XCUIElementTypeStaticText[1]")).getAttribute("label");
			if(titleSummary.equalsIgnoreCase("Audience Reviews"))
			{
				for(int i1=0;i1<8;i1++)
				{
				Dimension size = this.driver.manage().window().getSize();
				int startx=size.width/2;
				int starty=(int)(size.height*0.9);
				@SuppressWarnings("unused")
				int endx=size.width/2;
				int endy=(int)(size.height*0.2);
				driver.swipe(startx, starty, startx, endy, 1000);			 
				}
				driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell["+i+"]/XCUIElementTypeButton[1]")).click();
			}
			}
			
		}

}














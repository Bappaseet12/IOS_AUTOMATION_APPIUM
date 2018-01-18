package com.appium.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;










import com.appium.model.ExtLogger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
/**
 * 
 * @author sowmya.bg
 *
 */
public class MorePage {
	private ExtLogger log = new ExtLogger(MorePage.class.toString());
	WebDriverWait wait;
	IOSDriver<MobileElement> driver;

	public MorePage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = (IOSDriver<MobileElement>) driver;
		wait = new WebDriverWait(driver, 100);
	}	

	/*Elements in More screen*/
	@iOSFindBy(name="More")
	public WebElement more;
	
	@iOSFindBy(name="Manage Location")
	public WebElement manageLocation;
	
	
	@iOSFindBy(xpath="//XCUIElementTypeLink[@name='Gift Cards']")
	public WebElement giftCards;
	
	@iOSFindBy(name="Terms and Policies")
	public WebElement termsAndPolicies;

	@iOSFindBy(name="Help & FAQ")
	public WebElement helpFAQ;
	
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name='Sign In']")
	public WebElement signIn_Btn;
	
	@iOSFindBy(xpath="//XCUIElementTypeButton[@name='Sign Out']")
	public WebElement signOut_Btn;


	/*Display of Elements*/
	public boolean isMoreScreenDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(more));
		log.stepLog("User navigated to More screen");
		return more.isDisplayed();
	}
	public boolean isGiftCardsDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(giftCards));
		log.stepLog("giftCards displayed");
		return giftCards.isDisplayed();
	}
	public boolean isTermsAndPoliciesDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(termsAndPolicies));
		log.stepLog("Terms And Policies Displayed");
		return termsAndPolicies.isDisplayed();
	}
	public boolean isHelpFAQDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(helpFAQ));
		log.stepLog("Help & FAQ Displayed");
		return helpFAQ.isDisplayed();
	}
	public boolean isSignOutBtnDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(signOut_Btn));
		log.stepLog("Sign out Button Displayed");
		return signOut_Btn.isDisplayed();
	}
	public boolean isSignInBtnDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(signIn_Btn));
		log.stepLog("Sign out Button Displayed");
		return signIn_Btn.isDisplayed();
	}
	
	/*Methods for Elements*/

	public void clickSignIn_Btn() {
		wait.until(ExpectedConditions.visibilityOf(signIn_Btn));		
		signIn_Btn.click();
		log.stepLog("Tapped on SignIn button");
	}
	public void clickSignOut_Btn() {
		wait.until(ExpectedConditions.visibilityOf(signOut_Btn));		
		signOut_Btn.click();
		log.stepLog("Tapped on SignIn button");
	}
	public void manageLocation()
	{
		wait.until(ExpectedConditions.visibilityOf(manageLocation));
		manageLocation.click();
	}
	
}














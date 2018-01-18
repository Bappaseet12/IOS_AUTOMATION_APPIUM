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
import io.appium.java_client.remote.HideKeyboardStrategy;
/**
 * 
 * @author macadmin
 *
 */
public class LoginPage {
	private ExtLogger log = new ExtLogger(LoginPage.class.toString());
	WebDriverWait wait;
	IOSDriver<MobileElement> driver;
	MorePage more;

	public LoginPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = (IOSDriver<MobileElement>) driver;
		wait = new WebDriverWait(driver, 100);
	}	

	/*Elements in Login screen*/
	@iOSFindBy(name="Close")
	public WebElement close;

	@iOSFindBy(name="Forgot Password")
	public WebElement forgotPassword;
	
	@iOSFindBy(xpath="//XCUIElementTypeTextField")
	public WebElement emailFeild;

	@iOSFindBy(xpath="//XCUIElementTypeSecureTextField")
	public WebElement passwordField;
	
	
	@iOSFindBy(name="Sign-up")
	public WebElement signUp_Link;


	/*Display of Elements*/
	public boolean isCloseDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(close));
		log.stepLog("Closed Button displayed");
		return close.isDisplayed();
	}
	public boolean isForgotPasswordDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(forgotPassword));
		log.stepLog("Forgot Password link displayed");
		return forgotPassword.isDisplayed();
	}
	public boolean isSignUp_LinkDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(signUp_Link));
		log.stepLog("Sign up Link Displayed");
		return signUp_Link.isDisplayed();
	}
	
	
	/*Methods for Elements*/

	public void enterEmail(String email) 
	{
		wait.until(ExpectedConditions.visibilityOf(emailFeild));
		emailFeild.sendKeys(email);
	}

	public void enterPassword(String password) 
	{
		wait.until(ExpectedConditions.visibilityOf(passwordField));
		passwordField.sendKeys(password);
	}
	
	/*Business Operations for Log in Page*/
	public void loginToApplication(String email,String password) 
	{
		enterEmail(email);
		//driver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Next");
		enterPassword(password);
		more =new MorePage(driver);
		more.clickSignIn_Btn();
	}
}














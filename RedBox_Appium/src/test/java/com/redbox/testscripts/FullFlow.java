package com.redbox.testscripts;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appium.model.ApplicationLibrary;
import com.appium.model.CommonLibrary;
import com.appium.model.ConfigurationLibrary;
import com.appium.model.DataManager;
import com.appium.model.Reports;
import com.appium.pages.HomePage;
import com.appium.pages.LoginPage;
import com.appium.pages.MorePage;

public class FullFlow{

	IOSDriver<MobileElement> driver;
	MorePage morePage;
	HomePage homePage;
	LoginPage loginPage;
	CommonLibrary comlib;
	ApplicationLibrary applib;
	Reports reports;
	DataManager datamanager;

	String moduleName = "Launch Application";
	String testCaseName = getClass().getSimpleName();

	

	public void init() {
		comlib = new CommonLibrary();
		applib = new ApplicationLibrary();
		reports = new Reports();
		datamanager = new DataManager();
	}

	@BeforeClass
	public void startUp() throws Exception {
		init();
		if(datamanager.executionController(testCaseName).equals("Yes")) {
			reports.scriptStartTime = comlib.getCurrentTime();
			reports.createFile(testCaseName);
			driver = applib.launchIosdApplication(driver);
			//Thread.sleep(2000);
			
		} else {
			System.out.println(testCaseName + " execution is skipped");
			ConfigurationLibrary.skipCount++;
			throw new SkipException(testCaseName + " execution is skipped");
		}
	}

	@BeforeMethod
	public void beforeTest(Method methodName) throws Exception {
		reports.writeTestName(methodName.getName());
	}

	
	@Test
	public void launchApplication() throws Exception {

		try {
			
			homePage = new HomePage(driver);
			

			/*try {
				Assert.assertTrue(homePage.splashLogo());
				reports.writeIntoFile(driver, testCaseName,  "Validate Splash Screen", "Launch the App", "Splash Screen is displayed", reports.pass, "", comlib.getCurrentTime());
			}catch(Error e)
			{
				reports.writeIntoFile(driver, testCaseName,  "Validate Splash Screen", "Launch the App", "Splash Screen is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
				Assert.fail();
			} 
						
			try {
				Assert.assertTrue(homePage.inProgress());
				reports.writeIntoFile(driver, testCaseName,  "Validate In-Progress Spinner", "Verify Splash Screen, In-progress ", "Splash Screen, In progress Spinner is displayed", reports.pass, "", comlib.getCurrentTime());
			}catch(Error e)
			{
				reports.writeIntoFile(driver, testCaseName,  "Validate Splash Screen", "Launch the App", "Splash Screen is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
				System.out.println("Register button validation failed. Reason:" +e.getMessage());
				Assert.fail();
			} */
			homePage.moreTab();
					
			try {
				morePage = new MorePage(driver);
				Assert.assertTrue(morePage.isMoreScreenDisplayed());
				Assert.assertTrue(morePage.isGiftCardsDisplayed());
				Assert.assertTrue(morePage.isHelpFAQDisplayed());
				Assert.assertTrue(morePage.isTermsAndPoliciesDisplayed());
				reports.writeIntoFile(driver, testCaseName,  "Tap on More tab", "Tap on More tab", "User Naviagted to More screen", reports.pass, "", comlib.getCurrentTime());
			}catch(Exception e)
			{
				reports.writeIntoFile(driver, testCaseName,  "Tap on More tab", "Tap on More tab", "More Screen is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
				System.out.println("More Screen Not displayed" +e.getMessage());
				Assert.fail();
			} 
			morePage.clickSignIn_Btn();
			loginPage= new LoginPage(driver);						
			loginPage.loginToApplication("test123@gen.com", "Est@12345");
			
			try {
				Assert.assertTrue(homePage.inProgress());				
				reports.writeIntoFile(driver, testCaseName,  "Tap on Sign In Button", "Username and Password Entered", "Signing is IN-Progress", reports.pass, "", comlib.getCurrentTime());
			}catch(Exception e)
			{
				reports.writeIntoFile(driver, testCaseName,  "Tap on Sign In Button", "Username and Password Entered", "Signing IN-Progress icon is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
				System.out.println("More Screen Not displayed" +e.getMessage());
				Assert.fail();
			} 
		} catch(Exception e) {
			reports.writeIntoFile(driver, testCaseName, "Exception", "Tried performing action using iOS driver", "Exception occured", reports.fail, e.getMessage(), comlib.getCurrentTime());
			Assert.fail("validation failed");
		}
	}

	@AfterMethod
	public void afterTest() throws Exception {
		comlib.afterTestRun();
	}

	@AfterClass
	public void tearDown() throws Exception {
		comlib.afterScript(reports, moduleName, testCaseName);
		driver.quit();
		System.out.println(testCaseName + " execution completed.");

	}
}

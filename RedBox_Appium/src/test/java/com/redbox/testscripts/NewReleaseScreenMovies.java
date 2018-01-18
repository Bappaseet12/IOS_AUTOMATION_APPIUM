package com.redbox.testscripts;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.model.ApplicationLibrary;
import com.appium.model.CommonLibrary;
import com.appium.model.ConfigurationLibrary;
import com.appium.model.DataManager;
import com.appium.model.Reports;
import com.appium.pages.HomePage;
import com.appium.pages.LoginPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class NewReleaseScreenMovies {
	IOSDriver<MobileElement> driver;
	LoginPage loginPage;
	CommonLibrary comlib;
	ApplicationLibrary applib;
	Reports reports;
	DataManager datamanager;
	HomePage homePage;
	String moduleName = "Movies Tab Reels & Browse All Option";
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
			try {
			Assert.assertTrue(homePage.isNewAtBoxReelDisplayed());
			reports.writeIntoFile(driver, testCaseName,  "New At The Box in Movies Tab", "New At The Box Reelin Movies Tab ", "New At The Box Reel in Movies Tab ", reports.pass, "", comlib.getCurrentTime());
			}
			catch(Exception e)
			{
				reports.writeIntoFile(driver, testCaseName,  "New At The Box Reel in Movies Tab ", "New At The Box Reel is not Displayed in Movies Tab ", "New At The Box Reel is not displayed in Movies Tab ", reports.fail, e.getMessage(), comlib.getCurrentTime());
				System.out.println("More Screen Not displayed" +e.getMessage());
				Assert.fail();
			} 
			
			try {
				Assert.assertTrue(homePage.isNewAtTheBoxBrowseAllDisplayed());
				reports.writeIntoFile(driver, testCaseName,  "New At The Box Browse All displayed in Movies Tab ", "New At The Box Browse All displayed in Movies Tab ", "New At The Box Browse All displayed in Movies Tab ", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "New At The Box Browse All is noot displayed in Movies Tab ", "New At The Box Browse All displayed is not Displayed in Movies Tab ", "New At The Box Browse All displayed is not displayed in Movies Tab ", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("More Screen Not displayed" +e.getMessage());
					Assert.fail();
				}
			homePage.scrollToUp();
			Thread.sleep(5000);
			
			try {
				Assert.assertTrue(homePage.isNewOnDemandDisplayed());
				reports.writeIntoFile(driver, testCaseName,  "New On Demand Reel Displayed in Movies Tab ", "New On Demand Reel Displayed in Movies Tab ", "New On Demand Reel Displayed in Movies Tab ", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "New On Demand Reel Displayed in Movies Tab ", "New On Demand Reel Displayed is not Displayed in Movies Tab ", "New On Demand Reel Displayed is not displayed in Movies Tab ", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("More Screen Not displayed" +e.getMessage());
					Assert.fail();
				} 
			
			try {
				Assert.assertTrue(homePage.isNewOnDemandBrowseAllDisplayed());
				reports.writeIntoFile(driver, testCaseName,  "New On Demand Browse All displayed in Movies Tab ", "New On Demand Browse All displayed in Movies Tab ", "New On Demand Browse All displayed in Movies Tab ", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "New On Demand Browse All displayed in Movies Tab ", "New On Demand Browse All displayed is not Displayed in Movies Tab ", "New On Demand Browse All displayed is not displayed in Movies Tab ", reports.fail, e.getMessage(), comlib.getCurrentTime());
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
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

public class NewRleaseMovie {
	IOSDriver<MobileElement> driver;
	LoginPage loginPage;
	CommonLibrary comlib;
	ApplicationLibrary applib;
	Reports reports;
	DataManager datamanager;
	HomePage homePage;
	String moduleName = "Home Screen Reels & Browse All Verification";
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
	public void newReleaseMovie() throws Exception {

		try {
			homePage = new HomePage(driver);
			try {
				Assert.assertTrue(homePage.isNewAtBoxReelDisplayed());
				reports.writeIntoFile(driver, testCaseName,  "New At the Box Reel Displayed", "New At the Box Reel  is Displayed", "New At the Box Reel is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "New At the Box Reel", "New At the Box Reel is Not Displayed", "New At the Box Reel is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("New At the Box Reel Not displayed" +e.getMessage());
					Assert.fail();
				} 
			try {
				Assert.assertTrue(homePage.isNewAtTheBoxBrowseAllDisplayed());
				reports.writeIntoFile(driver, testCaseName,  "New At the box browse All", "New At the box browse All is Displayed", "New At the box browse All is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "New At the box browse All", "New At the box browse All is Not Displayed", "New At the box browse All is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("Movies Tab Not displayed" +e.getMessage());
					Assert.fail();
				} 
			Thread.sleep(5000);
			homePage.scrollToUp();
			
			try {
			Assert.assertTrue(homePage.isNewOnDemandBrowseAllDisplayed());
			reports.writeIntoFile(driver, testCaseName,  "New on DEmand Browse All", "New on DEmand Browse All is Visible", "New on DEmand Browse All is Launched", reports.pass, "", comlib.getCurrentTime());
			}
			catch(Exception e)
			{
				reports.writeIntoFile(driver, testCaseName,  "New on DEmand Browse All", "New on DEmand Browse All is not displayed", "New on DEmand Browse All is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
				System.out.println("More Screen Not displayed" +e.getMessage());
				Assert.fail();
			} 
			
		
			try {
				Assert.assertTrue(homePage.isNewOnDemandDisplayed());
				reports.writeIntoFile(driver, testCaseName,  "New On Demand Displayed", "New On Demand is Displayed", "New On Demand is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "New On Demand", "New On Demand is Not Displayed", "New On Demand is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("Movies Tab Not displayed" +e.getMessage());
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
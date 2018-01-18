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

public class NewReleasesScreenTv {
	IOSDriver<MobileElement> driver;
	LoginPage loginPage;
	CommonLibrary comlib;
	ApplicationLibrary applib;
	Reports reports;
	DataManager datamanager;
	HomePage homePage;
	String moduleName = "TV Tab Reels & Browse All Option";
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
			Thread.sleep(1000);
			homePage.tvTab();
			try {
			Assert.assertTrue(homePage.isNewTvReelsDisplayed());
			reports.writeIntoFile(driver, testCaseName,  "new TV Reels Displayed in TV Tab", "new TV Reels Displayed in TV Tab", "new TV Reels Displayed in TV Tab", reports.pass, "", comlib.getCurrentTime());
			}
			catch(Exception e)
			{
				reports.writeIntoFile(driver, testCaseName,  "new TV Reels Displayed in TV Tab", "new TV Reels Displayed in TV Tab is not Displayed", "new TV Reels Displayed in TV Tab is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
				System.out.println("More Screen Not displayed" +e.getMessage());
				Assert.fail();
			} 
			try {
				Assert.assertTrue(homePage.isNewTvBrowseAllDisplayed());
				reports.writeIntoFile(driver, testCaseName,  "New TV Browse All Displayed in TV Tab", "New TV Browse All Displayed in TV Tab", "New TV Browse All Displayed in TV Tab", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "New TV Browse All Displayed in TV Tab in TV Tab", "New TV Browse All Displayed in TV Tab is not Displayed", "New TV Browse All Displayed in TV Tab is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
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
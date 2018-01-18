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

public class NewReleaseScreenGames {
	IOSDriver<MobileElement> driver;
	LoginPage loginPage;
	CommonLibrary comlib;
	ApplicationLibrary applib;
	Reports reports;
	DataManager datamanager;
	HomePage homePage;
	String moduleName = "Games Tab Reels & Browse All Options";
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
			homePage.gamesTab();
			try {
				Assert.assertTrue(homePage.isNewPS4Reel());
				reports.writeIntoFile(driver, testCaseName,  "New PS4 Reels Displayed in Games Tab", "New PS4 Reel Displayed in Games Tab", "New PS4 Reel Displayed in Games Tab", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "New PS4 Reel Displayed in Games Tab", "New PS4 Reel Displayed in Games Tab is not Displayed", "New PS4 Reel Displayed in Games Tab is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("New PS4 Reels Displayed in Games Tab Not displayed" +e.getMessage());
					Assert.fail();
				} 
				
					
					try {
						Assert.assertTrue(homePage.isNewPS4BrowseAll());
						reports.writeIntoFile(driver, testCaseName,  "New PS4 Browse All in Games Tab", "New PS4 Browse All in Games Tab", "New PS4 Browse All in Games Tab", reports.pass, "", comlib.getCurrentTime());
						}
						catch(Exception e)
						{
							reports.writeIntoFile(driver, testCaseName,  "New PS4 Browse All in Games Tab", "New PS4 Browse All Games Tab is not Displayed", "New PS4 Browse All in Games Tab is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
							System.out.println("New PS4 Browse All in Games Tab is Not Displayed" +e.getMessage());
							Assert.fail();
						} 
					//homePage.slideGamesNewPS4first();
					homePage.scrollToUp();
					Thread.sleep(5000);
					
					try {
						Assert.assertTrue(homePage.isNewPS4XBOXOneReel());
						reports.writeIntoFile(driver, testCaseName,  "New PS4 X BOX Reel in Games Tab", "New PS4 X BOX Reel  in Games Tab", "New PS4 X BOX Reel  in Games Tab", reports.pass, "", comlib.getCurrentTime());
						}
						catch(Exception e)
						{
							reports.writeIntoFile(driver, testCaseName,  "New PS4 X BOX Reel  in Games Tab", "New PS4 X BOX Reel  is not Displayed", "New PS4 X BOX Reel  is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
							System.out.println("New PS4 X BOX Reel in Games Tab Not Displayed" +e.getMessage());
							Assert.fail();
						} 
					
					
					try {
						Assert.assertTrue(homePage.isNewPS4XBOXOneBrowseAll());
						Thread.sleep(5000);
						reports.writeIntoFile(driver, testCaseName,  "New PS4 X BOX One Browse All in Games Tab", "New PS4 X BOX One Browse All in Games Tab", "New PS4 X BOX One Browse All in Games Tab", reports.pass, "", comlib.getCurrentTime());
						}
						catch(Exception e)
						{
							reports.writeIntoFile(driver, testCaseName,  "New PS4 X BOX One Browse All in Games Tab", "New PS4 X BOX One Browse All is not Displayed", "New PS4 X BOX One Browse All is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
							System.out.println("New PS4 X BOX One Browse All in Games Tab is not Displayed" +e.getMessage());
							Assert.fail();
						} 
					homePage.slideGamesNewXBOXONESecond();
					Thread.sleep(5000);
					System.out.println("Waited 4 secs");
					try {
						Assert.assertTrue(homePage.isNewXBOX360Reel());
						reports.writeIntoFile(driver, testCaseName,  "New XBOX 360 Reel in Games Tab", "New XBOX 360 Reel in Games Tab", "New XBOX 360 Reel  in Games Tab", reports.pass, "", comlib.getCurrentTime());
						}
						catch(Exception e)
						{
							reports.writeIntoFile(driver, testCaseName,  "New XBOX 360 Reel  in Games Tab", "New XBOX 360 Reel  is not Displayed", "New XBOX 360 Reel  is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
							System.out.println("New XBOX 360 Reel in Games Tab is Not Displayed" +e.getMessage());
							Assert.fail();
						} 
					
					
					try {
						Assert.assertTrue(homePage.isNewXBOX360BrowseAll());
						reports.writeIntoFile(driver, testCaseName,  "New XBOX 360 Browse All in  Games Tab", "New XBOX 360 Browse All in  in Games Tab", "New XBOX 360 Browse All in  in Games Tab", reports.pass, "", comlib.getCurrentTime());
						}
						catch(Exception e)
						{
							reports.writeIntoFile(driver, testCaseName,  "New XBOX 360 Browse All in Games Tab", "New XBOX 360 Browse All in is not Displayed", "New XBOX 360 Browse All in  is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
							System.out.println("New XBOX 360 Browse All in  Games Tab Not Displayed" +e.getMessage());
							Assert.fail();
						} 
					Thread.sleep(5000);
			
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
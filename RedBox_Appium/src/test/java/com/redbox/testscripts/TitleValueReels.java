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

public class TitleValueReels {
	IOSDriver<MobileElement> driver;
	LoginPage loginPage;
	CommonLibrary comlib;
	ApplicationLibrary applib;
	Reports reports;
	DataManager datamanager;
	HomePage homePage;
	String moduleName = "Title Value of Every Reels";
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
			Thread.sleep(5000);
			
			
			try {
				homePage.getTitleValueofNewAtBox();
				
			reports.writeIntoFile(driver, testCaseName,  "New At The Box Title Value Displayed in Movies Tab", "New At The Box Title Value Displayed in Movies Tab ", "New At The Box Title Value Displayed in Movies Tab", reports.pass, "", comlib.getCurrentTime());
			}
			catch(Exception e)
			{
				reports.writeIntoFile(driver, testCaseName,  "Title Value Not Displayed in Movies Tab New At The Box ", "Title Value Not Displayed in Movies Tab New At The Box ", "Title Value Not Displayed in Movies Tab New At The Box ", reports.fail, e.getMessage(), comlib.getCurrentTime());
				System.out.println("More Screen Not displayed" +e.getMessage());
				Assert.fail();
			} 
			
			try {
				homePage.scrollToUp();
				homePage.getTitleValueofNewOnDemand();
				reports.writeIntoFile(driver, testCaseName,  "Title Value Displayed for New On Demand Reel inside Movies", "Title Value Displayed for New On Demand Reel inside Movies ", "Title Value Displayed for New On Demand Reel inside Movies ", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Title Value Not Displayed in Movies Tab New On Demand", "Title Value Not Displayed in Movies Tab New On Demand ", "Title Value Not Displayed in Movies Tab New On Demand ", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("More Screen Not displayed" +e.getMessage());
					Assert.fail();
				} 
			
			try {
				homePage.tvTab();
			    homePage.getTitleValueofNewTVTVTab();
				reports.writeIntoFile(driver, testCaseName,  "Title Value of Reel New TV Tab ", "Title Value of Reel New TV Tab", "Title Value of Reel New TV Tab", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Title Value of Reel is not DIsplayed for New TV Tab ", "Title Value of Reel is not DIsplayed for New TV Tab", "Title Value of Reel is not DIsplayed for New TV Tab ", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("More Screen Not displayed" +e.getMessage());
					Assert.fail();
				} 
			
			try {
				homePage.gamesTab();
			    homePage.getTitleValueofNewPS4GamesTab();
			  
				reports.writeIntoFile(driver, testCaseName,  "New PS4 Games Tab Displayed inside Games Tab", "New PS4 Games Tab Displayed inside Games Tab", "New PS4 Games Tab Displayed inside Games Tab", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "New PS4 Games Tab is not Displayed inside Games Tab ", "New PS4 Games Tab is not Displayed inside Games Tab ", "New PS4 Games Tab is not Displayed inside Games Tab", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("More Screen Not displayed" +e.getMessage());
					Assert.fail();
				} 
			
			try {
			     homePage.scrollToUp();
				homePage.getTitleValueofNewXBOXOneTab();
			
				reports.writeIntoFile(driver, testCaseName,"New XBOX One inside Game Tab is Displayed", "New XBOX One inside Game Tab is Displayed", "New XBOX One inside Game Tab is Displayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "New XBOX One inside Game Tab is Not Displayed ", "New XBOX One inside Game Tab is Not Displayed ", "New XBOX One inside Game Tab is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("More Screen Not displayed" +e.getMessage());
					Assert.fail();
				} 
			
			try {
				homePage.scrollToUp();
				homePage.getTitleValueofNewXBOX360GamesTab();  
				reports.writeIntoFile(driver, testCaseName,  "New XBOX 360 inside Games Tab is Displayed", "New XBOX 360 inside Games Tab is Displayed", "New XBOX 360 inside Games Tab is Displayed ", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "New XBOX 360 inside Games Tab is not Displayed ", "New XBOX 360 inside Games Tab is not Displayed  ", "New XBOX 360 inside Games Tab is not Displayed  ", reports.fail, e.getMessage(), comlib.getCurrentTime());
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
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

public class HomeScreenValidation {
	IOSDriver<MobileElement> driver;
	LoginPage loginPage;
	CommonLibrary comlib;
	ApplicationLibrary applib;
	Reports reports;
	DataManager datamanager;
	HomePage homePage;
	String moduleName = "HomeScreenUI Verification";
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
			Assert.assertTrue(homePage.newTabDisplay());
			reports.writeIntoFile(driver, testCaseName,  "Home Screen Default Tab Launched", "Default New Tab is Launched", "Default New Tab is Launched", reports.pass, "", comlib.getCurrentTime());
			}
			catch(Exception e)
			{
				reports.writeIntoFile(driver, testCaseName,  "Tap on More tab", "Tap on More tab", "More Screen is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
				System.out.println("More Screen Not displayed" +e.getMessage());
				Assert.fail();
			} 
			try {
				Assert.assertTrue(homePage.searchIconDisplay());
				reports.writeIntoFile(driver, testCaseName,  "Search Icon", "Search Icon is Displayed", "Search Icon is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Search Icon", "Search Icon is Not Displayed", "Search Icon is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("More Screen Not displayed" +e.getMessage());
					Assert.fail();
				} 
			try {
				Assert.assertTrue(homePage.myBagIconDisplay());
				reports.writeIntoFile(driver, testCaseName,  "My Bag Icon", "My Bag Icon is Displayed", "My Bag Icon is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Search Icon", "My Bag Icon is Not Displayed", "My Bag Icon is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("My Bag Icon Not displayed" +e.getMessage());
					Assert.fail();
				} 
			try {
				Assert.assertTrue(homePage.moviesTabDisplay());
				reports.writeIntoFile(driver, testCaseName,  "Movies Tab", "Movies Tab is Displayed", "Movies Tab is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Movies Tab", "Movies Tab is Not Displayed", "Movies Tab is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("Movies Tab Not displayed" +e.getMessage());
					Assert.fail();
				} 
			try {
				Assert.assertTrue(homePage.tvTabDisplay());
				reports.writeIntoFile(driver, testCaseName,  "TV Tab", "TV Tab is Displayed", "TV  Tab is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "TV Tab", "TV Tab is Not Displayed", "TV Tab  is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("TV Tab  Not displayed" +e.getMessage());
					Assert.fail();
				}
			try {
				Assert.assertTrue(homePage.gamesTabDisplay());
				reports.writeIntoFile(driver, testCaseName,  "Games Tab", "Games Tab is Displayed", "Games  Tab is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Games Tab", "GAMES Tab is Not Displayed", "GAMES  Tab  is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("TV Tab  Not displayed" +e.getMessage());
					Assert.fail();
				}
			try {
				Assert.assertTrue(homePage.redboxTitlepresent());
				reports.writeIntoFile(driver, testCaseName,  "Redbox Title", "Redbox Title is Displayed", "Redbox Title is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Redbox Title", "Redbox Title is Not Displayed", "Redbox Title  is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("Redbox Title Not displayed" +e.getMessage());
					Assert.fail();
				}
			
			try {
				Assert.assertTrue(homePage.locationIcon());
				reports.writeIntoFile(driver, testCaseName,  "Location Icon", "Location Icon is Displayed", "Location Icon is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Location Icon", "Location Icon is Not Displayed", "Location Icon is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("Redbox Title Not displayed" +e.getMessage());
					Assert.fail();
				}
			try {
				Assert.assertTrue(homePage.upcomingTabDisplay());
				reports.writeIntoFile(driver, testCaseName,  "Upcoming Tab", "Upcoming Tab is Displayed", "Upcoming Tab is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Upcoming Tab ", "Upcoming Tab is Not Displayed", "Upcoming Tab is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("Upcoming Tab Not displayed" +e.getMessage());
					Assert.fail();
				}
			try {
				Assert.assertTrue(homePage.myRedboxTabDisplay());
				reports.writeIntoFile(driver, testCaseName,  "Redbox Tab", "Redbox Tab is Displayed", "Redbox Tab is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Upcoming Tab ", "Redbox Tab is Not Displayed", "Redbox Tab is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("Upcoming Tab Not displayed" +e.getMessage());
					Assert.fail();
				}
			try {
				Assert.assertTrue(homePage.browseTabDisplay());
				reports.writeIntoFile(driver, testCaseName,  "Browse Tab", "Browse Tab is Displayed", "Browse Tab is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Browse Tab ", "Browse Tab is Not Displayed", "Browse Tab is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("Upcoming Tab Not displayed" +e.getMessage());
					Assert.fail();
				}
			try {
				Assert.assertTrue(homePage.moreTabDisplay());
				reports.writeIntoFile(driver, testCaseName,  "More Tab", "More Tab is Displayed", "More Tab is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "More Tab ", "More Tab is Not Displayed", "More Tab is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					System.out.println("Upcoming Tab Not displayed" +e.getMessage());
					Assert.fail();
				}
			//homePage.getMoviesName();
			
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
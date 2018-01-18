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
import com.appium.pages.MorePage;
import com.appium.pages.SerachPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class MoreTab {
	IOSDriver<MobileElement> driver;
	LoginPage loginPage;
	CommonLibrary comlib;
	ApplicationLibrary applib;
	Reports reports;
	DataManager datamanager;
	HomePage homePage;
	String moduleName = "More Tab Specification";
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
	public void ManagelocationVerify() throws Exception {

		try {
			
			
			MorePage morepage= new MorePage(driver);
			morepage.manageLocation();
		
			try {
				Assert.assertTrue(morepage.isMoreScreenDisplayed());
				reports.writeIntoFile(driver, testCaseName,  "Tap on Manage Location Icon", "Verify of Show Map", "Show Map is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Tap on Manage Location Icon", "Show Map is Not Displayed", "Show Mapis Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					//System.out.println("Movies Tab Not displayed" +e.getMessage());
					Assert.fail();
				} 
			
			/*try {
				Assert.assertTrue(searchPage.isMapHandle());
				reports.writeIntoFile(driver, testCaseName,  "Tap on Manage Location Icon", "Verify of  Tap on Manage Location Icon", "Map slider icon is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Tap on Manage Location Icon", "Map slider iconis Not Displayed", "Map slider iconis Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					//System.out.println("Movies Tab Not displayed" +e.getMessage());
					Assert.fail();
				} 
			
			try {
				Assert.assertTrue(searchPage.isSearchDisplayed());
				reports.writeIntoFile(driver, testCaseName,  "Tap on Manage Location Icon", "Verify of  Tap on Manage Location Icon", "Serach icon is DIsplayed", reports.pass, "", comlib.getCurrentTime());
				}
				catch(Exception e)
				{
					reports.writeIntoFile(driver, testCaseName,  "Tap on Manage Location Icon", "Serach icon is Not Displayed", "Serach icon is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
					//System.out.println("Movies Tab Not displayed" +e.getMessage());
					Assert.fail();
				} */

			
			
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
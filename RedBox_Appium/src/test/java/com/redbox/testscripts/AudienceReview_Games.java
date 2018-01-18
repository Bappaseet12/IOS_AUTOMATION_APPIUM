package com.redbox.testscripts;

import java.lang.reflect.Method;
import java.util.List;

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
import com.appium.pages.AudienceReviewPage;
import com.appium.pages.HomePage;
import com.appium.pages.LoginPage;
import com.appium.pages.SerachPage;
import com.appium.pages.TitleDetailsScreenPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class AudienceReview_Games {
	IOSDriver<MobileElement> driver;
	LoginPage loginPage;
	CommonLibrary comlib;
	ApplicationLibrary applib;
	Reports reports;
	DataManager datamanager;
	HomePage homePage;
	TitleDetailsScreenPage titlePage;
	AudienceReviewPage AudiencePage;
	String moduleName = "Verify Title Screen- Movies";
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
	public void audienceReviewScreen() throws Exception {

		try {
			titlePage= new TitleDetailsScreenPage(driver);
			homePage = new HomePage(driver);
			homePage.gamesTab();
			homePage.clickTitleOne();
			
			try {
				
				Assert.assertTrue(titlePage.isTitleTextDisplayed());
			reports.writeIntoFile(driver, testCaseName,  " Verify Title view screen ", "Tap on First title present in New at Box", "User navigated to Title screen", reports.pass, "", comlib.getCurrentTime());
			}
			catch(Exception e)
			{
				reports.writeIntoFile(driver, testCaseName,  "Tap on First title present in New at Box ", " User didn't navigated to Title screen", " Title view screen is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
				
				Assert.fail();
			} 
			Thread.sleep(6000);
			AudiencePage= new AudienceReviewPage(driver);
			AudiencePage.clickOnReviewComments();
			try {
				
				Assert.assertTrue(AudiencePage.isReviewTitleDisplayed());
				reports.writeIntoFile(driver, testCaseName,  " Audience details for Title ", "Tap on Audience review", AudiencePage.displayOfAudienceReviewDetails().toString(), reports.pass, "", comlib.getCurrentTime());
	
			}
			catch(Exception e)
			{
				reports.writeIntoFile(driver, testCaseName,  "Verify Reviews screen ", " User didn't navigated to Review screen", " Review screen is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
				//System.out.println("More Screen Not displayed" +e.getMessage());
				Assert.fail();
			} 
			try {
				
				Assert.assertTrue(AudiencePage.isBackButtonDisplayed());
				reports.writeIntoFile(driver, testCaseName,  " Verify Reviews screen ", "Tap on Audience review", "Back button Displayed", reports.pass, "", comlib.getCurrentTime());
	
			}
			catch(Exception e)
			{
				reports.writeIntoFile(driver, testCaseName,  "Verify Reviews screen ", " User didn't navigated to Review screen", " Review screen is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
				//System.out.println("More Screen Not displayed" +e.getMessage());
				Assert.fail();
			} 	
			
			try {
				
				Assert.assertTrue(AudiencePage.isItemIconDisplayed());
				reports.writeIntoFile(driver, testCaseName,  " Verify Reviews screen ", "Tap on Audience review", "Item Icon Displayed", reports.pass, "", comlib.getCurrentTime());
	
			}
			catch(Exception e)
			{
				reports.writeIntoFile(driver, testCaseName,  "Verify Reviews screen ", " User navigated to Review screen", " Item Icon is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
				//System.out.println("More Screen Not displayed" +e.getMessage());
				Assert.fail();
			} 
			try {
				
				Assert.assertTrue(homePage.myBagIconDisplay());
				reports.writeIntoFile(driver, testCaseName,  " Verify Reviews screen ", "Tap on Audience review", "My bag  Icon Displayed", reports.pass, "", comlib.getCurrentTime());
				reports.writeIntoFile(driver, testCaseName,  " Verify Reviews screen ", " Audience review comments",AudiencePage.displayOfAudienceReview() , reports.pass, "", comlib.getCurrentTime());
	
			}
			catch(Exception e)
			{
				reports.writeIntoFile(driver, testCaseName,  "Verify Reviews screen ", " User navigated to Review screen", " Mybag Icon is not displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
				//System.out.println("More Screen Not displayed" +e.getMessage());
				Assert.fail();
			} 
			
			
		} catch(Exception e) {
			reports.writeIntoFile(driver, testCaseName, "Exception", "Tried performing action using iOS driver", "Exception occured", reports.fail, e.getMessage(), comlib.getCurrentTime());
			System.out.println(e);
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
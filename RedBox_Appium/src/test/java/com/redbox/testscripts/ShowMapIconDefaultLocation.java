package com.redbox.testscripts;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
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
import com.appium.pages.SerachPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class ShowMapIconDefaultLocation {
IOSDriver<MobileElement> driver;
LoginPage loginPage;
CommonLibrary comlib;
ApplicationLibrary applib;
Reports reports;
DataManager datamanager;
HomePage homePage;
String moduleName = "Select location";
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
homePage = new HomePage(driver);

homePage.manageLocation();
SerachPage searchPage = new SerachPage(driver);
searchPage.sreachIconClick();
searchPage.searchIconSendText("chicago");
Thread.sleep(1000);
searchPage.directscrollMaps();
Thread.sleep(5000);
try {
	Assert.assertTrue(searchPage.locationIconHomePageSelected());
	System.out.println("Location Get Selected is get Passed");
	Thread.sleep(1000);
reports.writeIntoFile(driver, testCaseName,  "Location Selection is Successfull", "Location Select Button is Displayed", "Location Select Button is Displayed", reports.pass, "", comlib.getCurrentTime());
}
catch(Exception e)
{
reports.writeIntoFile(driver, testCaseName,  "Location Selection is Failed", "Location is not Selected", "Location is not Selected", reports.fail, e.getMessage(), comlib.getCurrentTime());
Assert.fail();
}
Thread.sleep(2000);
homePage.manageLocation();
try {
	Assert.assertTrue(searchPage.isShowMapDisplayed());
	System.out.println("Location Get Selected is get Passed");
	Thread.sleep(2000);
reports.writeIntoFile(driver, testCaseName,  "Show Map Button Displayed", "Show Map Button Displayed", "Show Map Button Displayed", reports.pass, "", comlib.getCurrentTime());
}
catch(Exception e)
{
reports.writeIntoFile(driver, testCaseName,  "Show Map Button is Not Displayed", "Show Map Button is Not Displayed", "Show Map Button is Not Displayed", reports.fail, e.getMessage(), comlib.getCurrentTime());
Assert.fail();
}
searchPage.showMapClicked();
searchPage.mapCursorHandle();
Thread.sleep(1000);
try {
	Assert.assertFalse(	searchPage.checkSelectButtonofSelectedLoc());
	Thread.sleep(1000);
reports.writeIntoFile(driver, testCaseName,  "Favorite Location Select Button is not present", "Favorite Location Select Button is not present", "Favorite Location Select Button is not present", reports.pass, "", comlib.getCurrentTime());
}
catch(Exception e)
{
reports.writeIntoFile(driver, testCaseName,  "Favorite Location Select Button is not present", "Favorite Location Select Button is not present", "Favorite Location Select Button is not present", reports.fail, e.getMessage(), comlib.getCurrentTime());
Assert.fail();
}

try {
Assert.assertEquals(searchPage.favoriteLocationAtTop(),0);
	
reports.writeIntoFile(driver, testCaseName,  "Favorite Location is present At Top", "Favorite Location is present At Top", "Favorite Location is present At Top", reports.pass, "", comlib.getCurrentTime());
}
catch(Exception e)
{
reports.writeIntoFile(driver, testCaseName,  "Favorite Location is present At Top", "Favorite Location is present At Top", "Favorite Location is present At Top", reports.fail, e.getMessage(), comlib.getCurrentTime());
Assert.fail();
}

try {
	Assert.assertTrue(searchPage.defaultLocationDisplayedAfterSettingLocation());
	
reports.writeIntoFile(driver, testCaseName,  "Default Location is Set after Setting Location is Passed", "Default Location is Set after Setting Location is Passed", "Default Location is Set after Setting Location is Passed", reports.pass, "", comlib.getCurrentTime());
}
catch(Exception e)
{
reports.writeIntoFile(driver, testCaseName,  "Default Location is Set after Setting Location is Not Passed", "Default Location is Set after Setting Location is Not Passed", "Default Location is Set after Setting Location is Not Passed", reports.fail, e.getMessage(), comlib.getCurrentTime());
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
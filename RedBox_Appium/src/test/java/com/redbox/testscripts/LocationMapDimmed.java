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
import com.appium.pages.LocationsPage;
import com.appium.pages.LoginPage;
import com.appium.pages.SerachPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class LocationMapDimmed {
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
LocationsPage locationspage = new LocationsPage(driver);
SerachPage searchPage = new SerachPage(driver);
searchPage.sreachIconClick();
searchPage.searchIconSendText("chicago");
searchPage.directscrollMaps();
Thread.sleep(8000);

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
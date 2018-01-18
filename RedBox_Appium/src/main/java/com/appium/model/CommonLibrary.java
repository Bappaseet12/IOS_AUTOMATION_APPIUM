package com.appium.model;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

import com.appium.pages.HomePage;
import com.appium.pages.MorePage;

public class CommonLibrary {

	public void initialize(String testCaseName, DataManager datamanager, CommonLibrary comlib, Reports reports)
			throws Exception {

		if (datamanager.executionController(testCaseName).equals("Yes")) {
			reports.scriptStartTime = comlib.getCurrentTime();
			reports.createFile(testCaseName);
		} else {
			System.out.println(testCaseName + " execution is skipped");
			ConfigurationLibrary.skipCount++;
			throw new SkipException(testCaseName + " execution is skipped");
		}

	}

	public void quit(String moduleName, String testCaseName, DataManager datamanager, CommonLibrary comlib,
			Reports reports) throws Exception {

		comlib.afterScript(reports, moduleName, testCaseName);

		System.out.println(testCaseName + " execution completed.");

	}

	IOSDriver<MobileElement> driver;
	MorePage morePage;
	HomePage homePage;
	CommonLibrary comlib;
	ApplicationLibrary applib;
	Reports reports;
	DataManager datamanager;

	String moduleName = "Add New Item to Cart";
	String testCaseName = getClass().getSimpleName();

	//public int randomNumber = ( int )( Math.random() * 9999 );

	public void init() {
		comlib = new CommonLibrary();
		applib = new ApplicationLibrary();
		reports = new Reports();
		datamanager = new DataManager();
	}

	/*
	 * Random numbers
	 */

	public int random() {

		int Maxnumber = 2000000000;
		int Minnumber = 1000000000;
		Random rn = new Random();
		int n = Maxnumber - Minnumber + 1;
		int i = rn.nextInt() % n;
		int randomNum = Minnumber + i;
		return randomNum;
	}
	/*
	 * Random Number for Specified range
	 */

	public int randomSpec(int Maxnumber, int Minnumber) {

		Random rn = new Random();
		int n = Maxnumber - Minnumber + 1;
		int i = rn.nextInt() % n;
		int randomNum = Minnumber + i;
		return randomNum;
	}

	/*
	 * Method will help you to swipe the screen using Screen dimension
	 * 
	 */
	public void swipe(IOSDriver<MobileElement> driver)
	{
		for(int i=0;i<8;i++)
		{
		Dimension size = driver.manage().window().getSize();
		int startx=size.width/2;
		int starty=(int)(size.height*0.9);
		int endx=size.width/2;
		int endy=(int)(size.height*0.2);
		driver.swipe(startx, starty, startx, endy, 1000);		 
		 
		}
	}

	/*
	 * Select an item form Dropdown.
	 * 
	 */
	public void select(WebDriver driver, String ID, String filter) {

		Select dropdown = new Select(driver.findElement(By.id(ID)));
		dropdown.selectByVisibleText(filter);

	}

	// public void SetUp(DataManager datamanager, CommonLibrary comlib, Reports
	// reports, WebDriver driver,
	// String testCaseName) throws Exception {
	//
	// if (datamanager.executionController(testCaseName).equals("Yes")) {
	// reports.scriptStartTime = comlib.getCurrentTime();
	// reports.creatFile(testCaseName);
	// driver = comlib.launchBrowser(driver, ConfigurationLibrary.browser);
	// Thread.sleep(500);
	//
	// } else {
	// System.out.println(testCaseName + " execution is skipped");
	// ConfigurationLibrary.skipCount++;
	// throw new SkipException(testCaseName + " execution is skipped");
	// }
	// }

	/*
	 * Find element on UI
	 */
	public boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/*
	 * Capture screenshots
	 */
	public static void captureScreenshot(WebDriver driver, String ImageName) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(ConfigurationLibrary.imagePath + "//" + ImageName + ".jpg"));
	}

	/*
	 * Test case pass report
	 */
	public void pass(Reports reports, String moduleName, String testCaseName) throws Exception {
 		ConfigurationLibrary.passCount = ConfigurationLibrary.passCount + 1;
		reports.summaryReport(moduleName, testCaseName, getExecutionTime(reports.scriptStartTime, getCurrentTime()),
				reports.pass);
		reports.closeFile();
		//File file = new File(ConfigurationLibrary.videoPath);
	//	File myFile = new File(file, videoName + ".mov");
		//myFile.delete();
	}

	/*
	 * Test case fail report
	 */
	public void fail(Reports reports, String moduleName, String tcName) throws Exception {
		ConfigurationLibrary.failCount = ConfigurationLibrary.failCount + 1;
		reports.summaryReport(moduleName, tcName, getExecutionTime(reports.scriptStartTime, getCurrentTime()),
				reports.fail);
		reports.closeFile();
	}

	/*
	 * System current date and time
	 */
	public String getCurrentTime() {
		Calendar cd = Calendar.getInstance();
		SimpleDateFormat datefor = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss");
		String date = datefor.format(cd.getTime());
		return date;
	}

	/*
	 * System current date and time
	 */
	public String getCurrentDate() {
		DateFormat datefor = new SimpleDateFormat("MM/dd/yyyy");
		Date dates = new Date();
		String date = datefor.format(dates);
		return date;
	}

	/*
	 * Method for after method
	 */
	public void afterTestRun() {
		if (Reports.testStatus) {
			Reports.passedTests++;
		} else {
			Reports.failedTests++;
		}
		Reports.testStatus = true;
	}

	/*
	 * Method for after class.
	 */
	public void afterScript(Reports reports, String moduleName, String testCaseName) throws Exception {
		// stopRecording();
		reports.executionHealthReport(moduleName);
		if (Reports.failedTests > 0) {
			fail(reports, moduleName, testCaseName);
		} else {
			pass(reports, moduleName, testCaseName);
		}
		Reports.failedTests = 0;
		Reports.passedTests = 0;
	}

	/*
	 * WebDriver wait
	 */

	public void ExplicitWait(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}


	public String PatientId() {
		Random num = new Random();
		String patId = "PAT" + num.nextInt(111 * 123);
		return patId;
	}

	/*
	 * To verify if element is disabled
	 */

	public boolean isElementDisabled(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		String text = element.getAttribute("class");
		if (text.contains("disabled"))
			return true;
		else
			return false;
	}

	/*
	 * To verify if element is checked
	 */

	public boolean isElementChecked(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		String text = element.getAttribute("class");
		if (text.contains("checked"))
			return true;
		else
			return false;
	}

	/*
	 * Download csv file
	 */

	public void download(WebDriver driver, String downloadID, String expectedText) throws Exception {

		String filePath = System.getProperty("user.dir") + "/downloadedFiles";

		FileUtils.cleanDirectory(new File(filePath));

		driver.findElement(By.id(downloadID)).click();
		Thread.sleep(1000);

		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		String actualFileName = listOfFiles[0].getName();

		Thread.sleep(1000);

		String expectedFileName = expectedText;

		Assert.assertTrue(actualFileName.contains(expectedFileName), "File mismatch");
	}

	

	/*
	 * Get execution time
	 */
	@SuppressWarnings("deprecation")
	public static String getExecutionTime(String executionStartTime, String executionEndTime) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss");
		SimpleDateFormat timeFor = new SimpleDateFormat("HH:mm:ss");

		Date endTime = sdf.parse(executionEndTime);
		Date startTime = sdf.parse(executionStartTime);
		endTime.setHours(endTime.getHours() - startTime.getHours());
		endTime.setMinutes(endTime.getMinutes() - startTime.getMinutes());
		endTime.setSeconds(endTime.getSeconds() - startTime.getSeconds());

		String date = timeFor.format(endTime);
		return date;
	}

}

package com.appium.model;


import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
/**
 * 
 * @author sowmya.bg
 *
 */

public class ApplicationLibrary {

	public  IOSDriver<MobileElement> launchIosdApplication(IOSDriver<MobileElement> driver) throws Exception {

		/**
		 * DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("newCommandTimeout", 10000);
		capabilities.setCapability("launchTimeout", 90000);
		capabilities.setCapability("deviceName", StartExecution.bookingDeviceID.capabilities.deviceName);
		capabilities.setCapability("browserName", StartExecution.bookingDeviceID.capabilities.deviceName);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appActivity", ConfigurationLibrary.activityName);
		capabilities.setCapability("appPackage", ConfigurationLibrary.packageName);
		capabilities.setCapability("fullReset", true);
		capabilities.setCapability("app-activity", ConfigurationLibrary.activityName);
		capabilities.setCapability("app-package", ConfigurationLibrary.packageName);
		**/

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigurationLibrary.deviceName);
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("udid",ConfigurationLibrary.UD_ID);
		capabilities.setCapability("platformVersion", ConfigurationLibrary.platform_version);
		capabilities.setCapability("bundleId", ConfigurationLibrary.Bundle_Id);
	    capabilities.setCapability("noReset","true");
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);		
		return driver;
	}
}
	
	

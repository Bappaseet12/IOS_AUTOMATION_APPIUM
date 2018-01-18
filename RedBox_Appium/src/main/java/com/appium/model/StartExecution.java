package com.appium.model;

import java.net.URL;

import org.testng.annotations.Test;

import com.fb.preSetupScripts.EntryPointTest;
import com.fb.preSetupScripts.FetchData;
import com.ssts.pcloudy.dto.booking.BookingDtoDevice;

public class StartExecution {

	public static BookingDtoDevice bookingDeviceID;
	public static URL endPoint;

	@Test
	public void startTime() throws Exception { 
		CommonLibrary commonLibrary = new CommonLibrary();
		ConfigurationLibrary.executionStartTime = commonLibrary.getCurrentTime();
		Reports.deleteReportFolder();
		Reports.deleteLatestReportFolder();
		
		/**EntryPointTest entry = new EntryPointTest();
		FetchData sample = entry.test();
		bookingDeviceID = sample.getBookedDevicesID();
		System.out.println(bookingDeviceID);
		endPoint = sample.getEndpoint();
		System.out.println(endPoint);**/
	}
}

package com.FalconTalk.AutoDiscovery;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.FalconTalk.Config.Activity;
import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.Data.Data;
import com.FalconTalk.PageActions.AutoDiscoveryPage;
import com.FalconTalk.PageObject.Common.Common;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AutoDiscovery {
	public static final String AutoDiscoveryFaildNotice = "Please connect to the onboard wifi";
	
	
	
	
	@BeforeTest
	public void Setup() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		Activity.AndroidLaunchApp();
		Common common = new Common();
		common.AgreeAndContinue();
		AppDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=0,description="Verify if all the router list is showing properly or not in app launching in following order\r\n" + 
			"1. Axxess\r\n" + 
			"2. CG-710 (Legacy)\r\n" + 
			"3. CG-710 (FC)\r\n" + 
			"4. CNX-900\r\n" + 
			"5. GDR\r\n" + 
			"6. SDR")
	@Severity(SeverityLevel.BLOCKER)
	public void RouterListTest() {
		AutoDiscoveryPage autodiscovery = new AutoDiscoveryPage();
		ArrayList<String> routerlists = new ArrayList<String>();
		routerlists = autodiscovery.RouterList();
		int i=0;
		while(i<6) {
			String RouterName = routerlists.get(i);
			Assert.assertEquals(RouterName, Data.RouterList.get(i), "Router List is not Ritht Way");
			i++;
		}
		
	}
	
	@Test(priority=1,description="Verify if pressing on Skip button takes the app to configuration page")
	@Severity(SeverityLevel.CRITICAL)
	public void SkipButtonTest() {
		AutoDiscoveryPage autodiscovery = new AutoDiscoveryPage();
		String str = autodiscovery.SkipButton();
		Assert.assertEquals(str, AutoDiscoveryFaildNotice, "It is not App configeration Page");
	}
	
	@AfterTest
	public void tearDown() { 
		Activity.CloseApp(); 
		AppiumServer.Stop();
	}

}

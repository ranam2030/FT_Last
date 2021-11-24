package com.FalconTalk.ExtRingGroup;

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
import com.FalconTalk.PageActions.RingGroupExtensionPage;
import com.FalconTalk.PageObject.Common.Common;

class ExtensionRingGroupAxxess {
	
	@BeforeTest
	public void Setup() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		Activity.AndroidLaunchApp();
		Common common = new Common();
		common.AgreeAndContinue();
		AppDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@Test(priority=0)
	public void RingGroupExtensionAxxessTest() {
		RingGroupExtensionPage ringgroupaxxess = new RingGroupExtensionPage();
		ArrayList<String> RingGroupName = new ArrayList<String>();
		RingGroupName = ringgroupaxxess.RingGroupExtensionAxxess();
		int i=0;
		while(i<3) {
			Assert.assertEquals(RingGroupName.get(i), Data.RingGroupAxxess.get(i), "Ring Group Name is Not Correct");
			i++;
		}
		
	}
	
	@Test(priority=1)
	public void DisplayNameTest() {
		RingGroupExtensionPage ringgroupaxxess = new RingGroupExtensionPage();
		String DisplayName = ringgroupaxxess.DisplayName();
		String DeviceName = Activity.deviceName();
		Assert.assertEquals(DisplayName, DeviceName, "Display Name is Not Correct");
	}
	
	@Test(priority=2)
	public void RingGroupExtensionAxxessSelectTest() {
		RingGroupExtensionPage ringgroupaxxess = new RingGroupExtensionPage();
		ringgroupaxxess.RingGroupExtensionAxxessSelect();
	}
	
	@Test(priority=3)
	public void CancelButtonAxxessTest() {
		RingGroupExtensionPage ringgroupaxxess = new RingGroupExtensionPage();
		String AutoDiscoveryFailedNotice = ringgroupaxxess.CancelButtonAxxess();
		Assert.assertEquals(AutoDiscoveryFailedNotice, Data.AutoDiscoveryFailedNotice, "Configuration page is not showing");
	}
	
	@Test(priority=4)
	public void ApplyButtonAxxessTest() {
		RingGroupExtensionPage ringgroupaxxess = new RingGroupExtensionPage();
		String AccountName = ringgroupaxxess.ApplyButtonAxxess();
		Assert.assertEquals(AccountName, Data.PROFILE_NAME_AXXESS, "Account Name is Not Correct");
	}
	
	@Test(priority=5)
	public void AccountStatusTest() {
		RingGroupExtensionPage ringgroupaxxess = new RingGroupExtensionPage();
		String AccountStatus = ringgroupaxxess.AccountStatus();
		Assert.assertEquals(AccountStatus, Data.PROFILE_STATUS_ONLINE, "Account Status is Not Correct");
	}
	
	@Test(priority=6)
	public void ProfilePageAccountNameTest() {
		RingGroupExtensionPage ringgroupaxxess = new RingGroupExtensionPage();
		String ProfilePageAccountName = ringgroupaxxess.ProfilePageAccountName();
		Assert.assertEquals(ProfilePageAccountName, Data.PROFILE_NAME_AXXESS, "Account name is Not Correct");
	}
	
	
	@AfterTest
	public void tearDown() { 
		Activity.CloseApp(); 
		AppiumServer.Stop();
	}

}

package com.FalconTalk.CabinModeConfiguration;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.KeypadPage;

class VerifyCabinDevice {
	public static final String PROFILE_NAME_AXXESS= "Not Ready";
	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		Thread.sleep(5000);
	}
	
	@Test(priority = 1)
	public void CabinAccountNameInKeypadTest() {
		KeypadPage keypadpage = new KeypadPage();
		String str = keypadpage.ProfileName();
		System.out.println(str);
		Assert.assertEquals(str, PROFILE_NAME_AXXESS, "Wrong profile name show");
	}
	
	@Test(priority = 2)
	public void CabinAccountStatusShowingOnKeypadTest() {
		KeypadPage keypadpage = new KeypadPage();
		System.out.println(keypadpage.AccountStatus());
	}
	
	@AfterTest
	public void tearDown() { 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}

}

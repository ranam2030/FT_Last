package com.FalconTalk.Keypad;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.KeypadPage;



public class Keypad{
	
	
	public static final String PROFILE_NAME_AXXESS= "Axxess";
	public static final String PROFILE_STATUS_ONLINE = "ONLINE";
	public static final String PROFILE_STATUS_OFFLINE = "OFFLINE";

	@BeforeTest()
	public void Setup() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		Thread.sleep(2000);
	}
	
	@Test
	public void ProfileNameTest() {
		KeypadPage keypadpage = new KeypadPage();
		String str = keypadpage.ProfileName();
		System.out.println(str);
		Assert.assertEquals(str, PROFILE_NAME_AXXESS, "Wrong profile name show");
	}
	
	@Test
	public void AccountStatusTest() {
		KeypadPage keypadpage = new KeypadPage();
		String status = keypadpage.AccountStatus();
		Assert.assertEquals(status, PROFILE_STATUS_ONLINE, "Status Should be show online");
	}
	
	@Test
	public void ProfileNameNaveTest() {
		KeypadPage keypadpage = new KeypadPage();
		String NaveName = keypadpage.ProfileNameNave();
		Assert.assertEquals(NaveName, PROFILE_NAME_AXXESS, "Wrong profile name show on NavBar");
	}
	
	@Test
	public void AccountStatusNaveTest() {
		KeypadPage keypadpage = new KeypadPage();
		String statusNave = keypadpage.AccountStatusNave();
		Assert.assertEquals(statusNave, PROFILE_STATUS_ONLINE, "Status on Nave Should be show online");
	}
 
	  
	  @AfterTest 
	  public void tearDown() { 
		//Activity.CloseApp(); 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}
	 
}

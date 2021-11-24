package com.FalconTalk.HoneywellAccount;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.FalconTalk.Config.Activity;
import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.Data.HonweywellAccountData;
import com.FalconTalk.PageActions.AutoDiscoveryPage;
import com.FalconTalk.PageActions.HoneywellAccountPage;
import com.FalconTalk.PageObject.Common.Common;

class HoneywellAccount {
	
	@BeforeTest
	public void Setup() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		Activity.AndroidLaunchApp();
		Common common = new Common();
		AutoDiscoveryPage autodiscovery = new AutoDiscoveryPage();
		common.AgreeAndContinue();
		autodiscovery.ClickSkipButton();
		AppDriver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void HoneywellAccountNumberButtonTest() {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		honweywellAccountPage.HoneywellLogin();
		Assert.assertEquals(honweywellAccountPage.LoginPage(), HonweywellAccountData.loginPage, "Not Going to login page");
	}
	
	@Test(priority=2)
	public void CancelButtonLoginPageTest() {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		honweywellAccountPage.CancelButtonPress();
		Assert.assertEquals(honweywellAccountPage.ConfigurationPage(), HonweywellAccountData.ConfigurationPage, "Not Going to Configuration Page");
		honweywellAccountPage.HoneywellLogin();
	}
	
	@Test(priority=3)
	public void EmptyFieldValidationTest() {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		honweywellAccountPage.LoginButtonPress();
		Assert.assertEquals(honweywellAccountPage.SignInFaildMessage(), HonweywellAccountData.SignInFailedBothEmptyMassage, "Sign In Faild Massage not showing properly");
		honweywellAccountPage.dialogMessageOkButtonPress();
		
		honweywellAccountPage.InputUserName(HonweywellAccountData.UsernameInput);
		honweywellAccountPage.LoginButtonPress();
		Assert.assertEquals(honweywellAccountPage.SignInFaildMessage(), HonweywellAccountData.SignInFailedPasswordEmptyMassage, "Sign In Faild Massage not showing properly");
		honweywellAccountPage.dialogMessageOkButtonPress();
		
		honweywellAccountPage.ClearUserName();
		honweywellAccountPage.InputPassword(HonweywellAccountData.PasswordInput);
		honweywellAccountPage.LoginButtonPress();
		Assert.assertEquals(honweywellAccountPage.SignInFaildMessage(), HonweywellAccountData.SignInFailedUserNameEmptyMassage, "Sign In Faild Massage not showing properly");
		honweywellAccountPage.dialogMessageOkButtonPress();
		
	}
	
	@Test(priority=4)
	public void VerifyTheAuthenticationTest() throws InterruptedException {
		HoneywellAccountPage honweywellAccountPage = new HoneywellAccountPage();
		honweywellAccountPage.ClearUserName();
		honweywellAccountPage.InputUserName(HonweywellAccountData.UsernameInput);
		honweywellAccountPage.ClearPassword();
		honweywellAccountPage.InputPassword(HonweywellAccountData.PasswordInput);
		honweywellAccountPage.LoginButtonPress();
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void tearDown() { 
		Activity.CloseApp(); 
		AppiumServer.Stop();
	}


}

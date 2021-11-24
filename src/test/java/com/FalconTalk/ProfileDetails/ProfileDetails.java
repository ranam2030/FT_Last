package com.FalconTalk.ProfileDetails;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.FalconTalk.PageActions.*;
import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;

class ProfileDetails {
	
	
	@BeforeTest
	public void Setup() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		ProfileDetailsPage profiledetailsPage = new ProfileDetailsPage();
		profiledetailsPage.setup();
		Thread.sleep(2000);
	}
	
	@Test(priority=0)
	public void ProfileNamefieldTest() {
		ProfileDetailsPage profiledetailsPage = new ProfileDetailsPage();
		Assert.assertEquals(profiledetailsPage.ProfileNamefield(), false);
	}
	
	@Test(priority=1)
	public void DomainfieldTest() {
		ProfileDetailsPage profiledetailsPage = new ProfileDetailsPage();
		Assert.assertEquals(profiledetailsPage.Domainfield(), true);
	}
	
	@Test(priority=2)
	public void ExtensionfieldTest() {
		ProfileDetailsPage profiledetailsPage = new ProfileDetailsPage();
		Assert.assertEquals(profiledetailsPage.Extensionfield(), true);

	}
	
	@Test(priority=3)
	public void ApplyButtonTest() throws InterruptedException {
		ProfileDetailsPage profiledetailsPage = new ProfileDetailsPage();
		String status = profiledetailsPage.ApplyButton();
		Assert.assertEquals(status, "Registered", "Account is not Registered");
	
	}
	
	@AfterTest
	public void tearDown() { 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}

}

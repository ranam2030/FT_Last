package com.FalconTalk.ManualAccountConfiguration;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.Data.ProfileDetailsData;
import com.FalconTalk.PageActions.ProfilePage;
public class ManufacturerProfile {
	
	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		Thread.sleep(2000);
		ProfilePage addprofilepage = new ProfilePage();
		addprofilepage.setup();
		Thread.sleep(2000);
	}
	
	@Test(priority=0)
	public void manufacturerselectionTest() {
		ProfilePage addprofilepage = new ProfilePage();
		ArrayList<String> manufacturernamelist = new ArrayList<String>();
		manufacturernamelist = addprofilepage.manufacturerselection();
		int i = 0;
		while(i<3) {
			Assert.assertEquals(manufacturernamelist.get(i),ProfileDetailsData.ManufacturerList.get(i) , "Ring Manufacturer Name is Not Correct");
			i++;
		}
	}
	
	@Test(priority=1)
	public void manufacturerSelectionandgogoApplyButtonTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.manufacturerSelectionandgogoApplyButton(),ProfileDetailsData.CabinPage , "Can't get cabin account page");
	}
	
	@Test(priority=2)
	public void manufacturerSelectionandhoneywellApplyButtonTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.manufacturerSelectionandhoneywellApplyButton(),ProfileDetailsData.CabinPage , "Can't get cabin account page");
	}
	
	@Test(priority=3)
	public void manufacturerSelectionsatcomDirectApplyButtonTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.manufacturerSelectionsatcomDirectApplyButton(),ProfileDetailsData.CabinPage , "Can't get cabin account page");
	}
	
	@Test(priority=4)
	public void manufacturerSelectioncustomApplyButtonTest() {
		ProfilePage addprofilepage = new ProfilePage();
		Assert.assertEquals(addprofilepage.manufacturerSelectioncustomApplyButton(),"Custom" , "Can't get cabin account page");
	}
	
	@AfterTest
	public void tearDown() { 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}

}

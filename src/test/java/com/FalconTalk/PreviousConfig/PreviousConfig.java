package com.FalconTalk.PreviousConfig;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.Data.Data;
import com.FalconTalk.PageActions.PreviousConfigPage;

class PreviousConfig {
	
	
	@BeforeTest()
	public void Setup() throws MalformedURLException, InterruptedException {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		AppiumServer.Start();
		preconfpage.PreviousPage();
		Thread.sleep(2000);
	}
	
	@Test(priority=0)
	public void LastExtensionPageTest() {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		boolean res = preconfpage.LastExtensionPage();
		Assert.assertEquals(res, true);
	}
	
	@Test(priority=1)
	public void LastExtensionTest() {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		String preext = preconfpage.LastExtension();
		Assert.assertEquals(preext, Data.PreExtension, "Extension don't match with Previous extension");
	}
	
	@Test(priority=2)
	public void LastRingGroupTest() {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		String preringgroup = preconfpage.LastRingGroup();
		Assert.assertEquals(preringgroup, Data.PreRingGroup , "RingGroup don't match with Previous Ring Group");
	}
	
	@Test(priority=3)
	public void LastDisplayNameTest() {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		String predisplayname = preconfpage.LastDisplayName();
		Assert.assertEquals(predisplayname, Data.PreDisplayName, "Display Name don't match with Previous Display Name");
	}
	
	@Test(priority=4)
	public void OkButtonTest() {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		Assert.assertEquals(preconfpage.OkButton(), Data.NavDrawerAccInfo, "Account Information dosen't match");
	}
	
	@Test(priority=5)
	public void ChangeButtonTest() {
		PreviousConfigPage preconfpage = new PreviousConfigPage();
		Assert.assertEquals(preconfpage.ChangeButton(), Data.NavDrawerAccInfo1, "Test Case is Failed");
	}

}

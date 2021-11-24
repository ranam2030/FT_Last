package com.FalconTalk.HistoryFunctionality;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.PageActions.HistoryFunctionalityPage;
import com.FalconTalk.Utils.SystemUtils;

class HistoryFunctionality {
	
	
	@BeforeTest()
	public void Setup() throws MalformedURLException, InterruptedException {
		AppiumServer.Start();
		ActiavityMain.AndroidLaunchApp();
		Thread.sleep(6000);
		//messagepage.Setup();
	}
	
	@Test(priority=0)
	public void HistoryFunctionTest() {
		HistoryFunctionalityPage Historypage = new HistoryFunctionalityPage();
		Historypage.HistoryFunction();
	}
	
	@Test(priority=1,description="Make outbound call and verify outbound call entry is showing in history \"All\" list")
	public void OutboundCallListInHistoryTest() throws InterruptedException {
		HistoryFunctionalityPage Historypage = new HistoryFunctionalityPage();
		Historypage.CallFromKeypad("214");
		Historypage.EndCall();
		Historypage.getHistoryTab();
		Thread.sleep(2000);
		System.out.println(Historypage.getCallerName());
	}
	
	@Test(priority=2,description="Verify if actual call entry date is showing properly in history list")
	public void CallEntryDateTest() {
		HistoryFunctionalityPage Historypage = new HistoryFunctionalityPage();
		
		Assert.assertEquals(Historypage.getCallDate(),"Today" , "Call Entry date is not showing properly");
	}
	
	@Test(priority=3,description="Verify if history details page is showing for outbound call entry")
	public void HistoryDetailsPageOutboundCallTest() {
		HistoryFunctionalityPage Historypage = new HistoryFunctionalityPage();
		Historypage.getHistoryDetailsPage();
		Assert.assertEquals(Historypage.getCallStatus(),"Outgoing Call" , "Outbound Call Entry is not showing on history details page");
	}
	
	@Test(priority=4,description="Verify if actual call time and date is showing properly in details page")
	public void HistoryDetailsPageDateTest() {
		HistoryFunctionalityPage Historypage = new HistoryFunctionalityPage();
		SystemUtils utils = new SystemUtils();
		System.out.println(Historypage.getCallDates());
		System.out.println(utils.getCurrentDate());
	}
	
	@Test(priority=5,description="Delete entry from \"All\" list")
	public void DeleteHistoryFromAllListTest() throws InterruptedException {
		HistoryFunctionalityPage Historypage = new HistoryFunctionalityPage();
		Historypage.getBack();
		Thread.sleep(2000);
		Historypage.DeleteHistory();
	}
	
	
	
	
	@AfterTest
	public void tearDown() { 
		ActiavityMain.CloseApp();
		AppiumServer.Stop();
	}

}

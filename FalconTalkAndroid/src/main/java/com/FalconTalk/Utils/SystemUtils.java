package com.FalconTalk.Utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.Common.Common;
public class SystemUtils {
	Common CommonObj = new Common();
	public void hideKeyboard() {
		((SystemUtils) AppDriver.getDriver()).hideKeyboard();
		//AppDriver.getDriver().navigate().back();
		
	}
	public void navigateBack() {
		AppDriver.getDriver().navigate().back();
	}
	
	public void SaveContactsSamsungS10Plus(String Name,String Number) {
		CommonObj.EnterContactName.sendKeys(Name);
		//navigateBack();
		CommonObj.PressPhone.click();
		//navigateBack();
		CommonObj.EnterContactPhoneNumber.sendKeys(Number);
		CommonObj.SaveContact.click();
		CommonObj.NavigateBack.click();
		System.out.println("Contact Save SuccessFully");
	}
	public String getCurrentDate() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		//System.out.println(date.format(formatter));
	    return date.format(formatter);
	}
}

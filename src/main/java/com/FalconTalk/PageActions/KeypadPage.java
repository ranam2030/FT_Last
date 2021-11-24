package com.FalconTalk.PageActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.KeypadObj;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class KeypadPage {
	KeypadObj keypad = new KeypadObj();
	public KeypadPage() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	
	public static final String PROFILE_NAME_AXXESS= "Axxess";
	public static final String PROFILE_STATUS_ONLINE = "ONLINE";
	public static final String PROFILE_STATUS_OFFLINE = "OFFLINE";
	
	By byKeypad = By.xpath("//android.widget.TextView[@text='KEYPAD']");
	By byNavigationDrawer = By.xpath("//android.widget.ImageButton[@content-desc='The navigation drawer is opened']");
	By byAccountNameNavDrawer = By.id("com.dassault.HONfalcontalk:id/navigation_drawer_account_information_display_name");
	
	
	public String ProfileName() {
		String ProfileName;
		String ProfileNameXpath = "//android.widget.TextView[@text='Axxess']";
		System.out.println("Keypad Page Start");
		AppDriver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		new WebDriverWait(AppDriver.getDriver(),120).until(ExpectedConditions.presenceOfElementLocated(byKeypad));
		keypad.Keypad.click();
		boolean ObjectStatus = ObjectFoundorNot(ProfileNameXpath);
		System.out.println(ObjectStatus);
		if(ObjectStatus == true) {
			ProfileName = keypad.SelectAccountNameAxxess.getText();
		}
		else {
			ProfileName = keypad.SelectAccountNameNotReady.getText();
		}
		System.out.println(ProfileName);
		return ProfileName;
	}
	public boolean ObjectFoundorNot(String xpath) {
		try {
	        AppDriver.getDriver().findElement(By.id(xpath));
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
		
	}
	public String AccountStatus() { //Return Account Status from Keypad module
		String Online = "//android.widget.TextView[@text='ONLINE']";
		String ProfileStatus;
		boolean ObjectStatus = ObjectFoundorNot(Online);
		if(ObjectStatus == true) {
			ProfileStatus = keypad.SelectAccountStatusOnline.getText();
		}
		else {
			ProfileStatus = keypad.SelectAccountStatusOffline.getText();
		}
		return ProfileStatus;
	}
	
	public String ProfileNameNave() {
		AppDriver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		new WebDriverWait(AppDriver.getDriver(),50).until(ExpectedConditions.presenceOfElementLocated(byNavigationDrawer));
		keypad.NavigationDrawer.click();
		new WebDriverWait(AppDriver.getDriver(),80).until(ExpectedConditions.presenceOfElementLocated(byAccountNameNavDrawer));
		String AccountName = keypad.AccountNameNavDrawer.getText();
		System.out.println(AccountName);
		return AccountName;
	}
	
	public String AccountStatusNave() { //Return Account Status from navigation drawer
		String statusNav = keypad.SelectAccountStatus.getText();
		//keypad.UserProfiles.click();
		System.out.println(statusNav);
		return statusNav;
	}
	
	public String getAccountNameCustom() { //Return Account Name from keypadModule
		System.out.println(keypad.SelectAccountNameCustom.getText());
		return keypad.SelectAccountNameCustom.getText();
	}
	
	public void getNavigationDrawerOpen() { //Open Navigation Drawer
		keypad.NavigationDrawer.click();
	}
	
	public String getAccountNameNav() { //return Account Name from nav drawer
		return keypad.AccountNameNavDrawer.getText();
	}
	
	public void getUserProfile() { // Click on user profile
		keypad.UserProfiles.click();
	}

}

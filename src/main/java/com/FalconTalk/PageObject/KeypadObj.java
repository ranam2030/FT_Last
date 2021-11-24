package com.FalconTalk.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class KeypadObj {
	public KeypadObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='KEYPAD']")
	public WebElement Keypad;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Axxess']")
	public WebElement SelectAccountNameAxxess;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Not Ready']")
	public WebElement SelectAccountNameNotReady;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Custom']")
	public WebElement SelectAccountNameCustom;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ONLINE']")
	public WebElement SelectAccountStatus;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ONLINE']")
	public WebElement SelectAccountStatusOnline;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OFFLINE']")
	public WebElement SelectAccountStatusOffline;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/user_profiles")
	public WebElement UserProfiles;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/navigation_drawer_account_information_display_name")
	public WebElement AccountNameNavDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/navigation_drawer_account_information_display_extension")
	public WebElement ExtensionNavDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/profile_selection")
	public WebElement ProfileSelection;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	
}


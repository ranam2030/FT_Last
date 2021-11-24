package com.FalconTalk.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.FalconTalk.Config.AppDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HoneywellAccountObj {
	
	public HoneywellAccountObj() {
		PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
	}
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='The navigation drawer is opened']")
	public WebElement NavigationDrawer;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/nav_drawer_signin")
	public WebElement signin;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/falcontalk_login_instruction")
	public WebElement loginpage;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/input_username")
	public WebElement usernameInput;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/input_password")
	public WebElement passwordInput;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_login")
	public WebElement loginButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_cancel")
	public WebElement cancelButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/forget_password")
	public WebElement forgotPassword;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/dialog_message")
	public WebElement dialogMessage;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/btn_ok")
	public WebElement dialogMessageOkButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/button_honeywell_login")
	public WebElement honeywellLoginButton;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/falcontalk_login_instruction")
	public WebElement honeywellLoginInstraction;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/label_username")
	public WebElement labelUserName;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/label_password")
	public WebElement labelPassword;
	
	@AndroidFindBy(id = "com.dassault.HONfalcontalk:id/auto_discovery_failed_notice")
	public WebElement ConfigurationPage;
	
	

}

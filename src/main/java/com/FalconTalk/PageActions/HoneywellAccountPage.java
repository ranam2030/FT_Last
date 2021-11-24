package com.FalconTalk.PageActions;

import org.openqa.selenium.By;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.PageObject.HoneywellAccountObj;

public class HoneywellAccountPage {
	
	HoneywellAccountObj honeywellaccountobj = new HoneywellAccountObj();
	
	public void HoneywellLogin() {
		honeywellaccountobj.honeywellLoginButton.click();
	}
	public void CancelButtonPress() {
		honeywellaccountobj.cancelButton.click();
	}
	
	public void ClearUserName() {
		honeywellaccountobj.usernameInput.clear();
	}
	
	public void InputUserName(String username) {
		honeywellaccountobj.usernameInput.sendKeys(username);
	}
	
	public void ClearPassword() {
		honeywellaccountobj.passwordInput.clear();
	}
	
	public void InputPassword(String password) {
		honeywellaccountobj.passwordInput.sendKeys(password);
	}
	
	public void LoginButtonPress() {
		honeywellaccountobj.loginButton.click();
	}
	
	public String LoginPage() {
		return honeywellaccountobj.labelUserName.getText();
	}
	
	public String ConfigurationPage() {
		return honeywellaccountobj.ConfigurationPage.getText();
	}
	
	public String SignInFaildMessage() {
		return honeywellaccountobj.dialogMessage.getText();
	}
	
	public void dialogMessageOkButtonPress() {
		honeywellaccountobj.dialogMessageOkButton.click();
	}
	
	public boolean UserNameIsEmptyOrNot() {
		String str= "com.dassault.HONfalcontalk:id/input_username";
		AppDriver.getDriver().findElement(By.id(str));
		String text = honeywellaccountobj.usernameInput.getAttribute("contentSize");
		System.out.println(text);
		return text.isEmpty();
	}
	
}

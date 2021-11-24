package com.FalconTalk.PageActions;

import com.FalconTalk.Config.AppDriver;
import com.FalconTalk.Config.Scrolling;
import com.FalconTalk.PageObject.ContactsFunctionalityObj;
import com.FalconTalk.Utils.Utils;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsFunctionalityPage {
    ContactsFunctionalityObj ContactObj = new ContactsFunctionalityObj();
    public ContactsFunctionalityPage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }
    public void CloseSearchOption(){
        ContactObj.SearchClose.click();
        ContactObj.SearchClose.click();
    }

    public void getBack(){
        ContactObj.NavigationBack.click();
    }
    public void getContactPage(){
        ContactObj.Contacts.click();
    }
    public void scrollContactPage(){
        By df = By.id("dfsa");
        String dsf = "fdsf";
        Utils ut = new Utils();
        ut.scrollDown();
        //ut.scrollNClick(df,dsf);
    }
    public void ContactSearch(String Keyword){
        ContactObj.SearchBtn.click();
        ContactObj.SearchKeyword.sendKeys(Keyword);
    }
    public void CancelSearch(){
        ContactObj.SearchClose.click();
    }
    public void getContactSearchDetails(){
        ContactObj.ContactSearchList.click();
    }
    public void GetCallFromContactDetailspage(){
        try{
            ContactObj.CallFromContactDetails.click();
            Thread.sleep(10000);

        }catch (Exception e){

        }
    }
    public void getHistorypage(){
        ContactObj.History.click();
    }
    public String getFirstCallNameFromHistory(){
        return ContactObj.AllCallListOnHistoryPage.get(0).getText();
    }
    public void getFirstCallDetailsFromHistory(){
        ContactObj.AllCallListOnHistoryPage.get(0).click();

    }
    public String getContactSearchname(){
        return ContactObj.ContactSearchList.getText();
    }
    public int getContactSize(){
        return ContactObj.ContactName.size();
    }
    public void getContactDetails(int index){
        ContactObj.ContactName.get(index).click();
    }
    public void getNewContact(){
        ContactObj.CreateNewCOntact.click();
    }

    public void CreateNewContact(String deviceName,String NamePrefix, String FirstName, String MiddleName, String LastName, String NameSuffix, String Phone, String Email){
        if(deviceName.equals("SM-T510")){//Samsung Galaxy Tab A = SM - T510
            ContactObj.ArrowButton.click();
            if(NamePrefix !=null){
                ContactObj.NamePrefix.sendKeys(NamePrefix);
            }
            if(FirstName != null){
                ContactObj.FirstName.sendKeys(FirstName);
            }
            if(MiddleName != null){
                ContactObj.MiddleName.sendKeys(MiddleName);
            }
            if(LastName != null){
                ContactObj.LastName.sendKeys(LastName);
            }
            if(NameSuffix != null){
                ContactObj.NameSuffix.sendKeys(NameSuffix);
            }
            if (Phone != null){
                ContactObj.PhoneNumberClick.click();
                ContactObj.PhoneNumberInput.sendKeys(Phone);
            }
            if (Email != null){
                ContactObj.EmailClink.click();
                ContactObj.EmailInput.sendKeys(Email);
            }
            ContactObj.SaveButton.click();
        }

    }














}

package com.FalconTalk.ContactsFunctionality;
import com.FalconTalk.Config.ActiavityMain;
import com.FalconTalk.Config.AppiumServer;
import com.FalconTalk.Data.ContactsData;
import com.FalconTalk.PageActions.ContactsFunctionalityPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class ContactsFunctionality {
    //public static String device = ActiavityMain.deviceName();
    @BeforeTest
    public void setup() throws MalformedURLException, InterruptedException {
        AppiumServer.Start();
        ActiavityMain.AndroidLaunchApp();
        Thread.sleep(5000);
    }

    @Test(priority = 1,description = "Access any contacts details page and verify if it is showing properly with all info or not")
    public void ContactTestTest() throws InterruptedException {
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getContactPage();

        //Utils.scrollDown();
        //ContactFunction.scrollContactPage();
        //int num = ContactFunction.getContactSize();
        //ContactFunction.getContactDetails(num-1);
        //Thread.sleep(60000);
        //System.out.println(num);
    }

    @Test(priority = 2,description = "Create New Contact from Contacts module")
    public void AddContactTest() throws NullPointerException,IndexOutOfBoundsException,InterruptedException{
        int i;
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getContactPage();
        ContactFunction.getNewContact();
        String device = ActiavityMain.deviceName();
        System.out.println(device);
        Thread.sleep(3000);
        for (i=0;i<1;i++) {
            ContactFunction.CreateNewContact(device,ContactsData.Prefix.get(0), ContactsData.FirstName.get(0), ContactsData.MiddleName.get(0), ContactsData.LastName.get(0), ContactsData.Suffix.get(0), ContactsData.Phone.get(0), ContactsData.Email.get(0));
        }
        Thread.sleep(3000);
        ContactFunction.getBack();
    }

    @Test(priority = 3,description = "Create New Contact from Contacts module and verify that contact is showing in contacts list")
    public void ContactShowingOnContactsListTest(){
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.ContactSearch(ContactsData.Prefix.get(0));

        System.out.println(  ContactFunction.getContactSearchname());
        ContactFunction.CloseSearchOption();
    }

    @Test(priority = 4,description = "Create New Contact from Contacts module and verify that contact is synced in history list")
    public void ContactSyncwithHistoryTest(){
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getContactPage();
        ContactFunction.ContactSearch(ContactsData.Prefix.get(0));
        ContactFunction.getContactSearchDetails();
        ContactFunction.GetCallFromContactDetailspage();
        ContactFunction.getBack();
        ContactFunction.CloseSearchOption();
        ContactFunction.getHistorypage();
        ContactFunction.getFirstCallNameFromHistory();
        System.out.println(ContactFunction.getFirstCallNameFromHistory());
        String Str = ContactsData.Prefix.get(0)+" "+ ContactsData.FirstName.get(0)+" "+ ContactsData.MiddleName.get(0)+" "+ ContactsData.LastName.get(0)+","+" "+ ContactsData.Suffix.get(0);
        Assert.assertEquals(ContactFunction.getFirstCallNameFromHistory(),Str,"New Contact Cann't Synced in History list");
    }

    @Test(priority = 5,description = "Create New Contact from Contacts module and verify that contact is synced in history details")
    public void ContactSyncWithHistoryDetailsTest(){
        ContactsFunctionalityPage ContactFunction = new ContactsFunctionalityPage();
        ContactFunction.getFirstCallDetailsFromHistory();
        ContactFunction.getFirstCallNameFromHistory();
        String Str = ContactsData.Prefix.get(0)+" "+ ContactsData.FirstName.get(0)+" "+ ContactsData.MiddleName.get(0)+" "+ ContactsData.LastName.get(0)+","+" "+ ContactsData.Suffix.get(0);
        Assert.assertEquals(ContactFunction.getFirstCallNameFromHistory(),Str,"New Contact Cann't Synced in History list");
    }

    @AfterTest
    public void tearDown() {
        ActiavityMain.CloseApp();
        AppiumServer.Stop();
    }
}

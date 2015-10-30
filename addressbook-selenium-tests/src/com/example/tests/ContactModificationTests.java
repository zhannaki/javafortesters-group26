package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contactData){
		app.navigateTo().mainPage();
		app.navigateTo().gotoHomePage();
		
		//read contacts list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
		
	    int index = 0;
		app.getContactHelper().editContact(index);
		
	    app.getContactHelper().fillContactForm(contactData, MODIFICATION);
	    app.getContactHelper().updateContact();
	    app.navigateTo().returnToHomePage();
	    
	    //read updated contact list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    oldList.remove(index);
	    oldList.add(contactData);
	    Collections.sort(oldList);    
	    //comparison
	    assertEquals(oldList, newList);	    
	}
}

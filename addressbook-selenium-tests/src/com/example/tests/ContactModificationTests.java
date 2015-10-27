package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contactData){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoHomePage();
		
		//read contacts list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
		
	    int index = 0;
		app.getContactHelper().editContact(index);
		
	    app.getContactHelper().addContactData(contactData);
	    app.getContactHelper().updateContact();
	    app.getNavigationHelper().returnToHomePage();
	    
	    //read updated contact list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    oldList.remove(index);
	    oldList.add(contactData);
	    Collections.sort(oldList);    
	    //comparison
	    assertEquals(oldList, newList);	    
	}
}

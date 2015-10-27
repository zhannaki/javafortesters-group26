package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void removeSomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoHomePage();
		
		//read contacts list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
		
	    int index = 0;
		app.getContactHelper().editContact(index);
		app.getContactHelper().deleteContact();
		app.getNavigationHelper().returnToHomePage();
		
		//read updated contact list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    oldList.remove(index);	    
	    //comparison
	    assertEquals(oldList, newList);
	}
}

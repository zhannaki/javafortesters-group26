package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void removeSomeContact(){
		app.navigateTo().mainPage();
		app.navigateTo().gotoHomePage();
		
		//read contacts list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
		
	    int index = 0;
		app.getContactHelper().editContact(index);
		app.getContactHelper().deleteContact();
		app.navigateTo().returnToHomePage();
		
		//read updated contact list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    oldList.remove(index);	    
	    //comparison
	    assertEquals(oldList, newList);
	}
}

package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoHomePage();
		
		//read contacts list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
		
	    int index = 0;
		app.getContactHelper().editContact(index);
		
		ContactData contactData = new ContactData();
	    contactData.firstName = "Katya";
	    contactData.lastName = "Ivanova";
	    contactData.address = "Nevskiy Prospect 134";
	    contactData.mobilePhone = "+7(911)0989777";
	    contactData.email = "kinna@list.ru";
	    contactData.email2 = "inna.i.kabysheva@mail.ru";
	    contactData.bday = "16";
	    contactData.bmonth = "January";
	    contactData.byear = "1984";
	    
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

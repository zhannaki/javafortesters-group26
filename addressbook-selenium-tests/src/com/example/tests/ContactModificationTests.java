package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoHomePage();
		
		app.getContactHelper().editContact(2);
		
		ContactData contactData = new ContactData();
	    contactData.firstName = "Inna";
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
	    
	}
}

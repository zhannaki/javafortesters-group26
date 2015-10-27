package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test(dataProvider = "randomValidContactGenerator")
  public void testValidContactCreation(ContactData contactData) throws Exception {
	app.getNavigationHelper().openMainPage();
   
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    app.getContactHelper().addNew();
	app.getContactHelper().addContactData(contactData);
    app.getContactHelper().submitNewContact();
    app.getNavigationHelper().gotoHomePage();
    
    //read new data
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    oldList.add(contactData);
    Collections.sort(oldList);
    assertEquals(oldList, newList);
  }

 }

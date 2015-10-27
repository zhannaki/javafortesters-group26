package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
   
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    app.getContactHelper().addNew();
    
    ContactData contactData = new ContactData();
    contactData.firstName = "anna";
    contactData.lastName = "sheva";
    contactData.address = "Nevskiy Prospect 134";
    contactData.homePhone = "+7(812)3500111";
    contactData.mobilePhone = "+7(911)0989111";
    contactData.officePhone = "+7(815)3555555";
    contactData.email = "moe_pismo@bk.ru";
    contactData.email2 = "zhanna.i.kabysheva@mail.ru";
    contactData.bday = "20";
    contactData.bmonth = "August";
    contactData.byear = "1986";
    contactData.newGroup = "group1";
    contactData.address2 = "Nevskiy Prospect 33"; 
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

  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	//save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    ContactData contactData = new ContactData();
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

package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().gotoAddNew();
    ContactData contactData = new ContactData();
    contactData.firstName = "Zhanna";
    contactData.lastName = "Kabysheva";
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
  }

  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().gotoAddNew();
    app.getContactHelper().addContactData(new ContactData());
    app.getContactHelper().submitNewContact();
    app.getNavigationHelper().gotoHomePage();
  }

}

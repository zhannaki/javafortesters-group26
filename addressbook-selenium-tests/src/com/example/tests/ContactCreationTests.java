package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    gotoAddNew();
    addContactData(new ContactData("Zhanna", "Kabysheva", "Nevskiy Prospect 134", "+7(812)3500111", "+7(911)0989111", "+7(815)3555555", "moe_pismo@bk.ru", "zhanna.i.kabysheva@mail.ru", "20", "August", "1986", "group1", "empty", "Nevskiy Prospect 33"));
    submitNewContact();
    gotoHomePage();
  }

  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    gotoAddNew();
    addContactData(new ContactData());
    submitNewContact();
    gotoHomePage();
  }

}

package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {

	@Test
	public void removeSomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoHomePage();
		app.getContactHelper().editContact(2);
		app.getContactHelper().deleteContact();
	}
}

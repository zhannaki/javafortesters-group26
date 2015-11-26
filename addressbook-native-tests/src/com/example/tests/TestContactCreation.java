package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestContactCreation extends TestBase{

	@DataProvider
	public Iterator<Object> generateContacts() {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < 1; i++) {
			Contact contact = new Contact()
					.setFirstname(generateRandomString())
					.setLastname(generateRandomString());
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	@Test(dataProvider = "generateContacts")
	public void deleteContact(Contact contact) {
		app.getContactHelper().createContact(contact);
		Contact createdContact = app.getContactHelper().getFirstContact();
		Assert.assertEquals(contact, createdContact);		
	}
	
}

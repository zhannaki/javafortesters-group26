package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

public class TestDeleteContact extends TestBase{

	@Test
	public void testDeleteContact() {		
		Contact deletedContact  = app.getContactHelper().deleteContact();
		Contact firstContact = app.getContactHelper().getFirstContact();
 		Assert.assertNotEquals(firstContact, deletedContact);		
	}
}

package com.example.tests;

import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contactData){
		
		//read contacts list
	    SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		
	    int index = 0;
	    app.getContactHelper().modification(index, contactData);
	    
	    //read updated contact list
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //comparison
	    assertThat(newList, equalTo(oldList.without(index).withAdded(contactData)));   
	}
}

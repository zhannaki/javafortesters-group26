package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
public class ContactRemovalTests extends TestBase {

	@Test
	public void removeSomeContact(){
		
		//read contacts list
	    SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		
	    int index = 0;
	    app.getContactHelper().deleteContactByIndex(index);
	
		//read updated contact list
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	      
	    //comparison
	    assertThat(newList, equalTo(oldList.without(index)));
	}
}

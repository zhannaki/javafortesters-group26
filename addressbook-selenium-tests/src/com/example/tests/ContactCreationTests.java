package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase{

  @Test(dataProvider = "randomValidContactGenerator")
  public void testValidContactCreation(ContactData contactData) throws Exception {
	
    //save old state
    SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
    
    app.getContactHelper().addNewContact(contactData);
  
    //read new data
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    assertThat(newList, equalTo(oldList.withAdded(contactData)));
  }

 }

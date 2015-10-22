package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitNewContact() {
		click(By.name("submit"));
	}

	public void gotoAddNew() {
		click(By.linkText("add new"));
	}

	public void addContactData(ContactData contactData) {
		type(By.name("firstname"), contactData.firstName);
	    type(By.name("lastname"),contactData.lastName);
	    type(By.name("address"),contactData.address);
	    type(By.name("home"),contactData.homePhone);
	    type(By.name("mobile"),contactData.mobilePhone);
	    type(By.name("work"),contactData.officePhone);
	    type(By.name("email"),contactData.email);
	    type(By.name("email2"),contactData.email2);	    	   
	    selectByText(contactData.bday, By.name("bday"));	    	
	    selectByText(contactData.bmonth, By.name("bmonth"));	    	
	    type(By.name("byear"),contactData.byear);	    
	   // selectByText(contactData.newGroup, By.name("new_group"));	     	
	    type(By.name("address2"),contactData.address2);
	    type(By.name("phone2"),contactData.phone2);	    
	}

	public void updateContact() {
		click(By.xpath("//input[@value='Update']"));
	}

	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
	}

	public void editContact(int index) {
		//click(By.xpath("//img[@title='Edit'][" + index + "]"));		
		click(By.xpath("//*[@id='maintable']/tbody/tr[" + (index + 1) + "]/td[7]/a/img"));
	}

}

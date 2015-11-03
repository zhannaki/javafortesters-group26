package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;	
	private SortedListOf<ContactData> cachedContacts;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public ContactHelper addNewContact(ContactData contactData) {
		manager.navigateTo().mainPage();		   
		addNew();
		fillContactForm(contactData, CREATION);
	    submitNewContact();
	    manager.navigateTo().returnToHomePage();
	    rebuildContacts();
	    return this;
	}
	
	public ContactHelper deleteContactByIndex(int index) {
		manager.navigateTo().mainPage();
		editContact(index);
		deleteContact();
		manager.navigateTo().returnToHomePage();
		rebuildContacts();
		return this;		
	}
	
	public ContactHelper modification(int index, ContactData contactData) {
		manager.navigateTo().mainPage();
		editContact(index);		
	    fillContactForm(contactData, MODIFICATION);
	    updateContact();
	    manager.navigateTo().returnToHomePage();
		return this;
	}	

	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null){
			rebuildContacts();
		}	
		return cachedContacts;
	}

	private void rebuildContacts() {
		manager.navigateTo().mainPage();
		cachedContacts = new SortedListOf<ContactData>();
		List<WebElement> rows = driver.findElements(By.name("entry"));
		for (WebElement row : rows) {
			ContactData contact = new ContactData()
					.withFirstName(row.findElement(By.xpath(".//td[3]")).getText())
					.withLastName(row.findElement(By.xpath(".//td[2]")).getText());
			cachedContacts.add(contact);		
		}
	}
	
	//-------------------------------------------

	public void submitNewContact() {
		click(By.name("submit"));
		cachedContacts = null;
	}

	public void addNew() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contactData, boolean formType) {
		type(By.name("firstname"), contactData.getFirstName());
	    type(By.name("lastname"),contactData.getLastName());
	    type(By.name("address"),contactData.getAddress());
	    type(By.name("home"),contactData.getHomePhone());
	    type(By.name("mobile"),contactData.getMobilePhone());
	    type(By.name("work"),contactData.getOfficePhone());
	    type(By.name("email"),contactData.getEmail());
	    type(By.name("email2"),contactData.getEmail2());	    	   
	    selectByText(contactData.getBday(), By.name("bday"));	    	
	    selectByText(contactData.getBmonth(), By.name("bmonth"));	    	
	    type(By.name("byear"),contactData.getByear());	    
	    if (formType == CREATION){
	    	selectByText(contactData.getNewGroup(), By.name("new_group"));	 
	    } else {
	    	if (driver.findElements(By.name("new_group")).size() > 0) {
	    		throw new Error("Group selector exists in contact modification form");
	    	}
	    }
	       	
	    type(By.name("address2"),contactData.getAddress2());
	    type(By.name("phone2"),contactData.getPhone2());	    
	}

	public void updateContact() {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts = null;
	}

	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts = null;
	}
	
	public void editContact(int index) {	
		click(By.xpath("//*[@id='maintable']/tbody/tr[" + (index + 2) + "]/td[7]/a/img"));
	}

}

package com.example.fw;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();			
	}

	private void confirmContactCreation() {
		manager.getAutoItHelper()
			.click("Save")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
			.send("TDBEdit12", contact.getFirstname())
			.send("TDBEdit11", contact.getLastname());
	}

	private void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("Add").winWaitAndActivate("Add Contact", "", 5000);
		waiting(2000);
	}

	public Contact getFirstContact() {
		manager.getAutoItHelper().focus("TListView1")
			.send("{DOWN}{SPACE}")
			.click("Edit")
			.winWaitAndActivate("Update Contact", "", 5000);
		waiting(2000);
		Contact contact = new Contact()
				.setFirstname(manager.getAutoItHelper().getText("TDBEdit12"))
				.setLastname(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper().click("Cancel");
		return contact;
	}
	
	private void waiting(long ml) {
		try {
			Thread.sleep(ml);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

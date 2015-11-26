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

	public Contact deleteContact() {
		winWait();
		Contact contact = getFirstContact();
		winWait();
		selectFirstElement();
		winWait();
		clickDelete();
		return contact;
	}

	private void winWait() {
		manager.getAutoItHelper().winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	private void clickDelete() {
		manager.getAutoItHelper().click("Delete");
		waiting(1000);
		manager.getAutoItHelper().send("{ENTER}")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
	}	
	
	public Contact getFirstContact() {
		selectFirstElement();
		manager.getAutoItHelper().click("Edit")
			.winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact()
				.setFirstname(manager.getAutoItHelper().getText("TDBEdit12"))
				.setLastname(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper().click("Cancel");
		return contact;
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
	}

	private void selectFirstElement() {
		manager.getAutoItHelper().focus("TListView1")
			.send("{DOWN}{SPACE}");
		waiting(500);
	}
	
	private void waiting(long ml) {
		try {
			Thread.sleep(ml);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

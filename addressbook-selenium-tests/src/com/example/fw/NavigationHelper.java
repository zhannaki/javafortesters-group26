package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToGroupPage() {
	    click(By.linkText("group page"));
	}

	public void gotoGroupsPage() {
	    click(By.linkText("groups"));
	}

	public void openMainPage() {
	    manager.driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

	public void gotoHomePage() {
		click(By.linkText("home"));
	}

}

package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void groupsPage() {
		if (! onGroupsPage()) {
			click(By.linkText("groups"));	    
		}
	}
	
	public void mainPage() {
	    openUrl();
	}

	public void gotoHomePage() {
		click(By.linkText("home"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}
	
	private boolean onGroupsPage() {
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("/group.php") && driver.findElement(driver.findElement(By.name("new")).Size() > 0))
		{
			return true;
		} else {
			return false;
		}
	}

}

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
		if (! onMainPage()){
			click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {		
		return driver.findElements(By.id("maintable")).size() > 0;		
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}
	
	private boolean onGroupsPage() {	
		return (driver.getCurrentUrl().contains("/group.php") && driver.findElements(By.name("new")).size() > 0);	
	}

}

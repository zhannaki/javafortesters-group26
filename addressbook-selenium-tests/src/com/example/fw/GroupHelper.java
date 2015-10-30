package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public GroupHelper createGroup(GroupData group) {				
		manager.navigateTo().groupsPage();
    	initGroupCreation();
    	fillGroupForm(group);
    	submitGroupCreation();
    	returnToGroupsPage();  	
    	return this;
	}
	
	public List<GroupData> getGroups() {
		manager.navigateTo().groupsPage();
		
		List< GroupData> groups = new  ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {			
			String title = checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(new GroupData().withName(name));
		}
		return groups;
	}
	
	public GroupHelper deleteGroup(int index) {		
		selectGroupByIndex(index);
		submitGroupRemoval();
		returnToGroupsPage();
		return this;
	}

	public GroupHelper modifyGroup(int index, GroupData group) {		
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupsPage();
		return this;		
	}
	
	// --------------------------------низкоуровневые методы -----------------------------------------------
	
	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
	}
	
	public void submitGroupRemoval() {
		click(By.name("delete"));
	}

	public GroupHelper initGroupCreation() {
		manager.navigateTo().groupsPage();
		click(By.name("new"));
		return this;
	}

	public GroupHelper fillGroupForm(GroupData groupData) {
	    type(By.name("group_name"), groupData.getGroupname());
	    type(By.name("group_header"),groupData.getHeader());
	    type(By.name("group_footer"),groupData.getFooter());	    
	    return this;
	}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
	}

	public GroupHelper returnToGroupsPage() {
	    click(By.linkText("group page"));
	    return this;
	}	
}

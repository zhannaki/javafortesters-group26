package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void fillGroupForm(GroupData groupData) {
	    type(By.name("group_name"), groupData.groupname);
	    type(By.name("group_header"),groupData.header);
	    type(By.name("group_footer"),groupData.footer);    
	}

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));		
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index + "]"));
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));	
	}

	public void submitGroupModification(int i) {
		click(By.name("update"));
		
	}

}

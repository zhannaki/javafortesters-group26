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
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));	
	}

	public void submitGroupModification() {
		click(By.name("update"));		
	}

	public List<GroupData> getGroups() {
		List< GroupData> groups = new  ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			title = title.substring("Select (".length(), title.length() - ")".length());					
			group.groupname = title;
					
			groups.add(group);
		}
		return groups;
	}

}

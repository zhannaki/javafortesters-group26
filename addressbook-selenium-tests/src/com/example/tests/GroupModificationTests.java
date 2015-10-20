package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

	@Test
	public void modifySomeGroup(){
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData groupData = new GroupData();
		groupData.groupname = "updategroup";
		app.getGroupHelper().fillGroupForm(groupData);
		app.getGroupHelper().submitGroupModification(1);
		app.getNavigationHelper().returnToGroupPage();
	}
}

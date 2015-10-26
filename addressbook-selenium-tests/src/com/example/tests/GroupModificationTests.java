package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData groupData){
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    
	  //save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    //actions
		app.getGroupHelper().initGroupModification(0);
		app.getGroupHelper().fillGroupForm(groupData);
		app.getGroupHelper().submitGroupModification();
		app.getNavigationHelper().returnToGroupPage();
		
		//save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //compare states
	    oldList.remove(0);
	    oldList.add(groupData);
	    Collections.sort(oldList);
	    assertEquals(oldList, newList);
	}
}

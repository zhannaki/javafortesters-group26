package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {

	@Test(dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData groupData){		
	  //save old state
	    SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    //actions
	    int index = 0;
	    app.getGroupHelper().modifyGroup(index, groupData);		
		//save new state
	    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    //compare states	
	    assertThat(newList, equalTo(oldList.without(index).withAdded(groupData)));
	}
}

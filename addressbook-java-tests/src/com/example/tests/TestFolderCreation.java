package com.example.tests;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestFolderCreation extends TestBase {

	@Test
	public void testFoldersCreation(){
		Folders oldFolders =  app.getFolderHelper().getFolders();
		String folder = "newfolder11";		
		assertThat(app.getFolderHelper().createFolder(folder), is(nullValue()));
		Folders newFolders =  app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));
	}
	
}

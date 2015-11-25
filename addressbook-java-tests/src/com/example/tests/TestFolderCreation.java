package com.example.tests;

import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

public class TestFolderCreation extends TestBase {

	@Test
	public void testFoldersCreation(){
		addNewFolder("newfolder11");
		addNewFolder("newfolder112");
	}

	@Test
	public void testCreate2FoldersErrorExpected(){
		String folder = "newfolder1";
		addNewFolder(folder);
		addDuplicatedFolder(folder);
	}
	
	private void addNewFolder(String folder) {
		Folders oldFolders =  app.getFolderHelper().getFolders();						
		assertThat(app.getFolderHelper().createFolder(folder),is(nullValue()));			
		Folders newFolders =  app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));			
	}
	
	private void addDuplicatedFolder(String folder) {
		Folders oldFolders =  app.getFolderHelper().getFolders();						
		assertThat(app.getFolderHelper().createFolder(folder),containsString("Duplicated folder name"));			
		Folders newFolders =  app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders));			
	}
	
}

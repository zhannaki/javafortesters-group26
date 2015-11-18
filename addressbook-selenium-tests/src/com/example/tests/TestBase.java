package com.example.tests;


import java.text.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

import static com.example.tests.ContactDataGenerator.generateRandomContacts;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();	    
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();	    
	  }

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() throws ParseException{
		return wrapContactsForDataProvider(generateRandomContacts(5)).iterator();
	}

	public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contactData : contacts) {
			list.add(new Object[]{contactData});
		}
		return list;
	}
	
	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group: groups) {
			list.add(new Object[]{group});
		}
		return list;
	}

	public static String generateRandomString() {
	Random rnd = new Random();
	if (rnd.nextInt(3) == 0) {
		return "";
	} else {
		return "test" + rnd.nextInt();
		}
	}
}

package com.example.tests;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Calendar;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;


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
	public Iterator<Object[]> randomValidGroupGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i < 2; i++) {
			GroupData group = new GroupData()
					.withName(generateRandomString())
					.withHeader(generateRandomString())
					.withFooter(generateRandomString());		
			list.add(new Object[]{group});
		}
		return list.iterator();
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() throws ParseException{
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i < 2; i++) {
			ContactData contactData = new ContactData();
			
			contactData.firstName = generateRandomString();
			contactData.lastName = generateRandomString();
			contactData.address = generateRandomString();
			contactData.homePhone = generatePhoneNumber();
		    contactData.mobilePhone = generatePhoneNumber();
		    contactData.officePhone = generatePhoneNumber();
		    contactData.phone2 = generatePhoneNumber();
		    contactData.email = generateEmail();
		    contactData.email2 = generateEmail();	
		    contactData.bmonth = generateMonth();
		    contactData.byear = String.valueOf(generateNumber(1900, 2015));
		   
		    //расчет количества дней в мес€це		    
		    String bday = "01-" + contactData.bmonth.subSequence(0, 3) + "-" + contactData.byear;
		    DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		    Calendar calendar = Calendar.getInstance(Locale.ENGLISH);		    
		    calendar.setTime(df.parse(bday)); 
		    int maxdays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);		    
		    contactData.bday = String.valueOf(generateNumber(1, maxdays));
	    
		    //contactData.newGroup = "group1";
		    contactData.address2 = generateRandomString(); 
			list.add(new Object[]{contactData});
		}
		return list.iterator();
	}
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
	
	public String generateEmail(){
		String s = generateRandomString();
			if (s != ""){
				s = s + "@mail.ru";
			}
		return s;
	}
	
	public int generateNumber(int min, int max){
		Random rnd = new Random();
		return (rnd.nextInt(max-min)+1) + min;
	}

	public String generateMonth(){
		Random rnd = new Random();
		int m = rnd.nextInt(12);
		Locale locale = new Locale("ENGLISH");
		return new DateFormatSymbols(locale).getMonths()[m];
	}
	
	public String generatePhoneNumber(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "+7(" + generateStringFromNumbers(3) + ")" + generateStringFromNumbers(7);
		}
	}
	
	private String generateStringFromNumbers(int len){
		String s = "";
		for (int i=0; i<len; i++){
			s = s + String.valueOf(generateNumber(0, 9));
		}
		return s;
	}
	
}

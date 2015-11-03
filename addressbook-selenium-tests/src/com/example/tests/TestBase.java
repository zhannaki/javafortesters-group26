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
import com.example.utils.SortedListOf;

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
			
			String month = generateMonth();
			int year = generateNumber(1900, 2015);

			ContactData contactData = new ContactData()
					.withFirstName(generateRandomString())
					.withLastName(generateRandomString())
					.withAddress(generateRandomString())
					.withHomePhone(generatePhoneNumber())
					.withMobilePhone(generatePhoneNumber())
					.withOfficePhone(generatePhoneNumber())
					.withPhone2(generatePhoneNumber())
					.withEmail(generateEmail())
					.withEmail2(generateEmail())
					.withbmonth(month)
					.withbyear(String.valueOf(year))
					.withBday(generateDayOfMonth(month, year))
					.withNewGroup(generateGroupName())
					.withAddress2(generateRandomString());
			list.add(new Object[]{contactData});			
		}
		return list.iterator();
	}

	private String generateGroupName() {
		SortedListOf<GroupData> groups = app.getGroupHelper().getGroups();
		Random rnd = new Random();
			if (rnd.nextInt(3) == 0) {
				return null;
			} else {
				return groups.get(rnd.nextInt(groups.size())).getGroupname();
			}
	}
	
	private String generateDayOfMonth(String month, int year) throws ParseException {
		String bday = "01-" + month.subSequence(0, 3) + "-" + year;
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		Calendar calendar = Calendar.getInstance(Locale.ENGLISH);		    
		calendar.setTime(df.parse(bday)); 
		int maxdays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);		    
		String day = String.valueOf(generateNumber(1, maxdays));
		return day;
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

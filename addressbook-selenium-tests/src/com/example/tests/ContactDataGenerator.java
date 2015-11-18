package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

import static com.example.tests.TestBase.generateRandomString;

public class ContactDataGenerator {

	public static void main(String[] args) throws ParseException, IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount> <file> <format>");
			return;
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists, please remove it manually " + file);
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCvsFile(contacts, file);
		} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Uknown format " + format);
			return;
		}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("ContactData", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();		
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("ContactData", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}

	private static void saveContactsToCvsFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contactData : contacts) {
			writer.write(contactData.getFirstName() + ","
					+ contactData.getLastName() + ","
					+ contactData.getAddress() + ","
					+ contactData.getHomePhone() + ","
					+ contactData.getMobilePhone() + ","
					+ contactData.getOfficePhone() + ","
					+ contactData.getEmail() + ","
					+ contactData.getEmail2() + ","
					+ contactData.getBday() + ","
					+ contactData.getBmonth() + ","
					+ contactData.getByear() + ","
					+ contactData.getNewGroup() + ","
					+ contactData.getAddress2() + ","
					+ contactData.getPhone2() + ",!" + "\n");
		}
		writer.close();
	}

	/*	firstName;	lastName;	address;	homePhone;	mobilePhone;	 officePhone;	 email;	 email2;
	bday;	bmonth;	 byear;	 newGroup;	address2;	 phone2;*/
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null){
			String[] part = line.split(",");
			ContactData contact = new ContactData()
					.withFirstName(part[0])
					.withLastName(part[1])
					.withAddress(part[2])
					.withHomePhone(part[3])
					.withMobilePhone(part[4])
					.withOfficePhone(part[5])
					.withEmail(part[6])
					.withEmail2(part[7])
					.withBday(part[8])
					.withbmonth(part[9])
					.withbyear(part[10])
					.withNewGroup(part[11])
					.withAddress2(part[12])
					.withPhone2(part[13]);
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}	

	public static List<ContactData> generateRandomContacts(int amount) throws ParseException{
		List<ContactData> list = new ArrayList<ContactData>();
		
		for (int i = 0; i < amount; i++) {
			
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
			list.add(contactData);			
		}
		return list;
	}

	public static String generateGroupName() {
		//вопрос: как генерировать случайно выбранную группу?
		return "";			
	}
	
	private static String generateDayOfMonth(String month, int year) throws ParseException {
		String bday = "01-" + month.subSequence(0, 3) + "-" + year;
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		Calendar calendar = Calendar.getInstance(Locale.ENGLISH);		    
		calendar.setTime(df.parse(bday)); 
		int maxdays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);		    
		String day = String.valueOf(generateNumber(1, maxdays));
		return day;
	}
	
	public static String generateEmail(){
		String s = generateRandomString();
			if (s != ""){
				s = s + "@mail.ru";
			}
		return s;
	}
	
	public static int generateNumber(int min, int max){
		Random rnd = new Random();
		return (rnd.nextInt(max-min)+1) + min;
	}

	public static String generateMonth(){
		Random rnd = new Random();
		int m = rnd.nextInt(12);
		Locale locale = new Locale("ENGLISH");
		return new DateFormatSymbols(locale).getMonths()[m];
	}
	
	public static String generatePhoneNumber(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "+7(" + generateStringFromNumbers(3) + ")" + generateStringFromNumbers(7);
		}
	}
	
	private static String generateStringFromNumbers(int len){
		String s = "";
		for (int i=0; i<len; i++){
			s = s + String.valueOf(generateNumber(0, 9));
		}
		return s;
	}

}

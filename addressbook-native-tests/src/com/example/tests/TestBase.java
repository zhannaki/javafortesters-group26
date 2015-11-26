package com.example.tests;


import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeClass
	@Parameters({"configFile"})
	public void setUp(@Optional String configFile) throws Exception {
		if (configFile == null) {
			configFile = System.getProperty("configFile");
		}
		if (configFile == null) {
			configFile = System.getenv("configFile");
		}
		if (configFile == null) {
			configFile = "application.properties";
		}
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = ApplicationManager.getInstance(properties);    
		app.start();
	  }

	@AfterTest
	public void tearDown() throws Exception {
		ApplicationManager.getInstance(null).stop();    
	  }
	
	public static String generateRandomString() {
		return "test" + new Random().nextInt();
		}
}

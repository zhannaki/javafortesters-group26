package com.example.fw;

import java.io.IOException;

public class ProcessHelper extends HelperBase{
	
	private Process exec;

	public ProcessHelper(ApplicationManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
	
	public void startAppUnderTest() throws IOException{
		String command = manager.getProperty("app.path");
		exec = Runtime.getRuntime().exec(command);
	}
	
	public void stopAppUnderTest() {
		exec.destroy();
	}

}

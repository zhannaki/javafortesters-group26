package com.example.fw;

import org.netbeans.jemmy.operators.JMenuBarOperator;

public class MenuHelper {
	private ApplicationManager manager;

	public MenuHelper(ApplicationManager manager) {
		this.manager = manager;
	}

	public void pushCreateFolder() {
		JMenuBarOperator menu = new JMenuBarOperator(manager.getApplication());
		menu.pushMenuNoBlock("File|New folder...");
	}

}

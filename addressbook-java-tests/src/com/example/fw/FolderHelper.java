package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

import com.example.tests.Folders;

public class FolderHelper {

	private ApplicationManager manager;

	public FolderHelper(ApplicationManager manager) {
		this.manager = manager;		
	}

	public Folders getFolders() {
		List<String> list = new ArrayList<String>();
		JFrameOperator mainFrame = manager.getApplication();
		JTreeOperator tree = new JTreeOperator(mainFrame);
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child: children) {
			list.add("" + child);
		}
		return new Folders(list);
	}

	public String createFolder(String folder) {
		manager.getMenuHelper().pushCreateFolder();
		JDialogOperator dialog = new JDialogOperator(manager.getApplication());
		new JTextFieldOperator(dialog).setText(folder);
		new JButtonOperator(dialog, "OK").push();
		return waitMessageDialog("Warning", 3000);
	}
	
	private String waitMessageDialog(String title, int timeout) {
		long start = System.currentTimeMillis();
		long currenttime = start;
		while (currenttime < start +timeout) {
			JDialog dialog = JDialogOperator.findJDialog(manager.getApplication().getOwner(), title, false, false);
			if (dialog != null) {
				JDialogOperator dialogOperator = new JDialogOperator(dialog);
				String message = new JLabelOperator(dialogOperator).getText();
				dialogOperator.requestClose();
				return message;
			}
			try {
				Thread.sleep(500);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			currenttime = System.currentTimeMillis();
		}
		return null;
	}
}

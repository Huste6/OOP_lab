package buoi_1;

import javax.swing.JOptionPane;

public class customizeOptions {
	public static void main(String[] args) {
		Object[] opts = { "I do", "I don't" };
		int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?",
				"Select options", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opts, opts[1]);
		JOptionPane.showMessageDialog(null,
				"You are chosen: " + (option == JOptionPane.YES_OPTION ? "I do" : "I don't"));
		System.exit(0);
	}
}

package bai_tap_tren_lop;

import javax.swing.JOptionPane;

public class HelloNameDialog {
	public static void main(String[] args) {
		String result = JOptionPane.showInputDialog("Please enter your name: ");
		JOptionPane.showMessageDialog(null, "Hi " + result + "!");
		System.exit(0);
	}
}

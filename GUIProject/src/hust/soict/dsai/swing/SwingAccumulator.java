package hust.soict.dsai.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class SwingAccumulator extends JFrame{
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0;
	
	public SwingAccumulator() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2,2));
		
		cp.add(new Label("Enter an Integer:"));
		tfInput = new TextField(5);
		cp.add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		
		cp.add(new Label("The Accumulated Sum is: "));
		
		tfOutput = new TextField(10);
		tfOutput.setEditable(false);
		cp.add(tfOutput);
		
		setTitle("AWT accumulator");
		setSize(300,120);
		setVisible(true);		
	}
	public static void main(String[] args) {
		new AWTAccumulator();
	}
	private class TFInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			tfInput.setText("");
			tfOutput.setText(sum + "");
		}
	}
}

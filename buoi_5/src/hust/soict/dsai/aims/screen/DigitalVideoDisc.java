package hust.soict.dsai.aims.screen;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Disc;

public class DigitalVideoDisc extends Disc {
	public String getType() {
		return "DVD";
	}

	public String getDetails() {
		return ("Product ID: " + String.valueOf(this.getID()) + "\n" + "\t" + "Title: " + this.getTitle() + "\n" + "\t"
				+ "Category: " + this.getCategory() + "\n" + "\t" + "Director: " + this.getDirector() + "\n" + "\t"
				+ "Length: " + String.valueOf(this.getLength()) + " minutes" + "\n" + "\t" + "Price: $"
				+ String.valueOf(this.getCost()));
	}

	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		} else {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());

			// Display playback details in a Swing dialog
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			JPanel panel = new JPanel();
			JDialog dialog = new JDialog();
			JLabel label1 = new JLabel("Now playing: " + this.getTitle());
			JLabel label2 = new JLabel("DVD length: " + this.getLength());

			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			label1.setAlignmentX(Component.CENTER_ALIGNMENT);
			label2.setAlignmentX(Component.CENTER_ALIGNMENT);

			dialog.setTitle("Media Player");
			panel.add(Box.createVerticalGlue());
			panel.add(label1);
			panel.add(label2);
			panel.add(Box.createVerticalGlue());

			dialog.add(panel);
			dialog.setSize(250, 100);

			// Center the dialog on the screen
			int w = dialog.getSize().width;
			int h = dialog.getSize().height;
			int x = (dim.width - w) / 2;
			int y = (dim.height - h) / 2;
			dialog.setLocation(x, y);

			dialog.setVisible(true);
		}
	}

	// Constructors
	public DigitalVideoDisc(String title) {
		super(title);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
}

package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.CartFullException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;

	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);

		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);

		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton addToCartButton = new JButton("Add to cart");
		addToCartButton.addActionListener(new AddToCartListener());
		container.add(addToCartButton);

		JButton detailsButton = new JButton("View details");
		detailsButton.addActionListener(new DetailsListener());
		container.add(detailsButton);

		if (media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(new PlayButtonListener());
			container.add(playButton);
		}

		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	private class PlayButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (media instanceof Disc) {
					((Disc) media).play();
				} else {
					showErrorDialog("This media is not a playable disc.");
				}
			} catch (PlayerException ex) {
				showErrorDialog(media.getTitle() + " cannot be played\nMedia length is non-positive.");
			}
		}
	}

	private class AddToCartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				cart.addMedia(media);
				showInfoDialog(media.getTitle() + " added to cart");
			} catch (CartFullException ex) {
				showInfoDialog("The cart is full");
			}
		}
	}

	private class DetailsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showInfoDialog("<html>" + media.getDetails().replaceAll("\n", "<br/>") + "</html>");
		}
	}

	private void showInfoDialog(String message) {
		JPanel p = new JPanel();
		JDialog d = new JDialog();
		JLabel l = new JLabel(message, SwingConstants.CENTER);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(Box.createVerticalGlue());
		p.add(l);
		p.add(Box.createVerticalGlue());
		d.add(p);
		d.setSize(200, 100);
		centerDialog(d);
		d.setVisible(true);
	}

	private void showErrorDialog(String message) {
		JPanel p = new JPanel();
		JDialog d = new JDialog();
		JLabel l = new JLabel(message, SwingConstants.CENTER);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(Box.createVerticalGlue());
		p.add(l);
		p.add(Box.createVerticalGlue());
		d.add(p);
		d.setSize(250, 100);
		centerDialog(d);
		d.setVisible(true);
	}

	private void centerDialog(JDialog d) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = d.getSize().width;
		int h = d.getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		d.setLocation(x, y);
	}
}

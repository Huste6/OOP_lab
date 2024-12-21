package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
	private Store store;
	private Cart cart;

	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = getSize().width;
		int h = getSize().height;
		int x = (dim.width - w) / 2;
		int y = (dim.height - h) / 2;
		setLocation(x, y);
	}

	public static void main(String[] args) throws Exception {
		// Test
		Store myStore = new Store();
		Cart myCart = new Cart();

		// Create media
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Goblin King", "Animation", "Someone", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-fi", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		CompactDisc cd1 = new CompactDisc("ROTK OST (Part 1)", "Drama", "Various", 30.95f);
		CompactDisc cd2 = new CompactDisc("ROTK OST (Part 2)", "Drama", "Various", 25.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Inception", "Sci-fi", "Christopher Nolan", 148, 29.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Lion King", "Animation", "Disney", 89, 19.95f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Avatar", "Sci-fi", "James Cameron", 162, 27.50f);
		CompactDisc cd3 = new CompactDisc("Thriller", "Pop", "Michael Jackson", 15.99f);
		CompactDisc cd4 = new CompactDisc("Abbey Road", "Rock", "The Beatles", 19.99f);
		CompactDisc cd5 = new CompactDisc("1989", "Pop", "Taylor Swift", 18.95f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Matrix", "Sci-fi", "Wachowski Sisters", 136, 22.99f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Interstellar", "Sci-fi", "Christopher Nolan", 169, 32.95f);
		CompactDisc cd6 = new CompactDisc("The Dark Side of the Moon", "Rock", "Pink Floyd", 24.99f);
		CompactDisc cd7 = new CompactDisc("Back in Black", "Rock", "AC/DC", 21.95f);

		// Add media to store
		myStore.addMedia(dvd1);
		myStore.addMedia(dvd2);
		myStore.addMedia(dvd3);
		myStore.addMedia(cd1);
		myStore.addMedia(cd2);
		myStore.addMedia(dvd4);
		myStore.addMedia(dvd5);
		myStore.addMedia(dvd6);
		myStore.addMedia(cd3);
		myStore.addMedia(cd4);
		myStore.addMedia(cd5);
		myStore.addMedia(dvd7);
		myStore.addMedia(dvd8);
		myStore.addMedia(cd6);
		myStore.addMedia(cd7);

		// Start the store screen
		new StoreScreen(myStore, myCart);
	}

	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");

		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(new AddBookListener());
		smUpdateStore.add(addBook);
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(new AddCDListener());
		smUpdateStore.add(addCD);
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(new AddDVDListener());
		smUpdateStore.add(addDVD);

		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		JMenuItem cartMenu = new JMenuItem("View cart");
		cartMenu.addActionListener(new ViewCartListener());
		menu.add(cartMenu);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS:");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		JButton cartButton = new JButton("View cart");
		cartButton.setPreferredSize(new Dimension(100, 50));
		cartButton.setMaximumSize(new Dimension(100, 50));
		cartButton.addActionListener(new ViewCartListener());

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cartButton);
		header.add(Box.createRigidArea(new Dimension(10, 10)));

		return header;
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(5, 5, 2, 2));
		List<Media> mediaInStore = store.getItemsInStore();
		for (Media media : mediaInStore) {
			MediaStore cell = new MediaStore(media, cart);
			center.add(cell);
		}
		return center;
	}

	private class ViewCartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new CartScreen(store, cart);
			dispose();
		}
	}

	private class AddDVDListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddDVDToStoreScreen(store, cart);
			dispose();
		}
	}

	private class AddBookListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddBookToStoreScreen(store, cart);
			dispose();
		}
	}

	private class AddCDListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddCDToStoreScreen(store, cart);
			dispose();
		}
	}
}

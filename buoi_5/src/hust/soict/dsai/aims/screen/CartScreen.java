package hust.soict.dsai.aims.screen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	private Store store;
	private Cart cart;
	static {
		Platform.startup(() -> {
		});
	}

	private void initializeFxPanel(JFXPanel fxPanel) {
		Platform.runLater(() -> {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
				CartScreenController controller = new CartScreenController(store, cart, this);
				loader.setController(controller);
				Parent root = loader.load();
				fxPanel.setScene(new Scene(root));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	public CartScreen(Store store, Cart cart) {
		super();
		this.store = store;
		this.cart = cart;
		this.setSize(1024, 768);
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Cart");
		this.setVisible(true);
		JFrame frame = this;
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new StoreScreen(store, cart);
				dispose();
			}
		});
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
					CartScreenController controller = new CartScreenController(store, cart, frame);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String args[]) throws Exception {
		// Test DigitalVideoDiscs (DVDs)
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Goblin King", "Animation", "Someone", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-fi", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Matrix", "Sci-fi", "Wachowski", 136, 29.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Inception", "Sci-fi", "Christopher Nolan", 148, 29.95f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 22.50f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 89, 21.00f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Titanic", "Drama", "James Cameron", 195, 26.50f);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Interstellar", "Sci-fi", "Christopher Nolan", 169, 34.99f);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Jumanji", "Adventure", "Jake Kasdan", 119, 20.99f);

		// Test Tracks for CompactDiscs
		Track track1 = new Track("Wei", 10);
		Track track2 = new Track("Shu", 21);
		Track track3 = new Track("Wu", 15);
		Track track4 = new Track("Track 4", 12);
		Track track5 = new Track("Track 5", 8);
		Track track6 = new Track("Track 6", 17);
		Track track7 = new Track("Track 7", 14);
		Track track8 = new Track("Track 8", 20);

		// Test CompactDiscs (CDs)
		CompactDisc cd1 = new CompactDisc("ROTK OST (Part 1)", "Drama", "Various", 30.95f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		CompactDisc cd2 = new CompactDisc("ROTK OST (Part 2)", "Drama", "Various", 25.99f);
		cd2.addTrack(track3);
		CompactDisc cd3 = new CompactDisc("Classical Hits", "Classical", "Beethoven", 40.00f);
		cd3.addTrack(track4);
		CompactDisc cd4 = new CompactDisc("Summer Vibes", "Pop", "Various", 15.95f);
		cd4.addTrack(track5);
		CompactDisc cd5 = new CompactDisc("The Best of Rock", "Rock", "Various", 25.50f);
		cd5.addTrack(track6);
		CompactDisc cd6 = new CompactDisc("Jazz Essentials", "Jazz", "Various", 29.99f);
		cd6.addTrack(track7);
		CompactDisc cd7 = new CompactDisc("Reggae Rhythms", "Reggae", "Various", 18.50f);
		cd7.addTrack(track8);

		// Create Cart and Add Media
		Cart myCart = new Cart();
		myCart.addMedia(dvd1);
		myCart.addMedia(dvd2);
		myCart.addMedia(dvd3);
		myCart.addMedia(dvd4);
		myCart.addMedia(dvd5);
		myCart.addMedia(dvd6);
		myCart.addMedia(dvd7);
		myCart.addMedia(dvd8);
		myCart.addMedia(dvd9);
		myCart.addMedia(dvd10);
		myCart.addMedia(cd1);
		myCart.addMedia(cd2);
		myCart.addMedia(cd3);
		myCart.addMedia(cd4);
		myCart.addMedia(cd5);
		myCart.addMedia(cd6);
		myCart.addMedia(cd7);

		// Create Store and Display Cart Screen
		Store myStore = new Store();
		new CartScreen(myStore, myCart);
	}

}

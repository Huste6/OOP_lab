package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

	public AddBookToStoreScreen(Store store, Cart cart) {
		super(store, cart);

		JFrame frame = this; // Reference to this frame

		// Create and configure the JFXPanel for embedding JavaFX
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel); // Add JFXPanel to the Swing container

		this.setTitle("Add Book to Store");
		this.setSize(800, 600); // Set the window size
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle window close

		// Initialize JavaFX inside Platform.runLater to ensure it runs on the JavaFX
		// thread
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					// Load the FXML file for the JavaFX interface
					FXMLLoader loader = new FXMLLoader(getClass().getResource("addBookToStore.fxml"));

					// Create the controller and pass the store and cart
					AddBookToStoreScreenController controller = new AddBookToStoreScreenController(store, cart, frame);
					loader.setController(controller);

					// Load the FXML layout
					Parent root = loader.load();

					// Set the scene for the JavaFX panel
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace(); // Handle exceptions during FXML loading
				}
			}
		});

		this.setVisible(true);
	}

	public static void main(String[] args) {
		// Initialize the store and cart and show the AddBookToStoreScreen
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new AddBookToStoreScreen(new Store(), new Cart());
			}
		});
	}
}

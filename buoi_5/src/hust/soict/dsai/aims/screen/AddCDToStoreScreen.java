package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddCDToStoreScreen extends AddItemToStoreScreen {

	public AddCDToStoreScreen(Store store, Cart cart) {
		super(store, cart);

		JFrame frame = this;

		// Initialize JavaFX panel
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setTitle("Add CD to Store");
		this.setSize(800, 600); // Set default window size
		this.setVisible(true);

		// Run JavaFX setup on the JavaFX thread
		Platform.runLater(() -> {
			try {
				FXMLLoader loader = new FXMLLoader(
						getClass().getResource("/hust/soict/dsai/aims/screen/addCDToStore.fxml"));
				AddCDToStoreScreenController controller = new AddCDToStoreScreenController(store, cart, frame);
				loader.setController(controller);
				Parent root = loader.load();
				fxPanel.setScene(new Scene(root));
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Error loading FXML: " + e.getMessage());
			}
		});
	}

	public static void main(String[] args) {
		// Launching the Swing-JavaFX integrated application
		new AddCDToStoreScreen(new Store(), new Cart());
	}
}

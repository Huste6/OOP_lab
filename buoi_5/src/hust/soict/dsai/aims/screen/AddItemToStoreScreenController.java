package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public abstract class AddItemToStoreScreenController {
	protected Store store;
	protected Cart cart;
	private JFrame stage; // Swing JFrame to manage the window

	protected String title;
	protected String category;
	protected float cost;

	@FXML
	protected TextField tfTitle; // JavaFX TextField for user input
	@FXML
	protected TextField tfCategory;
	@FXML
	protected TextField tfCost;

	public AddItemToStoreScreenController(Store store, Cart cart, JFrame stage) {
		super();
		this.store = store;
		this.cart = cart;
		this.stage = stage; // Used to hide JFrame later
	}

	@FXML
	public void initialize() {
		// Setting up listeners for changes in the text fields
		tfTitle.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				title = newValue; // Capture title input
			}
		});

		tfCategory.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				category = newValue; // Capture category input
			}
		});

		tfCost.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					cost = Float.parseFloat(newValue); // Capture and convert cost input
				} catch (NumberFormatException e) {
					cost = 0f; // Default to 0 if the input is invalid
				}
			}
		});
	}

	@FXML
	protected void viewStore() {
		// Navigate to Store screen
		new StoreScreen(store, cart);
		stage.hide(); // Hide the current JFrame
	}

	@FXML
	protected void viewCart() {
		// Navigate to Cart screen
		new CartScreen(store, cart);
		stage.hide(); // Hide the current JFrame
	}

	@FXML
	protected void addBookToStore() {
		// Navigate to AddBook screen
		new AddBookToStoreScreen(store, cart);
		stage.hide(); // Hide the current JFrame
	}

	@FXML
	protected void addCDToStore() {
		// Navigate to AddCD screen
		new AddCDToStoreScreen(store, cart);
		stage.hide(); // Hide the current JFrame
	}

	@FXML
	protected void addDVDToStore() {
		// Navigate to AddDVD screen
		new AddDVDToStoreScreen(store, cart);
		stage.hide(); // Hide the current JFrame
	}

	@FXML
	protected abstract void addBtnPressed(); // Abstract method to be implemented in subclasses
}

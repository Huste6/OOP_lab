package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.DupplicatedItemException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class AddDVDToStoreScreenController extends AddItemToStoreScreenController {
	private String director;
	private int length;
	private Media dvd;

	@FXML
	private TextField tfDirector;

	@FXML
	private TextField tfLength;

	public AddDVDToStoreScreenController(Store store, Cart cart, JFrame stage) {
		super(store, cart, stage);
	}

	@FXML
	public void initialize() {
		// Listen for changes in the director's field
		tfDirector.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				director = newValue; // Update director value when changed
			}
		});

		// Listen for changes in the length field and validate input as integer
		tfLength.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					length = Integer.parseInt(newValue); // Parse the integer length value
				} catch (NumberFormatException e) {
					length = 0; // Default to 0 if parsing fails
				}
			}
		});

		super.initialize(); // Call parent initialize method
	}

	@FXML
	@Override
	protected void addBtnPressed() {
		// Create a new DVD object
		dvd = new DigitalVideoDisc(this.title, this.category, this.director, this.length, this.cost);

		try {
			// Try adding the DVD to the store
			store.addMedia(dvd);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Notification");
			alert.setHeaderText("Success");
			alert.setContentText(dvd.getTitle() + " has been added to the store");
			alert.showAndWait();
		} catch (DupplicatedItemException e) {
			// Handle case where DVD already exists in store
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Notification");
			alert.setHeaderText("Failure");
			alert.setContentText("Failed to add DVD. Please enter valid information.");
			alert.showAndWait();
		}
	}
}

package hust.soict.dsai.aims.screen;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.DupplicatedItemException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

public class AddBookToStoreScreenController extends AddItemToStoreScreenController {
	private Book book;
	private ArrayList<String> authors = new ArrayList<>();
	private int numPages;

	@FXML
	private TextField tfAuthors;

	@FXML
	private TextField tfNumPages;

	public AddBookToStoreScreenController(Store store, Cart cart, JFrame stage) {
		super(store, cart, stage);
	}

	public void initialize() {
		// Ensure proper handling of numeric input for `tfNumPages`
		tfNumPages.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					numPages = Integer.parseInt(newValue);
				} catch (NumberFormatException e) {
					numPages = 0; // Reset if input is invalid
				}
			}
		});

		super.initialize(); // Call parent class initialization if required
	}

	@FXML
	private void addAuthorBtnPressed() {
		// Prompt user to input an author name
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Add Author");
		dialog.setHeaderText("Add a new author to the book");
		dialog.setContentText("Enter author name:");

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			String author = result.get().trim();
			if (!authors.contains(author) && !author.isEmpty()) {
				authors.add(author);
				if (tfAuthors.getText().isEmpty()) {
					tfAuthors.setText(author);
				} else {
					tfAuthors.setText(tfAuthors.getText() + ", " + author);
				}
			} else {
				// Show error alert if the author name is duplicate or empty
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Invalid Author");
				alert.setContentText("Author name is either empty or already exists in the list.");
				alert.showAndWait();
			}
		}
	}

	@FXML
	@Override
	protected void addBtnPressed() {
		// Create a new book and add authors
		book = new Book(this.title, this.category, this.numPages, this.cost);
		for (String author : authors) {
			try {
				book.addAuthor(author);
			} catch (DupplicatedItemException e) {
				// Handle duplicate authors
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Duplicate Author");
				alert.setContentText("The list of authors contains duplicate names.");
				alert.showAndWait();
				tfAuthors.setText(""); // Clear the authors field to retry
				return;
			}
		}

		// Try to add the book to the store
		try {
			store.addMedia(book);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success");
			alert.setHeaderText("Book Added");
			alert.setContentText(book.getTitle() + " has been successfully added to the store.");
			alert.showAndWait();
		} catch (DupplicatedItemException e) {
			// Handle duplicate books in the store
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Duplicate Book");
			alert.setContentText("The book already exists in the store.");
			alert.showAndWait();
		}
	}
}

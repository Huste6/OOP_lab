module buoi_5 {
	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.swing;
	requires java.base;

	// Mở các package để khai thác với JavaFX
	opens hust.soict.dsai.aims.media to javafx.base;
	opens hust.soict.dsai.aims.cart to javafx.fxml;
	opens hust.soict.dsai.aims.store to javafx.fxml;
	opens hust.soict.dsai.aims.screen to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}

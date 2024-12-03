package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;

public class cartTest {
	public static void main(String[] args) {
		Cart cart = new Cart();

		// Tạo các mục Media
		DigitalVideoDisc dvd = new DigitalVideoDisc("Inception", "Sci-Fi", 19.99f, 148, "Christopher Nolan");
		Book book = new Book("The Great Gatsby", "Fiction", 10.99f);
		CompactDisc cd = new CompactDisc("Greatest Hits", "Music", 15.99f, 60, "Various Artists", "John Doe");

		Track track1 = new Track("Song A", 4);
		Track track2 = new Track("Song B", 5);
		cd.addTrack(track1);
		cd.addTrack(track2);

		// Thêm vào giỏ hàng
		cart.addMedia(dvd);
		cart.addMedia(book);
		cart.addMedia(cd);

		// Hiển thị giỏ hàng
		cart.printCart();

		// Xóa mục khỏi giỏ hàng
		cart.removeMedia(book);
		cart.printCart();

	}
}

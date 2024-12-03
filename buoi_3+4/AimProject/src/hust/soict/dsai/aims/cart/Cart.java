package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class Cart {
//	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<>();

	// thêm media vào giỏ hàng
	public void addMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			System.out.println(media.getTitle() + " đã tồn tại!");
		} else {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " đã được thêm vào thành công!");
		}
	}

	// xóa media vào giỏ hàng
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Đã xóa " + media.getTitle() + " thành công!");
		} else {
			System.out.println(media.getTitle() + " không tồn tại trong list!");
		}
	}

	public void emptyCart() {
		for (Media m : itemsOrdered) {
			itemsOrdered.remove(m);
		}
	}

	public float totalCost() {
		float sum = 0.0f;
		for (Media media : itemsOrdered) {
			sum += media.getCost();
		}
		return sum;
	}

	public void printCart() {
		System.out.println("---------------------------------------");
		System.out.println("Order Items: ");
		for (Media m : itemsOrdered) {
			System.out.println(m.toString());
		}
		System.out.println("Total Cost: " + totalCost() + "$");
		System.out.println("---------------------------------------");
	}

	// tìm kiếm trong giỏ hàng
	// tìm kiếm theo ID
	public Media search(int id) {
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				System.out.println("Tìm thấy media: " + media.toString());
				return media;
			}
		}
		System.out.println("Không tìm thấy media với ID: " + id);
		return null;
	}

	// tìm kiếm theo title
	public Media search(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Tìm thấy media: " + media.toString());
				return media;
			}
		}
		System.out.println("Không tìm thấy media với title: " + title);
		return null;
	}

	public void sortCart(int command) {
		if (command == 0) {
			// Sort by title
			itemsOrdered.sort(Comparator.comparing(Media::getTitle));
			System.out.println("Giỏ hàng đã được sắp xếp theo title.");
		} else if (command == 1) {
			// Sort by cost
			itemsOrdered.sort(Comparator.comparing(Media::getCost));
			System.out.println("Giỏ hàng đã được sắp xếp theo cost.");
		} else {
			System.out.println("Lựa chọn sắp xếp không hợp lệ.");
		}
	}

//	public void printOrder() {
//		System.out.println("Order Items: ");
//		for (DigitalVideoDisc dvd : itemsOrdered) {
//			System.out.println("- " + dvd.getTitle() + "---Cost: " + dvd.getCost());
//		}
//	}

//	//6.Open the Cart class
//	public void printCart() {
//		 int i=1;
//		 System.out.println("***********************CART***********************");
//		 System.out.println("Ordered Items:");
//		 for (DigitalVideoDisc dvd : itemsOrdered) {
//			 System.out.println(i + ". "+ dvd.toString()+ "$");
//			 i++;
//		 }
//		 System.out.println("Total cost: " + this.totalCost());
//		 System.out.println("**************************************************");
//	}
//	

	// Search Cart
	// search by id
//	public void searchCart(int id) {
//		int index = -1;
//		for (DigitalVideoDisc dvd : itemsOrdered) {
//			 if(dvd.getId() == id) {
//				 System.out.println("dvd found by Id: " + dvd.getTitle());
//				 index = 1;
//				 return;
//			 }
//		}
//		if(index == -1) {
//			System.out.println("Not found dvd!");
//		}
//	}
//	public void searchCart(String title) {
//		int index = -1;
//		for (DigitalVideoDisc dvd : itemsOrdered) {
//			 if(dvd.getTitle() == title) {
//				 System.out.println("dvd found by Title: " + dvd.getTitle());
//				 index = 1;
//				 return;
//			 }
//		}
//		if(index == -1) {
//			System.out.println("Not found dvd!");
//		}
//
//	}
	// End Search Cart
}

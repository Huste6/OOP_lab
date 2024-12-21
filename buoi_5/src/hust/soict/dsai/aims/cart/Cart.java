package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exception.CartFullException;
import hust.soict.dsai.aims.exception.NonExistingItemException;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	private static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public void addMedia(Media medium) throws CartFullException {
		if (this.itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			throw new CartFullException("Giỏ hàng đã đầy.");
		} else {
			this.itemsOrdered.add(medium);
			System.out.println(medium.getTitle() + " đã được thêm vào giỏ hàng.");
		}
	}

	public void removeMedia(Media medium) throws NonExistingItemException {
		if (this.itemsOrdered.remove(medium)) {
			System.out.println(medium.getTitle() + " đã được xóa khỏi giỏ hàng.");
		} else {
			throw new NonExistingItemException(medium.getTitle() + " không có trong giỏ hàng.");
		}
	}

	public float totalCost() {
		float cost = 0.0f;
		for (Media medium : itemsOrdered) {
			cost += medium.getCost();
		}
		cost = (float) (Math.round(cost * 100.0) / 100.0);
		return cost;
	}

	public void print() {
		System.out.println("\n***********************GIỎ HÀNG***********************");
		System.out.println("Các sản phẩm trong giỏ hàng:");
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			System.out.println(Integer.toString(i + 1) + ".\t" + this.itemsOrdered.get(i).getDetails() + "\n");
		}
		System.out.println("Tổng chi phí: " + "$" + this.totalCost());
		System.out.println("***************************************************");
		System.out.println("\n");
	}

	public boolean filterMedia(int id) {
		boolean found = false;
		int qty = 0;
		float cost = 0f;
		System.out.println("\n******************KẾT QUẢ TÌM KIẾM********************");
		System.out.println("Mã sản phẩm: " + id);
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).getID() == id) {
				System.out.println(Integer.toString(i + 1) + ".\t" + this.itemsOrdered.get(i).getDetails() + "\n");
				qty += 1;
				cost = this.itemsOrdered.get(i).getCost();
				found = true;
			}
		}
		if (found) {
			System.out.println("Tổng số sản phẩm có mã " + id + " tìm thấy: " + qty);
			System.out.println("Tổng chi phí cho các sản phẩm này: " + "$" + (cost * qty));
			System.out.println("***************************************************");
			System.out.println("\n");
			return true;
		} else {
			System.out.println("Không có sản phẩm nào trong giỏ hàng.");
			System.out.println("***************************************************");
			System.out.println("\n");
			return false;
		}
	}

	public boolean filterMedia(String title) {
		boolean found = false;
		int qty = 0;
		float cost = 0f;
		System.out.println("\n******************KẾT QUẢ TÌM KIẾM********************");
		System.out.println("Tên sản phẩm: " + title);
		for (int i = 0; i < this.itemsOrdered.size(); i++) {
			if (this.itemsOrdered.get(i).search(title)) {
				System.out.println(Integer.toString(i + 1) + ".\t" + this.itemsOrdered.get(i).getDetails() + "\n");
				qty += 1;
				cost = this.itemsOrdered.get(i).getCost();
				found = true;
			}
		}
		if (found) {
			System.out.println("Tổng số sản phẩm có tên " + title + " tìm thấy: " + qty);
			System.out.println("Tổng chi phí cho các sản phẩm này: " + "$" + (cost * qty));
			System.out.println("***************************************************");
			System.out.println("\n");
			return true;
		} else {
			System.out.println("Không có sản phẩm nào trong giỏ hàng!");
			System.out.println("***************************************************");
			System.out.println("\n");
			return false;
		}
	}

	public Media searchMedia(String title) {
		for (Media medium : this.itemsOrdered) {
			if (medium.getTitle().toLowerCase().equals(title.toLowerCase())) {
				return medium;
			}
		}
		return null;
	}

	public void sortByTitle() {
		FXCollections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortByCost() {
		FXCollections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}

	public int getSize() {
		return this.itemsOrdered.size();
	}

	public ObservableList<Media> getItemsOrdered() {
		return this.itemsOrdered;
	}

	public void empty() {
		this.itemsOrdered.clear();
	}
}

package hust.soict.dsai.aims.store;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.DupplicatedItemException;
import hust.soict.dsai.aims.exception.NonExistingItemException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private List<Media> itemsInStore = new ArrayList<>();
	private Store store;

	public void addMedia(Media medium) throws DupplicatedItemException {
		if (medium == null || medium.getTitle() == null) {
			throw new IllegalArgumentException("Media hoặc tiêu đề không được để trống.");
		}
		if (this.itemsInStore.contains(medium)) {
			throw new DupplicatedItemException("Sản phẩm \"" + medium.getTitle() + "\" đã tồn tại trong cửa hàng.");
		}
		medium.setDateAdded(LocalDate.now());
		this.itemsInStore.add(medium);
		System.out.println("\"" + medium.getTitle() + "\" đã được thêm vào cửa hàng.");
	}

	public void removeMedia(Media medium) throws NonExistingItemException {
		if (medium == null || medium.getTitle() == null) {
			throw new IllegalArgumentException("Media hoặc tiêu đề không được để trống.");
		}
		if (this.itemsInStore.remove(medium)) {
			System.out.println("\"" + medium.getTitle() + "\" đã được xóa khỏi cửa hàng.");
		} else {
			throw new NonExistingItemException("Sản phẩm \"" + medium.getTitle() + "\" không có trong cửa hàng.");
		}
	}

	public Media searchMedia(String title) {
		if (title == null) {
			throw new IllegalArgumentException("Tiêu đề không được để trống.");
		}
		for (Media medium : this.itemsInStore) {
			if (medium.getTitle().equalsIgnoreCase(title)) {
				return medium;
			}
		}
		return null;
	}

	public void print() {
		System.out.println("\n************* DANH SÁCH SẢN PHẨM TRONG CỬA HÀNG **************");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.printf("%d. %s - %s%n", i + 1, this.itemsInStore.get(i).getTitle(),
					this.itemsInStore.get(i).getType());
		}
		System.out.println("*************************************************************\n");
	}

	public List<Media> getItemsInStore() {
		return new ArrayList<>(this.itemsInStore); // Trả về bản sao của danh sách
	}

	public void loadDataFromFile(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				String type = fields[0];
				String title = fields[1];
				String category = fields[2];
				String creator = fields[3];
				int length = Integer.parseInt(fields[4]);
				float cost = Float.parseFloat(fields[5]);

				if (type.equalsIgnoreCase("DVD")) {
					store.addMedia(new DigitalVideoDisc(title, category, creator, length, cost));
				} else if (type.equalsIgnoreCase("CD")) {
					store.addMedia(new CompactDisc(title, category, creator, cost));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
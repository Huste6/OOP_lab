package aimsProject;

import java.util.ArrayList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private int qtyOrdered;
	private ArrayList<DigitalVideoDisc> itemsOrdered;

	public Cart() {
		itemsOrdered = new ArrayList<>();
		qtyOrdered = 0;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(dvd);
			qtyOrdered++;
			System.out.println("The disc \"" + dvd.getTitle() + "\" has been added.");
		} else {
			System.out.println("The order is almost full. Cannot add more DVDs.");
		}

	}

	public float totalCost() {
		float sum = 0.0f;
		for (DigitalVideoDisc dvd : itemsOrdered) {
			sum += dvd.getCost();
		}
		return sum;
	}

	public void printOrder() {
		System.out.println("Order Items: ");
		for (DigitalVideoDisc dvd : itemsOrdered) {
			System.out.println("- " + dvd.getTitle() + "---Cost: " + dvd.getCost());
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
		if (itemsOrdered.remove(dvd)) {
			qtyOrdered--;
			System.out.println("The disc \"" + dvd.getTitle() + "\" has been removed.");
		} else {
			System.out.println("Not found " + dvd.getTitle());
		}
	}
}

package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

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
	
	//Overloading 
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for(DigitalVideoDisc dvd:dvdList) {
			if(qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered.add(dvd);
				qtyOrdered++;
				System.out.println("The disc \"" + dvd.getTitle() + "\" has been added.");
			}else {
				System.out.println("The order is almost full. Cannot add more DVDs.");
			}
		}
	}
//	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
//		for(DigitalVideoDisc dvd:dvdList) {
//			if(qtyOrdered < MAX_NUMBERS_ORDERED) {
//				itemsOrdered.add(dvd);
//				qtyOrdered++;
//				System.out.println("The disc \"" + dvd.getTitle() + "\" has been added.");
//			}else {
//				System.out.println("The order is almost full. Cannot add more DVDs.");
//			}
//		}
//	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {

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
	
	//6.Open the Cart class
	public void printCart() {
		 int i=1;
		 System.out.println("***********************CART***********************");
		 System.out.println("Ordered Items:");
		 for (DigitalVideoDisc dvd : itemsOrdered) {
			 System.out.println(i + ". "+ dvd.toString()+ "$");
			 i++;
		 }
		 System.out.println("Total cost: " + this.totalCost());
		 System.out.println("**************************************************");
	}
	
	
	public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
		if (itemsOrdered.remove(dvd)) {
			qtyOrdered--;
			System.out.println("The disc \"" + dvd.getTitle() + "\" has been removed.");
		} else {
			System.out.println("Not found " + dvd.getTitle());
		}
	}
	
	// Search Cart
	//search by id
	public void searchCart(int id) {
		int index = -1;
		for (DigitalVideoDisc dvd : itemsOrdered) {
			 if(dvd.getId() == id) {
				 System.out.println("dvd found by Id: " + dvd.getTitle());
				 index = 1;
				 return;
			 }
		}
		if(index == -1) {
			System.out.println("Not found dvd!");
		}
	}
	public void searchCart(String title) {
		int index = -1;
		for (DigitalVideoDisc dvd : itemsOrdered) {
			 if(dvd.getTitle() == title) {
				 System.out.println("dvd found by Title: " + dvd.getTitle());
				 index = 1;
				 return;
			 }
		}
		if(index == -1) {
			System.out.println("Not found dvd!");
		}

	}
	// End Search Cart
}

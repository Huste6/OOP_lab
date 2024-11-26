package aimsProject;

public class Store {
    private DigitalVideoDisc itemsStore[];
    private int numberOfDiscs;

    public Store(int maxNumberOfDiscs) {
        this.itemsStore = new DigitalVideoDisc[maxNumberOfDiscs];
        this.numberOfDiscs = 0;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (numberOfDiscs < itemsStore.length) {
            itemsStore[numberOfDiscs] = dvd;
            numberOfDiscs++;
            System.out.println("The disc \"" + dvd.getTitle() + "\" has been added.");
        } else {
            System.out.println("The order is almost full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (numberOfDiscs == 0) {
            System.out.println("The cart is empty!");
            return;
        }

        int index = -1;
        for (int i = 0; i < numberOfDiscs; i++) {
            if (itemsStore[i].equals(dvd)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < numberOfDiscs - 1; i++) {
                itemsStore[i] = itemsStore[i + 1];
            }
            itemsStore[numberOfDiscs - 1] = null;
            numberOfDiscs--;
            System.out.println("Remove dvd success!");
        } else {
            System.out.println("Can't found dvd to remove!");
        }
    }

    public void printStore() {
        System.out.println("------------------------------------");
        for (int i = 0; i < numberOfDiscs; i++) {
            if (itemsStore[i] != null) {
                System.out.println(i + 1 + ". " + itemsStore[i].toString());
            }
        }
        System.out.println("------------------------------------");
    }
}
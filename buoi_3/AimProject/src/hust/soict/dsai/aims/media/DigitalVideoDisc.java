package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
	// 5.Classifier Member and Instance Member
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
		nbDigitalVideoDiscs++;
	}

	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - "
				+ this.getLength() + " : " + this.getCost();
	}
}

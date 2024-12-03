package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	// 5.Classifier Member and Instance Member
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
		nbDigitalVideoDiscs++;
	}

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - "
				+ this.getLength() + " : " + this.getCost();
	}
}

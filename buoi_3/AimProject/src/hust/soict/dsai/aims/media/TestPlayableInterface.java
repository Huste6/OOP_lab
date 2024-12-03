package hust.soict.dsai.aims.media;

public class TestPlayableInterface {
	public static void main(String[] args) {
		// Tạo DVD
		DigitalVideoDisc dvd = new DigitalVideoDisc("Interstellar", "Sci-Fi", 24.99f, 169, "Christopher Nolan");
		dvd.play();

		// Tạo Tracks
		Track track1 = new Track("Song A", 4);
		Track track2 = new Track("Song B", 5);

		// Tạo CD
		CompactDisc cd = new CompactDisc("Greatest Hits", "Music", 15.0f, 60, "Various Artists", "John Doe");
		cd.addTrack(track1);
		cd.addTrack(track2);

		// Play CD
		cd.play();
	}
}

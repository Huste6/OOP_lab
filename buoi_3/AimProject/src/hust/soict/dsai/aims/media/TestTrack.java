package hust.soict.dsai.aims.media;

public class TestTrack {
	public static void main(String[] args) {
		CompactDisc cd = new CompactDisc("Hits of 2024", "Music", 15.0f, 60, "John Doe", "Various Artists");
		Track track1 = new Track("Song 1", 4);
		Track track2 = new Track("Song 2", 5);
		Track track3 = new Track("Song 1", 4);

		// add track
		cd.addTrack(track1);
		cd.addTrack(track2);
		cd.addTrack(track3);

		// delete track
		cd.removeTrack(track1);

		System.out.println("Total length of cd: " + cd.getLength());
	}
}

package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<>();

	// contructor
	public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
		super(title, category, cost, length, director);
		this.artist = artist;
	}

	// getter and setter
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	// addTrack
	public void addTrack(Track track) {
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Track " + track.getTitle() + " added to list tracks!");
		} else {
			System.out.println("Track " + track.getTitle() + " đã tồn tại!");
		}
	}

	// removeTrack
	public void removeTrack(Track track) {
		if (!tracks.contains(track)) {
			System.out.println("Track " + track.getTitle() + " does not exist in list tracks!");
		} else {
			tracks.remove(track);
			System.out.println("Removed " + track.getTitle() + " successfully!");
		}
	}

	// getLength
	public int getLength() {
		int sum = 0;
		for (Track t : tracks) {
			sum += t.getLength();
		}
		return sum;
	}
}

package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.DupplicatedItemException;
import hust.soict.dsai.aims.exception.NonExistingItemException;
import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public void addTrack(Track track) throws DupplicatedItemException {
		if (this.tracks.contains(track)) {
			throw new DupplicatedItemException(
					"The track " + track.getTitle() + " is already in the tracklist of " + this.getTitle());
		} else {
			this.tracks.add(track);
			System.out.println(
					"The track " + track.getTitle() + " has been added to the tracklist of " + this.getTitle());
		}
	}

	public void removeTrack(Track track) throws NonExistingItemException {
		if (this.tracks.remove(track)) {
			System.out.println(
					"The track " + track.getTitle() + " has been removed from the tracklist of " + this.getTitle());
		} else {
			throw new NonExistingItemException(
					"The track " + track.getTitle() + " is not in the tracklist of " + this.getTitle());
		}
	}

	public int getLength() {
		int totalLength = 0;
		for (Track track : this.tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}

	public void play() throws PlayerException {
		if (this.getLength() <= 0) {
			throw new PlayerException("ERROR: CD length is non-positive!");
		} else {
			System.out.println("Playing CD: " + this.getTitle());
			for (Track track : this.tracks) {
				try {
					track.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
		}
	}

	public String getType() {
		return "CD";
	}

	public String getDetails() {
		StringBuffer tracklist = new StringBuffer();
		if (this.tracks.size() >= 1) {
			tracklist.append(this.tracks.get(0).getTitle());
			for (int i = 1; i < this.tracks.size(); i++) {
				tracklist.append(", " + this.tracks.get(i).getTitle());
			}
		}
		return ("Product ID: " + String.valueOf(this.getID()) + "\n" + "\t" + "Title: " + this.getTitle() + "\n" + "\t"
				+ "Category: " + this.getCategory() + "\n" + "\t" + "Artist: " + this.getArtist() + "\n" + "\t"
				+ "Director: " + this.getDirector() + "\n" + "\t" + "Tracklist: " + tracklist + "\n" + "\t" + "Length: "
				+ String.valueOf(this.getLength()) + " minutes" + "\n" + "\t" + "Price: $"
				+ String.valueOf(this.getCost()));
	}

	public CompactDisc(String title, String category, String artist, String director, float cost) {
		super(title, category, director, cost);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public CompactDisc(String title, String category) {
		super(title, category);
	}

	public CompactDisc(String title) {
		super(title);
	}

	public String getArtist() {
		return artist;
	}
}

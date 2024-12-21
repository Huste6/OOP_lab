package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private int length;

	// Constructor
	public Track(String title, int length) {
		if (title == null || title.isBlank()) {
			throw new IllegalArgumentException("Title cannot be null or empty.");
		}
		if (length < 0) {
			throw new IllegalArgumentException("Length cannot be negative.");
		}
		this.title = title;
		this.length = length;
	}

	public Track(String title) {
		this(title, 0); // Default length to 0
	}

	// Getters
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	// Overridden equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof Track) {
			Track other = (Track) obj;
			return this.length == other.length && this.title.equalsIgnoreCase(other.title);
		}
		return false;
	}

	// Implementation of play method
	@Override
	public void play() throws PlayerException {
		if (this.length <= 0) {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
		if (this.title == null || this.title.isBlank()) {
			throw new PlayerException("ERROR: Track title is not set!");
		}

		System.out.println("Playing track: " + this.title);
		System.out.println("Track length: " + this.length + " minutes");
	}
}

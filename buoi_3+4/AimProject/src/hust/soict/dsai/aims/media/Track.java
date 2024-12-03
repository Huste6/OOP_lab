package hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable {
	private String title;
	private int length;

	// contructor
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	// getter and setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Track track = (Track) o;
		return this.length == track.length && Objects.equals(this.title, track.title);
	}
}

package model;

import java.awt.Image;

public class FrameView {
	private Image image;
	private long time;

	public FrameView(Image image, long time) {
		super();
		this.image = image;
		this.time = time;
	}

	public Image getImage() {
		return image;
	}

	public long getTime() {
		return time;
	}

}

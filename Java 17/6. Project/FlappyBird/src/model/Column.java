package model;

import java.awt.Graphics2D;
import java.awt.Image;



public class Column {
	public static final int BOT = 1;
	public static final int TOP = 2;
	private int x;
	private int y;
	private Image image;
	public Column(int x, int y, int type) {
		this.x = x;
		this.y = y;
		if (type == 1) {
			image=Loader.loadImage("columnBot.png");
		} else if (type == 2) {
			image = Loader.loadImage("columnTop.png");
		}
	}

	public void draw(Graphics2D g2d) {
		g2d.drawImage(this.image, this.x, this.y, null);
	}

	public void update() {
		this.x -= 2;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getWidth() {
		return this.image.getWidth(null);
	}

	public int getHeight() {
		return this.image.getHeight(null);
	}

}

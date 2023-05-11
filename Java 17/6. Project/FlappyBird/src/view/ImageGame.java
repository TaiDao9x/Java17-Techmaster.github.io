package view;

import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import model.Loader;

public class ImageGame extends DecorateBut {

	private int numBut;
	public static final int imgPlay = 1;
	public static final int imgGuide = 2;
	public static final int imgAbout = 3;
	public static final int imgRank = 4;
	public static final int imgExit = 5;

	public ImageGame(AbstractButton c, int numBut) {
		super(c);

		this.numBut = numBut;
		setImage();

	}

	private void setImage() {
		switch (numBut) {
		case 1:
			btn.setIcon(new ImageIcon(Loader.loadImage("play1.png")));
			btn.setMargin(new Insets(0, 0, 0, 0));
			btn.setBorderPainted(false);
			btn.setContentAreaFilled(false);
			btn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

			setBounds(350, 370, 110, 58);
			break;
		case 2:
			btn.setIcon(new ImageIcon(Loader.loadImage("guide.png")));
			btn.setMargin(new Insets(0, 0, 0, 0));
			btn.setBorderPainted(false);
			btn.setContentAreaFilled(false);
			btn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			setBounds(230, 420, 110, 58);
			break;

		case 3:
			btn.setIcon(new ImageIcon(Loader.loadImage("about.png")));
			btn.setMargin(new Insets(0, 0, 0, 0));
			btn.setBorderPainted(false);
			btn.setContentAreaFilled(false);
			btn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			setBounds(470, 420, 110, 58);
			break;
		case 4:
			btn.setIcon(new ImageIcon(Loader.loadImage("rank.png")));
			btn.setMargin(new Insets(0, 0, 0, 0));
			btn.setBorderPainted(false);
			btn.setContentAreaFilled(false);
			btn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			setBounds(350, 470, 110, 58);
			break;
		case 5:
			btn.setIcon(new ImageIcon(Loader.loadImage("exit.png")));
			btn.setMargin(new Insets(0, 0, 0, 0));
			btn.setBorderPainted(false);
			btn.setContentAreaFilled(false);
			btn.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			setBounds(130, 510, 110, 58);

			break;
		}

	}

	public int getNumBut() {
		return numBut;
	}

}

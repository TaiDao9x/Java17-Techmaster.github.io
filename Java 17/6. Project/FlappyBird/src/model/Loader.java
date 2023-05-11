package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Loader {
	private static  Loader loader=new Loader() ;

	public static Image loadImage(String filename) {
		return new ImageIcon(loader.getClass().getResource("/images/" + filename)).getImage();
	}
	
}

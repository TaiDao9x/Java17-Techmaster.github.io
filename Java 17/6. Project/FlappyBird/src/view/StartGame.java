package view;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Loader;

public class StartGame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<ImageGame> listBtn = new ArrayList<>();

	public StartGame() {
		JLabel lb = new JLabel();
		lb.setIcon(new ImageIcon(Loader.loadImage("startgame.png")));
		ImageGame btnPlay, btnGuide, btnRank, btnExit, btnAbout;
		lb.add(btnPlay = new ImageGame(new JButton(), ImageGame.imgPlay));
		lb.add(btnGuide = new ImageGame(new JButton(), ImageGame.imgGuide));
		lb.add(btnAbout = new ImageGame(new JButton(), ImageGame.imgAbout));
		lb.add(btnRank = new ImageGame(new JButton(), ImageGame.imgRank));
		lb.add(btnExit = new ImageGame(new JButton(), ImageGame.imgExit));
		listBtn.add(btnPlay);
		listBtn.add(btnGuide);
		listBtn.add(btnAbout);
		listBtn.add(btnRank);
		listBtn.add(btnExit);

		add(lb);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}
	

	public ArrayList<ImageGame> getListBtn() {
		return listBtn;
	}


	public static void main(String[] args) {
		new StartGame();
	}

}

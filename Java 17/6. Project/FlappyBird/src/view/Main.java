
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Score;

public class Main extends JFrame {
	GameView game;

	public static final int WIDTH = 800, HEIGHT = 512;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main() {
		game = new GameView();
		setTitle("Flappy Bird");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/icon.png")));
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(3);
		this.setResizable(false);
		getContentPane().add(game);
		this.setVisible(true);
		this.setLocation(500, 100);

	}

	public GameView getGame() {
		return game;
	}

}

package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import model.Model;
import model.Score;

public class GameView extends JPanel {
	private Model model;

	public GameView() {

		this.requestFocusInWindow();
		this.setFocusable(true);

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		model.draw(g2d);
	}

	public void setModel(Model model) {
		this.model = model;
	}

}

package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Bird;
import model.Model;
import model.Sound;
import view.Main;

public class ControllerGame implements Runnable, KeyListener, MouseListener {
	Model model;
	Main view;

	public ControllerGame() {

		this.model = new Model();
		this.view = new Main();
		view.addKeyListener(this);
		view.addMouseListener(this);
		view.setFocusable(true);
		view.requestFocusInWindow();
		view.getGame().setModel(this.model);

	}

	public void startGame() {
		new Thread(this).start();

	}

	@Override
	public void run() {
		while (true) {
		
			view.repaint();
			model.update();
			
			died();

			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void died() {
		model.died();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!model.isPlaying()) {

			model.setPlaying();
		}
		model.getBird().setFly(Bird.BOUNCE);
		Sound.FLAP.play();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		model.getBird().setFly(Bird.FALL);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 32) {
			if (!model.isPlaying()) {

				model.setPlaying();
			}
			model.getBird().setFly(Bird.BOUNCE);
			Sound.FLAP.play();
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			model.changeState();;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		model.getBird().setFly(Bird.FALL);

	}

	@Override
	public void keyTyped(KeyEvent e) {

		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		ControllerGame m = new ControllerGame();

	}

}

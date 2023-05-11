package model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import view.Main;

public class Obstacle {
	public static final int SPACE_BOT_TOP = 100, SPACE_TWO_OBSTACLE = 200;
	private Column columnBot;
	private Column columnTop;
	private int distance;
	private final int[] y_Values = { 0, -50, -100, -150, -200 };

	public Obstacle(int x, int y) {
		columnTop = new Column(x, y, 2);
		columnBot = new Column(x, y + columnTop.getHeight() + SPACE_BOT_TOP, 1);

	}

	public Obstacle() {
	}

	public void draw(Graphics2D g2d) {
		columnTop.draw(g2d);
		columnBot.draw(g2d);
	}

	public void update() {
		columnTop.update();
		columnBot.update();
	}

	public int getWidth() {
		return columnTop.getWidth();
	}

	public int getX() {
		return columnTop.getX();
	}

	public boolean isHit(Bird bird) {
		int xHv = bird.getX() + 5;
		int yHv = bird.getY();
		int height = bird.getHeight();
		if ((xHv + height >= getX()) && (xHv <= getX() + getWidth())) {
			if ((yHv <= this.columnTop.getY() + this.columnTop.getHeight()) || 
					(yHv + height >= this.columnBot.getY())) {
				return true;
			}
		}
		return false;
	}

	public void addObstacle(ArrayList<Obstacle> obstacles) {
	
		if (distance < Obstacle.SPACE_TWO_OBSTACLE) {
			distance += BackGround.SPEED;
		} else {
			obstacles.add(new Obstacle(Main.WIDTH, y_Values[new Random().nextInt(5)]));
		
			
			distance -= Obstacle.SPACE_TWO_OBSTACLE;
		}
	}
}

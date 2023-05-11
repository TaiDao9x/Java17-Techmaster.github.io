package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import view.Main;

public class Model {
	private BackGround ground1;
	private BackGround sky1;
	private BackGround ground2;
	private BackGround sky2;
	private Bird bird;
	private Score score;
	private Obstacle ob;
	private StateGame stateGame;//trang thai game

	int scoreD = 0;
	int bestScore;
	boolean playing;
	ArrayList<Obstacle> obstacles;

	public Model() {
		ground1 = new BackGround(0, BackGround.GROUND);
		sky1 = new BackGround(0, BackGround.SKY);
		ground2 = new BackGround(ground1.getWidth(), BackGround.GROUND);
		sky2 = new BackGround(sky1.getWidth(), BackGround.SKY);
		bird = new BirdFactory().birdFactory();
		score = new Score();
		ob = new Obstacle();
		obstacles = new ArrayList<>();
		stateGame = new StateStart();

	}

	public void update() {
		stateGame.update(this);
//		 ground1.update();
//		 sky1.update();
//		 ground2.update();
//		 sky2.update();
//		 this.bird.update(1);
//		 if (playing) {
//		 ob.addObstacle(obstacles);
//		
//		 }
//		
//		
//		 for (int i = 0; i < obstacles.size(); i++) {
//		 Obstacle obs = obstacles.get(i);
//		 if (obs.getX() + obs.getWidth() < 0) {
//		
//		 obstacles.remove(i);
//		
//		 } else {
//		
//		 obs.update();
//		
//		
//		
//		 if (obs.getX() == this.bird.getX() - 24) {
//		
//		
//		
//		
//		 scoreD++;
//		 Sound.CORE.play();
//		
//		 }
//		 }
//		
//		 }

	}

	public Obstacle getOb() {
		return ob;
	}

	public void setOb(Obstacle ob) {
		this.ob = ob;
	}

	public StateGame getStateGame() {
		return stateGame;
	}

	public void setStateGame(StateGame stateGame) {
		this.stateGame = stateGame;
	}

	public int getScoreD() {
		return scoreD;
	}

	public void setScoreD(int scoreD) {
		this.scoreD = scoreD;
	}

	public int getBestScore() {
		return bestScore;
	}

	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}

	public void setGround1(BackGround ground1) {
		this.ground1 = ground1;
	}

	public void setSky1(BackGround sky1) {
		this.sky1 = sky1;
	}

	public void setGround2(BackGround ground2) {
		this.ground2 = ground2;
	}

	public void setSky2(BackGround sky2) {
		this.sky2 = sky2;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	public void draw(Graphics2D g) {

		sky1.draw(g);
		sky2.draw(g);
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);

		}
		ground1.draw(g);
		ground2.draw(g);

		g.setColor(Color.RED);
		g.setFont(new Font("", Font.BOLD, 40));
		g.drawString("Bestscore: " + Score.read(), 20, 40);

		g.setColor(Color.yellow);
		g.setFont(new Font("", Font.BOLD, 40));

		g.drawString("" + scoreD, Main.WIDTH / 2 - 15, 50);

		this.bird.draw(g);

	}

	public void died() {
		if (this.bird.died(obstacles)) {
			Sound.HIT.play();
			score.addScore(scoreD);
			String medal = score.medal(scoreD);
			ImageIcon image = new ImageIcon(Loader.loadImage(medal));
			int op = JOptionPane.showConfirmDialog(null,
					"YOUR SCORE: " + scoreD + "\n" + "BEST: " + score.read() + "\n" + "AGAIN?", "menu",
					JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, image);

			if (op == JOptionPane.YES_NO_OPTION) {
				replay();
			} else {
				System.exit(0);
			}
		}
	}

	private void replay() {
		ground1 = new BackGround(0, BackGround.GROUND);
		sky1 = new BackGround(0, BackGround.SKY);
		ground2 = new BackGround(ground1.getWidth(), BackGround.GROUND);
		sky2 = new BackGround(sky1.getWidth(), BackGround.SKY);
		this.bird = new BirdFactory().birdFactory();
		score = new Score();
		scoreD = 0;
		setPlaying();
		stateGame = new StateStart();

		obstacles.clear();

	}

	public BackGround getGround1() {
		return ground1;
	}

	public BackGround getSky1() {
		return sky1;
	}

	public BackGround getGround2() {
		return ground2;
	}

	public BackGround getSky2() {
		return sky2;
	}

	public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}

	public Score getScore() {
		return score;
	}

	public void setPlaying() {
		if (playing) {
			this.playing = false;
			
			
			

		} else {
			this.playing = true;
			this.setStateGame(new StatePlay());
			

		}
	}

	public boolean isPlaying() {
		return playing;
	}

	boolean pause = false;

	public void changeState() {
		if (!pause) {
			this.setStateGame(new StatePause());
			pause = true;

		} else {
			this.setStateGame(new StatePlay());
			pause = false;
		}
	}

}

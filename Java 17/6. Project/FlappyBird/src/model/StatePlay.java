package model;

public class StatePlay implements StateGame {

	@Override
	public void update(Model game) {
		
		game.getGround1().update();
		game.getSky1().update();
		game.getGround2().update();
		game.getSky2().update();

		game.getBird().update(1);
		
		game.getOb().addObstacle(game.obstacles);

		for (int i = 0; i < game.obstacles.size(); i++) {
			Obstacle obs = game.obstacles.get(i);
			if (obs.getX() + obs.getWidth() < 0) {

				game.obstacles.remove(i);

			} else {

				obs.update();

				if (obs.getX() == game.getBird().getX() - 24) {

					game.scoreD++;
					Sound.CORE.play();

				}
			}

		}

	}

}

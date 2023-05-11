package model;

public class StateStart implements StateGame {

	@Override
	public void update(Model game) {
		game.getGround1().update();
		game.getSky1().update();
		game.getGround2().update();
		game.getSky2().update();

		game.getBird().update(1);
		
	}

}

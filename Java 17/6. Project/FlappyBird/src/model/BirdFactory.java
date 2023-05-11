package model;

import java.util.Random;

public class BirdFactory {
	public static Bird birdFactory() {
		Random sc = new Random();
		int ran = sc.nextInt(4);
		switch (ran) {
		case 1:
			return new Bird1();
		case 2:
			return new Bird2();
		case 3:
			return new Bird4();
		default:
			return new Bird3();
		}
	}
}

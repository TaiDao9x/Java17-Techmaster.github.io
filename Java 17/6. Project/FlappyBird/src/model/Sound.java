package model;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	private AudioClip sound;
	public static final Sound HIT = new Sound("/sound/hit.wav");
	public static final Sound FLAP = new Sound("/sound/flap.wav");
	public static final Sound CORE = new Sound("/sound/score.wav");
	public static final Sound THEME = new Sound("/sound/theme.wav");

	public Sound(String name) {
		try {
			sound = Applet.newAudioClip(Sound.class.getResource(name));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void play() {
		try {
			new Thread() {
				public void run() {
					sound.play();
				}
			}.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

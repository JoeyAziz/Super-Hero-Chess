package model.sounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BackgroundSound{
	private Clip clip;
	public BackgroundSound(String path) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		clip.loop(20);
	}
	
	public void stop() {
		clip.stop();
	}

	

}

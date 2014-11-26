package net.ulixava.minecraftplatformer;

import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream; 
 
public class BeanSound
{
	
	private static boolean isPlaying = false;
	private static AudioPlayer player;
	private static AudioStream audioStream;
	
  public static void startBackgroundMusic()
  { 
	  try {
		  String soundFile = "music/BeanSoundTrack.mp3";
		  InputStream in = new FileInputStream(soundFile); 
		  audioStream = new AudioStream(in); 
		  player = AudioPlayer.player;
		  player.start(audioStream);
		  isPlaying = true;
	  }
	  catch (Exception e) {
		  e.printStackTrace();
	  }
  }
  
  public static void toggleBackgroundMusic() {
	  if (isPlaying) {
		  player.stop(audioStream);
	  } else {
		  player.start(audioStream);
	  }
	  isPlaying = !isPlaying;
  }
}
package com.npng.onepiece.sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
	
	public class Playsound {	
		
		public static Clip clip;
		
		 public static void playSound(String fn) {
		      try {
		         AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fn));
		         clip = AudioSystem.getClip();
		         
		         clip.stop();
		         clip.open(ais);
		         clip.loop(Clip.LOOP_CONTINUOUSLY);
		         clip.start();
		         
		      } catch (UnsupportedAudioFileException | IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      } catch (LineUnavailableException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		   }
	}



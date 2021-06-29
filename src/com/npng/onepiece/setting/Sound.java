package com.npng.onepiece.setting;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.npng.onepiece.user.view.MainFrame;

public class Sound extends JPanel {
	private MainFrame mainFrame; 
	
	
	public Sound(MainFrame mainFrame) {
		
		this.setSize(1200,800);
		Image icon = new ImageIcon("image/mainMenu/soundbackground").getImage().getScaledInstance(1200, 800, 0);
		this.mainFrame = mainFrame;

	}
}

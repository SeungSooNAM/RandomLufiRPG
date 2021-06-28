package com.npng.onepiece.mainMenu;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;

public class MainMenu extends JFrame{
	private Image img;
	
	public MainMenu() {			
		homeframe();
	}
	public void homeframe() {
		
		this.img = img;
		this.setBounds(300, 150, 1400, 800);
		setSize(1400,800);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel background = new JPanel();
		
	}
}

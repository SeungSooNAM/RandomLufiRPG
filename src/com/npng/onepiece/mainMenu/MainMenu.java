package com.npng.onepiece.mainMenu;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;

public class MainMenu extends JFrame{
	
	private ImageIcon background =  new ImageIcon("image/mainMenu/mainBackground.PNG");
	Image img = background.getImage();
	
	
	public MainMenu() {
		homeframe();
	}
	
	public void homeframe() {
		
		setSize(1400, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g) {
		
		g.drawImage(img, 0 , 0, getWidth(), getHeight(),this);
	}
	public static void main(String[] args){
		new MainMenu();
	}
	
}

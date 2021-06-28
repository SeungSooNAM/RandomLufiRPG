package com.npng.onepiece.setting;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Setting extends JFrame{

	private JButton sound = new JButton();
	private JButton ranking = new JButton();
	private JButton gameoff = new JButton();
	
	
	private ImageIcon background =  new ImageIcon("image/mainMenu/mainBackground.PNG");
	Image backimg = background.getImage();
	
	public Setting() {
		settingbackground();
	}
	
	public void settingbackground() {
		
		setSize(1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		sound.setLayout(null);
		sound.setBounds(120, 195, 330, 70);
		this.sound.add(sound);
		sound.setBorderPainted(false);
		
		ranking.setLayout(null);
		ranking.setBounds(120, 292,  330, 80);
		this.ranking.add(ranking);
		ranking.setBorderPainted(false);
		
		gameoff.setLayout(null);
		gameoff.setBounds(120, 392,  330, 80);
		this.gameoff.add(gameoff);
		gameoff.setBorderPainted(false);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		
			g.drawImage(backimg, 0 , 0, getWidth(), getHeight(),this);
		}
	
	public static void main(String[] args) {
		
		new Setting();
	}
}

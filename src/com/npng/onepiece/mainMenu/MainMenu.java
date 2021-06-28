package com.npng.onepiece.mainMenu;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Graphics;

public class MainMenu extends JFrame{

	private JButton btnCh = new JButton(); 
	private JButton btnInven = new JButton();
	private JButton btnShop = new JButton();
	private JButton btnFriend = new JButton();
	private JButton btnAchieve = new JButton();
	private JButton btnGameready = new JButton();
	
	
	private ImageIcon background =  new ImageIcon("image/mainMenu/mainBackground.PNG");
	Image backimg = background.getImage();
	
	private ImageIcon chinfo = new ImageIcon("image/btn/chinfo.PNG");
	private ImageIcon inven = new ImageIcon("image/btn/inven.PNG");
	private ImageIcon shop = new ImageIcon("image/btn/shop.PNG");
	private ImageIcon friend = new ImageIcon("image/btn/friend.PNG");
	private ImageIcon ach = new ImageIcon("image/btn/ach.PNG");
	private ImageIcon ready = new ImageIcon("image/btn/ready.PNG");
	
	
	public MainMenu() {
		homeframe();
		btn();
	}
	
	public void btn() {
		
		btnCh.setLayout(null);
		btnCh.setBounds(85, 195, 500, 70);
		add(btnCh);
		btnCh.setIcon(chinfo);
		
		
		btnInven.setLayout(null);
		btnInven.setBounds(85, 295, 500, 70);
		add(btnInven);
		btnCh.setIcon(chinfo);
		
	
		btnShop.setLayout(null);
		btnShop.setBounds(85,395, 500, 70);
		add(btnShop);
		btnCh.setIcon(shop);
		
		
		btnFriend.setLayout(null);
		btnFriend.setBounds(85, 495, 500, 70);
		add(btnFriend);
		btnCh.setIcon(friend);
		
		
		btnAchieve.setLayout(null);
		btnAchieve.setBounds(85, 595, 500, 70);
		add(btnAchieve);
		btnCh.setIcon(ach);
		
		
		btnGameready.setLayout(null);
		btnGameready.setBounds(880, 650, 450, 80);
		add(btnGameready);
		btnCh.setIcon(ready);
		
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
		
		g.drawImage(backimg, 0 , 0, getWidth(), getHeight(),this);
	}
	
	public static void main(String[] args){
		
		new MainMenu();
	}
	
}

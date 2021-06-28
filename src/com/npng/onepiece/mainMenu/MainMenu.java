package com.npng.onepiece.mainMenu;

import java.awt.Image;
import java.awt.event.ActionListener;

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
	private JButton btnSetting = new JButton();
	
	
	private ImageIcon background =  new ImageIcon("image/mainMenu/mainBackground.PNG");
	Image backimg = background.getImage();
	
	private ImageIcon chinfo = new ImageIcon("image/btn/chinfo.PNG");
	private ImageIcon inven = new ImageIcon("image/btn/inven.PNG");
	private ImageIcon shop = new ImageIcon("image/btn/shop.PNG");
	private ImageIcon friend = new ImageIcon("image/btn/friend.PNG");
	private ImageIcon ach = new ImageIcon("image/btn/ach.PNG");
	private ImageIcon ready = new ImageIcon("image/btn/ready.PNG");
	private ImageIcon setting = new ImageIcon("image/btn/setting.jpg");
	
	public MainMenu() {
		homeframe();
//		btn();
	}
	
//	public void btn() {
//		
//		btnCh.setLayout(null);
//		btnCh.setBounds(120, 195, 330, 70);
//		this.add(btnCh);
//		btnCh.setBorderPainted(false);
//		btnCh.setIcon(chinfo);
//
//		
//		btnInven.setLayout(null);
//		btnInven.setBounds(120, 292,  330, 80);
//		this.add(btnInven);
//		btnInven.setBorderPainted(false);
//		btnInven.setIcon(inven);
//		
//	
//		btnShop.setLayout(null);
//		btnShop.setBounds(120, 392,  330, 80);
//		this.add(btnShop);
//		btnShop.setBorderPainted(false);
//		btnShop.setIcon(shop);
//		
//		
//		btnFriend.setLayout(null);
//		btnFriend.setBounds(120, 492,  330, 80);
//		this.add(btnFriend);
//		btnFriend.setBorderPainted(false);
//		btnFriend.setIcon(friend);
//		
//		
//		btnAchieve.setLayout(null);
//		btnAchieve.setBounds(120, 592,  330, 80);
//		this.add(btnAchieve);
//		btnAchieve.setBorderPainted(false);
//		btnAchieve.setIcon(ach);
//		
//		
//		
//		btnGameready.setLayout(null);
//		btnGameready.setBounds(740, 652, 350, 80);
//		this.add(btnGameready);
//		btnGameready.setBorderPainted(false);
//		btnGameready.setIcon(ready);
//		
//		
//		btnSetting.setLayout(null);
//		btnSetting.setBounds(1050, 10,100,100);
//		this.add(btnSetting);
//		btnSetting.setBorderPainted(false);
//		btnSetting.setIcon(setting);
//		
//	}

	
	public void homeframe() {
		
		setSize(1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		
		btnCh.setLayout(null);
		btnCh.setBounds(120, 195, 330, 70);
		this.add(btnCh);
		btnCh.setBorderPainted(false);
		btnCh.setIcon(chinfo);

		
		btnInven.setLayout(null);
		btnInven.setBounds(120, 292,  330, 80);
		this.add(btnInven);
		btnInven.setBorderPainted(false);
		btnInven.setIcon(inven);
		
	
		btnShop.setLayout(null);
		btnShop.setBounds(120, 392,  330, 80);
		this.add(btnShop);
		btnShop.setBorderPainted(false);
		btnShop.setIcon(shop);
		
		
		btnFriend.setLayout(null);
		btnFriend.setBounds(120, 492,  330, 80);
		this.add(btnFriend);
		btnFriend.setBorderPainted(false);
		btnFriend.setIcon(friend);
		
		
		btnAchieve.setLayout(null);
		btnAchieve.setBounds(120, 592,  330, 80);
		this.add(btnAchieve);
		btnAchieve.setBorderPainted(false);
		btnAchieve.setIcon(ach);
		
		
		
		btnGameready.setLayout(null);
		btnGameready.setBounds(740, 652, 350, 80);
		this.add(btnGameready);
		btnGameready.setBorderPainted(false);
		btnGameready.setIcon(ready);
		
		
		btnSetting.setLayout(null);
		btnSetting.setBounds(1050, 10,100,100);
		this.add(btnSetting);
		btnSetting.setBorderPainted(false);
		btnSetting.setIcon(setting);
		
		
		
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

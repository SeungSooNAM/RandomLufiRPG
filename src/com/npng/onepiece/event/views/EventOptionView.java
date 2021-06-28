package com.npng.onepiece.event.views;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.event.controller.eventController;
import com.npng.onepiece.user.view.LoginView;

public class EventOptionView extends JPanel{
	
	private Image img;
	private LoginView mf;
	private EventOptionView view;
	
	public EventOptionView(LoginView mf) {
		
		this.mf = mf;
		this.view = this;
		
		this.setSize(1200, 800);
		mf.add(this);
		
Font font6 = new Font("",0,25);
		
		JLabel label = new JLabel(new ImageIcon());
		 
		this.img = new ImageIcon("image/sce/3.PNG").getImage().getScaledInstance(1000, 800, 0);
		
		
		label.setIcon(new ImageIcon(img));
		
		eventController text = new eventController();
		
		String name1 = text.optnum1(number);
		String name2 = text.optnum2(number);
		
		
		JLabel text1 = new JLabel(name1);
		JLabel text2 = new JLabel(name2);
		text1.setFont(font6);
		text2.setFont(font6);
		
		text1.setLocation(0, 100);
		text1.setSize(1000, 1000);
		
		text2.setLocation(0, 130);
		text2.setSize(1000, 1000);
		
		label.setBounds(0, 0, 800, 800);
		
		this.add(text1);
		this.add(text2);
		
		this.setLayout(null);
		
		this.add(label);
	}
	
	
	
	
	
	
	
	

}

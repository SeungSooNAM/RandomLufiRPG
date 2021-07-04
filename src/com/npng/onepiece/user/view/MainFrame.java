package com.npng.onepiece.user.view;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	public static MainFrame mf;

	public MainFrame() {
		
		super("Random Lupi RPG");
		this.setBounds(300, 150, 1200, 850);
		this.mf = this;
		
		new LoginPageView(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}


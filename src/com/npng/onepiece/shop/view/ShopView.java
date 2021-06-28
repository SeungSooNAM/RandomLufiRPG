package com.npng.onepiece.shop.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ShopView extends JPanel {

	
	private Image img;

	public ShopView() {

		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("images/store_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));
		

		
		
		JButton buttonExit = new JButton(new ImageIcon("images/buttonExit.PNG"));
		JButton buttonItem1 = new JButton(new ImageIcon("images/meat1.PNG"));
		JButton buttonItem2 = new JButton(new ImageIcon("images/hat3.PNG"));
		
		JButton buttonMyItem1 = new JButton(new ImageIcon("images/meat1.PNG"));
		
		buttonExit.setBounds(1000, 690, 190, 65);
		buttonItem1.setBounds(337, 90, 90, 90);
		buttonItem2.setBounds(447, 90, 90, 90);
		
		label.add(buttonExit);
		label.add(buttonItem1);
		label.add(buttonItem2);
		this.add(label);
		mf.add(this);
	}

}
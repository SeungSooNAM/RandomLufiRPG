package com.npng.onepiece.inventory;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.greedy.section03.change.MainFrame;
import com.greedy.section03.change.MainPage2;

public class InventoryView extends JPanel {

	private MainFrame mf;
	private MainPage2 mainPage2;
	private Image img;

	public InventoryView(MainFrame mf) {
		this.mf = mf;
		this.mainPage2 = this;



		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("images/inven_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));
		

		
		JButton buttonExit = new JButton(new ImageIcon("images/buttonExit.PNG"));
//		JButton buttonItem1 = new JButton(new ImageIcon("images/meat1.PNG"));
//		JButton buttonItem2 = new JButton(new ImageIcon("images/hat3.PNG"));
//		
		JButton buttonMyItem1 = new JButton(new ImageIcon("images/hat1.PNG"));
		JButton buttonCancle = new JButton(new ImageIcon("images/cancle.PNG"));
		
		
		buttonExit.setBounds(1000, 690, 190, 65);
//		buttonItem1.setBounds(337, 90, 90, 90);
//		buttonItem2.setBounds(447, 90, 90, 90);
		buttonMyItem1.setBounds(120, 90, 90, 90);
		
		
		buttonMyItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				img = new ImageIcon("images/inven_bg_info.PNG").getImage().getScaledInstance(1200, 800, 0);
				label.setIcon(new ImageIcon(img));
				
				
				buttonCancle.setBounds(900, 500, 150, 54);
				label.add(buttonCancle);

			}
			
			
		});
		
		buttonCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				label.remove(buttonCancle);
				
				img = new ImageIcon("images/inven_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
				label.setIcon(new ImageIcon(img));
			}
			
			
		});
		

		label.add(buttonExit);
//		label.add(buttonItem1);
//		label.add(buttonItem2);
//		label.add(buttonItem2);
		label.add(buttonMyItem1);
		this.add(label);
		mf.add(this);
		mf.add(this);
	}
}

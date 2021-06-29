package com.npng.onepiece.inventory.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.view.MainFrame;



public class InventoryView extends JPanel {

	private MainFrame  mf;
	private InventoryView mainPage;
	private Image img;
	private Image img2;

	public InventoryView (MainFrame mf) {
		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.mainPage = this;

		JLabel InfoLabel = new JLabel("아이템설명");
		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/shop/inven_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));
		

		
		
		JLabel labelIcon = new JLabel(new ImageIcon());
		this.img2 = new ImageIcon("image/shop/hat1.PNG").getImage().getScaledInstance(90, 90, 0);
		labelIcon.setIcon(new ImageIcon(img2));
		
		

		
		
		
		JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));	
		JButton buttonMyItem1 = new JButton(new ImageIcon("image/shop/hat1.PNG"));
		JButton buttonCancle = new JButton(new ImageIcon("image/shop/cancle.PNG"));
		
		
		buttonExit.setBounds(1000, 690, 190, 65);

		buttonMyItem1.setBounds(120, 90, 90, 90);
		
		
		buttonMyItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf));
			}
			
			
		});
		

		
	
		label.add(buttonExit);

		label.add(buttonMyItem1);
		this.add(label);
		mf.add(this);
		repaint();
		revalidate();

	}

}
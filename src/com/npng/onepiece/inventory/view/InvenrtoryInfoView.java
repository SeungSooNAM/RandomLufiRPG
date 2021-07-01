package com.npng.onepiece.inventory.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.view.MainFrame;

public class InvenrtoryInfoView extends JPanel {

	private MainFrame  mf;
	private InvenrtoryInfoView mainPage2;
	private Image img;
	private Image img2;

	public InvenrtoryInfoView (MainFrame mf) {
		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.mainPage2 = this;

		JLabel InfoLabel = new JLabel("아이템이름");
		JLabel InfoLabel2 = new JLabel("아이템정보");
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/shop/inven_bg_info.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));


		JLabel labelIcon = new JLabel(new ImageIcon());
		this.img2 = new ImageIcon("image/shop/hat1.PNG").getImage().getScaledInstance(90, 90, 0);
		labelIcon.setIcon(new ImageIcon(img2));
		
		


		JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));
		JButton buttonEquip = new JButton(new ImageIcon("image/shop/buttonEquip.PNG"));
		
		JButton buttonMyItem1 = new JButton(new ImageIcon("image/shop/hat1.PNG"));
		JButton buttonCancle = new JButton(new ImageIcon("image/shop/cancle.PNG"));



		buttonExit.setBounds(1000, 690, 190, 65);
		buttonMyItem1.setBounds(120, 90, 90, 90);




		Font font = new Font("맑은 고딕", Font.PLAIN, 20);

		InfoLabel.setBounds(750, 350, 100, 20);
		InfoLabel2.setBounds(750, 390, 200, 20);
		
		InfoLabel.setFont(font); 
		InfoLabel2.setFont(font); 
		InfoLabel.setForeground(Color.WHITE);
		InfoLabel2.setForeground(Color.WHITE);

		
		
		
		
		buttonCancle.setBounds(900, 500, 150, 54);
		buttonEquip.setBounds(600, 500, 150, 54);
		labelIcon.setBounds(750, 250, 90, 90);
		
		label.add(buttonCancle);
		label.add(buttonEquip);
		label.add(InfoLabel);
		label.add(InfoLabel2);

		label.add(labelIcon);



		buttonEquip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ViewUtil.changePanel(mf, mainPage2, new InventoryView(mf));
			}


		});
		buttonCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ViewUtil.changePanel(mf, mainPage2, new InventoryView(mf));
			}
			
			
		});

	
		label.add(buttonExit);

		label.add(buttonMyItem1);
		this.add(label);
		mf.add(this);



	}

}
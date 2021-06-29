package com.npng.onepiece.shop.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.view.MainFrame;



public class ShopView extends JPanel {

	private MainFrame  mf;
	private ShopView mainPage;
	private Image img;
	private Image img2;

	public ShopView(MainFrame mf) {
		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.mainPage = this;

		JLabel InfoLabel = new JLabel("아이템설명");

		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/shop/store_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));

		JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));
		JButton buttonItem1 = new JButton(new ImageIcon("image/shop/meat1.PNG"));
		JButton buttonItem2 = new JButton(new ImageIcon("image/shop/hat3.PNG"));

		JButton buttonMyItem1 = new JButton(new ImageIcon("image/shop/hat1.PNG"));

		buttonExit.setBounds(1000, 690, 190, 65);
		buttonItem1.setBounds(50, 100, 90, 90);
		buttonMyItem1.setBounds(50, 480, 90, 90);
		buttonItem2.setBounds(160, 100, 90, 90);
		JButton buttonCancle = new JButton(new ImageIcon("image/shop/cancle.PNG"));


		JLabel labelIcon = new JLabel(new ImageIcon());

		Image img2 = new ImageIcon("image/shop/infoBoard.PNG").getImage().getScaledInstance(300, 615, 0);
		labelIcon.setIcon(new ImageIcon(img2));
		
		
		
		buttonItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ViewUtil.changePanel(mf, mainPage, new ShopInfoView(mf));
	
			}

		});
		
		buttonMyItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ViewUtil.changePanel(mf, mainPage, new MineInfoView(mf));
	
			}

		});



		label.add(buttonExit);
		label.add(buttonItem1);
		label.add(buttonItem2);
		label.add(buttonMyItem1);

		this.add(label);
		this.repaint();
		this.revalidate();
		
		mf.add(this);
	}

}

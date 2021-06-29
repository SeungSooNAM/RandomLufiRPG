package com.npng.onepiece.shop.view;

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

public class MineInfoView extends JPanel {

	private MainFrame  mf;
	private MineInfoView mainPageI;
	private Image img;
	private Image img2;


	public MineInfoView (MainFrame mf) {
		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.mainPageI = this;

		JLabel InfoLabel = new JLabel("<html><body style='text-align:center;'>아이템이름<br />아이템정보<br /> 아이템가격 : 122</body></html>", JLabel.CENTER);

		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/shop/store_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));


		JLabel labelBoard = new JLabel(new ImageIcon());

		Image img2 = new ImageIcon("image/shop/infoBoard.PNG").getImage().getScaledInstance(300, 615, 0);
		labelBoard.setIcon(new ImageIcon(img2));


		JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));
		JButton buttonBuy = new JButton(new ImageIcon("image/shop/buttonBuy.PNG"));
		JButton buttonCancle = new JButton(new ImageIcon("image/shop/buttonCancle.PNG"));
		
		JButton buttonItem1 = new JButton(new ImageIcon("image/shop/meat1.PNG"));
		JButton buttonItem2 = new JButton(new ImageIcon("image/shop/hat3.PNG"));

		JButton buttonMyItem1 = new JButton(new ImageIcon("image/shop/hat1.PNG"));

		buttonExit.setBounds(1000, 690, 190, 65);
		buttonBuy.setBounds(780, 600, 100, 35);
		buttonCancle.setBounds(930, 600, 100, 35);
		buttonItem1.setBounds(50, 100, 90, 90);
		buttonMyItem1.setBounds(50, 480, 90, 90);
		buttonItem2.setBounds(160, 100, 90, 90);
		


		



		label.add(InfoLabel);
		
		label.add(buttonBuy);
		label.add(buttonCancle);
		
		label.add(labelBoard);
		
		
		Font font = new Font("맑은 고딕", Font.PLAIN, 20);
		InfoLabel.setBounds(800, 0, 200, 550);
		InfoLabel.setFont(font); 

		InfoLabel.setForeground(Color.WHITE);


		labelBoard.setBounds(750, 50, 310, 620);



		buttonBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				ViewUtil.changePanel(mf, mainPageI, new ShopView(mf));
				
			}


		});
		buttonCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				ViewUtil.changePanel(mf, mainPageI, new ShopView(mf));
				
			}
			
			
		});



		label.add(buttonExit);
		
		label.add(buttonItem1);
		label.add(buttonItem2);
		label.add(buttonMyItem1);
		this.add(label);
		
		repaint();
		revalidate();
	}

}
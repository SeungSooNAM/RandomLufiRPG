package com.npng.onepiece.shop.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;
import com.npng.onepiece.shop.controller.ShopController;
import com.npng.onepiece.user.view.MainFrame;

public class ShopAlarmView extends JPanel {

	private MainFrame  mf;
	private ShopAlarmView mainPageI;
	private Image img;
	private List<ItemDTO> shopList;

//	i는 상점의 몇번쨰 칸인지
	public ShopAlarmView (MainFrame mf, JLabel alarm, InventoryDTO inven, int cn, int s) {

		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.mainPageI = this;
		

		JLabel MoneyLabel = new JLabel("소지금 : " + inven.getGold() + "G");
		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/shop/store_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));


		JLabel labelBoard = new JLabel(new ImageIcon());

		Image img2 = new ImageIcon("image/shop/infoBoard.PNG").getImage().getScaledInstance(300, 615, 0);
		labelBoard.setIcon(new ImageIcon(img2));

		JLabel labelIcon = new JLabel(new ImageIcon());


		JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));

		JButton buttonCancle = new JButton(new ImageIcon("image/shop/buttonCancle.PNG"));

		JButton buttonItem1 = new JButton(new ImageIcon("image/shop/item/2.PNG"));
		JButton buttonItem2 = new JButton(new ImageIcon("image/shop/item/3.PNG"));
		JButton buttonItem3 = new JButton(new ImageIcon("image/shop/item/4.PNG"));
		JButton buttonItem4 = new JButton(new ImageIcon("image/shop/item/8.PNG"));
		JButton buttonItem5 = new JButton(new ImageIcon("image/shop/item/9.PNG"));
		JButton buttonItem6 = new JButton(new ImageIcon("image/shop/item/10.PNG"));
		JButton buttonItem7 = new JButton(new ImageIcon("image/shop/item/14.PNG"));
		JButton buttonItem8 = new JButton(new ImageIcon("image/shop/item/15.PNG"));
		JButton buttonItem9 = new JButton(new ImageIcon("image/shop/item/16.PNG"));
		JButton buttonItem10 = new JButton(new ImageIcon("image/shop/item/19.PNG"));
		
		if(s == 1) {
			buttonItem1 = new JButton(new ImageIcon("image/shop/item/5.PNG"));
			buttonItem2 = new JButton(new ImageIcon("image/shop/item/6.PNG"));
			
		}
		if(s == 2) {
			buttonItem1 = new JButton(new ImageIcon("image/shop/item/11.PNG"));
			buttonItem2 = new JButton(new ImageIcon("image/shop/item/12.PNG"));
		}
		if(s == 3) {
			buttonItem1 = new JButton(new ImageIcon("image/shop/item/17.PNG"));
			buttonItem2 = new JButton(new ImageIcon("image/shop/item/18.PNG"));
			
		}
		
		JButton buttonMyItem1 = new JButton(new ImageIcon("image/shop/item/" + inven.getInven1() +".PNG"));
		JButton buttonMyItem2 = new JButton(new ImageIcon("image/shop/item/" + inven.getInven2() +".PNG"));
		JButton buttonMyItem3 = new JButton(new ImageIcon("image/shop/item/" + inven.getInven3() +".PNG"));
		JButton buttonMyItem4 = new JButton(new ImageIcon("image/shop/item/" + inven.getInven4() +".PNG"));
		JButton buttonMyItem5 = new JButton(new ImageIcon("image/shop/item/" + inven.getInven5() +".PNG"));
		JButton buttonMyItem6 = new JButton(new ImageIcon("image/shop/item/" + inven.getInven6() +".PNG"));
		JButton buttonMyItem7 = new JButton(new ImageIcon("image/shop/item/" + inven.getInven7() +".PNG"));
		JButton buttonMyItem8 = new JButton(new ImageIcon("image/shop/item/" + inven.getInven8() +".PNG"));
		JButton buttonMyItem9 = new JButton(new ImageIcon("image/shop/item/" + inven.getInven9() +".PNG"));
		JButton buttonMyItem10 = new JButton(new ImageIcon("image/shop/item/" + inven.getInven10() +".PNG"));

		buttonExit.setBounds(1000, 690, 190, 65);

		buttonCancle.setBounds(900, 600, 100, 35);

		buttonItem1.setBounds(50, 100, 90, 90);
		buttonItem2.setBounds(160, 100, 90, 90);
		buttonItem3.setBounds(270, 100, 90, 90);
		buttonItem4.setBounds(380, 100, 90, 90);
		buttonItem5.setBounds(490, 100, 90, 90);
		buttonItem6.setBounds(50, 220, 90, 90);
		buttonItem7.setBounds(160, 220, 90, 90);
		buttonItem8.setBounds(270, 220, 90, 90);
		buttonItem9.setBounds(380, 220, 90, 90);
		buttonItem10.setBounds(490, 220, 90, 90);


		buttonMyItem1.setBounds(50, 480, 90, 90);
		buttonMyItem2.setBounds(160, 480, 90, 90);
		buttonMyItem3.setBounds(270, 480, 90, 90);
		buttonMyItem4.setBounds(380, 480, 90, 90);
		buttonMyItem5.setBounds(490, 480, 90, 90);
		buttonMyItem6.setBounds(50, 600, 90, 90);
		buttonMyItem7.setBounds(160, 600, 90, 90);
		buttonMyItem8.setBounds(270, 600, 90, 90);
		buttonMyItem9.setBounds(380, 600, 90, 90);
		buttonMyItem10.setBounds(490, 600, 90, 90);


		
		

		
		Font fontM = new Font("맑은 고딕", Font.PLAIN, 30);
		MoneyLabel.setFont(fontM); 
		MoneyLabel.setBounds(950, 5, 300, 100);


		alarm.setBounds(820, 300, 450, 100);
		alarm.setForeground(Color.WHITE);
		
		label.add(alarm);

		labelIcon.setBounds(850, 150 , 90, 90);

		labelBoard.setBounds(750, 50, 310, 620);
		
		
		
		
		buttonCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ViewUtil.changePanel(mf, mainPageI, new ShopView(mf, cn, s));

			}

		});


		label.add(labelIcon);


		
		label.add(alarm);
	




		label.add(buttonCancle);
		label.add(buttonExit);

		label.add(labelBoard);
		label.add(MoneyLabel);

		label.add(buttonItem1);
		label.add(buttonItem2);
		if(s==0) {
			label.add(buttonItem3);
			label.add(buttonItem4);	
			label.add(buttonItem5);		
			label.add(buttonItem6);		
			label.add(buttonItem7);		
			label.add(buttonItem8);		
			label.add(buttonItem9);
			label.add(buttonItem10);
		}
		
		
		
		if(inven.getInven1() != 0) {
			label.add(buttonMyItem1);
		}
		if(inven.getInven2() != 0) {
			label.add(buttonMyItem2);
		}
		if(inven.getInven3() != 0) {
			label.add(buttonMyItem3);
		}
		if(inven.getInven4() != 0) {
			label.add(buttonMyItem4);
		}
		if(inven.getInven5() != 0) {
			label.add(buttonMyItem5);
		}
		if(inven.getInven6() != 0) {
			label.add(buttonMyItem6);
		}
		if(inven.getInven7() != 0) {
			label.add(buttonMyItem7);
		}
		if(inven.getInven8() != 0) {
			label.add(buttonMyItem8);
		}
		if(inven.getInven9() != 0) {
			label.add(buttonMyItem9);
		}
		if(inven.getInven10() != 0) {
			label.add(buttonMyItem10);
		}
		


		this.add(label);

		repaint();
		revalidate();
	}

}
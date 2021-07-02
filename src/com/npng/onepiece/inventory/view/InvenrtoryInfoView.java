package com.npng.onepiece.inventory.view;

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
import com.npng.onepiece.inventory.controller.InventoryController;
import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;
import com.npng.onepiece.user.view.MainFrame;

public class InvenrtoryInfoView extends JPanel {

	private MainFrame  mf;
	private InvenrtoryInfoView mainPage2;
	private Image img;
	private Image img2;
	private List<ItemDTO> itemList;
	public InvenrtoryInfoView (MainFrame mf, int i, int n, InventoryDTO inven) {
		
		InventoryController itemInfo = new InventoryController();
		
		itemList = itemInfo.getItemInfo();
		
		ItemDTO selectedItem = new ItemDTO();
		
		for(int k = 0; k < itemList.size(); k++) {
			if(itemList.get(k).getNum() == i) {
				selectedItem = itemList.get(k);
			}
		}

		System.out.println(itemList);
		
		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.mainPage2 = this;

		
		JLabel MoneyLabel = new JLabel("소지금 : " + inven.getGold() + "G");
		JLabel labelName = new JLabel("이름 : " + selectedItem.getName());
		JLabel labelCate = new JLabel("종류 : "+ selectedItem.getCate());
		JLabel labelGrade = new JLabel("등급 : "+ selectedItem.getGrade());
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/shop/inven_bg_info.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));


		JLabel labelIcon = new JLabel(new ImageIcon());
		this.img2 = new ImageIcon("image/shop/item/" + selectedItem.getNum() +".PNG").getImage();
		labelIcon.setIcon(new ImageIcon(img2));
		
		


		JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));
		JButton buttonEquip = new JButton(new ImageIcon("image/shop/buttonEquip.PNG"));
		JButton buttonCancle = new JButton(new ImageIcon("image/shop/cancle.PNG"));
		
		
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
		
		buttonMyItem1.setBounds(120, 90, 90, 90);
		buttonMyItem2.setBounds(245, 90, 90, 90);
		buttonMyItem3.setBounds(120, 222, 90, 90);
		buttonMyItem4.setBounds(245, 222, 90, 90);
		buttonMyItem5.setBounds(120, 354, 90, 90);
		buttonMyItem6.setBounds(245, 354, 90, 90);
		buttonMyItem7.setBounds(120, 486, 90, 90);
		buttonMyItem8.setBounds(245, 486, 90, 90);
		buttonMyItem9.setBounds(120, 618, 90, 90);
		buttonMyItem10.setBounds(245, 618, 90, 90);




		
		Font fontM = new Font("맑은 고딕", Font.PLAIN, 30);
		MoneyLabel.setFont(fontM); 
		MoneyLabel.setBounds(950, 5, 300, 100);
		
		Font font = new Font("맑은 고딕", Font.PLAIN, 20);

		labelName.setFont(font); 
		labelName.setBounds(750, 350, 400, 20);
		labelName.setForeground(Color.WHITE);

		labelCate.setFont(font); 
		labelCate.setBounds(750, 390, 200, 20);
		labelCate.setForeground(Color.WHITE);

		labelGrade.setFont(font); 
		labelGrade.setBounds(750, 430, 200, 20);
		labelGrade.setForeground(Color.WHITE);
		
		
		
		buttonCancle.setBounds(900, 500, 150, 54);
		buttonEquip.setBounds(600, 500, 150, 54);
		labelIcon.setBounds(750, 250, 90, 90);
		
		label.add(buttonCancle);
		label.add(buttonEquip);
		label.add(labelName);
		label.add(labelCate);
		label.add(labelGrade);

		label.add(labelIcon);



		buttonEquip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ViewUtil.changePanel(mf, mainPage2, new InventoryView(mf, inven));
			}


		});
		buttonCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ViewUtil.changePanel(mf, mainPage2, new InventoryView(mf,inven));
			}
			
			
		});

	
		label.add(MoneyLabel);
		label.add(buttonExit);

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
		mf.add(this);



	}

}
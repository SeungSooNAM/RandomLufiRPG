package com.npng.onepiece.inventory.view;

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
import com.npng.onepiece.inventory.model.dto.EquipDTO;
import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.model.dto.WeaponDTO;
import com.npng.onepiece.user.view.MainFrame;



public class InventoryView extends JPanel {

	private MainFrame  mf;
	private InventoryView mainPage;
	private Image img;
	private Image img2;
	private EquipDTO equip;
	
	public InventoryView (MainFrame mf, InventoryDTO inven) {
		
		InventoryController equipInfo = new InventoryController();
		equip = equipInfo.getEquipInfo();
		
		if(inven.getInven1() < 4)
		
		System.out.println(equip);
		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.mainPage = this;
		
		WeaponDTO w = new WeaponDTO();
	

		JLabel InfoLabel = new JLabel("아이템설명");
		
		JLabel MoneyLabel = new JLabel("소지금 : " + inven.getGold() + "G");
		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/shop/inven_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));
		

		JLabel labelIcon = new JLabel(new ImageIcon());
		this.img2 = new ImageIcon("image/shop/hat1.PNG").getImage().getScaledInstance(90, 90, 0);

		labelIcon.setIcon(new ImageIcon(img2));
		
		

		JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));	
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
		
		Font font = new Font("맑은 고딕", Font.PLAIN, 30);
		MoneyLabel.setFont(font); 
		MoneyLabel.setBounds(950, 5, 300, 100);

		labelIcon.setIcon(new ImageIcon(img2));		
		
		JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));	
		JButton buttonMyItem1 = new JButton(new ImageIcon("image/shop/hat1.PNG"));
		JButton buttonCancle = new JButton(new ImageIcon("image/shop/cancle.PNG"));		

		
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
		
		
		buttonMyItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int n = 1;
				int i = inven.getInven1();
				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven));
			}
			
		});
		buttonMyItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 2;
				int i = inven.getInven2();
				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven));
			}
			
		});
		buttonMyItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 3;
				int i = inven.getInven3();
				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven));
			}
			
		});
		buttonMyItem4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 4;
				int i = inven.getInven4();
				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven));
			}
			
		});
		buttonMyItem5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 5;
				int i = inven.getInven5();
				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven));
			}
			
		});
		buttonMyItem6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 6;
				int i = inven.getInven6();
				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven));
			}
			
		});
		buttonMyItem7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 7;
				int i = inven.getInven7();
				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven));
			}
			
		});
		buttonMyItem8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 8;
				int i = inven.getInven8();
				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven));
			}
			
		});
		buttonMyItem9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 9;
				int i = inven.getInven9();
				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven));
			}
			
		});
		buttonMyItem10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 10;
				int i = inven.getInven10();
				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven));
			}
			
		});
		
		
		label.add(MoneyLabel);

				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf));
			}			
			
		});		
	

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
		repaint();
		revalidate();

	}

}
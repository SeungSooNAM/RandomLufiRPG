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
import com.npng.onepiece.inventory.controller.InventoryController;
import com.npng.onepiece.inventory.model.dto.EquipDTO;
import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.model.dto.WeaponDTO;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.MainFrame;



public class InventoryView extends JPanel {

	private MainFrame  mf;
	private InventoryView mainPage;
	private Image img;
	private Image img2;
	private EquipDTO equip;
	private InventoryDTO inven;

	public InventoryView (MainFrame mf, int cn) {
		

		InventoryController invenControl = new InventoryController();
		inven = invenControl.getInventoryInfo(cn);
		equip = invenControl.getEquipInfo(cn);
		
		
		System.out.println(inven);

		int [] invenNum = new int[10];
		invenNum[0] = inven.getInven1();
		invenNum[1] = inven.getInven2();
		invenNum[2] = inven.getInven3();
		invenNum[3] = inven.getInven4();
		invenNum[4] = inven.getInven5();
		invenNum[5] = inven.getInven6();
		invenNum[6] = inven.getInven7();
		invenNum[7] = inven.getInven8();
		invenNum[8] = inven.getInven9();
		invenNum[9] = inven.getInven10();

		int [] invenE = new int[10];
		for(int i = 0; i < 10; i++) {
			invenE[i] = 0;
		}

		for(int i = 0; i < 10; i++) {
			if(invenNum[i] >= 1 && invenNum[i] < 7) {
				if (equip.geteWeaponNum() == invenNum[i]) {
					invenE[i] = 1;
				}
			} else if (invenNum[i] >= 7 && invenNum[i] < 13) {
				if (equip.geteArmorNum() == invenNum[i]) {
					invenE[i] = 1;
				}
			} else if (invenNum[i] >= 13 && invenNum[i] < 19) {
				if (equip.geteASCNum() == invenNum[i]) {
					invenE[i] = 1;
				}
			}

		}

		System.out.println(equip);
		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.mainPage = this;

		WeaponDTO w = new WeaponDTO();


		JLabel labelE1 = new JLabel("장비중");
		JLabel labelE2 = new JLabel("장비중");
		JLabel labelE3 = new JLabel("장비중");
		JLabel labelE4 = new JLabel("장비중");
		JLabel labelE5 = new JLabel("장비중");
		JLabel labelE6 = new JLabel("장비중");
		JLabel labelE7 = new JLabel("장비중");
		JLabel labelE8 = new JLabel("장비중");
		JLabel labelE9 = new JLabel("장비중");
		JLabel labelE10 = new JLabel("장비중");
		
		
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

		Font fontE = new Font("맑은 고딕", Font.PLAIN, 30);
		labelE1.setFont(fontE);
		labelE1.setForeground(Color.GREEN);
		labelE1.setBounds(120, 180, 100, 30);
		
		labelE2.setFont(fontE);
		labelE2.setForeground(Color.GREEN);
		labelE2.setBounds(245, 180, 100, 30);
		
		labelE3.setFont(fontE);
		labelE3.setForeground(Color.GREEN);
		labelE3.setBounds(120, 312, 100, 30);
		
		labelE4.setFont(fontE);
		labelE4.setForeground(Color.GREEN);
		labelE4.setBounds(245, 312, 100, 30);
		
		labelE5.setFont(fontE);
		labelE5.setForeground(Color.GREEN);
		labelE5.setBounds(120, 444, 100, 30);
		
		labelE6.setFont(fontE);
		labelE6.setForeground(Color.GREEN);
		labelE6.setBounds(245, 444, 100, 30);
		
		labelE7.setFont(fontE);
		labelE7.setForeground(Color.GREEN);
		labelE7.setBounds(120, 576, 100, 30);
		
		labelE8.setFont(fontE);
		labelE8.setForeground(Color.GREEN);
		labelE8.setBounds(245, 576, 100, 30);
		
		labelE9.setFont(fontE);
		labelE9.setForeground(Color.GREEN);
		labelE9.setBounds(120, 708, 100, 30);
		
		labelE10.setFont(fontE);
		labelE10.setForeground(Color.GREEN);
		labelE10.setBounds(245, 708, 100, 30);
		
		
//		n은 몇번째 인벤칸인지, i는 해당 칸에 들어있는 아이템의 번호
		buttonMyItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 1;
				int i = inven.getInven1();
				ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven, equip, invenE[0], cn));
			}

		});
		buttonMyItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 2;
				int i = inven.getInven2();
					ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven, equip, invenE[1], cn));
			}

		});
		buttonMyItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 3;
				int i = inven.getInven3();
					ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven, equip, invenE[2], cn));
			}

		});
		buttonMyItem4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 4;
				int i = inven.getInven4();
					ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven, equip, invenE[3], cn));
			}

		});
		buttonMyItem5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 5;
				int i = inven.getInven5();
					ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven, equip, invenE[4], cn));
			}

		});
		buttonMyItem6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 6;
				int i = inven.getInven6();
					ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven, equip, invenE[5], cn));
			}

		});
		buttonMyItem7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 7;
				int i = inven.getInven7();
					ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven, equip, invenE[6], cn));			
			}

		});
		buttonMyItem8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 8;
				int i = inven.getInven8();
					ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven, equip,  invenE[7], cn));
			}

		});
		buttonMyItem9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 9;
				int i = inven.getInven9();
					ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven, equip,  invenE[8], cn));			
			}

		});
		buttonMyItem10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 10;
				int i = inven.getInven10();
					ViewUtil.changePanel(mf, mainPage, new InvenrtoryInfoView(mf,i, n, inven, equip,  invenE[9], cn));
			}

		});
		
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, mainPage, new MainMenu(mf, cn));
			}

		});


		label.add(MoneyLabel);
		label.add(buttonExit);

		if(inven.getInven1() != 0) {
			
			label.add(buttonMyItem1);
			if(invenE[0] == 1) {
			label.add(labelE1);
			}
		}
		if(inven.getInven2() != 0) {
			label.add(buttonMyItem2);
			if(invenE[1] == 1) {
			label.add(labelE2);
			}
		}
		if(inven.getInven3() != 0) {
			label.add(buttonMyItem3);
			if(invenE[2] == 1) {
			label.add(labelE3);
		}
		}
		if(inven.getInven4() != 0) {
			label.add(buttonMyItem4);
			if(invenE[3] == 1) {
			label.add(labelE4);
			}
		}
		if(inven.getInven5() != 0) {
			label.add(buttonMyItem5);
			if(invenE[4] == 1) {
			label.add(labelE5);
			}
		}
		if(inven.getInven6() != 0) {
			label.add(buttonMyItem6);
			if(invenE[5] == 1) {
			label.add(labelE6);
			}
		}
		if(inven.getInven7() != 0) {
			label.add(buttonMyItem7);
			if(invenE[6] == 1) {
			label.add(labelE7);
			}
		}
		if(inven.getInven8() != 0) {
			label.add(buttonMyItem8);
			if(invenE[7] == 1) {
			label.add(labelE8);
			}
		}
		if(inven.getInven9() != 0) {
			label.add(buttonMyItem9);
			if(invenE[8] == 1) {
			label.add(labelE9);
			}
		}
		if(inven.getInven10() != 0) {
			label.add(buttonMyItem10);
			if(invenE[9] == 1) {
			label.add(labelE10);
			}
		}
		this.add(label);
		mf.add(this);
		repaint();
		revalidate();

	}

}
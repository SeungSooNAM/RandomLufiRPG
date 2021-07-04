package com.npng.onepiece.shop.view;

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
import com.npng.onepiece.inventory.view.InventoryView;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.MainFrame;



public class ShopView extends JPanel {

	private MainFrame  mf;
	private ShopView mainPage;
	private InventoryView invenPage;
	private Image img;
	private Image img2;
	private InventoryDTO inven;

	// 상점입장 : s가 0이면 일반상점, s가 1이면 무기 특수상점, s가 2이면 방어구 특수상점, s가 3이면 장식품 특수상점
	public ShopView(MainFrame mf, int cn, int s) {
		
		//인벤토리 정보 받아오기
		InventoryController invenControl = new InventoryController();
		inven = invenControl.getInventoryInfo(cn);

		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.mainPage = this;

		JLabel MoneyLabel = new JLabel("소지금 : " + inven.getGold() + "G");

		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/shop/store_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));

		JLabel labelIcon = new JLabel(new ImageIcon());

		Image img2 = new ImageIcon("image/shop/infoBoard.PNG").getImage().getScaledInstance(300, 615, 0);
		labelIcon.setIcon(new ImageIcon(img2));

		JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));

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
		
		buttonExit.setBounds(1000, 690, 190, 65);

		Font font = new Font("맑은 고딕", Font.PLAIN, 30);
		MoneyLabel.setFont(font); 
		MoneyLabel.setBounds(950, 5, 300, 100);



		//		i = 상점의 몇번쨰 칸 - 1
		buttonItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				ViewUtil.changePanel(mf, mainPage, new ShopInfoView(mf, i, inven, cn, s));

			}

		});

		buttonItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 1;
				ViewUtil.changePanel(mf, mainPage, new ShopInfoView(mf, i, inven, cn, s));

			}

		});

		buttonItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 2;
				ViewUtil.changePanel(mf, mainPage, new ShopInfoView(mf, i, inven, cn, s));

			}

		});

		buttonItem4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 3;
				ViewUtil.changePanel(mf, mainPage, new ShopInfoView(mf, i, inven, cn, s));

			}

		});

		buttonItem5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 4;
				ViewUtil.changePanel(mf, mainPage, new ShopInfoView(mf, i, inven, cn, s));

			}

		});

		buttonItem6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 5;
				ViewUtil.changePanel(mf, mainPage, new ShopInfoView(mf, i, inven, cn, s));

			}

		});

		buttonItem7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 6;
				ViewUtil.changePanel(mf, mainPage, new ShopInfoView(mf, i, inven, cn, s));

			}

		});
		buttonItem8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 7;
				ViewUtil.changePanel(mf, mainPage, new ShopInfoView(mf, i, inven, cn, s));

			}

		});
		buttonItem9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 8;
				ViewUtil.changePanel(mf, mainPage, new ShopInfoView(mf, i, inven, cn, s));

			}

		});
		buttonItem10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 9;
				ViewUtil.changePanel(mf, mainPage, new ShopInfoView(mf, i, inven, cn, s));

			}

		});


		//		n은 몇번째 인벤칸인지, i는 해당 칸에 들어있는 아이템의 번호
		buttonMyItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 1;
				int i = inven.getInven1();
				ViewUtil.changePanel(mf, mainPage, new MineInfoView(mf, i, n, inven, cn, s));

			}

		});
		buttonMyItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 2;
				int i = inven.getInven2();
				ViewUtil.changePanel(mf, mainPage, new MineInfoView(mf, i, n, inven, cn, s));

			}

		});
		buttonMyItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 3;
				int i = inven.getInven3();
				ViewUtil.changePanel(mf, mainPage, new MineInfoView(mf, i, n, inven, cn, s));

			}

		});
		buttonMyItem4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 4;
				int i = inven.getInven4();
				ViewUtil.changePanel(mf, mainPage, new MineInfoView(mf, i, n, inven, cn, s));

			}

		});
		buttonMyItem5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 5;
				int i = inven.getInven5();
				ViewUtil.changePanel(mf, mainPage, new MineInfoView(mf, i, n, inven, cn, s));

			}

		});
		buttonMyItem6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 6;
				int i = inven.getInven6();
				ViewUtil.changePanel(mf, mainPage, new MineInfoView(mf, i, n, inven, cn, s));

			}

		});
		buttonMyItem7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 7;
				int i = inven.getInven7();
				ViewUtil.changePanel(mf, mainPage, new MineInfoView(mf, i, n, inven, cn, s));

			}

		});
		buttonMyItem8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 8;
				int i = inven.getInven8();
				ViewUtil.changePanel(mf, mainPage, new MineInfoView(mf, i, n, inven, cn, s));

			}

		});
		buttonMyItem9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 9;
				int i = inven.getInven9();
				ViewUtil.changePanel(mf, mainPage, new MineInfoView(mf, i, n, inven, cn, s));

			}

		});
		buttonMyItem10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = 10;
				int i = inven.getInven10();
				ViewUtil.changePanel(mf, mainPage, new MineInfoView(mf, i, n, inven, cn, s));

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
		this.repaint();
		this.revalidate();

	}

}

package com.npng.onepiece.shop.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.inventory.model.dto.InvenrtoryDTO;
import com.npng.onepiece.shop.model.dto.ItemDTO;
import com.npng.onepiece.user.view.MainFrame;

public class ShopInfoView extends JPanel {

	private MainFrame  mf;
	private ShopInfoView mainPageI;
	private Image img;
	private List<ItemDTO> shopList;



	public ShopInfoView (MainFrame mf, int i, InvenrtoryDTO inven) {
		
///////////////////////////////////////////////////////////////////////////	
		//2 3 8 9 14 15 19
		ItemDTO item1 = new ItemDTO();
		item1.setNum(2);
		item1.setName("토르의 망치");
		item1.setPrice(100);
		item1.setCate("무기");
		item1.setGrade("노말");
		item1.setEq_yn("N");

		ItemDTO item2 = new ItemDTO();
		item2.setNum(3);
		item2.setName("유바시리");
		item2.setPrice(500);
		item2.setCate("무기");
		item2.setGrade("레어");
		item2.setEq_yn("N");

		ItemDTO item3 = new ItemDTO();
		item3.setNum(8);
		item3.setName("해적두건");
		item3.setPrice(100);
		item3.setCate("방어구");
		item3.setGrade("노멀");
		item3.setEq_yn("N");

		ItemDTO item4 = new ItemDTO();
		item4.setNum(9);
		item4.setName("쵸파모자");
		item4.setPrice(500);
		item4.setCate("방어구");
		item4.setGrade("레어");
		item4.setEq_yn("N");

		ItemDTO item5 = new ItemDTO();
		item5.setNum(14);
		item5.setName("마이스터이어링");
		item5.setPrice(500);
		item5.setCate("장신구");
		item5.setGrade("노멀");
		item5.setEq_yn("N");
		
		ItemDTO item6 = new ItemDTO();
		item6.setNum(15);
		item6.setName("하프이어링");
		item6.setPrice(500);
		item6.setCate("장신구");
		item6.setGrade("레어");
		item6.setEq_yn("N");

		ItemDTO item7 = new ItemDTO();
		item7.setNum(19);
		item7.setName("커피");
		item7.setPrice(200);
		item7.setCate("포션");

		
		shopList = new ArrayList<ItemDTO>();

		shopList.add(item1);
		shopList.add(item2);
		shopList.add(item3);
		shopList.add(item4);
		shopList.add(item5);
		shopList.add(item6);
		shopList.add(item7);
		
		System.out.println(shopList.size());
		System.out.println(shopList.get(i));
		
	

//////////////////////////////////////////////////////////////////////
		
		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.mainPageI = this;
		
		
		JLabel labelName = new JLabel("이름 : " + shopList.get(i).getName());
		JLabel labelCate = new JLabel("종류 : "+ shopList.get(i).getCate());
		JLabel labelGrade = new JLabel("등급 : "+ shopList.get(i).getGrade());
		JLabel labelPrice = new JLabel("가격 : " + shopList.get(i).getPrice());
		
		JLabel MoneyLabel = new JLabel("소지금 : " + inven.getGold() + "G");
		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/shop/store_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));


		JLabel labelBoard = new JLabel(new ImageIcon());

		Image img2 = new ImageIcon("image/shop/infoBoard.PNG").getImage().getScaledInstance(300, 615, 0);
		labelBoard.setIcon(new ImageIcon(img2));

		JLabel labelIcon = new JLabel(new ImageIcon());

		Image img3 = new ImageIcon("image/shop/item/" + shopList.get(i).getNum() +".PNG").getImage();
		labelIcon.setIcon(new ImageIcon(img3));


		System.out.println("image/shop/item/" + shopList.get(i).getNum() +".PNG");



		JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));
		JButton buttonBuy = new JButton(new ImageIcon("image/shop/buttonBuy.PNG"));
		JButton buttonCancle = new JButton(new ImageIcon("image/shop/buttonCancle.PNG"));

		JButton buttonItem1 = new JButton(new ImageIcon("image/shop/item/2.PNG"));
		JButton buttonItem2 = new JButton(new ImageIcon("image/shop/item/3.PNG"));
		JButton buttonItem3 = new JButton(new ImageIcon("image/shop/item/8.PNG"));
		JButton buttonItem4 = new JButton(new ImageIcon("image/shop/item/9.PNG"));
		JButton buttonItem5 = new JButton(new ImageIcon("image/shop/item/14.PNG"));
		JButton buttonItem6 = new JButton(new ImageIcon("image/shop/item/15.PNG"));
		JButton buttonItem7 = new JButton(new ImageIcon("image/shop/item/19.PNG"));

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
		buttonBuy.setBounds(780, 600, 100, 35);
		buttonCancle.setBounds(930, 600, 100, 35);

		buttonItem1.setBounds(50, 100, 90, 90);
		buttonItem2.setBounds(160, 100, 90, 90);
		buttonItem3.setBounds(270, 100, 90, 90);
		buttonItem4.setBounds(380, 100, 90, 90);
		buttonItem5.setBounds(490, 100, 90, 90);
		buttonItem6.setBounds(50, 220, 90, 90);
		buttonItem7.setBounds(160, 220, 90, 90);


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


		Font font = new Font("맑은 고딕", Font.PLAIN, 20);
		labelName.setFont(font); 
		labelName.setBounds(820, 250, 200, 100);
		labelName.setForeground(Color.WHITE);

		labelCate.setFont(font); 
		labelCate.setBounds(820, 300, 200, 100);
		labelCate.setForeground(Color.WHITE);

		labelGrade.setFont(font); 
		labelGrade.setBounds(820, 350, 200, 100);
		labelGrade.setForeground(Color.WHITE);

		labelPrice.setFont(font); 
		labelPrice.setBounds(820, 400, 200, 100);
		labelPrice.setForeground(Color.WHITE);

		labelIcon.setBounds(850, 150 , 90, 90);

		labelBoard.setBounds(750, 50, 310, 620);
		
		
		
		buttonBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if((inven.getGold() - shopList.get(i).getPrice()) < 0) {
					System.out.println("돈이없자너");
					ViewUtil.changePanel(mf, mainPageI, new ShopView(mf, inven));
					return;
				}
				
				int cal = inven.getGold() - shopList.get(i).getPrice();
				
				if(i == 6) {
					inven.setGold(cal);
					System.out.println("목숨회복");
					System.out.println(inven);
					ViewUtil.changePanel(mf, mainPageI, new ShopView(mf, inven));
					return;
					
				}
				
				if((inven.getInven1() != 0) && (inven.getInven2() != 0) && (inven.getInven3() != 0) && (inven.getInven4() != 0) && (inven.getInven5() != 0)
						&& (inven.getInven6() != 0) && (inven.getInven7() != 0) && (inven.getInven8() != 0) && (inven.getInven9() != 0) && (inven.getInven10() != 0) ) {
					System.out.println("인벤 꽉 찼어!");
					ViewUtil.changePanel(mf, mainPageI, new ShopView(mf, inven));
					return;
				}
				
				
				
				if(inven.getInven1() == 0) {
					inven.setInven1(shopList.get(i).getNum());
				} else if (inven.getInven2() == 0) {
					inven.setInven2(shopList.get(i).getNum());
				} else if (inven.getInven3() == 0) {
					inven.setInven3(shopList.get(i).getNum());
				} else if (inven.getInven4() == 0) {
					inven.setInven4(shopList.get(i).getNum());
				} else if (inven.getInven5() == 0) {
					inven.setInven5(shopList.get(i).getNum());
				} else if (inven.getInven6() == 0) {
					inven.setInven6(shopList.get(i).getNum());
				} else if (inven.getInven7() == 0) {
					inven.setInven7(shopList.get(i).getNum());
				} else if (inven.getInven8() == 0) {
					inven.setInven8(shopList.get(i).getNum());
				} else if (inven.getInven9() == 0) {
					inven.setInven9(shopList.get(i).getNum());
				} else if (inven.getInven10() == 0) {
					inven.setInven10(shopList.get(i).getNum());
				}
				
				inven.setGold(cal);
				System.out.println(inven);
				ViewUtil.changePanel(mf, mainPageI, new ShopView(mf, inven));

			}

		});
		buttonCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ViewUtil.changePanel(mf, mainPageI, new ShopView(mf, inven));

			}

		});


		label.add(labelIcon);


		
		label.add(labelName);
		label.add(labelCate);
		
		if(shopList.get(i).getGrade() == null) {
		labelGrade = new JLabel("효과 : 목숨 1회복");
		labelGrade.setFont(font); 
		labelGrade.setBounds(820, 350, 200, 100);
		labelGrade.setForeground(Color.WHITE);
		}
		label.add(labelGrade);
		label.add(labelPrice);


		label.add(buttonBuy);
		label.add(buttonCancle);
		label.add(buttonExit);

		label.add(labelBoard);
		label.add(MoneyLabel);

		label.add(buttonItem1);
		label.add(buttonItem2);
		label.add(buttonItem3);
		label.add(buttonItem4);
		label.add(buttonItem5);
		label.add(buttonItem6);
		label.add(buttonItem7);

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
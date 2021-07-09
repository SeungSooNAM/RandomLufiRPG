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

import com.npng.onepiece.character.controller.CharacterController;
import com.npng.onepiece.character.model.dto.CharacterDTO;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.inventory.controller.InventoryController;
import com.npng.onepiece.inventory.model.dto.ASCDTO;
import com.npng.onepiece.inventory.model.dto.ArmorDTO;
import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;
import com.npng.onepiece.inventory.model.dto.WeaponDTO;
import com.npng.onepiece.shop.controller.ShopController;
import com.npng.onepiece.user.view.MainFrame;

public class ShopInfoView extends JPanel {

	private MainFrame  mf;
	private ShopInfoView mainPageI;
	private Image img;
	private List<ItemDTO> shopList;
	private List<WeaponDTO> weaponList;
	private List<ArmorDTO> armorList;
	private List<ASCDTO> ascList;
	private ShopController shopControl;
	
	private int status1;
	private int status2;

	//	i는 상점의 몇번쨰 칸인지
	public ShopInfoView (MainFrame mf, int i, InventoryDTO inven, int cn, int s) {


		shopControl = new ShopController();
		shopList = shopControl.getShopInfo();
		
		if(s == 1) {
			shopList = shopControl.getSpecialShopInfo1();
		}
		if(s == 2) {
			shopList = shopControl.getSpecialShopInfo2();
		}
		if(s == 3) {
			shopList = shopControl.getSpecialShopInfo3();
		}
		
		
		InventoryController itemInfo = new InventoryController();
		
		weaponList = itemInfo.getWeaponInfo();
		armorList = itemInfo.getArmorInfo();
		ascList = itemInfo.getASCInfo();
		
		status1 = 0;
		status2 = 0;
		
		for(int k = 0; k < 6; k++) {
			if(weaponList.get(k).getNum() == shopList.get(i).getNum()) {
				status1 = weaponList.get(k).getAtk();
				status2 = weaponList.get(k).getStr();

				break;
			} else if (armorList.get(k).getNum() == shopList.get(i).getNum()) {
				status1 = armorList.get(k).getHp();
				status2 = armorList.get(k).getDex();

				break;
			}else if (ascList.get(k).getNum() == shopList.get(i).getNum()) {
				status1 = ascList.get(k).getCha();
				status2 = ascList.get(k).getMp();

				break;
			}
		}

		System.out.println(shopList.size());
		System.out.println(shopList.get(i));
		
		


		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.mainPageI = this;


		JLabel labelName = new JLabel("이름 : " + shopList.get(i).getName());
		JLabel labelCate = new JLabel("종류 : "+ shopList.get(i).getCate());
		JLabel labelGrade = new JLabel("등급 : "+ shopList.get(i).getGrade());
		JLabel labelPrice = new JLabel("가격 : " + shopList.get(i).getPrice());
		
		JLabel labelSpec1 = new JLabel();
		JLabel labelSpec2 = new JLabel();

		if(shopList.get(i).getNum() >= 1 && shopList.get(i).getNum() < 7) {
			labelSpec1 = new JLabel("공격력 : " + status1);
			labelSpec2 = new JLabel("힘 : " + status2);
		} else if(shopList.get(i).getNum() >= 7 && shopList.get(i).getNum() < 13) {
			labelSpec1 = new JLabel("hp : " + status1);
			labelSpec2 = new JLabel("민첩 : " + status2);
		} else if(shopList.get(i).getNum() >= 13 && shopList.get(i).getNum() < 19) {
			labelSpec1 = new JLabel("카리스마 : " + status1);
			labelSpec2 = new JLabel("mp : " + status2);
		}
		
		
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
		buttonBuy.setBounds(780, 600, 100, 35);
		buttonCancle.setBounds(930, 600, 100, 35);

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






		Font fontM = new Font("맑은 고딕", Font.PLAIN, 15);
		MoneyLabel.setFont(fontM); 
		MoneyLabel.setBounds(950, 5, 300, 100);


		Font font = new Font("맑은 고딕", Font.PLAIN, 15);
		labelName.setFont(font); 
		labelName.setBounds(800, 250, 200, 100);
		labelName.setForeground(Color.WHITE);

		labelCate.setFont(font); 
		labelCate.setBounds(800, 300, 200, 100);
		labelCate.setForeground(Color.WHITE);

		labelGrade.setFont(font); 
		labelGrade.setBounds(800, 350, 200, 100);
		labelGrade.setForeground(Color.WHITE);

		labelPrice.setFont(font); 
		labelPrice.setBounds(800, 400, 200, 100);
		labelPrice.setForeground(Color.WHITE);
		
		labelSpec1.setFont(font); 
		labelSpec1.setBounds(900, 300, 200, 100);
		labelSpec1.setForeground(Color.WHITE);
		
		labelSpec2.setFont(font); 
		labelSpec2.setBounds(900, 350, 200, 100);
		labelSpec2.setForeground(Color.WHITE);

		labelIcon.setBounds(850, 150 , 90, 90);

		labelBoard.setBounds(750, 50, 310, 620);




		buttonBuy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if((inven.getGold() - shopList.get(i).getPrice()) < 0) {
					JLabel alarm = new JLabel("돈이 부족합니다.");
					ViewUtil.changePanel(mf, mainPageI, new ShopAlarmView(mf, alarm, inven, cn, s));
					return;
				}

				if((inven.getInven1() != 0) && (inven.getInven2() != 0) && (inven.getInven3() != 0) && (inven.getInven4() != 0) && (inven.getInven5() != 0)
						&& (inven.getInven6() != 0) && (inven.getInven7() != 0) && (inven.getInven8() != 0) && (inven.getInven9() != 0) && (inven.getInven10() != 0) ) {
					JLabel alarm = new JLabel("인벤토리 자리없음");
					ViewUtil.changePanel(mf, mainPageI, new ShopAlarmView(mf, alarm, inven, cn, s));

					return;
				}

				if(inven.getInven1() == shopList.get(i).getNum() || inven.getInven2() == shopList.get(i).getNum() || inven.getInven3() == shopList.get(i).getNum()
						|| inven.getInven4() == shopList.get(i).getNum() || inven.getInven5() == shopList.get(i).getNum() || inven.getInven6() == shopList.get(i).getNum()
						|| inven.getInven7() == shopList.get(i).getNum() || inven.getInven8() == shopList.get(i).getNum() || inven.getInven9() == shopList.get(i).getNum()
						|| inven.getInven10() == shopList.get(i).getNum()) {

					JLabel alarm = new JLabel("이미 보유중 ");


					ViewUtil.changePanel(mf, mainPageI, new ShopAlarmView(mf, alarm, inven, cn, s));
					return;
				}
				int cal = inven.getGold() - shopList.get(i).getPrice();

				if(i == 9) {
					inven.setGold(cal);
					System.out.println("목숨1회복");
					
//					캐릭터dto db에서 받아오기
//					int life = 캐릭터DTO.getLife 에서 받아오기
					CharacterDTO charDTO = new CharacterDTO();
					CharacterController charControl = new CharacterController();
					InventoryController itemInfo = new InventoryController();
					
					charDTO = charControl.lookChInfo(cn);
					int life = charDTO.getLife();
					life += 1;
					
//					캐릭터DTO.setLife(life)
//					db에 캐릭터DTO덮어쓰기
					charDTO.setLife(life);
					itemInfo.applyStatus(cn, charDTO);

					
					shopControl.tradeExecute(cn, inven);
					ViewUtil.changePanel(mf, mainPageI, new ShopView(mf, cn ,s));
					return;

				}
				
				
				//순서대로 인벤 빈칸 찾아서 번호 넣기
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

				shopControl.tradeExecute(cn, inven);

				ViewUtil.changePanel(mf, mainPageI, new ShopView(mf, cn, s));


			}

		});
		buttonCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ViewUtil.changePanel(mf, mainPageI, new ShopView(mf, cn, s));

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
		label.add(labelSpec1);
		label.add(labelSpec2);


		label.add(buttonBuy);
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
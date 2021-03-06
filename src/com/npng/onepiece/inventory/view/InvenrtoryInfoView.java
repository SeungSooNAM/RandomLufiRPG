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

import com.npng.onepiece.character.controller.CharacterController;
import com.npng.onepiece.character.model.dto.CharacterDTO;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.inventory.controller.InventoryController;
import com.npng.onepiece.inventory.model.dto.ASCDTO;
import com.npng.onepiece.inventory.model.dto.ArmorDTO;
import com.npng.onepiece.inventory.model.dto.EquipDTO;
import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;
import com.npng.onepiece.inventory.model.dto.WeaponDTO;
import com.npng.onepiece.user.view.MainFrame;

public class InvenrtoryInfoView extends JPanel {

	private MainFrame  mf;
	private InvenrtoryInfoView mainPage2;
	private Image img;
	private Image img2;
	private List<ItemDTO> itemList;
	private List<WeaponDTO> weaponList;
	private List<ArmorDTO> armorList;
	private List<ASCDTO> ascList;

	//	W1, W2 장비 중인 무기 스탯, A1, A2 장비중인 방어구 스탯, AC1, AC2 장비중인 악세사리 스탯
	private int statusW1;
	private int statusW2;
	private int statusA1;
	private int statusA2;
	private int statusAC1;
	private int statusAC2;

	//	status1, status2 선택된 아이템의 스탯
	private int status1;
	private int status2;

	//n 몇번째 인벤칸인지, i 아이템번호, isE 장착여부
	public InvenrtoryInfoView (MainFrame mf, int i, int n, InventoryDTO inven, EquipDTO equip, int isE, int cn) {
		//아이템 정보조회
		InventoryController itemInfo = new InventoryController();
		itemList = itemInfo.getItemInfo();
		ItemDTO selectedItem = new ItemDTO();

		for(int k = 0; k < itemList.size(); k++) {
			if(itemList.get(k).getNum() == i) {
				selectedItem = itemList.get(k);
			}
		}
		weaponList = itemInfo.getWeaponInfo();
		armorList = itemInfo.getArmorInfo();
		ascList = itemInfo.getASCInfo();

		statusW1 = 0;
		statusW2= 0;
		statusA1 = 0;
		statusA2= 0;
		statusAC1 = 0;
		statusAC2= 0;

		for(int k = 0; k < 6; k++) {
			if(weaponList.get(k).getNum() == equip.geteWeaponNum()) {			
				statusW1 = weaponList.get(k).getAtk();
				statusW2 = weaponList.get(k).getStr();

			} 
			if (armorList.get(k).getNum() == equip.geteArmorNum()) {
				statusA1 = armorList.get(k).getHp();
				statusA2 = armorList.get(k).getDex();

			}
			if (ascList.get(k).getNum() == equip.geteASCNum()) {
				statusAC1 = ascList.get(k).getCha();
				statusAC2 = ascList.get(k).getMp();

			}
		}

		System.out.println("장착중인 칼 스펙1 : " + statusW1);
		System.out.println("장착중인 캏 스펙2 : " + statusW2);
		System.out.println("장착중인 갑옷 스펙1 : " + statusA1);
		System.out.println("장착중인 갑스펙2 : " + statusA2);
		System.out.println("장착중인 악세 스펙1 : " + statusAC1);
		System.out.println("장착중인 악세 스펙2 : " + statusAC2);
		status1 = 0;
		status2 = 0;

		for(int k = 0; k < 6; k++) {
			if(weaponList.get(k).getNum() == i) {
				status1 = weaponList.get(k).getAtk();
				status2 = weaponList.get(k).getStr();

				break;
			} else if (armorList.get(k).getNum() == i) {
				status1 = armorList.get(k).getHp();
				status2 = armorList.get(k).getDex();

				break;
			}else if (ascList.get(k).getNum() == i) {
				status1 = ascList.get(k).getCha();
				status2 = ascList.get(k).getMp();

				break;
			}
		}


		//장비창 정보조회 및 인벤 내 장착장비 판단
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
		for(int j = 0; j < 10; j++) {
			invenE[j] = 0;
		}

		for(int j = 0; j < 10; j++) {
			if(invenNum[j] >= 1 && invenNum[j] < 7) {
				if (equip.geteWeaponNum() == invenNum[j]) {
					invenE[j] = 1;
				}
			} else if (invenNum[j] >= 7 && invenNum[j] < 13) {
				if (equip.geteArmorNum() == invenNum[j]) {
					invenE[j] = 1;
				}
			} else if (invenNum[j] >= 13 && invenNum[j] < 19) {
				if (equip.geteASCNum() == invenNum[j]) {
					invenE[j] = 1;
				}
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

		JLabel labelSpec1 = new JLabel();
		JLabel labelSpec2 = new JLabel();

		if(i >= 1 && i < 7) {
			labelSpec1 = new JLabel("공격력 : " + status1);
			labelSpec2 = new JLabel("힘 : " + status2);
		} else if(i >= 7 && i < 13) {
			labelSpec1 = new JLabel("hp : " + status1);
			labelSpec2 = new JLabel("민첩 : " + status2);
		} else if(i >= 13 && i < 19) {
			labelSpec1 = new JLabel("카리스마 : " + status1);
			labelSpec2 = new JLabel("mp : " + status2);
		}


		System.out.println(armorList);
		System.out.println(status1);
		System.out.println(status2);

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

		this.img = new ImageIcon("image/shop/inven_bg_info.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));


		JLabel labelIcon = new JLabel(new ImageIcon());
		this.img2 = new ImageIcon("image/shop/item/" + selectedItem.getNum() +".PNG").getImage();
		labelIcon.setIcon(new ImageIcon(img2));



		JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));
		JButton buttonEquip;
		if(isE == 0) {
			buttonEquip = new JButton(new ImageIcon("image/shop/buttonEquip.PNG"));
		}else {
			buttonEquip = new JButton(new ImageIcon("image/shop/buttonClear.PNG"));
		}

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
		labelName.setBounds(650, 350, 400, 20);
		labelName.setForeground(Color.WHITE);

		labelCate.setFont(font); 
		labelCate.setBounds(650, 390, 200, 20);
		labelCate.setForeground(Color.WHITE);

		labelGrade.setFont(font); 
		labelGrade.setBounds(650, 430, 200, 20);
		labelGrade.setForeground(Color.WHITE);

		labelSpec1.setFont(font);
		labelSpec1.setBounds(900, 350, 400, 20);
		labelSpec1.setForeground(Color.WHITE);

		labelSpec2.setFont(font);
		labelSpec2.setBounds(900, 390, 200, 20);
		labelSpec2.setForeground(Color.WHITE);



		buttonCancle.setBounds(900, 500, 150, 54);
		buttonEquip.setBounds(600, 500, 150, 54);
		labelIcon.setBounds(800, 250, 90, 90);

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



		label.add(buttonCancle);
		label.add(buttonEquip);
		label.add(labelName);
		label.add(labelCate);
		label.add(labelGrade);
		label.add(labelSpec1);
		label.add(labelSpec2);

		label.add(labelIcon);



		buttonEquip.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int k = 0;
				if (isE == 0) {
					k = i;
				} else {
					k = 0;
				}

				InventoryController itemInfo = new InventoryController();
				CharacterDTO charDTO = new CharacterDTO();
				CharacterController charControl = new CharacterController();
				charDTO = charControl.lookChInfo(cn);
				
				int atk = charDTO.getAtk();
				int str = charDTO.getStr();
				int hp = charDTO.getHp();
				int dex = charDTO.getDex();
				int cha = charDTO.getCharisma();
				int mp = charDTO.getMp();
				
				System.out.println(charDTO);

				if(i >= 1 && i < 7) {
					atk -= statusW1;  //장비 중이었던거 스탯 제거
					str -= statusW2;
					System.out.println("장착중이던 칼 스펙1 : " + statusW1);
					System.out.println("장착중이던 캏 스펙2 : " + statusW2);
					if(isE == 0) {
						atk += status1;  //지금 장착한거 스탯+
						str += status2;
					}
					equip.seteWeaponNum(k);


				} else if(i >= 7 && i < 13) {

					hp -= statusA1;  //장비 중이었던거 스탯 제거
					dex -= statusA2;
					System.out.println("장착중이던 갑옷 스펙1 : " + statusA1);
					System.out.println("장착중이던 갑옷 스펙2 : " + statusA2);
					if(isE == 0) {
						hp += status1;  //지금 장착한거 스탯+
						dex += status2;
					}
					equip.seteArmorNum(k);

				} else if(i >= 13 && i < 19) {

					cha -= statusAC1;  //장비 중이었던거 스탯 제거
					mp -= statusAC2;
					System.out.println("장착중이던 악세 스펙1 : " + statusAC1);
					System.out.println("장착중이던 악세 스펙2 : " + statusAC2);
					if (isE == 0) {
						cha += status1;  //지금 장착한거 스탯+
						mp += status2;
					}
					equip.seteASCNum(k);

				}
				charDTO.setAtk(atk);
				charDTO.setStr(str);
				charDTO.setHp(hp);
				charDTO.setDex(dex);
				charDTO.setCharisma(cha);
				charDTO.setMp(mp);
				
//				charDTO정보 db에 덮어쓰기
				itemInfo.applyStatus(cn, charDTO);
				

				itemInfo.registEquip(cn, equip);

//				System.out.println("지금 장착한 능력치1 출력 : " + status1);
//				System.out.println("지금 장착한 능력치2 출력 : " + status2);
				System.out.println(charDTO);
				ViewUtil.changePanel(mf, mainPage2, new InventoryView(mf,cn));
			}


		});
		buttonCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ViewUtil.changePanel(mf, mainPage2, new InventoryView(mf,cn));
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



	}

}
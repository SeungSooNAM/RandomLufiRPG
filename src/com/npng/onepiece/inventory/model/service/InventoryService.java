package com.npng.onepiece.inventory.model.service;

import java.util.ArrayList;
import java.util.List;

import com.npng.onepiece.inventory.model.dto.ASCDTO;
import com.npng.onepiece.inventory.model.dto.ArmorDTO;
import com.npng.onepiece.inventory.model.dto.EquipDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;
import com.npng.onepiece.inventory.model.dto.WeaponDTO;

public class InventoryService {
	
	private EquipDTO equip;
	public List<ItemDTO> getItemInfo() {

		ItemDTO item1 = new ItemDTO();
		item1.setNum(1);
		item1.setName("칼");
		item1.setPrice(100);
		item1.setCate("무기");
		item1.setGrade("노말");
		item1.setEq_yn("N");
		
		ItemDTO item2 = new ItemDTO();
		item2.setNum(2);
		item2.setName("토르의 망치");
		item2.setPrice(100);
		item2.setCate("무기");
		item2.setGrade("노말");
		item2.setEq_yn("N");

		ItemDTO item3 = new ItemDTO();
		item3.setNum(3);
		item3.setName("유바시리");
		item3.setPrice(500);
		item3.setCate("무기");
		item3.setGrade("레어");
		item3.setEq_yn("N");

		

		ItemDTO item4 = new ItemDTO();
		item4.setNum(4);
		item4.setName("장인의검");
		item4.setPrice(500);
		item4.setCate("무기");
		item4.setGrade("레어");
		item4.setEq_yn("N");

		ItemDTO item5 = new ItemDTO();
		item5.setNum(5);
		item5.setName("화도일문자");
		item5.setPrice(1000);
		item5.setCate("무기");
		item5.setGrade("유니크");
		item5.setEq_yn("N");

		ItemDTO item6 = new ItemDTO();
		item6.setNum(6);
		item6.setName("슈스이");
		item6.setPrice(1000);
		item6.setCate("무기");
		item6.setGrade("유니크");
		item6.setEq_yn("N");

		ItemDTO item7 = new ItemDTO();
		item7.setNum(7);
		item7.setName("밀짚모자");
		item7.setPrice(100);
		item7.setCate("방어구");
		item7.setGrade("노말");
		item7.setEq_yn("N");
		
		ItemDTO item8 = new ItemDTO();
		item8.setNum(8);
		item8.setName("해적두건");
		item8.setPrice(100);
		item8.setCate("방어구");
		item8.setGrade("노말");
		item8.setEq_yn("N");
		
		ItemDTO item9 = new ItemDTO();
		item9.setNum(9);
		item9.setName("쵸파모자");
		item9.setPrice(500);
		item9.setCate("방어구");
		item9.setGrade("레어");
		item9.setEq_yn("N");
		
		ItemDTO item10 = new ItemDTO();
		item10.setNum(10);
		item10.setName("캡틴아메리카방패");
		item10.setPrice(500);
		item10.setCate("방어구");
		item10.setGrade("레어");
		item10.setEq_yn("N");
		
		ItemDTO item11 = new ItemDTO();
		item11.setNum(11);
		item11.setName("에이스모자");
		item11.setPrice(1000);
		item11.setCate("방어구");
		item11.setGrade("유니크");
		item11.setEq_yn("N");
		
		ItemDTO item12 = new ItemDTO();
		item12.setNum(12);
		item12.setName("거프모자");
		item12.setPrice(200);
		item12.setCate("방어구");
		item12.setGrade("유니크");
		item12.setEq_yn("N");
		
		ItemDTO item13 = new ItemDTO();
		item13.setNum(13);
		item13.setName("은반지");
		item13.setPrice(100);
		item13.setCate("장신구");
		item13.setGrade("노말");
		item13.setEq_yn("N");
		
		ItemDTO item14 = new ItemDTO();
		item14.setNum(14);
		item14.setName("마이스터 이어링");
		item14.setPrice(100);
		item14.setCate("장신구");
		item14.setGrade("노말");
		item14.setEq_yn("N");
		
		ItemDTO item15 = new ItemDTO();
		item15.setNum(15);
		item15.setName("하프이어링");
		item15.setPrice(500);
		item15.setCate("장신구");
		item15.setGrade("레어");
		item15.setEq_yn("N");
		
		ItemDTO item16 = new ItemDTO();
		item16.setNum(16);
		item16.setName("마이스터링");
		item16.setPrice(500);
		item16.setCate("장신구");
		item16.setGrade("레어");
		item16.setEq_yn("N");
		
		ItemDTO item17 = new ItemDTO();
		item17.setNum(17);
		item17.setName("블루 링");
		item17.setPrice(1000);
		item17.setCate("장신구");
		item17.setGrade("유니크");
		item17.setEq_yn("N");
		
		ItemDTO item18 = new ItemDTO();
		item18.setNum(18);
		item18.setName("블루 팬던트");
		item18.setPrice(1000);
		item18.setCate("장신구");
		item18.setGrade("유니크");
		item18.setEq_yn("N");
		
		ItemDTO item19 = new ItemDTO();
		item19.setNum(19);
		item19.setName("커피");
		item19.setPrice(200);
		item19.setCate("포션");
		item19.setGrade("유니크");
		item19.setEq_yn("N");
		
		List<ItemDTO> itemList = new ArrayList<ItemDTO>();

	
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		itemList.add(item4);
		itemList.add(item5);
		itemList.add(item6);
		itemList.add(item7);
		itemList.add(item8);
		itemList.add(item9);
		itemList.add(item10);
		itemList.add(item11);
		itemList.add(item12);
		itemList.add(item13);
		itemList.add(item14);
		itemList.add(item15);
		itemList.add(item16);
		itemList.add(item17);
		itemList.add(item18);
		itemList.add(item19);
		return itemList;
	}

	public EquipDTO getEquipInfo() {
		equip = new EquipDTO();
		
		equip.seteArmorNum(0);
		equip.seteArmorNum(7);
		equip.seteASCNum(0);
		return equip;
	}

	public void equipChange(int i, int k) {
		equip = new EquipDTO();
		if(i == 1) {
			equip.seteArmorNum(k);
		} else if(i == 2) {
			equip.seteArmorNum(k);
		} else if(i == 3) {
			equip.seteASCNum(k);
		}
		
	}

	public List<WeaponDTO> getWeaponInfo() {
		WeaponDTO w1 = new WeaponDTO();
		w1.setStr(0);
		w1.setAtk(30);
		w1.setNum(1);
		
		WeaponDTO w2 = new WeaponDTO();
		w2.setStr(3);
		w2.setAtk(35);
		w2.setNum(2);
		
		WeaponDTO w3 = new WeaponDTO();
		w3.setStr(8);
		w3.setAtk(45);
		w3.setNum(3);
		
		WeaponDTO w4 = new WeaponDTO();
		w4.setStr(5);
		w4.setAtk(50);
		w4.setNum(4);
		
		WeaponDTO w5 = new WeaponDTO();
		w5.setStr(15);
		w5.setAtk(60);
		w5.setNum(5);
		
		WeaponDTO w6 = new WeaponDTO();
		w6.setStr(10);
		w6.setAtk(70);
		w6.setNum(6);
		
		List<WeaponDTO> weaponList = new ArrayList<WeaponDTO>();

		
		weaponList.add(w1);
		weaponList.add(w2);
		weaponList.add(w3);
		weaponList.add(w4);
		weaponList.add(w5);
		weaponList.add(w6);
		return weaponList;
	}

	public List<ArmorDTO> getArmorInfo() {

		ArmorDTO w1 = new ArmorDTO();
		w1.setHp(10);
		w1.setDex(0);
		w1.setNum(7);
		
		ArmorDTO w2 = new ArmorDTO();
		w2.setHp(20);
		w2.setDex(3);;
		w2.setNum(8);
		
		ArmorDTO w3 = new ArmorDTO();
		w3.setHp(40);
		w3.setDex(8);
		w3.setNum(9);
		
		ArmorDTO w4 = new ArmorDTO();
		w4.setHp(50);
		w4.setDex(5);
		w4.setNum(10);
		
		ArmorDTO w5 = new ArmorDTO();
		w5.setHp(80);;
		w5.setDex(15);
		w5.setNum(11);
		
		ArmorDTO w6 = new ArmorDTO();
		w6.setHp(100);
		w6.setDex(10);
		w6.setNum(12);
		
		List<ArmorDTO> armorList = new ArrayList<ArmorDTO>();

		
		armorList.add(w1);
		armorList.add(w2);
		armorList.add(w3);
		armorList.add(w4);
		armorList.add(w5);
		armorList.add(w6);
		return armorList;
	}

	public List<ASCDTO> getASCInfo() {
		ASCDTO w1 = new ASCDTO();
		w1.setCha(0);
		w1.setMp(10);
		w1.setNum(13);
		
		ASCDTO w2 = new ASCDTO();
		w2.setCha(3);
		w2.setMp(20);
		w2.setNum(14);
		
		ASCDTO w3 = new ASCDTO();
		w3.setCha(8);
		w3.setMp(25);
		w3.setNum(15);
		
		ASCDTO w4 = new ASCDTO();
		w4.setCha(5);
		w4.setMp(30);
		w4.setNum(16);
		
		ASCDTO w5 = new ASCDTO();
		w5.setCha(15);
		w5.setMp(40);
		w5.setNum(17);
		
		ASCDTO w6 = new ASCDTO();
		w6.setCha(10);
		w6.setMp(50);
		w6.setNum(18);
		
		List<ASCDTO> acInfo = new ArrayList<ASCDTO>();
		acInfo.add(w1);
		acInfo.add(w2);
		acInfo.add(w3);
		acInfo.add(w4);
		acInfo.add(w5);
		acInfo.add(w6);
		return acInfo;
	}

}

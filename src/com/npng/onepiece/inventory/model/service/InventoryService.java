package com.npng.onepiece.inventory.model.service;

import java.util.ArrayList;
import java.util.List;

import com.npng.onepiece.inventory.model.dto.EquipDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;

public class InventoryService {

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
		EquipDTO equip = new EquipDTO();
		equip.seteArmorNum(0);
		equip.seteArmorNum(7);
		equip.seteASCNum(0);
		return equip;
	}

}

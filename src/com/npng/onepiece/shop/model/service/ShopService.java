package com.npng.onepiece.shop.model.service;

import java.util.ArrayList;
import java.util.List;

import com.npng.onepiece.inventory.model.dto.ItemDTO;

public class ShopService {

	public List<ItemDTO> getShopInfo() {
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
				item5.setPrice(100);
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
				item7.setPrice(5000);
				item7.setCate("포션");

				
				List<ItemDTO> shopList = new ArrayList<ItemDTO>();

				shopList.add(item1);
				shopList.add(item2);
				shopList.add(item3);
				shopList.add(item4);
				shopList.add(item5);
				shopList.add(item6);
				shopList.add(item7);
		return shopList;
	}

}

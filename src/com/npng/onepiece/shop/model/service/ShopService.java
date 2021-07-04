package com.npng.onepiece.shop.model.service;

import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.commit;
import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;
import com.npng.onepiece.shop.model.dao.ShopDAO;

public class ShopService {

	private ShopDAO shopDAO = new ShopDAO();


	public int tradeExecute(int cn, InventoryDTO inven) {
		Connection con = getConnection();



		int result = shopDAO.tradeExecute(cn, inven, con);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

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
		item3.setNum(4);
		item3.setName("장인의 검");
		item3.setPrice(500);
		item3.setCate("무기");
		item3.setGrade("레어");
		item3.setEq_yn("N");
		
		ItemDTO item4 = new ItemDTO();
		item4.setNum(8);
		item4.setName("해적두건");
		item4.setPrice(100);
		item4.setCate("방어구");
		item4.setGrade("노멀");
		item4.setEq_yn("N");

		ItemDTO item5 = new ItemDTO();
		item5.setNum(9);
		item5.setName("쵸파모자");
		item5.setPrice(500);
		item5.setCate("방어구");
		item5.setGrade("레어");
		item5.setEq_yn("N");
		
		ItemDTO item6 = new ItemDTO();
		item6.setNum(10);
		item6.setName("캡틴아메리카 방패");
		item6.setPrice(500);
		item6.setCate("방어구");
		item6.setGrade("레어");
		item6.setEq_yn("N");
		
		ItemDTO item7 = new ItemDTO();
		item7.setNum(14);
		item7.setName("마이스터이어링");
		item7.setPrice(100);
		item7.setCate("장신구");
		item7.setGrade("노멀");
		item7.setEq_yn("N");
		
		ItemDTO item8 = new ItemDTO();
		item8.setNum(15);
		item8.setName("하프이어링");
		item8.setPrice(500);
		item8.setCate("장신구");
		item8.setGrade("레어");
		item8.setEq_yn("N");
		
		ItemDTO item9 = new ItemDTO();
		item9.setNum(16);
		item9.setName("마이스터 링");
		item9.setPrice(500);
		item9.setCate("장신구");
		item9.setGrade("레어");
		item9.setEq_yn("N");
		
		ItemDTO item10 = new ItemDTO();
		item10.setNum(19);
		item10.setName("커피");
		item10.setPrice(200);
		item10.setCate("포션");


		List<ItemDTO> shopList = new ArrayList<ItemDTO>();

		shopList.add(item1);
		shopList.add(item2);
		shopList.add(item3);
		shopList.add(item4);
		shopList.add(item5);
		shopList.add(item6);
		shopList.add(item7);
		shopList.add(item8);
		shopList.add(item9);
		shopList.add(item10);

		return shopList;
	}

	public List<ItemDTO> getSpecialShopInfo1() {
		// 5 6
		ItemDTO item1 = new ItemDTO();
		item1.setNum(5);
		item1.setName("화도일문자");
		item1.setPrice(1000);
		item1.setCate("무기");
		item1.setGrade("유니크");
		item1.setEq_yn("N");

		ItemDTO item2 = new ItemDTO();
		item2.setNum(6);
		item2.setName("슈스이");
		item2.setPrice(1000);
		item2.setCate("무기");
		item2.setGrade("유니크");
		item2.setEq_yn("N");

		List<ItemDTO> shopList = new ArrayList<ItemDTO>();

		shopList.add(item1);
		shopList.add(item2);


		return shopList;
	}

	public List<ItemDTO> getSpecialShopInfo2() {
		// 11 12
		ItemDTO item1 = new ItemDTO();
		item1.setNum(11);
		item1.setName("에이스모자");
		item1.setPrice(1000);
		item1.setCate("방어구");
		item1.setGrade("유니크");
		item1.setEq_yn("N");

		ItemDTO item2 = new ItemDTO();
		item2.setNum(12);
		item2.setName("거프모자");
		item2.setPrice(1000);
		item2.setCate("방어구");
		item2.setGrade("유니크");
		item2.setEq_yn("N");

		List<ItemDTO> shopList = new ArrayList<ItemDTO>();

		shopList.add(item1);
		shopList.add(item2);


		return shopList;
	}
	
	public List<ItemDTO> getSpecialShopInfo3() {
		// 17 18
		ItemDTO item1 = new ItemDTO();
		item1.setNum(17);
		item1.setName("블루 링");
		item1.setPrice(1000);
		item1.setCate("장신구");
		item1.setGrade("유니크");
		item1.setEq_yn("N");

		ItemDTO item2 = new ItemDTO();
		item2.setNum(18);
		item2.setName("블루 팬던트");
		item2.setPrice(1000);
		item2.setCate("장신구");
		item2.setGrade("유니크");
		item2.setEq_yn("N");

		List<ItemDTO> shopList = new ArrayList<ItemDTO>();

		shopList.add(item1);
		shopList.add(item2);


		return shopList;
	}
}

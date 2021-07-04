package com.npng.onepiece.shop.controller;

import java.util.List;

import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;
import com.npng.onepiece.shop.model.service.ShopService;

public class ShopController {
	private ShopService shopService = new ShopService();;
	
	public List<ItemDTO> getShopInfo() {
		
		List<ItemDTO> itemList = shopService.getShopInfo();
		
		return itemList;
	}
	
	public List<ItemDTO> getSpecialShopInfo1() {
		
		List<ItemDTO> itemList = shopService.getSpecialShopInfo1();
		
		return itemList;
	}
public List<ItemDTO> getSpecialShopInfo2() {
		
		List<ItemDTO> itemList = shopService.getSpecialShopInfo2();
		
		return itemList;
	}
public List<ItemDTO> getSpecialShopInfo3() {
	
	List<ItemDTO> itemList = shopService.getSpecialShopInfo3();
	
	return itemList;
}

	public void tradeExecute(int cn, InventoryDTO inven) {
		
		shopService = new ShopService();
		
		int result = shopService. tradeExecute(cn, inven);
		if(result > 0) {
			System.out.println("거래성공!");
		} else {
			System.out.println("거래실패ㅠㅠ");
		}
		
	}


	

}

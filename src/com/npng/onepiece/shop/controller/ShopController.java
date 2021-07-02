package com.npng.onepiece.shop.controller;

import java.util.List;

import com.npng.onepiece.inventory.model.dto.ItemDTO;
import com.npng.onepiece.shop.model.service.ShopService;

public class ShopController {
	
	private ShopService shopService = new ShopService();
	
	public List<ItemDTO> getShopInfo() {
		List<ItemDTO> itemList = shopService.getShopInfo();
		return itemList;
	}

}

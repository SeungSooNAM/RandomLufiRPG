package com.npng.onepiece.inventory.controller;

import java.util.List;

import com.npng.onepiece.inventory.model.dto.EquipDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;
import com.npng.onepiece.inventory.model.service.InventoryService;

public class InventoryController {
	
	private InventoryService invenService = new InventoryService();
	
	public List<ItemDTO> getItemInfo() {
		List<ItemDTO> itemList = invenService.getItemInfo();
		return itemList;
	}

	public EquipDTO getEquipInfo() {
		
		EquipDTO equip = invenService.getEquipInfo();
		return equip;
	}

}

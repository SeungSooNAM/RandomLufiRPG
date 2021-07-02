package com.npng.onepiece.inventory.controller;

import java.util.List;

import com.npng.onepiece.inventory.model.dto.ASCDTO;
import com.npng.onepiece.inventory.model.dto.ArmorDTO;
import com.npng.onepiece.inventory.model.dto.EquipDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;
import com.npng.onepiece.inventory.model.dto.WeaponDTO;
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
//     i는 장비 종류, k는 아이템번호 or 0
	public void equipChange(int i, int k) {
		invenService.equipChange(i, k);
		
	}

	public List<WeaponDTO> getWeaponInfo() {
		List<WeaponDTO> wInfo = invenService.getWeaponInfo();
		
		
		return wInfo;
	}

	public List<ArmorDTO> getArmorInfo() {
		List<ArmorDTO> aInfo = invenService.getArmorInfo();
		return aInfo;
	}

	public List<ASCDTO> getASCInfo() {
		List<ASCDTO> acInfo = invenService.getASCInfo();
		return acInfo;
	}



}

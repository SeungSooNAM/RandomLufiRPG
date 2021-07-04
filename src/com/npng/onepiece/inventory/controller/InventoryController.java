package com.npng.onepiece.inventory.controller;

import java.util.List;

import com.npng.onepiece.character.model.dto.CharacterDTO;
import com.npng.onepiece.inventory.model.dto.ASCDTO;
import com.npng.onepiece.inventory.model.dto.ArmorDTO;
import com.npng.onepiece.inventory.model.dto.EquipDTO;
import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;
import com.npng.onepiece.inventory.model.dto.WeaponDTO;
import com.npng.onepiece.inventory.model.service.InventoryService;

public class InventoryController {
	
	private InventoryService invenService = new InventoryService();
	
	
	public InventoryDTO getInventoryInfo(int cn) {
		InventoryDTO inven = invenService.getInventoryInfo(cn);
		return inven;
	}
	
	public EquipDTO getEquipInfo(int cn) {
		EquipDTO equip = invenService.getEquipInfo(cn);
		return equip;
	}
	
	public List<ItemDTO> getItemInfo() {
		List<ItemDTO> itemList = invenService.getItemInfo();
		return itemList;
	}
	
	//cn은 캐릭터 번호 종류 판별
	public void registEquip(int cn, EquipDTO equip) {
		int result = invenService.registEquip(cn, equip);
		if(result > 0) {
			System.out.println("장비변경성공!");
		} else {
			System.out.println("장비변경실패ㅠㅠ");
		}
		
	}
	
	public void applyStatus(int cn, CharacterDTO charDTO) {
		// TODO Auto-generated method stub
		int result = invenService.applyStatus(cn, charDTO);
		if(result > 0) {
			System.out.println("장비 능력치 적용 성공!");
		} else {
			System.out.println("장비 능력치 적용 실패ㅠㅠ");
		}
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

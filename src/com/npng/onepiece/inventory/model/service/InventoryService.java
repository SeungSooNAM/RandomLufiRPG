package com.npng.onepiece.inventory.model.service;

import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.commit;
import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.npng.onepiece.character.model.dto.CharacterDTO;
import com.npng.onepiece.inventory.model.dao.InventoryDAO;
import com.npng.onepiece.inventory.model.dto.ASCDTO;
import com.npng.onepiece.inventory.model.dto.ArmorDTO;
import com.npng.onepiece.inventory.model.dto.EquipDTO;
import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;
import com.npng.onepiece.inventory.model.dto.WeaponDTO;

public class InventoryService {
	
	private InventoryDAO invenDAO= new InventoryDAO();
	

	
	public InventoryDTO getInventoryInfo(int cn) {
		
		Connection con = getConnection();
		
		InventoryDTO inven = invenDAO. getInventoryInfo(con, cn);
		close(con);
		return inven;
	}
	public EquipDTO getEquipInfo(int cn) {
		
		Connection con = getConnection();
		EquipDTO equip = invenDAO.getEquipInfo(con, cn);
		return equip;
	}
	
	public List<ItemDTO> getItemInfo() {

		Connection con = getConnection();
		List<ItemDTO> itemList = invenDAO.getItemInfo(con);
		close(con);
	
	
		return itemList;
	}
	
	public int registEquip(int cn, EquipDTO equip) {
		Connection con = getConnection();
		int result = invenDAO.registEquip(cn,equip, con);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public int applyStatus(int cn, CharacterDTO charDTO) {
		Connection con = getConnection();
		int result = invenDAO.applyStatus(cn, charDTO, con);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
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

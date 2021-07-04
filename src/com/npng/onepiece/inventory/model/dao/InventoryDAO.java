package com.npng.onepiece.inventory.model.dao;

import static com.npng.onepiece.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.npng.onepiece.character.model.dto.CharacterDTO;
import com.npng.onepiece.inventory.model.dto.EquipDTO;
import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.model.dto.ItemDTO;

public class InventoryDAO {


	private Properties prop;

	public InventoryDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/inven-query.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public InventoryDTO getInventoryInfo(Connection con, int cn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		InventoryDTO invenInfo = null;

		String query = prop.getProperty("selectInventory");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cn);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				invenInfo = new InventoryDTO();
				invenInfo.setCharNum(rset.getInt("CHAR_NUMBER"));
				invenInfo.setGold(rset.getInt("INVEN_GOLD"));
				invenInfo.setInven1(rset.getInt("INVEN1"));
				invenInfo.setInven2(rset.getInt("INVEN2"));
				invenInfo.setInven3(rset.getInt("INVEN3"));
				invenInfo.setInven4(rset.getInt("INVEN4"));
				invenInfo.setInven5(rset.getInt("INVEN5"));
				invenInfo.setInven6(rset.getInt("INVEN6"));
				invenInfo.setInven7(rset.getInt("INVEN7"));
				invenInfo.setInven8(rset.getInt("INVEN8"));
				invenInfo.setInven9(rset.getInt("INVEN9"));
				invenInfo.setInven10(rset.getInt("INVEN10"));


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return invenInfo;
	}


	public EquipDTO getEquipInfo(Connection con, int cn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		EquipDTO equipInfo = null;

		String query = prop.getProperty("selectEquip");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cn);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				equipInfo = new EquipDTO();
				equipInfo.setCharNum(rset.getInt("CHAR_NUMBER"));
				equipInfo.seteWeaponNum(rset.getInt("WEAPON_YN"));
				equipInfo.seteArmorNum(rset.getInt("ARMOR_YN"));
				equipInfo.seteASCNum(rset.getInt("ACS_YN"));


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return equipInfo;
	}




	public List<ItemDTO> getItemInfo(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		List<ItemDTO> itemList = null;


		String query = prop.getProperty("selectAllItem");


		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			itemList = new ArrayList<>();

			while(rset.next()) {
				ItemDTO item = new ItemDTO();

				item.setCate(rset.getString("ITEM_CATE"));
				item.setName(rset.getString("ITEM_NAME"));
				item.setPrice(rset.getInt("ITEM_PRICE"));
				item.setGrade(rset.getString("ITEM_GRADE"));
				item.setNum(rset.getInt("ITEM_NUM"));
				item.setEq_yn(rset.getString("ITEM_EQ_YN"));


				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return itemList;
	}




	public int registEquip(int cn, EquipDTO equip, Connection con) {

		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("registEquip");

		try {
			pstmt = con.prepareStatement(query);



			pstmt.setInt(1, equip.geteWeaponNum());
			pstmt.setInt(2, equip.geteArmorNum());
			pstmt.setInt(3, equip.geteASCNum());
			pstmt.setInt(4, cn);


			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}




	public int applyStatus(int cn, CharacterDTO charDTO, Connection con) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("applyStatus");

		try {
			pstmt = con.prepareStatement(query);



			pstmt.setInt(1, charDTO.getAtk());
			pstmt.setInt(2, charDTO.getStr());
			pstmt.setInt(3, charDTO.getHp());
			pstmt.setInt(4, charDTO.getDex());
			pstmt.setInt(5, charDTO.getCharisma());
			pstmt.setInt(6, charDTO.getMp());
			pstmt.setInt(7, charDTO.getLife());
			pstmt.setInt(8, cn);


			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}

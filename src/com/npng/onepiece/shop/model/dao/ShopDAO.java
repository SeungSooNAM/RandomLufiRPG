package com.npng.onepiece.shop.model.dao;

import static com.npng.onepiece.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.npng.onepiece.inventory.model.dto.InventoryDTO;

public class ShopDAO {
	
	private Properties prop;
	
	public ShopDAO() {
	prop = new Properties();
	try {
		prop.loadFromXML(new FileInputStream("mapper/inven-query.xml"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public int tradeExecute(int cn, InventoryDTO inven, Connection con) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("tradeExecute");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, inven.getGold());
			pstmt.setInt(2, inven.getInven1());
			pstmt.setInt(3, inven.getInven2());
			pstmt.setInt(4, inven.getInven3());
			pstmt.setInt(5, inven.getInven4());
			pstmt.setInt(6, inven.getInven5());
			pstmt.setInt(7, inven.getInven6());
			pstmt.setInt(8, inven.getInven7());
			pstmt.setInt(9, inven.getInven8());
			pstmt.setInt(10, inven.getInven9());
			pstmt.setInt(11, inven.getInven10());
			pstmt.setInt(12, cn);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}

package com.npng.onepiece.achievement.model.dao;

import static com.npng.onepiece.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.npng.onepiece.achievement.model.dto.AchDTO;
import com.npng.onepiece.achievement.model.dto.Ch_AchDTO;
import com.npng.onepiece.inventory.model.dto.InventoryDTO;

public class AchDAO {

	private AchDTO achDTO;
	private Properties prop; 		
	
	public AchDAO() {
		this.achDTO = new AchDTO();
		this.prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/achievement-query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Ch_AchDTO findAchievement(Connection con,int chNum, int i) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Ch_AchDTO chAchInfo = new Ch_AchDTO();

		String query = prop.getProperty("findAchievement");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, chNum);
			pstmt.setInt(2, i);

			rset = pstmt.executeQuery();

			if(rset.next()) {
				chAchInfo.setCharNum(rset.getInt("CHAR_NUM"));
				chAchInfo.setAchNum(rset.getInt("ACH_NUM"));


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return chAchInfo;
	}



	public int insertAchivement(Connection con, int chNum, int i) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertAchivement");

		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, chNum);
			pstmt.setInt(2, i);


			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}

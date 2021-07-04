package com.npng.onepiece.friend.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.npng.onepiece.friend.model.dto.FriendDTO;
import com.npng.onepiece.gameready.view.CreateCharacterView;

import static com.npng.onepiece.common.JDBCTemplate.close;

public class FriendDAO {

private Properties prop;
	
	public FriendDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/friend-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<FriendDTO> friendInfo(Connection con) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<FriendDTO> friendList = null;
		FriendDTO friend = null;
		
		
		
		String query = prop.getProperty("friendInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, CreateCharacterView.chNum);
			
			rset = pstmt.executeQuery();
			
			friendList = new ArrayList<>();
			
			while(rset.next()) {
				friend = new FriendDTO();
				friend.setFrName(rset.getString("FR_NAME"));
				friend.setFrSkill(rset.getInt("FR_SKIL"));
				friend.setFrNum(rset.getInt("FR_NUM"));
				friend.setFrMp(rset.getInt("FR_MP"));
				friend.setFrGrade(rset.getString("GRADE"));
				friendList.add(friend);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return friendList;
	}
	public int checkMoney(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int gold = 0;
		
		String query = prop.getProperty("checkMoney");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, CreateCharacterView.chNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				gold = rset.getInt("INVEN_GOLD");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return gold;
	}
	
	public int decreaseGold(Connection con, int gold) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		String query = prop.getProperty("decreaseGold");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, gold);
			System.out.println("돈: " + CreateCharacterView.chNum);
			pstmt.setInt(2, CreateCharacterView.chNum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	public int upgrade(Connection con, String name) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("upgrade");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, CreateCharacterView.chNum);
			pstmt.setString(2, name);
			System.out.println(name);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

}

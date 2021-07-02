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
			
			rset = pstmt.executeQuery();
			
			friendList = new ArrayList<>();
			
			while(rset.next()) {
				friend = new FriendDTO();
				friend.setFrName(rset.getString("FR_NAME"));
				friend.setFrSkill(rset.getInt("FR_SKIL"));
				friend.setFrGrade(rset.getString("FR_GRADE"));
				friend.setFrHave(rset.getString("FR_HAVE_YN"));
				friend.setFrNum(rset.getInt("FR_NUM"));
				friend.setFrMp(rset.getInt("FR_MP"));
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

}

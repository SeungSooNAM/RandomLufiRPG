package com.npng.onepiece.ending.model.dao;

import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.commit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Properties;

import com.npng.onepiece.ending.model.dto.EndingDTO;
import com.npng.onepiece.gameready.view.CreateCharacterView;
import com.npng.onepiece.user.model.dto.MemberDTO;



public class EndingDAO {

	private Properties prop;
	private CreateCharacterView createCharacterView;
	
	public EndingDAO() {
		
this.prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/ranking-query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public EndingDTO loadChInfo(int chNum, Connection con) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;	
		EndingDTO chInfoDTO = null;
		String query = prop.getProperty("loadChInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, chNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				chInfoDTO = new EndingDTO();
				chInfoDTO.setChName(rset.getString("CHAR_NAME"));
				chInfoDTO.setChScore(rset.getInt("CHAR_SCORE"));
				System.out.println("rset" + rset.getString("CHAR_NAME"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
			
		}
		System.out.println("chInfoDTO : " + chInfoDTO);
		return chInfoDTO;
	}

	public int updateRanking(Connection con, int chNum, EndingDTO chInfoDTO) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("InsertRanking");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, chInfoDTO.getChName());
			pstmt.setInt(2, chNum);
			pstmt.setInt(3, chInfoDTO.getChScore());	
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}

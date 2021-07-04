package com.npng.onepiece.ending.model.dao;

import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.commit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.npng.onepiece.ending.model.dto.EndingDTO;
import com.npng.onepiece.gameready.view.CreateCharacterView;



public class EndingDAO {

	private Properties prop;
	
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

	public int saveScore(EndingDTO endingDTO, Connection con) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("updateRanking");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, CreateCharacterView.chNum);
			pstmt.setString(2, endingDTO.getChName());
			pstmt.setInt(3, endingDTO.getChScore());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		
		
		return result;
	}
	
	}
	
}

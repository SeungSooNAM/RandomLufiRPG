package com.npng.onepiece.gameready.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import static com.npng.onepiece.common.JDBCTemplate.close;

import com.npng.onepiece.gameready.model.dto.NewCharacterDTO;

public class GameReadyDAO {	
	
	private Properties prop;	
	
	public GameReadyDAO() {
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/character-query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertNewCharacter(Connection con, NewCharacterDTO charDTO) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertNewCharacter");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, charDTO.getName());
			pstmt.setInt(2, charDTO.getLevel());
			pstmt.setInt(3, charDTO.getAtk());
			pstmt.setInt(4, charDTO.getHp());
			pstmt.setInt(5, charDTO.getLife());
			pstmt.setInt(6, charDTO.getExp());
			pstmt.setInt(7, charDTO.getStr());
			pstmt.setInt(8, charDTO.getDex());
			pstmt.setInt(9, charDTO.getCharisma());
			pstmt.setInt(10, charDTO.getPoint());
			pstmt.setInt(11, charDTO.getMp());
			
			pstmt.setInt(12, charDTO.getUserNum());
			pstmt.setInt(13, charDTO.getScore());
			
			result = pstmt.executeUpdate();			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}

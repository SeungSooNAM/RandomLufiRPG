package com.npng.onepiece.character.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import static com.npng.onepiece.common.JDBCTemplate.close;

import com.npng.onepiece.character.model.dto.CharacterDTO;

public class CharacterDAO {

	private CharacterDTO cDTO;
	private Properties prop;

	public CharacterDAO() {
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

	// 캐릭터 정보창 보기위해 DB에서 DTO에 캐릭터 정보 넣기
	public CharacterDTO lookChInfo(Connection con, int chNum) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("lookChInfo");
		
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, chNum);

			rset = pstmt.executeQuery();


			while (rset.next()) {
				cDTO = new CharacterDTO();

				cDTO.setName(rset.getString("CHAR_NAME"));
				cDTO.setLevel(rset.getInt("CHAR_LV"));
				cDTO.setAtk(rset.getInt("CHAR_ATK"));
				cDTO.setHp(rset.getInt("CHAR_HP"));
				cDTO.setLife(rset.getInt("CHAR_LIFE"));
				cDTO.setExp(rset.getInt("CHAR_EXP"));
				cDTO.setStr(rset.getInt("CHAR_STR"));
				cDTO.setDex(rset.getInt("CHAR_DEX"));
				cDTO.setCharisma(rset.getInt("CHAR_CHARISMA"));
				cDTO.setPoint(rset.getInt("CHAR_POINT"));
				cDTO.setMp(rset.getInt("CHAR_MP"));
				cDTO.setScore(rset.getInt("CHAR_SCORE"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(pstmt);
			close(rset);
		}

		return cDTO;
	}

	public int CharacterStrUp(Connection con, CharacterDTO charDTO, int chNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("CharacterStrUp");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, charDTO.getStr());
			pstmt.setInt(2, charDTO.getPoint());
			pstmt.setInt(3, chNum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int CharacterDexUp(Connection con, CharacterDTO charDTO, int chNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("CharacterDexUp");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, charDTO.getDex());
			pstmt.setInt(2, charDTO.getPoint());
			pstmt.setInt(3, chNum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int CharacterChaUp(Connection con, CharacterDTO charDTO, int chNum) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("CharacterChaUp");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, charDTO.getCharisma());
			pstmt.setInt(2, charDTO.getPoint());
			pstmt.setInt(3, chNum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}

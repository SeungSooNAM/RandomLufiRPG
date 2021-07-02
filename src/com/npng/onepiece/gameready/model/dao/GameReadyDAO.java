package com.npng.onepiece.gameready.model.dao;

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

	public int insertNewCharacter(Connection con, NewCharacterDTO charDTO ) {
		/*TEST*/System.out.println("생성한 캐릭터 기본정보 DB에 insert하는 메소드 실행됨...");
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

	//생성캐릭터 인벤토리 등록
	public int createNewInventory(Connection con, int charNum) {
		/*TEST*/System.out.println("생성한 캐릭터의 초기 인벤토리 정보 DB에 insert하는 메소드 실행됨...");
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("createNewInventory");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, charNum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(" dao createNewInventory result " + result);
		return result;
	}

	//생성캐릭터 장비창 등록
	public int createNewItemEquip(Connection con, int charNum) {
		/*TEST*/System.out.println("생성한 캐릭터의 초기 장비창정보 DB에 insert하는 메소드 실행됨...");
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("createNewItemEquip");	
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, charNum);
			
			result = pstmt.executeUpdate();
			
			System.out.println("dao createNewItemEquip result : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		System.out.println(" createNewItemEquip의 result" + result);
		return result;
	}

	//로그인 한 유저의 캐릭터 번호 찾기
	public int findLoginCharNum(Connection con, NewCharacterDTO charDTO) {		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int char_num = 0;
		
		String query = prop.getProperty("findLoginCharNum");
		try {
			pstmt = con.prepareStatement(query);		
			pstmt.setInt(1, charDTO.getUserNum());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {				
				char_num = rset.getInt("CHAR_NUMBER");		
			} else {
				System.out.println("로그인한 유저의 캐릭터번호 조회 실패");
			}
			
			System.out.println("dao findLoginCharNum.charNum : " + char_num);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);	

		}
				
		return char_num;
	}

	public int searchNum(Connection con, int uNum) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int char_num = 0;
		
		String query = prop.getProperty("findLoginCharNum");
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, uNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {				
				char_num = rset.getInt("CHAR_NUMBER");		
			} else {
				System.out.println("로그인한 유저의 캐릭터번호 조회 실패");
			}
			
			System.out.println("searchNum : " + char_num);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);	

		}
				
		return char_num;
	}

}

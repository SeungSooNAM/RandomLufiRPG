package com.npng.onepiece.setting.model.dao;

import static com.npng.onepiece.common.JDBCTemplate.close;

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

import com.npng.onepiece.setting.model.dto.RankingDTO;

public class RankingDAO {
	
	private Properties prop;

	public RankingDAO() {
		
		this.prop = new Properties();
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/ranking-query.xml")); //쿼리문 바꾸자
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<RankingDTO> selectRanking(Connection con) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		List<RankingDTO> rankingList = null;
		
		String query = prop.getProperty("selectRanking");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			rankingList = new ArrayList<>();
			
			while(rset.next()) {
				RankingDTO ranking = new RankingDTO();
				
				ranking.setChNum(rset.getInt("CHAR_NUMBER"));
				ranking.setName(rset.getString("CHAR_NAME"));
				ranking.setScore(rset.getInt("CHAR_SCORE"));
				
				rankingList.add(ranking);
				System.out.println("rankingList : " + rankingList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} close(rset);
		  close(pstmt);
		System.out.println("rankingList : " + rankingList);
		
		return rankingList;
	}

}

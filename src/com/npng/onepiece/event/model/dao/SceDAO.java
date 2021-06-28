package com.npng.onepiece.event.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import static com.npng.onepiece.common.JDBCTemplate.close;

import com.npng.onepiece.event.model.dto.SceDTO;

public class SceDAO {
	
	private static Properties prop;
	
	public SceDAO() {
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SceDTO scenum(Connection con, int num) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		SceDTO story = null;
		
		String query = prop.getProperty("searhscenum");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				story = new SceDTO();
				
				story.setStroy(rset.getString("SCE_STORY"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}
		
		
		
		return story;
	}

}


package com.npng.onepiece.event.model.dao;

import static com.npng.onepiece.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

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

	public static SceDTO loginnumber(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		SceDTO sce = new SceDTO();
		
		String query = prop.getProperty("searchuserlogin");
		
		try {
			pstmt = con.prepareStatement(query);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
//				sce = new SceDTO();
				
//				sce.setLogionnum(rset.getInt("USER_NUM"));
				sce.setCharnum(rset.getInt("CHAR_NUMBER"));
	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}
		
		return sce;
	}
	
	public  SceDTO scenum(Connection con, int map, int num) { 
											// 선택지 시나리오번호
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		SceDTO sce = null;
		
		String query = prop.getProperty("searhcharsce");
		
		try {
			pstmt = con.prepareStatement(query);
//			pstmt.setInt(1, num);
//			pstmt.setInt(2, map);
			pstmt.setInt(1, 3);
			pstmt.setInt(2, 1);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				 sce = new SceDTO();
				
				sce.setOptstr(rset.getInt("OPT_STR"));
				sce.setOptdex(rset.getInt("OPT_DEX"));
				sce.setOptcha(rset.getInt("OPT_CHA"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

			
			
		}
		

		return sce;
	}


}

package com.npng.onepiece.user.model.dao;

import static com.npng.onepiece.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.Properties;

import com.npng.onepiece.user.model.dto.MemberDTO;

public class MemberDAO {

	private Properties prop;
	
	public MemberDAO() {
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/member-query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int joinNewMember(Connection con, MemberDTO member) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("joinNewMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int login(Connection con, Map<String, String> map) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectAllMember");

		try {
			pstmt = con.prepareStatement(query);
			


			rset = pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return 0;
		
	}

}

package com.npng.onepiece.user.model.dao;

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

import com.npng.onepiece.user.model.dto.MemberDTO;
import com.npng.onepiece.user.view.FindPasswordPageView;

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

	public int login(Connection con, String loginId, String loginPwd) {

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		int result = 0;

		String query = prop.getProperty("selectPassword");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, loginId);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				if (rset.getString(1).contentEquals(loginPwd)) {
					result = 1;
				} else {
					result = -1;
				}
			} else {
				result = -1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return result;

	}

	public int findPassword(Connection con, String userId, String userName) {

		PreparedStatement pstmt = null;

		ResultSet rset = null;

		int result = 0;

		String query = prop.getProperty("selectName");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				if (rset.getString(1).contentEquals(userName)) {
					result = 1;
				} else {
					result = -1;
				}
			} else {
				result = -1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return result;
	}

	public int newPassword(Connection con, String newPwd) {
		
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updatePassword");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, FindPasswordPageView.userId);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int managerLoginn(Connection con, String managerId, String managerPwd) {
		
		PreparedStatement pstmt = null;

		ResultSet rset = null;

		int result = 0;

		String query = prop.getProperty("selectPassword");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, managerId);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				if (rset.getString(1).contentEquals(managerPwd)) {
					result = 1;
				} else {
					result = -1;
				}
			} else {
				result = -2;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		System.out.println(result);
		return result;
	}

	public int deleteMember(Connection con, String userId) {

		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("deleteMember");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<MemberDTO> selectAllMember(Connection con) {

		PreparedStatement pstmt = null;
		
		ResultSet rset = null;

		List<MemberDTO> memberList = null;

		String query = prop.getProperty("selectAllMember");

		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			memberList = new ArrayList<>();

			while(rset.next()) {
				MemberDTO member = new MemberDTO();

				member.setUserNum(rset.getInt("USER_NUM"));
				member.setUserId(rset.getString("USER_ID"));
//				member.setUserPwd(rset.getString("USER_PASSWORD"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setAbleYN(rset.getString("ABLE_YN"));

				memberList.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return memberList;
	}

	public int userNum(Connection con, String loginId) {
		
		PreparedStatement pstmt = null;

		ResultSet rset = null;

		int uNum = 0;
		
		String query = prop.getProperty("selectUserNum");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, loginId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				uNum = rset.getInt(1);
				System.out.println(rset.getString(1));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return uNum;
	}

	public int newManagerPwd(Connection con, String userId, String userName, String newPwd) {
		
		PreparedStatement pstmt = null;

		int result = 0;

		String query = prop.getProperty("updateManagerPassword");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, userName);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}

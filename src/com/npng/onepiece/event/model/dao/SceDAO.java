
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

public  class SceDAO {
	
	private static Properties prop;
	
	public SceDAO() {
		this.prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/event-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public SceDTO loginnumber(Connection con) {
		
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
					
		//map=선택지 num=시나리오번호
		// 선택지 시나리오번호
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		SceDTO sce = null;
		
		String query = prop.getProperty("searchsce1");
		try {
			pstmt = con.prepareStatement(query);
			
			
			pstmt.setInt(1, num); 
			pstmt.setInt(2, map); 
//			pstmt.setInt(3, map); 
//			pstmt.setInt(1, 3);
//			pstmt.setInt(2, 1);
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
	
	public SceDTO scenum2(Connection con, int map, int num) {
		
		// 선택지 시나리오번호
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				SceDTO sce = null;
				
				String query = prop.getProperty("searchsce2");
				
				try {
					sce = new SceDTO();
					
					pstmt = con.prepareStatement(query);
					
					pstmt.setInt(2, map); 
					pstmt.setInt(1, num); 
//					pstmt.setInt(3, map); 
//					pstmt.setInt(1, 3);
//					pstmt.setInt(2, 1);
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


	public SceDTO searchCh(Connection con, int chNum) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		SceDTO ch = null;
		
		String query = prop.getProperty("searhch");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, chNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				ch = new SceDTO();
				
				ch.setCharstr(rset.getInt("CHAR_STR"));
				ch.setChardex(rset.getInt("CHAR_DEX"));
				ch.setCharcha(rset.getInt("CHAR_CHARISMA"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}
		
		return ch;
		
		
	}

	public SceDTO reward(Connection con, int num) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		SceDTO reward = null;
		
		String query = prop.getProperty("reward");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num); 
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
//				reward = new SceDTO();
				reward = new SceDTO();
				
				reward.setSceexp(rset.getInt("SCE_EXP"));
				reward.setScescore(rset.getInt("SCE_SCORE"));
				reward.setScemoney(rset.getInt("SCE_MONEY"));		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}
		
		
		return reward;
	}

	public int chUpdate(Connection con, SceDTO reward,int chNum) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("chupdate");
		
		try {
			pstmt = con.prepareStatement(query);



			pstmt.setInt(1, reward.getSceexp());
			pstmt.setInt(2, reward.getScescore());
			pstmt.setInt(3, chNum); 
	
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt); 
		}
		
		return result;
	}

	public int invenUpdate(Connection con, SceDTO reward, int chNum) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("invenupdate");
		try {
			pstmt = con.prepareStatement(query);

			pstmt.setInt(1, reward.getScemoney());
			pstmt.setInt(2, chNum); 
	
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt); 
		}
		
		return result;
	}



}

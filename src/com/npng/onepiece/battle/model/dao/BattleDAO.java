package com.npng.onepiece.battle.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.npng.onepiece.common.JDBCTemplate.close;

import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.battle.model.dto.FriendDTO;

public class BattleDAO {
	
	private Properties prop;
	
	public BattleDAO() {
		prop = new Properties();
		try {
			prop.loadFromXML(new FileInputStream("mapper/battle-query.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public BattleDTO selectAllBattleInfo(Connection con, int cNum) {		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BattleDTO battleInfo = null;
		
		String query = prop.getProperty("selectCharacterInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				battleInfo = new BattleDTO();
				battleInfo.setcName(rset.getString("CHAR_NAME"));
				battleInfo.setcLv(rset.getInt("CHAR_LV"));
				battleInfo.setcAtk(rset.getInt("CHAR_ATK"));
				battleInfo.setcHp(rset.getInt("CHAR_HP"));
				battleInfo.setcLife(rset.getInt("CHAR_LIFE"));
				battleInfo.setcExp(rset.getInt("CHAR_EXP"));
				battleInfo.setcStr(rset.getInt("CHAR_STR"));
				battleInfo.setcDex(rset.getInt("CHAR_DEX"));
				battleInfo.setcCharisma(rset.getInt("CHAR_CHARISMA"));
				battleInfo.setcPoint(rset.getInt("CHAR_POINT"));
				battleInfo.setcMp(rset.getInt("CHAR_MP"));
				battleInfo.setcNumber(rset.getInt("CHAR_NUMBER"));
				battleInfo.setUserNum(rset.getInt("USER_NUM"));
				battleInfo.setcScore(rset.getInt("CHAR_SCORE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return battleInfo;
	}

	public BattleDTO selectMonsterInfo(Connection con, int num) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BattleDTO battleInfo = null;
		
		String query = prop.getProperty("selectMonsterInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				battleInfo = new BattleDTO();
				battleInfo.setmName(rset.getString("MON_NAME"));
				battleInfo.setmLv(rset.getInt("MON_LV"));
				battleInfo.setmAtk(rset.getInt("MON_ATK"));
				battleInfo.setmDef(rset.getInt("MON_DEF"));
				battleInfo.setmHp(rset.getInt("MON_HP"));
				battleInfo.setmStr(rset.getInt("MON_STR"));
				battleInfo.setmDex(rset.getInt("MON_DEX"));
				battleInfo.setmNum(rset.getInt("MON_NUM"));
				battleInfo.setmCate(rset.getString("MON_CATE"));
				battleInfo.setmExp(rset.getInt("MON_EXP"));
				battleInfo.setmGold(rset.getInt("MON_GOLD"));
				battleInfo.setmScore(rset.getInt("MON_SCORE"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return battleInfo;
	}

	public int checkBossClear(Connection con, int map, int cNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BattleDTO battleInfo = null;
		int result = 0;
		
		String query = prop.getProperty("checkBossClear");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, map);
			pstmt.setInt(2, cNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				String bossClear = rset.getString("BOSS_CLEAR");
				if(bossClear == "Y") {
					result = 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public List<FriendDTO> friendInfo(Connection con, int cNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<FriendDTO> friendList = null;
		FriendDTO friend = null;
		
		String query = prop.getProperty("friendInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cNum);
			
			rset = pstmt.executeQuery();
			
			friendList = new ArrayList<>();
			
			while(rset.next()) {
				friend = new FriendDTO();
				friend.setFrName(rset.getString("FR_NAME"));
				friend.setFrSkill(rset.getInt("FR_SKIL"));
				friend.setFrGrade(rset.getString("FR_GRADE"));
				friend.setFrHave(rset.getString("FR_HAVE_YN"));
				friend.setFrNum(rset.getInt("FR_NUM"));
				friend.setFrMp(rset.getInt("FR_MP"));
				friendList.add(friend);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return friendList;
	}
	public int escape(Connection con, int cNum, int cExp) {
		
		PreparedStatement pstmt = null;

		int result = 0;

		
		String query = prop.getProperty("updateCharacter");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cExp);
			pstmt.setInt(2, cNum);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	

}

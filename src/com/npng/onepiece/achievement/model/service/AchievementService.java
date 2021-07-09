package com.npng.onepiece.achievement.model.service;

import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.commit;
import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.npng.onepiece.achievement.model.dao.AchDAO;
import com.npng.onepiece.achievement.model.dto.AchDTO;
import com.npng.onepiece.achievement.model.dto.Ch_AchDTO;
import com.npng.onepiece.battle.model.dao.BattleDAO;
import com.npng.onepiece.battle.model.dto.FriendDTO;
import com.npng.onepiece.inventory.model.dao.InventoryDAO;
import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.model.dto.WeaponDTO;

public class AchievementService {

	private AchDAO achDAO;
	private AchDTO achDTO;

	public AchievementService() {
		this.achDAO = new AchDAO();
		this.achDTO = new AchDTO();

	}


	public List<Ch_AchDTO> findAchievement(int chNum) {
		Connection con = getConnection();
		List<Ch_AchDTO> achList = new ArrayList<>();
		Ch_AchDTO achDTO = new Ch_AchDTO();
		
		for(int i = 1; i < 4; i++) {
			achDTO = achDAO.findAchievement(con, chNum, i);

			achList.add(achDTO);
		}


		close(con);

		return achList;
	}


	public int bossAchievement(int chNum) {
		Connection con = getConnection();
		int result1 = 0;
		int result = 0;
		BattleDAO battleDAO = new BattleDAO();
		for(int i = 1; i < 7; i++) {
			result1 += battleDAO.checkBossClear(con, i, chNum);
			
		}



		if (result1 == 6) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		} 
		close(con);

		//result 1이면 조건 달성
		return result;
	}


	public int friendAchievement(int chNum) {
		Connection con = getConnection();

		BattleDAO battleDAO = new BattleDAO();
		List<FriendDTO> friendList = battleDAO.friendInfo(con);

		int result = 0;

		if(friendList.size()  == 6) {
			result = 1;
		}

		if (result == 1) {
			commit(con);
		} else {
			rollback(con);
		} 
		close(con);

		//result 1이면 조건 달성
		return result;
	}


	public int MoneyAchievement(int chNum) {
		Connection con = getConnection();

		InventoryDAO invenDAO = new InventoryDAO();
		InventoryDTO inven  = invenDAO.getInventoryInfo(con, chNum);
		
		int result = 0;
		
		if(inven.getGold()  >= 3000) {
			result = 1;
		}

		if (result == 1) {
			commit(con);
		} else {
			rollback(con);
		} 
		close(con);

		//result 1이면 조건 달성
		return result;
	}


	public int insertAchivement(int chNum, int i) {
		Connection con = getConnection();

		achDAO = new AchDAO();
		int result = achDAO.insertAchivement(con, chNum, i);

		

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		} 
		close(con);

		return result;
	}

}

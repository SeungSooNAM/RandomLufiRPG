package com.npng.onepiece.friend.model.service;

import static com.npng.onepiece.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.List;

import com.npng.onepiece.friend.model.dto.FriendDTO;
import com.npng.onepiece.friend.model.dao.FriendDAO;

public class FriendService {
	
	private FriendDAO friendDao = new FriendDAO();

	public List<FriendDTO> friendInfo() {
		
		Connection con = getConnection();
		
		List<FriendDTO> friendList = null;
		
		friendList = friendDao.friendInfo(con);
		
		close(con);
		
		return friendList;
	}

	public int checkMoney() {
		
		Connection con = getConnection();
		
		int gold = 0;
		
		gold = friendDao.checkMoney(con);
		
		close(con);
		
		return gold;
	}

	public int upgrade(String name, int gold) {
		
		int resultGold = 0;
		int resultUpgrade = 0;
		int result = 0;
		int percentageUpgrade = (int) (Math.random() * 20);
		
		Connection con = getConnection();
		
		if(gold >= 50) {	
		gold -= 50; // 강화 비용
		resultGold = friendDao.decreaseGold(con, gold);		
			System.out.println("강화  숫자 : " + percentageUpgrade);
			if(percentageUpgrade > 15) {
				System.out.println("강화 성공");
				resultUpgrade = friendDao.upgrade(con, name);
				if(resultGold == 1 && resultUpgrade == 1) {
					commit(con);
					result = 2;  // 강화 성공 , 돈 감소 성공
				} else {
					rollback(con); // 둘 중 하나 실패
				}
			} else {
				if(resultGold > 0) {
					commit(con); 
					result = 1; // 강화 실패, 돈 감소 성공
				} else {
					rollback(con); // 돈감소 실패
				}
			}
		} else {
			result = 0; // 돈이 부족
		}
		
		
		
		close(con);
		
		return result;
	}

}

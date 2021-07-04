package com.npng.onepiece.friend.controller;

import java.util.List;

import javax.swing.JLabel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.friend.model.dto.FriendDTO;
import com.npng.onepiece.friend.model.service.FriendService;
import com.npng.onepiece.friend.view.SelectInfo;

public class FriendController {
	
	private FriendService friendService = new FriendService();
	
	

	public List<FriendDTO> friendInfo() {
		
		List<FriendDTO> friendList = null;
		
		friendList = friendService.friendInfo();
		
		return friendList;
	}



	public int checkMoney() {

		int gold = friendService.checkMoney();
		
		return gold;
	}



	public int upgrade(String name, int gold) {

		int result = 0;
		
		result = friendService.upgrade(name, gold);
		
		return result;
		
	}

}

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

}

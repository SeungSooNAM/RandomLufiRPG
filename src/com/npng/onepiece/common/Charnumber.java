package com.npng.onepiece.common;

import static com.npng.onepiece.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.npng.onepiece.event.model.dao.SceDAO;
import com.npng.onepiece.event.model.dto.SceDTO;

public class Charnumber {
	
	private SceDAO sceDAO;
	
	public int loginnumber() {
		
		Connection con = getConnection();
		
		SceDTO login= sceDAO.loginnumber(con);
		
		int num = login.getCharnum();
		
		return num;
		}

}

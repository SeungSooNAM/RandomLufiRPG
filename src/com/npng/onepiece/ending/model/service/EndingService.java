package com.npng.onepiece.ending.model.service;

import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.npng.onepiece.ending.model.dao.EndingDAO;
import com.npng.onepiece.ending.model.dto.EndingDTO;


public class EndingService {

	private EndingDAO endingDAO;
	
	public EndingService() {
		this.endingDAO = new EndingDAO();
	}
	

	public int updateRanking(int chNum) {
		
		Connection con = getConnection();
		
		EndingDTO chInfoDTO = endingDAO.loadChInfo(chNum, con);
		
		int result = endingDAO.updateRanking(con, chNum ,chInfoDTO);
		close(con);
		
		return result;
	}


}

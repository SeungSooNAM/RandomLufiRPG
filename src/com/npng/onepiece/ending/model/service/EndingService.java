package com.npng.onepiece.ending.model.service;

import java.sql.Connection;

import com.npng.onepiece.ending.model.dao.EndingDAO;
import com.npng.onepiece.ending.model.dto.EndingDTO;
import com.npng.onepiece.user.model.dto.MemberDTO;

import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.commit;
import static com.npng.onepiece.common.JDBCTemplate.rollback;


public class EndingService {

	private EndingDAO endingDAO;
	
	public EndingService() {
		this.endingDAO = new EndingDAO();
	}
	
	public int saveScore(EndingDTO endingDTO) {
		
		Connection con = getConnection();
		
		int result = endingDAO.saveScore(endingDTO, con);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}

package com.npng.onepiece.event.model.eventService;

import java.sql.Connection;

import com.npng.onepiece.event.model.dao.SceDAO;
import com.npng.onepiece.event.model.dto.SceDTO;

import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.commit;
import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.rollback;

public class EventService {
	
	private SceDAO sceDAO;
	
	public EventService() {
		this.sceDAO = new SceDAO();
		
	}

	public String scenum(int num) {
		
		Connection con = getConnection();
		
		String story = SceDAO.scenum(con, num);

		
		close(con);
		;
	}
	
}

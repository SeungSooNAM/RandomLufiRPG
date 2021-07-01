
package com.npng.onepiece.event.model.eventService;

import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.commit;
import static com.npng.onepiece.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.npng.onepiece.event.model.dao.SceDAO;
import com.npng.onepiece.event.model.dto.SceDTO;

public class EventService {
	
	private SceDAO sceDAO;
	
	public EventService() {
		this.sceDAO = new SceDAO();
		
	}
	public int loginnumber() {
		
	Connection con = getConnection();
	
	SceDTO login= sceDAO.loginnumber(con);
	
	int num = login.getCharnum();
	
	return num;
	}


	public int sceresult(int map ,int num) { //선택지 ,시나리오번호
		
	Connection con = getConnection();
	
		int loginnumber = loginnumber();
		
		SceDTO bat = sceDAO.scenum(con,map, num);
		
		
		close(con);
		return 1;
	}
	
}



package com.npng.onepiece.event.model.eventService;

import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.commit;
import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.npng.onepiece.event.model.dao.SceDAO;
import com.npng.onepiece.event.model.dto.SceDTO;

public class EventService {
	
	private SceDAO sceDAO;
	private SceDTO sce;
	
	public EventService() {
		this.sceDAO = new SceDAO();
		
	}
	public int loginnumber() {
		
	Connection con = getConnection();
	
	SceDTO login= sceDAO.loginnumber(con);
	int num = login.getCharnum();
	System.out.println("캐릭터번호= " +login);
	return num;
	}


	public int sceresult(int map ,int num, int chNum) { //선택지 ,시나리오번호
		
	Connection con = getConnection();
//		SceDTO sce = new SceDTO();
		
		
		if(map == 1) {
		
		 sce = sceDAO.scenum(con,map, num); /*시나리오 스탯호출*/
		} else {	
		 sce = sceDAO.scenum2(con,map, num); /*시나리오 스탯호출*/	
		}

		
		SceDTO ch = sceDAO.searchCh(con, chNum);/*캐릭서 스탯호출*/
		int result = 0;
		System.out.println("캐릭터스텟 : = " + ch);
		/*  캐릭터힘 시나리오스탯 비교*/
		if(ch.getCharstr() > sce.getOptstr()) {
			if(ch.getChardex() > sce.getOptdex()) {
				if(ch.getCharcha() > sce.getOptcha()) {
					result = 1;
				} 
			}
		} 
		/* 보상 받아오기*/
		SceDTO reward = sceDAO.reward(con, num);  //ㅇㅇㅇㅇㅇㅇㅇㅇㅇ
		int res = 0;
		System.out.println("보상 = " + reward);
		if(result == 1) {
			res += sceDAO.chUpdate(con, reward ,chNum);
			res += sceDAO.invenUpdate(con, reward ,chNum);
			/* 이긴걸로 업데이트*/
			/* 진걸로 업데이트*/
		} else {
			reward.setSceexp((int)(reward.getSceexp()*0.1));
			reward.setScescore((int)(reward.getScescore()*0.1));
			reward.setScemoney((int)(reward.getScemoney()*0.1));
			
			res += sceDAO.chUpdate(con, reward ,chNum);
			res += sceDAO.invenUpdate(con, reward ,chNum);
			
		}

		if(res == 2) {
			System.out.println(res);
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		close(con);
		return 1;
	}
	
}


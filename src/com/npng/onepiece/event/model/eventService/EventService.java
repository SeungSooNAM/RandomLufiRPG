
package com.npng.onepiece.event.model.eventService;

import static com.npng.onepiece.common.JDBCTemplate.close; 
import static com.npng.onepiece.common.JDBCTemplate.commit;
import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.Map;

import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.event.model.dao.SceDAO;
import com.npng.onepiece.event.model.dto.SceDTO;

public class EventService {
	
	private SceDAO sceDAO;
	private SceDTO sce;
	
	public EventService() {
		this.sceDAO = new SceDAO();
		
	}


	public int sceresult(int map ,int num, int chNum) { //선택지 ,시나리오번호
		System.out.println("시나리오번호 : " + num);
		System.out.println("캐릭터번호 = "+ chNum);

	Connection con = getConnection();		
		int commit = 0;

		
		Connection con = getConnection();		
		int commit = 0;

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
		int res =0;
		/* 보상 받아오기*/
		SceDTO reward = sceDAO.reward(con, num);  //
		System.out.println("보상 = " + reward);
		if(result == 1) {
			System.out.println("*w*****");
			res += sceDAO.chUpdate(con, reward ,chNum);
			res += sceDAO.invenUpdate(con, reward ,chNum);
			System.out.println("***d**");
			/* 이긴걸로 업데이트*/
			/* 진걸로 업데이트*/
		} else {
			reward.setSceexp((int)(reward.getSceexp()*0.1));
			reward.setScescore((int)(reward.getScescore()*0.1));
			reward.setScemoney((int)(reward.getScemoney()*0.1));
			
			res += sceDAO.chUpdate(con, reward ,chNum);
			System.out.println("**z***");
			res += sceDAO.invenUpdate(con, reward ,chNum);
			
		}
		if(res == 2) {

			commit(con);
			commit = 1;
		} else {
			rollback(con);
			result = 0;
			
		}
		 close(con);
		System.out.println("커밋 : " + commit);
		System.out.println("결과값 : " + result);
		
		return result;
	}
	public SceDTO reward(int result, int num) {
		
		Connection con = getConnection();
		SceDTO reward = new SceDTO();
		
		
		if(result == 1) {
			 reward = sceDAO.reward(con, num);
		}
		if(result == 0) {
			reward = sceDAO.reward(con, num);
			reward.setSceexp((int)(reward.getSceexp()*0.1));
			reward.setScescore((int)(reward.getScescore()*0.1));
			reward.setScemoney((int)(reward.getScemoney()*0.1));
		}
		
		close(con);
		return reward;
	}
	
	public String story(int result, int num) {
		
		Connection con = getConnection();
		SceDTO reward = new SceDTO();
		String story = null;
		
		if(result == 1) {
			 reward = sceDAO.scenum(con,1, num);
				 
			 }
			 
		if(result == 0) {
			reward = sceDAO.scenum2(con,2, num);
		}
		
		story = reward.getScestory();
		close(con);
		return story;
	}
	public int insertfriend(int chNum) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = sceDAO.insertfriend(con,chNum);
		
		if(result == 1) {

			commit(con);
			commit = 1;
		} else {
			rollback(con);

			
		}
		
		close(con);
		return result;
	}
	public int friendcheck( int chNum) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = sceDAO.friendcheck(con ,chNum);
		
		close(con);
		return result;
	}
	public int searchlife(int chNum) {

		Connection con = getConnection();
		
		int life = sceDAO.searchlife(con ,chNum);
		
		close(con);
		return life;
	}
	
	public SceDTO levelUp(int cNum) {
	      
	      Connection con = getConnection();
	      
	      SceDTO sd = sceDAO.levelUp(con, cNum);
	      int result = 0;
	      int point = 0;
	      int res = 0;
	      int exp = sd.getCharexp();
	      int lv = sd.getCharlv();
	      
	      
	      if(exp >= 100 * lv) {
	         result = 1;
	      } else {
	         result = 0;
	      }
	      
	     if(result == 1) {
	    	 res =  sceDAO.pointUp(con, cNum, lv, exp);
	     }
	     
	     if(res == 1) {
				commit(con);
				sd.setLvup(1);
				
				
			} else {
				rollback(con);
				
			}
	     System.out.println("커밋성공 : " + res);
	     close(con);
	      
	      return sd;
	   }


	public int chReward(BattleDTO battle) {
		
		Connection con = getConnection();
		int res = 0;
		res += sceDAO.chReward(con , battle);
		res += sceDAO.invenReward(con , battle);
		
		 if(res == 2) {
				commit(con);
				res = 1;
			} else {
				rollback(con);
				res= 0;
			}
		close(con);
		
		return res;
	}


	public int minusLife(BattleDTO battle) {
		
		Connection con = getConnection();
		int result = 0;
		result = sceDAO.minusLife(con, battle);
		
		if(result == 1) {
			commit(con);
		} else {
			rollback(con);
		}
		

			result = 0;
			
		}
		System.out.println("커밋 : " + commit);
		System.out.println("결과값 : " + result);

		close(con);
		return result;
	}

	public SceDTO reward(int result, int num) {
		
		Connection con = getConnection();
		SceDTO reward = new SceDTO();
		
		
		if(result == 1) {
			 reward = sceDAO.reward(con, num);
		}
		if(result == 2) {
			reward = sceDAO.reward(con, num);
			reward.setSceexp((int)(reward.getSceexp()*0.1));
			reward.setScescore((int)(reward.getScescore()*0.1));
			reward.setScemoney((int)(reward.getScemoney()*0.1));
		}
		
		close(con);
		return reward;
	}
	
	public String story(int result, int num) {
		
		Connection con = getConnection();
		SceDTO reward = new SceDTO();
		String story = null;
		
		if(result == 1) {
			 reward = sceDAO.scenum(con,1, num);
				 
			 }
			 
		if(result == 2) {
			reward = sceDAO.scenum2(con,2, num);
			reward.setSceexp((int)(reward.getSceexp()*0.1));
			reward.setScescore((int)(reward.getScescore()*0.1));
			reward.setScemoney((int)(reward.getScemoney()*0.1));
		}
		
		story = reward.getScestory();
		close(con);
		return story;
	}
	public int insertfriend(int chNum) {
		
		Connection con = getConnection();
		
		int result = 0;
		
		result = sceDAO.insertfriend(con,chNum);
		
		if(result == 1) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
			
		}
		
		close(con);
		return result;
	}

	

	
}


package com.npng.onepiece.event.controller;

import javax.swing.JPanel;

import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.event.model.dto.SceDTO;
import com.npng.onepiece.event.model.eventService.EventService;
import com.npng.onepiece.event.views.EventResultView;
import com.npng.onepiece.event.views.EventSceView;
import com.npng.onepiece.event.views.SelectMapView;
import com.npng.onepiece.user.view.MainFrame;

public class eventController {
	
	private EventSceView eventscevew;
	private MainFrame mf;
	private EventService eventservice = new EventService();
	
	
//	private EventService eventService = new EventService();
	
	public int random(int map) {
		int number = 0;
		
		if(map == 1 || map == 3 || map == 4 || map == 5) {
			 number = (int)(Math.random() *40)+3;
		}
		if(map == 2) {
			number = (int)(Math.random() *40)+2;  //조로
		}
		if(map == 6) {
			number = (int)(Math.random() *41)+3;  //핸콕
		}
		return number;
	}
	
	public int sceresult(int map , int num, int chNum, EventResultView view ) {
		//선택지, 시나리오번호,캐릭터번호
		int result = 0; /*1~4번맵*/  /* 38~ 40 은 특수상점*/
		if(num >= 3 &&  num <= 37 || num == 0) {	
		 result =eventservice.sceresult(map, num,chNum);
		}
	
		if(num == 2) {    /*5번맵*/
		 result = eventservice.sceresult(map, num,chNum);
		 if(result == 1) {  // 시나리오2번일시 조로획득
			 result = eventservice.insertfriend(chNum);
			 result = 3;
		 }
		}
		if(num== 41) {    /*6번맵*/
			/*핸콕 동료 이벤트실행*/
		}
		
		
		 return result;
	}
	
	public SceDTO reward(int result, int num) {
		
		SceDTO reward = eventservice.reward(result, num); //보상호출
		
		return reward;
	}

	public String story(int result, int num) {
		
		String reward = eventservice.story(result, num);
		
		return reward;
	}

	public int friendcheck(int chNum) {   // 2번 조로 있는지 체크  있으면 1반환 없으면 0반환

		int result = eventservice.friendcheck(chNum);
		
		return result;
		

	}

	public int life(int chNum) {
		
		int life = eventservice.searchlife(chNum);
		
		return life;
	}
	
	public SceDTO levelUp(int cNum) {  //레벨업
	      
	      SceDTO sd = eventservice.levelUp(cNum);
	      String lvup = null;
	      if(sd.getLvup() == 1) {
	    	  sd.setLvupname("레벨업!");
	    	  if(sd.getCharlv() == 5) {
	 	  
	    	  sd.setBossname("최종 보스 맵이 열렸습니다");
	    	  }
	      } 
	      
	      return sd;
	   }

	public int chreward(BattleDTO battle) {
		
		
		int res = eventservice.chReward(battle);
		
		return res;
	}

	public int minusLife(BattleDTO battle) {
		
		int result = eventservice.minusLife(battle);
		
		return result;
	}

	
	
	
	
	

}

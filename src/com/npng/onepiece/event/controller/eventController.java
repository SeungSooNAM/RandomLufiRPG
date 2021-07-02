package com.npng.onepiece.event.controller;

import javax.swing.JLabel;

import com.npng.onepiece.event.model.eventService.EventService;
import com.npng.onepiece.event.views.EventSceView;
import com.npng.onepiece.user.view.MainFrame;

public class eventController {
	
	private EventSceView eventscevew;
	private MainFrame mf;
	private EventService eventservice = new EventService();
	
	
//	private EventService eventService = new EventService();
	
	public int random(int map) {
		int number = 0;
		
		if(map <= 4) {
			 number = (int)(Math.random() *40)+3;
		}
		if(map == 5) {
			number = (int)(Math.random() *37)+2;
		}
		if(map == 6) {
			number = (int)(Math.random() *38)+2;
		}
		return number;
	}
	
	public String sceresult(int map , int num, int chNum) {
		//선택지, 시나리오번호,캐릭터번호
		
		int result = 0; /*1~4번맵*/  /* 38~ 40 은 특수상점*/
		if(num >= 3 && num <= 40) {	
		 result =eventservice.sceresult(map, num,chNum);
		}
	
		if(num == 2) {    /*5번맵*/
		 result = eventservice.sceresult(map, num,chNum);
		}
		if(num== 41) {    /*6번맵*/
			/*핸콕 동료 이벤트실행*/
		}
		 
		String name = "d";
		
		 return name;
	}
		
	
	public JLabel optnum1(int num) {
		return null;
		
	}
		
	public JLabel optnum2(int num) {
		return null;
			

		
		
		
		
		
  }
	
	
	

}

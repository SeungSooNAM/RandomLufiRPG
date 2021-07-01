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
		
		if(map <= 2) {
			 number = (int)(Math.random() *37)+3;
		}
		if(map == 1) {
		}
		if(map == 2) {
		}
		return number;
	}
	
	public int sceresult(int map , int num) { //선택지, 시나리오번호
		
		int result = 0;
		 result =eventservice.sceresult(map, num);
		
		 
		 return result;
	}
		
	
	public JLabel optnum1(int num) {
		return null;
		
	}
		
	public JLabel optnum2(int num) {
		return null;
			

		
		
		
		
		
  }
	
	
	

}

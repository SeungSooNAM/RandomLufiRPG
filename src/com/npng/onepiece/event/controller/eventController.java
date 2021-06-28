package com.npng.onepiece.event.controller;

import javax.swing.JLabel;

import com.npng.onepiece.event.model.dto.SceDTO;
import com.npng.onepiece.event.model.eventService.EventService;
import com.npng.onepiece.event.views.EventSceView;

public class eventController {
	
	private EventService eventService = new EventService();
	
	public void random() {
		
		int number = (int)(Math.random() *3)+1;
		if(number == 1) { // 전투
			
		} if(number >= 2) {  // 일반
			
		}
	}
	
	public JLabel scenum(int num) {
		
		String story = EventService.scenum(num);
		  
		return story;
//		EventSceView view = new EventSceView();
//		view.EventSceView(stroy);
	;
		
		
		
		
		
	}
	
	
	

}

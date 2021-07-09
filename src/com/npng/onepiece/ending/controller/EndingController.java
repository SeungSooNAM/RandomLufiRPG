package com.npng.onepiece.ending.controller;

import com.npng.onepiece.ending.model.service.EndingService;

public class EndingController {

	private EndingService endingService = new EndingService();

	public int updateRanking(int chNum) {
		
		int result = endingService.updateRanking(chNum);
		
		return result;
	}

}

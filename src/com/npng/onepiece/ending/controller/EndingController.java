package com.npng.onepiece.ending.controller;

import com.npng.onepiece.ending.model.dto.EndingDTO;
import com.npng.onepiece.ending.model.service.EndingService;
import com.npng.onepiece.ending.view.RankingView;

public class EndingController {

	private EndingService endingService;
	private RankingView rankingView;
	
	
	public void saveScore(EndingDTO endingDTO) {

		int result = endingService.saveScore(endingDTO);
		
		if(result > 0) {
			rankingView.displayRanking("updateSuccess");
		}else {
			rankingView.displayRanking("updateFailed");
		}
	}

}

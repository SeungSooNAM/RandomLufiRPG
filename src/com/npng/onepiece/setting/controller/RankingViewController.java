package com.npng.onepiece.setting.controller;

import java.util.List;

import com.npng.onepiece.setting.model.dto.RankingDTO;
import com.npng.onepiece.setting.model.service.RankingService;
import com.npng.onepiece.setting.view.RankingResultView;
import com.npng.onepiece.user.view.MainFrame;


public class RankingViewController {

	private RankingService rankingService = new RankingService();
	private RankingResultView rankingResultView;
	
	public List<RankingDTO> selectRanking() {
		
		List<RankingDTO> rankingList = rankingService.selectRanking();
		
		return rankingList;
	}

}

package com.npng.onepiece.setting.view;

import java.util.List;

import com.npng.onepiece.setting.model.dto.RankingDTO;

public class RankingResultView {

	
	public void display (List<RankingDTO> list) {
		for(RankingDTO m : list) {
			System.out.println(m);
		}
	}
	
}

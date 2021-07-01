package com.npng.onepiece.gameready.controller;

import com.npng.onepiece.gameready.model.dto.NewCharacterDTO;
import com.npng.onepiece.gameready.model.service.GameReadyService;
import com.npng.onepiece.gameready.view.ResultView;

public class GameReadyController {

	private ResultView resultView = new ResultView();
	private GameReadyService gameReadySerivce = new GameReadyService();

	public void insertNewCharacter(NewCharacterDTO charDTO) {

		int result = gameReadySerivce.insertNewCharacter(charDTO);

		if (result > 0) {
			resultView.displayDmlResult("createSuccess");
		} else {
			resultView.displayDmlResult("createFailed");
		}
	}
}

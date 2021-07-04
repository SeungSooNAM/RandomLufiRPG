package com.npng.onepiece.character.controller;

import java.sql.ResultSet;

import com.npng.onepiece.character.model.dto.CharacterDTO;
import com.npng.onepiece.character.model.service.CharacterService;
import com.npng.onepiece.gameready.view.ResultView;

public class CharacterController {

	private ResultView rv = new ResultView();
	private CharacterService cs = new CharacterService();
	private CharacterDTO cDTO;

	public CharacterDTO lookChInfo(int chNum) {

		cDTO = cs.lookChInfo(chNum);

		return cDTO;
	}

	public int CharacterStrUp(CharacterDTO charDTO, int chNum) {

		int result = cs.CharacterStrUp(charDTO, chNum);
		System.out.println(result);
		if (result > 0) {
			rv.displayDmlResult("updateSuccess");
		} else {
			rv.displayDmlResult("updateFailed");
		}
		return result;
	}

	public int CharacterDexUp(CharacterDTO charDTO, int chNum) {

		int result = cs.CharacterDexUp(charDTO, chNum);
		System.out.println(result);
		if (result > 0) {
			rv.displayDmlResult("updateSuccess");
		} else {
			rv.displayDmlResult("updateFailed");
		}
		return result;
	}

	public int CharacterChaUp(CharacterDTO charDTO, int chNum) {

		int result = cs.CharacterChaUp(charDTO, chNum);
		System.out.println(result);
		if (result > 0) {
			rv.displayDmlResult("updateSuccess");
		} else {
			rv.displayDmlResult("updateFailed");
		}
		return result;
	}
}
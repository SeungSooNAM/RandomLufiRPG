package com.npng.onepiece.battle.controller;

import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.battle.model.service.BattleService;
import com.npng.onepiece.battle.view.attack.AttackFailedView;
import com.npng.onepiece.battle.view.attack.AttackView;
import com.npng.onepiece.battle.view.attack.AvoidFailedView;
import com.npng.onepiece.battle.view.attack.AvoidSuccessView;
import com.npng.onepiece.battle.view.main.BattleContinueView;
import com.npng.onepiece.battle.view.attack.BattleLoseView;
import com.npng.onepiece.battle.view.main.BattleView;
import com.npng.onepiece.battle.view.attack.BattleWinView;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.mainMenu.MainFrame;

public class BattleController {
	
	BattleDTO battleInfo;
	BattleService battleService = new BattleService();
	
	public BattleDTO readyBattle(int map) {
		

		battleInfo = battleService.selectMonster(map);
		return battleInfo;
	}

	public void attack(MainFrame mf, BattleView battleView, BattleDTO battleInfo) {

		int result = battleService.attack(battleInfo);

		if(result == 1) {
			ViewUtil.changePanel(mf, battleView, new AttackView(mf, battleInfo)); //공격 성공
		} else if(result == 2){
			ViewUtil.changePanel(mf, battleView, new BattleWinView(mf, battleInfo));// 전투 승리
		} else {
			ViewUtil.changePanel(mf, battleView, new AttackFailedView(mf, battleInfo)); // 공격 실패
		}
		
	}
	
	public void attack(MainFrame mf, BattleContinueView battleContinueView, BattleDTO battleInfo) {
			
		int result = battleService.attack(battleInfo);
		
		if(result == 1) {
			ViewUtil.changePanel(mf, battleContinueView, new AttackView(mf, battleInfo)); //공격 성공
		} else if(result == 2){
			ViewUtil.changePanel(mf, battleContinueView, new BattleWinView(mf, battleInfo));// 전투 승리
		} else {
			ViewUtil.changePanel(mf, battleContinueView, new AttackFailedView(mf, battleInfo)); 
			// 공격 실패
		}
	
	}	

	public void Monsterattack(MainFrame mf, AttackView attackView, BattleDTO battleInfo) {
		
		int result = battleService.monsterAttack(battleInfo);
		if(result == 1) {
			ViewUtil.changePanel(mf, attackView, new AvoidSuccessView(mf, battleInfo)); //회피 성공
		} else if(result == 2){
			ViewUtil.changePanel(mf, attackView, new BattleLoseView(mf, battleInfo));// 캐릭터 죽음
		} else {
			System.out.println("controller dto : " + battleInfo);
			ViewUtil.changePanel(mf, attackView, new AvoidFailedView(mf, battleInfo)); //회피 실패
		}
	}
	
	public void Monsterattack(MainFrame mf, AttackFailedView attackFailedView, BattleDTO battleInfo) {
		
		int result = battleService.monsterAttack(battleInfo);
		if(result == 1) {
			ViewUtil.changePanel(mf, attackFailedView, new AvoidSuccessView(mf, battleInfo)); //회피 성공
		} else if(result == 2){
			ViewUtil.changePanel(mf, attackFailedView, new BattleLoseView(mf, battleInfo));// 캐릭터 죽음
		} else {
			System.out.println("controller dto : " + battleInfo);
			ViewUtil.changePanel(mf, attackFailedView, new AvoidFailedView(mf, battleInfo)); //회피 실패
		}
		
	}


	public void battleInfo(MainFrame mf, AvoidSuccessView avoidSuccessView, BattleDTO battleInfo) {
	
		ViewUtil.changePanel(mf, avoidSuccessView, new BattleContinueView(mf, battleInfo));
	}

	public void skill(MainFrame mf, BattleView battleView, BattleDTO battleInfo) {
		
		int result = battleService.skill(battleInfo);
		
	}


	







	

	

	

}

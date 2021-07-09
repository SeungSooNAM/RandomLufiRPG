package com.npng.onepiece.battle.controller;

import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.battle.model.dto.FriendDTO;
import com.npng.onepiece.battle.model.service.BattleService;
import com.npng.onepiece.battle.view.attack.AttackFailedView;
import com.npng.onepiece.battle.view.attack.AttackView;
import com.npng.onepiece.battle.view.attack.AvoidFailedView;
import com.npng.onepiece.battle.view.attack.AvoidSuccessView;
import com.npng.onepiece.battle.view.attack.BattleLoseView;
import com.npng.onepiece.battle.view.attack.BattleWinView;
import com.npng.onepiece.battle.view.escape.Escape;
import com.npng.onepiece.battle.view.main.BattleContinueView;
import com.npng.onepiece.battle.view.main.BattleView;
import com.npng.onepiece.battle.view.skill.SelectSkillView;
import com.npng.onepiece.battle.view.skill.SkillAttackView;
import com.npng.onepiece.common.ViewUtil;


public class BattleController {
	
	BattleDTO battleInfo;
	BattleService battleService = new BattleService();
	
	public BattleDTO readyBattle(int map, int cNum) {
		

		battleInfo = battleService.selectMonster(map, cNum);
		return battleInfo;
	}

	public void attack(BattleView battleView, BattleDTO battleInfo) {

		int result = battleService.attack(battleInfo);

		if(result == 1) {
			ViewUtil.changePanel(battleView, new AttackView(battleInfo)); //공격 성공
		} else if(result == 2){
			ViewUtil.changePanel(battleView, new BattleWinView(battleInfo, result));// 전투 승리
		} else {
			ViewUtil.changePanel(battleView, new AttackFailedView(battleInfo)); // 공격 실패
		}
		
	}
	
	public void attack(BattleContinueView battleContinueView, BattleDTO battleInfo) {
			
		int result = battleService.attack(battleInfo);
		
		if(result == 1) {
			ViewUtil.changePanel(battleContinueView, new AttackView(battleInfo)); //공격 성공
		} else if(result == 2){
			ViewUtil.changePanel(battleContinueView, new BattleWinView(battleInfo, result));// 전투 승리
		} else {
			ViewUtil.changePanel(battleContinueView, new AttackFailedView(battleInfo)); 
			// 공격 실패
		}
	
	}	

	public void Monsterattack(AttackView attackView, BattleDTO battleInfo) {
		
		int result = battleService.monsterAttack(battleInfo);
		if(result == 1) {
			ViewUtil.changePanel(attackView, new AvoidSuccessView(battleInfo)); //회피 성공
		} else if(result == 3){
			ViewUtil.changePanel(attackView, new BattleLoseView(battleInfo, result));// 캐릭터 죽음
		} else {
			System.out.println("controller dto : " + battleInfo);
			ViewUtil.changePanel(attackView, new AvoidFailedView(battleInfo)); //회피 실패
		}
	}
	
	public void Monsterattack(AttackFailedView attackFailedView, BattleDTO battleInfo) {
		
		int result = battleService.monsterAttack(battleInfo);
		if(result == 1) {
			ViewUtil.changePanel(attackFailedView, new AvoidSuccessView(battleInfo)); //회피 성공
		} else if(result == 3){
			ViewUtil.changePanel(attackFailedView, new BattleLoseView(battleInfo, result));// 캐릭터 죽음
		} else {
			System.out.println("controller dto : " + battleInfo);
			ViewUtil.changePanel(attackFailedView, new AvoidFailedView(battleInfo)); //회피 실패
		}
		
	}
	
	public void Monsterattack(SkillAttackView skillAttackView, BattleDTO battleInfo) {
		
		int result = battleService.monsterAttack(battleInfo);
		if(result == 1) {
			ViewUtil.changePanel(skillAttackView, new AvoidSuccessView(battleInfo)); //회피 성공
		} else if(result == 3){
			ViewUtil.changePanel(skillAttackView, new BattleLoseView(battleInfo, result));// 캐릭터 죽음
		} else {
			System.out.println("controller dto : " + battleInfo);
			ViewUtil.changePanel(skillAttackView, new AvoidFailedView(battleInfo)); //회피 실패
		}
		
	}



	public void battleInfo(AvoidSuccessView avoidSuccessView, BattleDTO battleInfo) {
	
		ViewUtil.changePanel(avoidSuccessView, new BattleContinueView(battleInfo));
	}


	public void zoroSkill(SelectSkillView selectSkillView, BattleDTO battleInfo, FriendDTO friend) {
		
		System.out.println("조로 선택");
		
		int result = 0;
		result = battleService.zoroSkill(battleInfo, friend);
		if(result > 0) {
			ViewUtil.changePanel(selectSkillView, new BattleWinView(battleInfo, result));
		}else {
			ViewUtil.changePanel(selectSkillView, new SkillAttackView(battleInfo, friend));
		}
	}

	public void sandiSkill(SelectSkillView selectSkillView, BattleDTO battleInfo, FriendDTO friend) {
		System.out.println("상디 선택");
		int result = 0;
		result = battleService.sandiSkill(battleInfo, friend);
		if(result > 0) {
			ViewUtil.changePanel(selectSkillView, new BattleWinView(battleInfo, result));
		}else {
			ViewUtil.changePanel(selectSkillView, new SkillAttackView(battleInfo, friend));
		}
	}

	public void oosopSkill(SelectSkillView selectSkillView, BattleDTO battleInfo, FriendDTO friend) {
		System.out.println("우습 선택");
		int result = 0;
		result = battleService.oosopSkill(battleInfo, friend);
		
		if(result > 0) {
			ViewUtil.changePanel(selectSkillView, new BattleWinView(battleInfo, result));
		}else {
			ViewUtil.changePanel(selectSkillView, new SkillAttackView(battleInfo, friend));
		}
	}

	public void namiSkill(SelectSkillView selectSkillView, BattleDTO battleInfo, FriendDTO friend) {
		System.out.println("나미 선택");
		int result = battleService.namiSkill(battleInfo, friend);
		
		if(result > 0) {
			ViewUtil.changePanel(selectSkillView, new BattleWinView(battleInfo, result));
		}else {
			ViewUtil.changePanel(selectSkillView, new SkillAttackView(battleInfo, friend));
		}
	}

	public void hankokSkill(SelectSkillView selectSkillView, BattleDTO battleInfo, FriendDTO friend) {
		System.out.println("핸콕 선택");
		battleService.hankokSkill(battleInfo, friend);
		
		ViewUtil.changePanel(selectSkillView, new SkillAttackView(battleInfo, friend));
		
	}

	public void reilighSkill(SelectSkillView selectSkillView, BattleDTO battleInfo, FriendDTO friend) {
		System.out.println("레일리선택");
		int result = 0;
		result = battleService.reilighSkill(battleInfo, friend);
		if(result > 0) {
			ViewUtil.changePanel(selectSkillView, new BattleWinView(battleInfo, result));
		}else {
			ViewUtil.changePanel(selectSkillView, new SkillAttackView(battleInfo, friend));
		}
	}

	public void escape(BattleView battleView, BattleDTO battleInfo) {

		int result = battleService.escape(battleInfo);
		
		if(result > 0) {
			ViewUtil.changePanel(battleView, new Escape(battleInfo));
		}
		
	}

	public int updateBossClear(int bossNum) {
		
		int result = battleService.updateBossClear(bossNum);
		
		return result;
	}

	public int updateFriend(int clearMonsterNum) {
		
		int result = battleService.updateFriend(clearMonsterNum);
		
		return result;
	}

	

	







	

	

	

}

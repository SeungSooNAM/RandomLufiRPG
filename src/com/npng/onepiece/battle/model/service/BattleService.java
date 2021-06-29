package com.npng.onepiece.battle.model.service;


import com.npng.onepiece.battle.model.dto.BattleDTO;
import static com.npng.onepiece.common.RandomDice.*;

public class BattleService {
	
	private BattleDTO battleInfo;

	public int attack(BattleDTO battleInfo) {
		
		int cAtk = battleInfo.getcAtk();
		int cHp = battleInfo.getcHp();
		int cStr = battleInfo.getcStr();
		int cDex = battleInfo.getcDex();
		int mAtk = battleInfo.getmAtk();
		int mHp = battleInfo.getmHp();
		int mStr = battleInfo.getmStr();
		int mDef = battleInfo.getmDef();
		int mDex = battleInfo.getmDex();
		
		int result = 0; // 공격 실패
		
		if(randomDice() + (cStr - mDex) > 25) {
			result = 1;     // 공격 성공
			mHp = mHp - cAtk + mDef;
			battleInfo.setmHp(mHp);
			
			if(mHp <= 0) {
				result = 2; // 몬스터 죽음
			}
		} 
			
		return result;
	}

	public int monsterAttack(BattleDTO battleInfo) {
		int cAtk = battleInfo.getcAtk();
		int cHp = battleInfo.getcHp();
		int cStr = battleInfo.getcStr();
		int cDex = battleInfo.getcDex();
		int mAtk = battleInfo.getmAtk();
		int mHp = battleInfo.getmHp();
		int mStr = battleInfo.getmStr();
		int mDef = battleInfo.getmDef();
		int mDex = battleInfo.getmDex();
		
		int result = 1; // 회피 성공
		
		if(randomDice() + (mStr - cDex) > 25) {
			result = 0;     // 회피 실패
			cHp = cHp - mAtk ;
			battleInfo.setcHp(cHp);
			System.out.println("chp" + cHp);
			
			if(cHp <= 0) {
				result = 2; // 캐릭터 죽음
			}
		} 
			
		return result;
	}

	public BattleDTO selectMonster(int map) {
	
		battleInfo = new BattleDTO();
		battleInfo.setcHp(100);
		battleInfo.setmHp(200);
		battleInfo.setcAtk(30);
		battleInfo.setmAtk(30);
		battleInfo.setcStr(10);
		battleInfo.setcDex(10);
		battleInfo.setmStr(5);
		battleInfo.setmDex(5);
		battleInfo.setmDef(1);
		battleInfo.setmNum(map);
		
		return battleInfo;
	}

	public int skill(BattleDTO battleInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

}

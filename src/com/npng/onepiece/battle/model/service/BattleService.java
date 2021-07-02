package com.npng.onepiece.battle.model.service;


import static com.npng.onepiece.common.RandomDice.randomDice;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.npng.onepiece.battle.model.dao.BattleDAO;
import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.battle.model.dto.FriendDTO;
import static com.npng.onepiece.common.JDBCTemplate.*;

public class BattleService {
	
	private BattleDTO battleInfo;
	private BattleDAO battleDao;

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
	
		Connection con = getConnection();
		
		
		battleDao = new BattleDAO();
		int cNum = battleDao.selectMonsterInfo(con);
		int result = battleDao.checkBossClear(con, map, cNum);  //보스 클리어 여부 확인
		int num = (int) (Math.random() * 20) + 10;  //랜덤 몬스터 선택
		if(result == 0) {  //보스 클리어 안됨
			if(num >= 29) {  //보스 전투 확률 2/20 : 10%
				num = map;  
			}
		}
		if(map == 7) {  //엔딩 전투
			num = 7;
		}
		
		BattleDTO battleInfo;
		BattleDTO battleInfo2;
		battleInfo = battleDao.selectAllBattleInfo(con, cNum);  //캐릭터 정보 저장
		battleInfo2 = battleDao.selectMonsterInfo(con, num); //몬스터 선택후 저장
		battleInfo.setmName(battleInfo2.getmName());
		battleInfo.setmLv(battleInfo2.getmLv());
		battleInfo.setmAtk(battleInfo2.getmAtk());
		battleInfo.setmDef(battleInfo2.getmDef());
		battleInfo.setmHp(battleInfo2.getmHp());
		battleInfo.setmStr(battleInfo2.getmStr());
		battleInfo.setmDex(battleInfo2.getmDex());
		battleInfo.setmNum(battleInfo2.getmNum());
		battleInfo.setmCate(battleInfo2.getmCate());
		battleInfo.setmExp(battleInfo2.getmExp());
		battleInfo.setmGold(battleInfo2.getmGold());
		battleInfo.setmScore(battleInfo2.getmScore());
		List<FriendDTO> friendList = battleDao.friendInfo(con, cNum);  //동료 조회
		battleInfo.setFriendList(friendList);
		
		close(con);
		
		return battleInfo;
	}

	public int zoroSkill(BattleDTO battleInfo) {
		
		int cMp = battleInfo.getcMp();
		int cCharisma = battleInfo.getcCharisma();
		int mHp = battleInfo.getmHp();
		int mDef = battleInfo.getmDef();
		
		
		List<FriendDTO> friendList = battleInfo.getFriendList();
		FriendDTO zoro = friendList.get(0);
		String grade = zoro.getFrGrade();
		int Skill = zoro.getFrSkill();
		int FrMp = zoro.getFrMp();
		if(grade == "normal") {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.3;
		}
		cMp -= FrMp;
		mHp -= Skill - mDef;
		battleInfo.setmHp(mHp);
		battleInfo.setcMp(cMp);
		int result = 0;
		if(mHp < 0) {
			result = 1; //캐릭터 승리
		}
		
		return result;
	}

	public int sandiSkill(BattleDTO battleInfo) {
		int cMp = battleInfo.getcMp();
		int cCharisma = battleInfo.getcCharisma();
		int mHp = battleInfo.getmHp();
		int mDef = battleInfo.getmDef();
		
		List<FriendDTO> friendList = battleInfo.getFriendList();
		FriendDTO zoro = friendList.get(0);
		String grade = zoro.getFrGrade();
		int Skill = zoro.getFrSkill();
		int FrMp = zoro.getFrMp();
		
		cMp -= FrMp;
		mHp -= Skill;
		battleInfo.setmHp(mHp);
		battleInfo.setcMp(cMp);
		if(grade == "normal") {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.3;
		}
		int result = 0;
		if(mHp < 0) {
			result = 1; //캐릭터 승리
		}
		return result;
	}

	public int oosopSkill(BattleDTO battleInfo) {

		int cMp = battleInfo.getcMp();
		int cCharisma = battleInfo.getcCharisma();
		int mHp = battleInfo.getmHp();
		int mDef = battleInfo.getmDef();
		int mAtk = battleInfo.getmAtk();
		
		List<FriendDTO> friendList = battleInfo.getFriendList();
		FriendDTO zoro = friendList.get(0);
		String grade = zoro.getFrGrade();
		int Skill = zoro.getFrSkill();
		int FrMp = zoro.getFrMp();
		if(grade == "normal") {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.3;
		}		
		cMp -= FrMp;
		mHp -= Skill - mDef;
		mAtk -= 5;
		battleInfo.setmHp(mHp);
		battleInfo.setcMp(cMp);
		battleInfo.setmAtk(mAtk);
		int result = 0;
		if(mHp < 0) {
			result = 1; //캐릭터 승리
		}
		return result;
	}

	public void namiSkill(BattleDTO battleInfo) {

		int cMp = battleInfo.getcMp();
		int cCharisma = battleInfo.getcCharisma();
		
		List<FriendDTO> friendList = battleInfo.getFriendList();
		FriendDTO zoro = friendList.get(0);
		String grade = zoro.getFrGrade();
		int Skill = zoro.getFrSkill();
		if(grade == "normal") {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.3;
		}
		cMp += Skill;
		if(cMp > 150) {
			cMp = 150;
		}
		battleInfo.setcMp(cMp);
		
	}

	public void hankokSkill(BattleDTO battleInfo) {

		int cHp = battleInfo.getcHp();
		int cMp = battleInfo.getcMp();
		int cCharisma = battleInfo.getcCharisma();
		
		List<FriendDTO> friendList = battleInfo.getFriendList();
		FriendDTO zoro = friendList.get(0);
		String grade = zoro.getFrGrade();
		int Skill = zoro.getFrSkill();
		int FrMp = zoro.getFrMp();
		if(grade == "normal") {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.3;
		}
		cMp -= FrMp;
		cHp += Skill;
		if(cHp > 200) {
			cHp = 200;
		}

		battleInfo.setcMp(cMp);
		battleInfo.setcHp(cHp);
		
	}

	public int reilighSkill(BattleDTO battleInfo) {
		int cMp = battleInfo.getcMp();
		int cCharisma = battleInfo.getcCharisma();
		int mHp = battleInfo.getmHp();
		int mDef = battleInfo.getmDef();
		int cAtk = battleInfo.getcAtk();
		
		List<FriendDTO> friendList = battleInfo.getFriendList();
		FriendDTO zoro = friendList.get(0);
		String grade = zoro.getFrGrade();
		int Skill = zoro.getFrSkill();
		int FrMp = zoro.getFrMp();
		if(grade == "normal") {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.3;
		}
		cMp -= FrMp;
		mHp -= Skill - mDef;
		cAtk += 10;
		battleInfo.setmHp(mHp);
		battleInfo.setcMp(cMp);
		battleInfo.setcAtk(cAtk);
		int result = 0;
		if(mHp < 0) {
			result = 1; //캐릭터 승리
		}
		return result;
	}

	public int escape(BattleDTO battleInfo) {
		
		Connection con = getConnection();
		
		battleDao = new BattleDAO();
		int cNum = battleInfo.getcNumber();
		int cExp = battleInfo.getcExp();
		cExp -= 200;
		if(cExp < 0) {
			cExp = 0;
		}
		int result = battleDao.escape(con, cNum, cExp);
		
		close(con);
		
		return result;
	}


}

package com.npng.onepiece.battle.model.service;


import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.RandomDice.randomDice;

import java.sql.Connection;
import java.util.List;

import com.npng.onepiece.battle.model.dao.BattleDAO;
import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.battle.model.dto.FriendDTO;

public class BattleService {
	
	private BattleDTO battleInfo;
	private BattleDAO battleDao;
	
	public BattleService() {
		battleDao = new BattleDAO();
	}

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
				result = 3; // 캐릭터 죽음
			}
		} 
			
		return result;
	}

	public BattleDTO selectMonster(int map, int cNum) {
	
		Connection con = getConnection();
		
		System.out.println("맵 번호 : " + map);
		int result = battleDao.checkBossClear(con, map, cNum);  //보스 클리어 여부 확인
		int num = 0;
		if(result == 0) {  //보스 클리어 안됨
			num = (int) (Math.random() * 23) + 10;  // 보스 포함 선택
			if(num >= 28) {  //보스 전투 확률 3/20 : 10%
				num = map;  
			}
		} else {  // 클리어시
			num = (int) (Math.random() * 20) + 8;
		}
		if(map == 7) {  //엔딩 전투
			num = 7;
		}
		System.out.println("몬스터 번호 : " + num);
		
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
		List<FriendDTO> friendList = battleDao.friendInfo(con);  //동료 조회
		battleInfo.setFriendList(friendList);
		
		close(con);
		
		return battleInfo;
	}

	public int zoroSkill(BattleDTO battleInfo, FriendDTO friend) {
		
		int cMp = battleInfo.getcMp();
		int cCharisma = battleInfo.getcCharisma();
		int mHp = battleInfo.getmHp();
		int mDef = battleInfo.getmDef();
		
		int Skill = friend.getFrSkill();
		int FrMp = friend.getFrMp();
		String grade = friend.getFrGrade();
		if(grade.equals("normal")) {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.2;
		}
		cMp -= FrMp;
		mHp -= Skill - mDef;
		battleInfo.setmHp(mHp);
		battleInfo.setcMp(cMp);
		int result = 0;
		if(mHp <= 0) {
			result = 2; //캐릭터 승리
		}
		
		return result;
	}

	public int sandiSkill(BattleDTO battleInfo, FriendDTO friend) {
		int cMp = battleInfo.getcMp();
		int cCharisma = battleInfo.getcCharisma();
		int mHp = battleInfo.getmHp();
		int mDef = battleInfo.getmDef();
		
		String grade = friend.getFrGrade();
		int Skill = friend.getFrSkill();
		int FrMp = friend.getFrMp();
		
		if(grade.equals("normal")) {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.2;
		}
		cMp -= FrMp;
		mHp -= Skill;
		battleInfo.setmHp(mHp);
		battleInfo.setcMp(cMp);		
		int result = 0;
		if(mHp <= 0) {
			result = 2; //캐릭터 승리
		}
		return result;
	}

	public int oosopSkill(BattleDTO battleInfo, FriendDTO friend) {

		int cMp = battleInfo.getcMp();
		int cCharisma = battleInfo.getcCharisma();
		int mHp = battleInfo.getmHp();
		int mDef = battleInfo.getmDef();
		int mAtk = battleInfo.getmAtk();
		
		String grade = friend.getFrGrade();
		int Skill = friend.getFrSkill();
		int FrMp = friend.getFrMp();
		if(grade.equals("normal")) {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.2;
		}	
		cMp -= FrMp;
		mHp -= Skill - mDef;
		mAtk -= 5;
		battleInfo.setmHp(mHp);
		battleInfo.setcMp(cMp);
		battleInfo.setmAtk(mAtk);
		int result = 0;
		if(mHp <= 0) {
			result = 2; //캐릭터 승리
		}
		return result;
	}

	public int namiSkill(BattleDTO battleInfo, FriendDTO friend) {

		int cMp = battleInfo.getcMp();
		int cCharisma = battleInfo.getcCharisma();
		int mHp = battleInfo.getmHp();
		int mDef = battleInfo.getmDef();

		int result = 0;
		

		String grade = friend.getFrGrade();
		int Skill = friend.getFrSkill();
		int FrMp = friend.getFrMp();
		if(grade.equals("normal")) {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.2;
		}
		cMp -= FrMp;
		mHp -= Skill - mDef;
		mDef -= 5;
		if(cMp > 150) {
			cMp = 150;
		}
		if(mHp <= 0) {
			result = 2; //캐릭터 승리
		}
		battleInfo.setcMp(cMp);
		battleInfo.setmHp(mHp);
		battleInfo.setmDef(mDef);
		return result;
	}

	public void hankokSkill(BattleDTO battleInfo, FriendDTO friend) {

		int cHp = battleInfo.getcHp();
		int cMp = battleInfo.getcMp();
		int cCharisma = battleInfo.getcCharisma();
		
		String grade = friend.getFrGrade();
		int Skill = friend.getFrSkill();
		int FrMp = friend.getFrMp();
		if(grade.equals("normal")) {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.2;
		}
		cMp += Skill;
		cHp += Skill;
		if(cHp > 200) {
			cHp = 200;
		}

		battleInfo.setcMp(cMp);
		battleInfo.setcHp(cHp);
		
	}

	public int reilighSkill(BattleDTO battleInfo, FriendDTO friend) {
		int cMp = battleInfo.getcMp();
		int cCharisma = battleInfo.getcCharisma();
		int mHp = battleInfo.getmHp();
		int mDef = battleInfo.getmDef();
		int cAtk = battleInfo.getcAtk();
		
		String grade = friend.getFrGrade();
		int Skill = friend.getFrSkill();
		int FrMp = friend.getFrMp();
		if(grade.equals("normal")) {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.2;
		}
		cMp -= FrMp;
		mHp -= Skill - mDef;
		cAtk += 10;
		battleInfo.setmHp(mHp);
		battleInfo.setcMp(cMp);
		battleInfo.setcAtk(cAtk);
		int result = 0;
		if(mHp <= 0) {
			result = 2; //캐릭터 승리
		}
		return result;
	}

	public int escape(BattleDTO battleInfo) {
		
		Connection con = getConnection();
		
		int cExp = battleInfo.getcExp();
		cExp -= 200;
		if(cExp < 0) {
			cExp = 0;
		}
		int result = battleDao.escape(con, cExp);
		
		close(con);
		
		return result;
	}

	public int updateBossClear(int bossNum) {
		
		Connection con = getConnection();
		
		int result = battleDao.updateBossClear(con, bossNum);
		
		close(con);
		
		return result;
		
	}

	public int updateFriend(int clearMonsterNum) {

		Connection con = getConnection();
		
		int result = battleDao.updateFriend(con, clearMonsterNum);
		
		close(con);
		
		return result;
	}


}

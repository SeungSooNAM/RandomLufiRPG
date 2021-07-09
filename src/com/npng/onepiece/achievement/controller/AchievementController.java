package com.npng.onepiece.achievement.controller;


import java.util.List;

import com.npng.onepiece.achievement.model.dto.AchDTO;
import com.npng.onepiece.achievement.model.dto.Ch_AchDTO;
import com.npng.onepiece.achievement.model.service.AchievementService;
import com.npng.onepiece.gameready.view.ResultView;

public class AchievementController {
	private ResultView rv = new ResultView();
	private AchDTO achDTO;
	private AchievementService as = new AchievementService();


	public AchievementController() {



	}
	
	
	public int checkAchievment(int chNum) {

		int result = 0;

		result = as.bossAchievement(chNum);

		//result 1이면 조건 달성
		return result;
	}


// 이 메소드로 획득한 업적리스트 받아옴
// if(list.get(조회하려는 업적번호 -1).getAchNum() != 0)로 업적당성여부 확인, 0이면 미달성 
	public List<Ch_AchDTO> findAchievement(int chNum) {
		List<Ch_AchDTO> achList = as.findAchievement(chNum);

		if (achList != null) {
			rv.displayDmlResult("findAchSuccess");
		} else {
			rv.displayDmlResult("findAchFailed");
		} 


		return achList;
	}
	
//  i는 확인하려는 업적의 번호, result가 1이면 업적 달성, 0 이면 미달성
	public int isAchievement(int chNum, int i) {
		
		as = new AchievementService();
		int result = 0;
		List<Ch_AchDTO> achList = as.findAchievement(chNum);
		if (achList.get(i - 1).getAchNum() != 0) {
			result = 1;
		}
		
		return result;
	}
//  보스올클리어 여부 판단
	public int bossAchievement(int chNum) {

		int result = 0;

		result = as.bossAchievement(chNum);

		//result 1이면 조건 달성
		return result;
	}
//  동료  다모으기 여부 판단
	public int friendAchievement(int chNum) {

		int result = 0;

		result = as.friendAchievement(chNum);

		//result 1이면 조건 달성
		return result;
	}
//  돈 3000달성 여부 판단	
	public int MoneyAchievement(int chNum) {

		int result = 0;
		System.out.println("cNum : " + chNum);
		result = as.MoneyAchievement(chNum);

		//result 1이면 조건 달성
		return result;
	}
	
//	i번 업적을 달성했음을 ch_achievement에 추가
	public void insertAchivement(int chNum, int i) {

		int result = 0;

		result = as. insertAchivement(chNum, i);

		if(result > 0) {
			System.out.println("업적추가 성공!");
		}else {
			System.out.println("업적추가 실패ㅠㅠ");
		}
		
	}


}

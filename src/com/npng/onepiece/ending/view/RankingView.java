package com.npng.onepiece.ending.view;

public class RankingView {

	public void displayRanking(String code) {
	
			switch(code){
			case "updateFailed" : System.out.println("랭킹 업데이트 실패");break;
			case "updateSuccess": System.out.println("랭킹 업데이트 성공"); break;
			default : System.out.println("알 수 없는 에러 발생!"); break;
		}
	}
}

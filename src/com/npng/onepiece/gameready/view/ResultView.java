package com.npng.onepiece.gameready.view;

public class ResultView {
	
public void displayDmlResult(String code) {
		
		switch(code) {
			case "createFailed" : System.out.println("캐릭터 생성 실패!"); break;			
			case "createSuccess" : System.out.println("캐릭터 생성 성공!"); break;			
			default : System.out.println("알 수 없는 에러 발생!"); break;
		}
		
	}
}

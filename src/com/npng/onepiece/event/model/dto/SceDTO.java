package com.npng.onepiece.event.model.dto;

public class SceDTO {
	
	private int num;
	private String stroy;
	private String clear;
	private int exp;
	private int score;
	private int money;
	
	public SceDTO() {
		
	}
	

	public SceDTO(int num, String stroy, String clear, int exp, int score, int money) {
		super();
		this.num = num;
		this.stroy = stroy;
		this.clear = clear;
		this.exp = exp;
		this.score = score;
		this.money = money;
	}


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStroy() {
		return stroy;
	}

	public void setStroy(String stroy) {
		this.stroy = stroy;
	}

	public String getClear() {
		return clear;
	}

	public void setClear(String clear) {
		this.clear = clear;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}


	@Override
	public String toString() {
		return num + stroy +  clear + exp + score
				 + money ;
	}
	
	

}

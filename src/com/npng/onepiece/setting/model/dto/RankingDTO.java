package com.npng.onepiece.setting.model.dto;

import java.io.Serializable;

public class RankingDTO implements Serializable{

	private int chNum;
	private int score;
	private String name;

	public RankingDTO() {}
	
	public RankingDTO(int chNum, int score, String name) {
		super();
		this.chNum = chNum;
		this.score = score;
		this.name = name;
	}

	public int getChNum() {
		return chNum;
	}

	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public void setChNum(int chNum) {
		this.chNum = chNum;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "닉네임 : " + name + ",  점수  " + score + "\n";
	}
	
	




	
	
	
	
	
}

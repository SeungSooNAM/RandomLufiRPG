package com.npng.onepiece.ending.model.dto;

import java.io.Serializable;

public class EndingDTO implements Serializable{

	private int chNum;
	private String chName;
	private int chScore;
	private int rank;
	
	public EndingDTO() {}
	
	public EndingDTO(int chNum, String chName, int chScore, int rank) {
		super();
		this.chNum = chNum;
		this.chName = chName;
		this.chScore = chScore;
		this.rank = rank;
	}

	public int getChNum() {
		return chNum;
	}

	public void setChNum(int chNum) {
		this.chNum = chNum;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public int getChScore() {
		return chScore;
	}

	public void setChScore(int chScore) {
		this.chScore = chScore;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "EndingDTO [chNum=" + chNum + ", chName=" + chName + ", chScore=" + chScore + ", rank=" + rank + "]";
	}
	
	
	
}

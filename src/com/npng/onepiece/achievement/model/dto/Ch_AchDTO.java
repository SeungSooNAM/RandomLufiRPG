package com.npng.onepiece.achievement.model.dto;

import java.io.Serializable;

public class Ch_AchDTO implements Serializable{
	private int charNum;
	private int achNum;
	public Ch_AchDTO() {}
	public Ch_AchDTO(int charNum, int achNum) {
		super();
		this.charNum = charNum;
		this.achNum = achNum;
	}
	public int getCharNum() {
		return charNum;
	}
	public void setCharNum(int charNum) {
		this.charNum = charNum;
	}
	public int getAchNum() {
		return achNum;
	}
	public void setAchNum(int achNum) {
		this.achNum = achNum;
	}
	@Override
	public String toString() {
		return "Ch_AchDTO [charNum=" + charNum + ", achNum=" + achNum + "]";
	}
	
	
}

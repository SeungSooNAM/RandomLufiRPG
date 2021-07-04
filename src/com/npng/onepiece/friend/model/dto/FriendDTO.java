package com.npng.onepiece.friend.model.dto;

import java.io.Serializable;

public class FriendDTO implements Serializable{

	private int frNum;
	private String frName;
	private int frSkill;
	private String frGrade;
	private String frHave;
	private int frMp;

	
	public FriendDTO() {}
	

	public FriendDTO(int frNum, String frName, int frSkill, String frGrade, String frHave, int frMp) {
		super();
		this.frNum = frNum;
		this.frName = frName;
		this.frSkill = frSkill;
		this.frGrade = frGrade;
		this.frHave = frHave;
		this.frMp = frMp;
	}

	public int getFrNum() {
		return frNum;
	}

	public void setFrNum(int frNum) {
		this.frNum = frNum;
	}

	public String getFrName() {
		return frName;
	}

	public void setFrName(String frName) {
		this.frName = frName;
	}

	public int getFrSkill() {
		return frSkill;
	}

	public void setFrSkill(int frSkill) {
		this.frSkill = frSkill;
	}

	public String getFrGrade() {
		return frGrade;
	}

	public void setFrGrade(String frGrade) {
		this.frGrade = frGrade;
	}

	public String getFrHave() {
		return frHave;
	}

	public void setFrHave(String frHave) {
		this.frHave = frHave;
	}

	public int getFrMp() {
		return frMp;
	}

	public void setFrMp(int frMp) {
		this.frMp = frMp;
	}

	
	


	@Override
	public String toString() {
		return "FriendDTO [frNum=" + frNum + ", frName=" + frName + ", frSkill=" + frSkill + ", frGrade=" + frGrade
				+ ", frHave=" + frHave + ", frMp=" + frMp + "]";
	}


}

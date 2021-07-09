package com.npng.onepiece.achievement.model.dto;

public class AchDTO {

	private int achNum;
	private String achName;
	
	public AchDTO() {		
		
	}

	public AchDTO(int achNum, String achName, String achHaveYN) {
		super();
		this.achNum = achNum;
		this.achName = achName;
	
	}

	public int getAchNum() {
		return achNum;
	}

	public String getAchName() {
		return achName;
	}
	

	public void setAchNum(int achNum) {
		this.achNum = achNum;
	}

	public void setAchName(String achName) {
		this.achName = achName;
	}
	

	@Override
	public String toString() {
		return "AchDTO [achNum=" + achNum + ", achName=" + achName + "]";
	}

	
	
	
}

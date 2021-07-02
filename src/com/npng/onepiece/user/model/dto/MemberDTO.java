package com.npng.onepiece.user.model.dto;

public class MemberDTO implements java.io.Serializable {

	private int userNum;
	private String userId;
	private String userPwd;
	private String userName;
	private String ableYN;
	
	public MemberDTO() {}

	public MemberDTO(int userNum, String userId, String userPwd, String userName, String ableYN) {
		super();
		this.userNum = userNum;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.ableYN = ableYN;
	}

	public int getUserNum() {
		return userNum;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public String getAbleYN() {
		return ableYN;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setAbleYN(String ableYN) {
		this.ableYN = ableYN;
	}

	@Override
	public String toString() {
		return "MemberDTO [userNum=" + userNum + ", userId=" + userId + ", userPwd=" + userPwd + ", userName="
				+ userName + ", ableYN=" + ableYN + "]" + "\n";
	}
	
	

}

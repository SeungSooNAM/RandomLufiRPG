package com.npng.onepiece.user.controller;

import java.util.List;
import java.util.Map;

import com.npng.onepiece.user.model.dto.MemberDTO;
import com.npng.onepiece.user.model.service.MemberService;

public class MemberController {

	private MemberService memberService = new MemberService();;
	
	public void joinNewMember(Map<String, String> map) {
		
		MemberDTO member = new MemberDTO();
		member.setUserId(map.get("userId"));
		member.setUserPwd(map.get("userPwd"));
		member.setUserName(map.get("userName"));
		

		memberService.joinNewMember(member);
	}

	public int login(String loginId, String loginPwd) {
		
		int result = memberService.login(loginId, loginPwd);
		
		
		return result;
	}

	public int findPassword(String userId, String userName) {
		
		int result = memberService.findPassword(userId, userName);
		
		return result;
	}

	public int newPassword(String newPwd) {
		
		int result = memberService.newPassword(newPwd);
		
		return result;
	}

	public int managerLogin(String managerId, String managerPwd) {
		
		int result = memberService.managerLoginn(managerId, managerPwd);
		
		return result;
	}

	public int deleteMember(String userId) {
		
		int result = memberService.deleteMember(userId);
		
		return result;
	}

	public List<MemberDTO> selectAllMember() {
		
		List<MemberDTO> memberList = memberService.selectAllMember();
		
		return memberList;
	}

	public int userNum(String loginId) {
		
		int uNum = memberService.userNum(loginId);
		
		return uNum;
	}

	

}

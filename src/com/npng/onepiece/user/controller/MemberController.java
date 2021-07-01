package com.npng.onepiece.user.controller;

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

	public int login(Map<String, String> map) {
		
		int result = memberService.login(map);
		
		
		return result;
	}

	

}

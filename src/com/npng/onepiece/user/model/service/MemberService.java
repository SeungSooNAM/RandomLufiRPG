package com.npng.onepiece.user.model.service;

import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.commit;
import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.npng.onepiece.user.model.dao.MemberDAO;
import com.npng.onepiece.user.model.dto.MemberDTO;

public class MemberService {

	private MemberDAO memberDAO;
	
	public MemberService() {
		this.memberDAO = new MemberDAO();
	}
	
	public int joinNewMember(MemberDTO member) {
		
		Connection con = getConnection();
		int result = memberDAO.joinNewMember(con, member);

		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public int login(String loginId, String loginPwd) {
		
		Connection con = getConnection();
		int result = memberDAO.login(con, loginId, loginPwd);
		close(con);
		
		return result;
	}

	public int findPassword(String userId, String userName) {
		
		Connection con = getConnection();
		int result = memberDAO.findPassword(con, userId, userName);
		close(con);
		
		return result;
	}

	public int newPassword(String newPwd) {
		
		Connection con = getConnection();
		int result = memberDAO.newPassword(con, newPwd);
		close(con);
		
		return result;
	}

	public int managerLoginn(String managerId, String managerPwd) {

		Connection con = getConnection();
		int result = memberDAO.managerLoginn(con, managerId, managerPwd);
		close(con);
		
		return result;
	}

	public int deleteMember(String userId) {
		
		Connection con = getConnection();
		int result = memberDAO.deleteMember(con, userId);
		close(con);
		
		return result;
	}

	public List<MemberDTO> selectAllMember() {

		Connection con = getConnection();
		List<MemberDTO> memberList = memberDAO.selectAllMember(con); 
		close(con);
		
		return memberList;
		
	}

	public String userNum(String loginId) {

		Connection con = getConnection();
		String uNum = memberDAO.userNum(con, loginId);
		
		return uNum;
	}

}

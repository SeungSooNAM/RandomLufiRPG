package com.npng.onepiece.user.model.service;

import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.commit;
import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.rollback;

import java.sql.Connection;
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

	public int login(Map<String, String> map) {
		
		Connection con = getConnection();
		int result = memberDAO.login(con, map);
		return result;
	}

}

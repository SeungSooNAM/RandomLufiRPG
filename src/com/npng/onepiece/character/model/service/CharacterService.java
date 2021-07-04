package com.npng.onepiece.character.model.service;

import java.sql.Connection;

import com.npng.onepiece.character.model.dao.CharacterDAO;
import com.npng.onepiece.character.model.dto.CharacterDTO;

import oracle.jdbc.OracleConnection.CommitOption;

import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.close;
import static com.npng.onepiece.common.JDBCTemplate.commit;
import static com.npng.onepiece.common.JDBCTemplate.rollback;

public class CharacterService {

	private CharacterDAO cDAO = new CharacterDAO();
	private CharacterDTO cDTO;

	public CharacterService() {
		this.cDAO = new CharacterDAO();
		this.cDTO = new CharacterDTO();
		
		
	}
	public CharacterDTO lookChInfo(int chNum) {
		Connection con = getConnection();
		
		cDTO = cDAO.lookChInfo(con, chNum);
		
		if (cDTO != null) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return cDTO;
	}
		
	
	public int CharacterStrUp(CharacterDTO charDTO, int chNum) {
		Connection con = getConnection();

		int result = cDAO.CharacterStrUp(con, charDTO, chNum);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}


	public int CharacterDexUp(CharacterDTO charDTO, int chNum) {
		Connection con = getConnection();

		int result = cDAO.CharacterDexUp(con, charDTO, chNum);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public int CharacterChaUp(CharacterDTO charDTO, int chNum) {
		Connection con = getConnection();

		int result = cDAO.CharacterChaUp(con, charDTO, chNum);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

}

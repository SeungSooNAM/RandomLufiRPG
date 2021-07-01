package com.npng.onepiece.gameready.model.service;

import java.sql.Connection;

import com.npng.onepiece.gameready.model.dao.GameReadyDAO;
import com.npng.onepiece.gameready.model.dto.NewCharacterDTO;
import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.commit;
import static com.npng.onepiece.common.JDBCTemplate.rollback;
import static com.npng.onepiece.common.JDBCTemplate.close;

public class GameReadyService {
	
	private GameReadyDAO gameReadyDAO;
	
	public GameReadyService() {
		this.gameReadyDAO = new GameReadyDAO();
	}

	public int insertNewCharacter(NewCharacterDTO charDTO) {
		Connection con = getConnection();
		
		int result = gameReadyDAO.insertNewCharacter(con, charDTO);
		
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);		
		
		return result;
	}

}

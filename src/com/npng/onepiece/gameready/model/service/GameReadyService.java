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
		int result = 0;
		
		result += gameReadyDAO.insertNewCharacter(con, charDTO); //생성한 캐릭터 정보 DB에 insert	
		
		
		int charNum = gameReadyDAO.findLoginCharNum(con, charDTO);// 로그인한 유저의 캐릭터번호 가져오기
		
		/*TEST*/System.out.println("DAO에서 로그인한 유저의 charNum 찾아옴  charNum = " + charNum);
		
		 result += gameReadyDAO.createNewInventory(con, charNum);
		 result += gameReadyDAO.createNewItemEquip(con, charNum);
		 
		
		if (result == 3) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);				
	
		return result;
	}

	public int searchChNum(int uNum) {
		
		Connection con = getConnection();
		
		int chNum = gameReadyDAO.searchNum(con ,uNum);
		return chNum;
	}
	
	
	

}

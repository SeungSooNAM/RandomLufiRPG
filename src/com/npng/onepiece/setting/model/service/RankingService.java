package com.npng.onepiece.setting.model.service;

import java.sql.Connection;
import java.util.List;

import com.npng.onepiece.setting.model.dao.RankingDAO;
import com.npng.onepiece.setting.model.dto.RankingDTO;
import com.npng.onepiece.user.view.MainFrame;

import static com.npng.onepiece.common.JDBCTemplate.getConnection;
import static com.npng.onepiece.common.JDBCTemplate.close;
public class RankingService {

	private RankingDAO rankingDAO;
	
	public RankingService() {
		this.rankingDAO = new RankingDAO();
	}

	public List<RankingDTO> selectRanking() {
		
		Connection con = getConnection();
		
		List<RankingDTO> rankingList = rankingDAO.selectRanking(con);
		
		close(con);
		
		return rankingList;
	}

}

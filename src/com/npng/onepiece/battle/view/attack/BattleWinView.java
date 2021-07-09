package com.npng.onepiece.battle.view.attack;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.battle.controller.BattleController;
import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.event.views.BattleResultView;
import com.npng.onepiece.user.view.MainFrame;


public class BattleWinView extends JPanel{
	
	private BattleWinView battleWinView;
	private BattleController battleController = new BattleController();
	private JLabel bl;
	private BattleDTO battleInfo;
	private int result;
	private int updateResult;
	private int getFriend;

	public BattleWinView(BattleDTO battleInfo, int result) {
		this.setSize(1200, 800);
		this.battleWinView = this;
		this.battleInfo = battleInfo;
		this.result = result;
		this.setLayout(null);
		
		
		Image img = new ImageIcon("image/battle/전투승리.png").getImage().getScaledInstance(1200, 800, 0);
		bl = new JLabel(new ImageIcon(img));
		bl.setLocation(0, 0);
		bl.setSize(1200, 800);
		this.add(bl);
		bl.addMouseListener(new MyMouseAdapter());
		int clearMonsterNum = battleInfo.getmNum();
		System.out.println("몬스터 번호 : " + clearMonsterNum);
		if(clearMonsterNum <= 7) {
			updateResult = battleController.updateBossClear(clearMonsterNum); //보스클리어 등록후 성공시 1반환
			if(clearMonsterNum == 7 ) {
				// 엔딩 이동
			} else if(clearMonsterNum == 1 || clearMonsterNum == 3 || clearMonsterNum == 4 || clearMonsterNum == 5) {
				System.out.println("몬스터 번호 : " + clearMonsterNum);
				getFriend = battleController.updateFriend(clearMonsterNum); // 동료 획득 등록 후 성공시 1반환
				System.out.println("동료 등록 성공 : " + getFriend);
			}
		}
	}
	




	private class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == bl) {
				ViewUtil.changePanel(MainFrame.mf, battleWinView, new BattleResultView(MainFrame.mf, battleInfo, 1, getFriend));
			}
		}
	}
}

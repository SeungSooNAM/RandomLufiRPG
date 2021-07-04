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


public class BattleLoseView extends JPanel{
	
	private BattleLoseView battleLoseView;
	private BattleController battleController = new BattleController();
	private JLabel bl;
	private BattleDTO battleInfo;
	private int result;

	public BattleLoseView(BattleDTO battleInfo, int result) {
		this.setSize(1200, 800);
		this.battleLoseView = this;
		this.battleInfo = battleInfo;
		this.result = result;
		this.setLayout(null);
		
		
		Image img = new ImageIcon("image/battle/전투패배.png").getImage().getScaledInstance(1200, 800, 0);
		bl = new JLabel(new ImageIcon(img));
		bl.setLocation(0, 0);
		bl.setSize(1200, 800);
		this.add(bl);
		bl.addMouseListener(new MyMouseAdapter());;
	}
	




	private class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == bl) {
				ViewUtil.changePanel(MainFrame.mf, battleLoseView, new BattleResultView(MainFrame.mf, battleInfo, 0 , 0));
			}
		}
	}
}
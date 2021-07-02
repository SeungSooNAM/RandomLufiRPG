package com.npng.onepiece.battle.view.attack;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.battle.controller.BattleController;
import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.battle.view.main.BattleContinueView;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.view.MainFrame;


public class AvoidSuccessView extends JPanel{

	private MainFrame mf;
	private AvoidSuccessView avoidSuccessView;
	private BattleController battleController = new BattleController();
	private JLabel bl;
	private BattleDTO battleInfo;

	public AvoidSuccessView(MainFrame mf, BattleDTO battleInfo) {
		this.setSize(1200, 800);
		this.mf = mf;
		this.avoidSuccessView = this;
		this.battleInfo = battleInfo;
		this.setLayout(null);
		
		
		
		Image img = new ImageIcon("image/battle/avoidSuccess.png").getImage().getScaledInstance(1200, 800, 0);
		bl = new JLabel(new ImageIcon(img));
		bl.setLocation(0, 0);
		bl.setSize(1200, 800);
		this.add(bl);
		bl.addMouseListener(new MyMouseAdapter());
	}
	
	private class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == bl) {
				System.out.println("회피 성공");
				ViewUtil.changePanel(mf, avoidSuccessView, new BattleContinueView(mf, battleInfo));
			}
		}
	}
}

package com.npng.onepiece.battle.view.attack;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.battle.controller.BattleController;
import com.npng.onepiece.battle.model.dto.BattleDTO;


public class AttackFailedView extends JPanel{
	
	private AttackFailedView attackFailedView;
	private BattleController battleController = new BattleController();
	private JLabel bl;
	private BattleDTO battleInfo;

	public AttackFailedView(BattleDTO battleInfo) {
		this.setSize(1200, 800);
		this.attackFailedView = this;
		this.battleInfo = battleInfo;
		this.setLayout(null);
		
		Image img = new ImageIcon("image/battle/attack/공격실패.png").getImage().getScaledInstance(1200, 800, 0);
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
				System.out.println("공격실패");
				battleController.Monsterattack(attackFailedView, battleInfo);
				
			}
		}
	}
}

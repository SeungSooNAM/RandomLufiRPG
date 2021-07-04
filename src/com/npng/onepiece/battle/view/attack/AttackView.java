package com.npng.onepiece.battle.view.attack;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.battle.controller.BattleController;
import com.npng.onepiece.battle.model.dto.BattleDTO;


public class AttackView extends JPanel{
	
	private AttackView attackView;
	private BattleController battleController = new BattleController();
	private JLabel bl;
	private BattleDTO battleInfo;

	public AttackView(BattleDTO battleInfo) {
		this.setSize(1200, 800);
		this.attackView = this;
		this.battleInfo = battleInfo;
		this.setLayout(null);
		
		int num = (int) (Math.random() * 3) + 1;
		Image img = new ImageIcon("image/battle/attack/루피공격" + num + ".png").getImage().getScaledInstance(1200, 800, 0);
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
				System.out.println("공격성공");
				battleController.Monsterattack(attackView, battleInfo);
			}
		}
	}
}

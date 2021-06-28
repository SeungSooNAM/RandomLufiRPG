package com.npng.onepiece.battle.view;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BattleView extends JPanel{
	
	private BattleView battleView;

	private JLabel characterInfo;
	private JLabel MonsterInfo;
	
	private JButton btnAttack;
	private JButton btnSkill;
	private JButton btnEscape;
	
	public BattleView() {
		this.setSize(1400, 800);
		this.setLayout(null);
		
		Image icon = new ImageIcon("iamges/battle.battleMain.jpg").getImage().getScaledInstance(1200, 800, 0);
		
		this.addMouseListener(new MyMouseAdapter());
		
		
		
		
		
		
		this.add(characterInfo);
		this.add(MonsterInfo);
		this.add(btnAttack);
		this.add(btnSkill);
		this.add(btnEscape);
	}
	
	private class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == btnAttack) {
//				ViewUtil.changePanel(mf, battleView, )
			}
		}
	}
}
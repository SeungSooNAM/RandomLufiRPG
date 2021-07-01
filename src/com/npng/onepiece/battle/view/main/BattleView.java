package com.npng.onepiece.battle.view.main;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.battle.controller.BattleController;
import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.mainMenu.MainFrame;

public class BattleView extends JPanel{

	private MainFrame mf;
	private BattleView battleView;
	private BattleController battleController = new BattleController();
	private BattleDTO battleInfo;

	private JLabel cLevel;
	private JLabel cName;
	private JLabel cAtk;
	private JLabel cHp;
	private JLabel mLevel;
	private JLabel mName;
	private JLabel mAtk;
	private JLabel mDef;
	private JLabel mHp;
	
	
	private JPanel atkPanel;
	private JPanel skilPanel;
	private JPanel escapePanel;
	private JPanel infoPanel;
	
	private JLabel atkLabel;
	private JLabel skilLabel;
	private JLabel infoLabel;
	private JLabel escapeLabel;
	
	private int cHpLabel;
	private int mHpLabel;
	

	public BattleView(MainFrame mf) {

		int map = 1; // 맵정보 받기
		
		this.setSize(1200, 800);
		this.mf = mf;
		this.battleView = this;
		mf.add(this);
		
		this.setLayout(null);
		Font font1 = new Font("Dialog",Font.BOLD, 50);
		
		Image img = new ImageIcon("image/battle/battleMain.png").getImage().getScaledInstance(1200, 800, 0);
		JLabel bl = new JLabel(new ImageIcon(img));
		bl.setLocation(0, 0);
		bl.setSize(1200, 800);
		this.add(bl);
		

		

		battleInfo = battleController.readyBattle(map);
		cHpLabel = battleInfo.getcHp();
		mHpLabel = battleInfo.getmHp();
		System.out.println(battleInfo.getmNum());
		Image img2 = new ImageIcon("image/battle/Monster" + battleInfo.getmNum() + ".png").getImage().getScaledInstance(400, 400, 0);
		JLabel bl2 = new JLabel(new ImageIcon(img2));
		bl2.setLocation(800, 120);
		bl2.setSize(300, 400);
		bl.add(bl2);
		
		
		atkPanel = new JPanel();
		atkPanel.setLocation(550, 550);
		atkPanel.setSize(280, 80);
		bl.add(atkPanel);
	
		atkLabel = new JLabel("기본공격");
		atkLabel.setFont(font1);
		atkPanel.add(atkLabel, BorderLayout.CENTER);
		
		skilPanel = new JPanel();
		skilPanel.setLocation(850, 550);
		skilPanel.setSize(280, 80);
		bl.add(skilPanel);
		
		escapePanel = new JPanel();
		escapePanel.setLocation(550, 640);
		escapePanel.setSize(280, 80);
		bl.add(escapePanel);
		
		infoPanel = new JPanel();
		infoPanel.setLocation(850, 640);
		infoPanel.setSize(280, 80);
		bl.add(infoPanel);
		
		
		atkPanel.addMouseListener(new MyMouseAdapter());
		

		cLevel = new JLabel("레벨 : 5");
		cLevel.setLocation(50, 20);
		cLevel.setSize(50, 50);
		
		cName = new JLabel("이름 : 루피");
		cName.setLocation(150, 20);
		cName.setSize(100, 50);
		
		cAtk = new JLabel("공격력 : 30");
		cAtk.setLocation(50, 50);
		cAtk.setSize(100, 50);
		
		cHp = new JLabel("체력 : " + cHpLabel);
		cHp.setLocation(150, 50);
		cHp.setSize(100, 50);
		
		mLevel = new JLabel("레벨 : 5");
		mLevel.setLocation(900, 20);
		mLevel.setSize(100, 50);
		
		mName = new JLabel("이름 : 아카이누");
		mName.setLocation(1000, 20);
		mName.setSize(100, 50);
		
		mAtk = new JLabel("공격력 : 40");
		mAtk.setLocation(900, 50);
		mAtk.setSize(100, 50);
		
		mDef = new JLabel("방어력 : 5");
		mDef.setLocation(1000, 50);
		mDef.setSize(100, 50);

		mHp = new JLabel("체력 : " + mHpLabel);
		mHp.setLocation(1100, 50);
		mHp.setSize(100, 50);
		
		
		bl.add(cLevel);
		bl.add(cName);
		bl.add(cAtk);
		bl.add(cHp);
		bl.add(mLevel);
		bl.add(mName);
		bl.add(mAtk);
		bl.add(mDef);
		bl.add(mHp);
		
	}
	
	private class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == atkPanel) {
				battleController.attack(mf, battleView, battleInfo);
			} else if(e.getSource() == skilPanel){
				battleController.skill(mf, battleView, battleInfo);
			}
		}
	}
	
	
}
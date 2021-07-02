package com.npng.onepiece.battle.view.main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.battle.controller.BattleController;
import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.battle.model.dto.FriendDTO;
import com.npng.onepiece.battle.view.skill.SelectSkillView;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.mainMenu.MainFrame;

public class BattleContinueView extends JPanel{

	private MainFrame mf;
	private BattleContinueView battleContinueView;
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
	private JLabel cMp;
	
	
	private JPanel atkPanel;
	private JPanel skilPanel;
	private JPanel escapePanel;
	private JPanel infoPanel;
	
	private JLabel atkLabel;
	private JLabel skilLabel;
	private JLabel infoLabel;
	private JLabel escapeLabel;
	
	private int cHpLabel;
	private int cMpLabel;
	private int cLvLabel;
	private String cNameLabel;
	private int cAtkLabel;
	
	private int mHpLabel;
	private String mNameLabel;
	private int mLvLabel;
	private int mDefLabel;
	private int mAtkLabel;
	
	public BattleContinueView(MainFrame mf, BattleDTO battleInfo) {

		this.setSize(1200, 800);
		this.mf = mf;
		this.battleContinueView = this;
		mf.add(this);
		
		this.setLayout(null);
		Font font1 = new Font("Dialog",Font.BOLD, 50);
		
		Image img = new ImageIcon("image/battle/battleMain.png").getImage().getScaledInstance(1200, 800, 0);
		JLabel bl = new JLabel(new ImageIcon(img));
		bl.setLocation(0, 0);
		bl.setSize(1200, 800);
		this.add(bl);
		
		Image img2 = new ImageIcon("image/battle/Monster" + battleInfo.getmNum() + ".png").getImage().getScaledInstance(400, 400, 0);
		JLabel bl2 = new JLabel(new ImageIcon(img2));
		bl2.setLocation(800, 120);
		bl2.setSize(300, 400);
		bl.add(bl2);
		
		this.battleInfo = battleInfo;
		cHpLabel = battleInfo.getcHp();
		cNameLabel = battleInfo.getcName();
		cLvLabel = battleInfo.getcLv();
		cAtkLabel = battleInfo.getcAtk();
		cMpLabel = battleInfo.getcMp();
		
		mHpLabel = battleInfo.getmHp();
		mNameLabel = battleInfo.getmName();
		mLvLabel = battleInfo.getmLv();
		mAtkLabel = battleInfo.getmAtk();
		mDefLabel = battleInfo.getmDef();
		
		
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
		
		skilLabel = new JLabel("스킬공격");
		skilLabel.setFont(font1);
		skilPanel.add(skilLabel, BorderLayout.CENTER);
		
//		escapePanel = new JPanel();
//		escapePanel.setLocation(550, 640);
//		escapePanel.setSize(280, 80);
//		bl.add(escapePanel);
//		
//		infoPanel = new JPanel();
//		infoPanel.setLocation(850, 640);
//		infoPanel.setSize(280, 80);
//		bl.add(infoPanel);
		
		
		atkPanel.addMouseListener(new MyMouseAdapter());
		skilPanel.addMouseListener(new MyMouseAdapter());

		cLevel = new JLabel("레벨 : " + cLvLabel);
		cLevel.setLocation(50, 20);
		cLevel.setSize(50, 50);
		
		cName = new JLabel("이름 : " + cNameLabel);
		cName.setLocation(150, 20);
		cName.setSize(100, 50);
		
		cAtk = new JLabel("공격력 : " + cAtkLabel);
		cAtk.setLocation(50, 50);
		cAtk.setSize(100, 50);
		
		cHp = new JLabel("체력 : " + cHpLabel);
		cHp.setLocation(150, 50);
		cHp.setSize(100, 50);
		
		cMp = new JLabel("마나 : " + cMpLabel);
		cMp.setLocation(250, 50);
		cMp.setSize(100, 50);
		
		mLevel = new JLabel("레벨 : " + mLvLabel);
		mLevel.setLocation(900, 20);
		mLevel.setSize(100, 50);
		
		mName = new JLabel("이름 : " + mNameLabel);
		mName.setLocation(1000, 20);
		mName.setSize(100, 50);
		
		mAtk = new JLabel("공격력 : " + mAtkLabel);
		mAtk.setLocation(900, 50);
		mAtk.setSize(100, 50);
		
		mDef = new JLabel("방어력 : " + mDefLabel);
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
		bl.add(cMp);
	}
	
	private class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == atkPanel) {
				battleController.attack(mf, battleContinueView, battleInfo);
			} else if(e.getSource() == skilPanel){
				ViewUtil.changePanel(mf, battleContinueView, new SelectSkillView(mf, battleInfo));
			} 
		}
	}
}

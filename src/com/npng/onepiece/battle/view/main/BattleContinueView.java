package com.npng.onepiece.battle.view.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.battle.controller.BattleController;
import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.battle.view.skill.SelectSkillView;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.view.MainFrame;


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
	private JLabel mType;
	
	
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
	private String mTypeLabel;
	
	public BattleContinueView(BattleDTO battleInfo) {

		this.setSize(1200, 800);
		this.battleContinueView = this;
		MainFrame.mf.add(this);
		
		this.setLayout(null);
		Font font1 = new Font("Dialog",Font.BOLD, 50);
		Font font2 = new Font("Dialog", Font.BOLD, 25);
		
		Image img = new ImageIcon("image/battle/battleMain.png").getImage().getScaledInstance(1200, 800, 0);
		JLabel bl = new JLabel(new ImageIcon(img));
		bl.setLocation(0, 0);
		bl.setSize(1200, 800);
		this.add(bl);
		
		Image img2 = new ImageIcon("image/battle/monster/몬스터" + battleInfo.getmNum() + ".png").getImage().getScaledInstance(400, 400, 0);
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
		mTypeLabel = battleInfo.getmCate();
		
		
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
		cLevel.setFont(font2);
		cLevel.setSize(180, 50);
		
		cName = new JLabel("이름 : " + cNameLabel);
		cName.setLocation(230, 20);
		cName.setFont(font2);
		cName.setSize(350, 50);
		
		cAtk = new JLabel("공격력 : " + cAtkLabel);
		cAtk.setLocation(50, 80);
		cAtk.setFont(font2);
		cAtk.setForeground(Color.MAGENTA);
		cAtk.setSize(180, 50);
		
		cHp = new JLabel("체력 : " + cHpLabel);
		cHp.setLocation(230, 80);
		cHp.setFont(font2);
		cHp.setForeground(Color.GREEN);
		cHp.setSize(180, 50);
		
		cMp = new JLabel("마나 : " + cMpLabel);
		cMp.setLocation(410, 80);
		cMp.setFont(font2);
		cMp.setForeground(Color.BLUE);
		cMp.setSize(180, 50);
		
		mLevel = new JLabel("레벨 : " + mLvLabel);
		mLevel.setLocation(650, 20);
		mLevel.setFont(font2);
		mLevel.setSize(180, 50);
		
		mName = new JLabel("이름 : " + mNameLabel);
		mName.setLocation(830, 20);
		mName.setFont(font2);
		mName.setSize(200, 50);
		
		mType = new JLabel("타입 : " + mTypeLabel);
		mType.setLocation(1030, 20);
		mType.setFont(font2);
		mType.setForeground(Color.red);
		mType.setSize(200, 50);
		
		mAtk = new JLabel("공격력 : " + mAtkLabel);
		mAtk.setLocation(650, 80);
		mAtk.setFont(font2);
		mAtk.setSize(180, 50);
		
		mDef = new JLabel("방어력 : " + mDefLabel);
		mDef.setLocation(830, 80);
		mDef.setFont(font2);
		mDef.setSize(180, 50);

		mHp = new JLabel("체력 : " + mHpLabel);
		mHp.setLocation(1010, 80);
		mHp.setFont(font2);
		mHp.setSize(180, 50);
		
		
		
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
		bl.add(mType);
	}
	
	private class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == atkPanel) {
				battleController.attack(battleContinueView, battleInfo);
			} else if(e.getSource() == skilPanel){
				ViewUtil.changePanel(battleContinueView, new SelectSkillView(battleInfo));
			} 
		}
	}
}

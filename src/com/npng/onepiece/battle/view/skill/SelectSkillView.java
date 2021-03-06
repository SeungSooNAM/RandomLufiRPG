package com.npng.onepiece.battle.view.skill;


import java.awt.BorderLayout;
import java.awt.Color;
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
import com.npng.onepiece.battle.view.main.BattleContinueView;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.view.MainFrame;


public class SelectSkillView extends JPanel{

	private BattleController battleController = new BattleController();
	private SelectSkillView selectSkillView;
	private BattleDTO battleInfo;
	private FriendDTO friend[] =  new FriendDTO[6];
	private List<FriendDTO> friendList;

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
	
	private JPanel zoroPanel;
	private JPanel sandiPanel;
	private JPanel oosopPanel;
	private JPanel namiPanel;
	private JPanel hankokPanel;
	private JPanel reilighPanel;
	private JPanel cancelPanel;
	private JPanel battleInfoPanel;
	
	private JLabel zoroLabel;
	private JLabel sandiLabel;
	private JLabel oosopLabel;
	private JLabel namiLabel;
	private JLabel hankokLabel;
	private JLabel reilighLabel;
	private JLabel cancelLabel;
	
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

	public SelectSkillView(BattleDTO battleInfo) {

		int map = 1; // 맵정보 받기
		System.out.println(battleInfo);
		this.setSize(1200, 800);
		this.selectSkillView = this;
		
		this.battleInfo = battleInfo;
		MainFrame.mf.add(this);

		this.setLayout(null);
		Font font1 = new Font("Dialog",Font.BOLD, 50);
		Font font2 = new Font("Dialog", Font.BOLD, 25);
		
		Image img = new ImageIcon("image/battle/battleMain.png").getImage().getScaledInstance(1200, 800, 0);
		JLabel bl = new JLabel(new ImageIcon(img));
		bl.setLocation(0, 0);
		bl.setSize(1200, 800);
		this.add(bl);
		
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
		

		Image img2 = new ImageIcon("image/battle/monster/몬스터" + battleInfo.getmNum() + ".png").getImage().getScaledInstance(400, 400, 0);
		JLabel bl2 = new JLabel(new ImageIcon(img2));
		bl2.setLocation(800, 120);
		bl2.setSize(300, 400);
		bl.add(bl2);
		
		
		
		zoroPanel = new JPanel();
		zoroPanel.setLocation(550, 550);
		zoroPanel.setSize(180, 80);
		bl.add(zoroPanel);
		zoroLabel = new JLabel("조로");
		zoroLabel.setFont(font1);
		zoroPanel.add(zoroLabel, BorderLayout.CENTER);
		zoroPanel.addMouseListener(new MyMouseAdapter());
		
		sandiPanel = new JPanel();
		sandiPanel.setLocation(750, 550);
		sandiPanel.setSize(180, 80);
		bl.add(sandiPanel);
		sandiLabel = new JLabel("상디");
		sandiLabel.setFont(font1);
		sandiPanel.add(sandiLabel, BorderLayout.CENTER);
		sandiPanel.addMouseListener(new MyMouseAdapter());
		
		oosopPanel = new JPanel();
		oosopPanel.setLocation(950, 550);
		oosopPanel.setSize(180, 80);
		bl.add(oosopPanel);
		oosopLabel = new JLabel("우솝");
		oosopLabel.setFont(font1);
		oosopPanel.add(oosopLabel, BorderLayout.CENTER);
		oosopPanel.addMouseListener(new MyMouseAdapter());
		
		namiPanel = new JPanel();
		namiPanel.setLocation(550, 640);
		namiPanel.setSize(180, 80);
		bl.add(namiPanel);
		namiLabel = new JLabel("나미");
		namiLabel.setFont(font1);
		namiPanel.add(namiLabel, BorderLayout.CENTER);
		namiPanel.addMouseListener(new MyMouseAdapter());
		
		hankokPanel = new JPanel();
		hankokPanel.setLocation(750, 640);
		hankokPanel.setSize(180, 80);
		bl.add(hankokPanel);
		hankokLabel = new JLabel("핸콕");
		hankokLabel.setFont(font1);
		hankokPanel.add(hankokLabel, BorderLayout.CENTER);
		hankokPanel.addMouseListener(new MyMouseAdapter());
		
		reilighPanel = new JPanel();
		reilighPanel.setLocation(950, 640);
		reilighPanel.setSize(180, 80);
		bl.add(reilighPanel);
		reilighLabel = new JLabel("레일리");
		reilighLabel.setFont(font1);
		reilighPanel.add(reilighLabel, BorderLayout.CENTER);
		reilighPanel.addMouseListener(new MyMouseAdapter());
		
		cancelPanel = new JPanel();
		cancelPanel.setLocation(200, 600);
		cancelPanel.setSize(200, 80);
		bl.add(cancelPanel);
		cancelLabel = new JLabel("돌아가기");
		cancelLabel.setFont(font1);
		cancelPanel.add(cancelLabel, BorderLayout.CENTER);
		cancelPanel.addMouseListener(new MyMouseAdapter());
		
//		battleInfoPanel = new JPanel();
//		battleInfoPanel.setLocation(100, 550);
//		battleInfoPanel.setSize(300, 160);
//		battleInfoPanel.setOpaque(false);
//		bl.add(battleInfoPanel);
//		JLabel attackInfo = new JLabel("동료가 없습니다.");
//		attackInfo.setBounds(10, 20, 160, 100);
//		battleInfoPanel.add(attackInfo, BorderLayout.CENTER);
		

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
		
		friendList = battleInfo.getFriendList();
		

	}
	
//	if(e.getSource() == zoroPanel) {
//		System.out.println(friendList);
//		FriendDTO zoro = friendList.get(1);
//		int num = zoro.getFrNum();
//		String grade = zoro.getFrGrade();
//		if(zoro.getFrHave().equals("Y")) { 
//			if(battleInfo.getcMp() >= zoro.getFrMp()) {
//				battleController.zoroSkill(mf, selectSkillView, battleInfo, num, grade);						
//			} else {
//				System.out.println("마나가 없습니다.");
//			}
//		} else {
//			System.out.println("동료가 없습니다.");
//		}
	private class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == zoroPanel) {
				int cnt = 0;
				if(friendList.size() == 0) {
					ViewUtil.changePanel(selectSkillView, new NotFriendView(battleInfo));
				} else {
					for(int i = 0; i < friendList.size(); i++) {
						if(friendList.get(i).getFrName().equals("조로")) {
							cnt++;
							int mp = friendList.get(i).getFrMp();						
							if(battleInfo.getcMp() >= mp) {
								battleController.zoroSkill(selectSkillView, battleInfo, friendList.get(i));
							} else {
								System.out.println("마나가 부족합니다.");
								ViewUtil.changePanel(selectSkillView, new EnoughMPView(battleInfo));
							}
						}
						if(i == friendList.size() - 1) {
							System.out.println(i);
							System.out.println("cnt : " + cnt);
							if(cnt == 0) {
								System.out.println("cnt : " + cnt);
								ViewUtil.changePanel(selectSkillView, new NotFriendView(battleInfo));
							}
						}
					} 
				}
				
				
				
			} else if(e.getSource() == sandiPanel){
				int cnt = 0;
				if(friendList.size() == 0) {
					ViewUtil.changePanel(selectSkillView, new NotFriendView(battleInfo));
				}else {
					for(int i = 0; i < friendList.size(); i++) {
						if(friendList.get(i).getFrName().equals("상디")) {
							cnt++;
							int mp = friendList.get(i).getFrMp();						
							if(battleInfo.getcMp() >= mp) {
								battleController.sandiSkill(selectSkillView, battleInfo,  friendList.get(i));
							} else {
								System.out.println("마나가 부족합니다.");
								ViewUtil.changePanel(selectSkillView, new EnoughMPView(battleInfo));
							}
						}
						if(i == friendList.size() - 1) {
							if(cnt == 0) {
								ViewUtil.changePanel(selectSkillView, new NotFriendView(battleInfo));
							}
						}
					}
				}
				
				
			} else if(e.getSource() == oosopPanel){
				int cnt = 0;
				if(friendList.size() == 0) {
					ViewUtil.changePanel(selectSkillView, new NotFriendView(battleInfo));
				} else {
					for(int i = 0; i < friendList.size(); i++) {						
						if(friendList.get(i).getFrName().equals("우솝")) {
							cnt++;
							int mp = friendList.get(i).getFrMp();					
							if(battleInfo.getcMp() >= mp) {
								battleController.oosopSkill(selectSkillView, battleInfo,  friendList.get(i));
							} else {
								System.out.println("마나가 부족합니다.");
								ViewUtil.changePanel(selectSkillView, new EnoughMPView(battleInfo));
							}
						} 
						if(i == friendList.size() - 1) {
							if(cnt == 0) {
								ViewUtil.changePanel(selectSkillView, new NotFriendView(battleInfo));
							}
						}
					}
				}
				
				
			} else if(e.getSource() == namiPanel){
				int cnt = 0;
				if(friendList.size() == 0) {
					ViewUtil.changePanel(selectSkillView, new NotFriendView(battleInfo));
				} else {
					for(int i = 0; i < friendList.size(); i++) {
						if(friendList.get(i).getFrName().equals("나미")) {
							cnt++;
							int mp = friendList.get(i).getFrMp();				
							if(battleInfo.getcMp() >= mp) {
								battleController.namiSkill(selectSkillView, battleInfo,  friendList.get(i));
							} else {							
								System.out.println("마나가 부족합니다.");
								ViewUtil.changePanel(selectSkillView, new EnoughMPView(battleInfo));
							}
						} 
						if(i == friendList.size() - 1) {
							if(cnt == 0) {
								ViewUtil.changePanel(selectSkillView, new NotFriendView(battleInfo));
							}
						}
						
					}
				}
				
				
			} else if(e.getSource() == hankokPanel){
				int cnt = 0;
				if(friendList.size() == 0) {
					ViewUtil.changePanel(selectSkillView, new NotFriendView(battleInfo));
				} else {
					for(int i = 0; i < friendList.size(); i++) {
						if(friendList.get(i).getFrName().equals("핸콕")) {
							cnt++;
							int mp = friendList.get(i).getFrMp();					
							if(battleInfo.getcMp() >= mp) {
								battleController.hankokSkill(selectSkillView, battleInfo,  friendList.get(i));
							} else {							
								System.out.println("마나가 부족합니다.");
								ViewUtil.changePanel(selectSkillView, new EnoughMPView(battleInfo));
							}
						} 
						if(i == friendList.size() - 1) {
							if(cnt == 0) {
								ViewUtil.changePanel(selectSkillView, new NotFriendView(battleInfo));
							}
						}
						
					}
				}
			
				
			} else if(e.getSource() == reilighPanel){
				int cnt = 0;
				if(friendList.size() == 0) {
					ViewUtil.changePanel(selectSkillView, new NotFriendView(battleInfo));
				} else {
					for(int i = 0; i < friendList.size(); i++) {
						if(friendList.get(i).getFrName().equals("레일리")) {
							cnt++;
							int mp = friendList.get(i).getFrMp();						
							if(battleInfo.getcMp() >= mp) {
								battleController.reilighSkill(selectSkillView, battleInfo,  friendList.get(i));
							} else {
								System.out.println("마나가 부족합니다.");
								ViewUtil.changePanel(selectSkillView, new EnoughMPView(battleInfo));
							}
						} 
						if(i == friendList.size() - 1) {
							if(cnt == 0) {
								ViewUtil.changePanel(selectSkillView, new NotFriendView(battleInfo));
							}
						}
					}
				}
			} else if(e.getSource() == cancelPanel) {
				ViewUtil.changePanel(selectSkillView, new BattleContinueView(battleInfo));
			}
		}
	}
}
	

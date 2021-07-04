package com.npng.onepiece.event.views;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.ending.view.LufiDie;
import com.npng.onepiece.event.controller.eventController;
import com.npng.onepiece.event.model.dto.SceDTO;
import com.npng.onepiece.user.view.MainFrame;

public class BattleResultView extends JPanel {
	
	private Image img;
	private MainFrame mf;
	private BattleResultView view;
	private int chNum;
	private int life;
	
	
	public BattleResultView(MainFrame mf ,BattleDTO battle, int result ,int friend) {  
		
		chNum = battle.getcNumber();
		this.mf = mf;
		this.view = this;
//		battle : mExp;, mScore; mName; cNumber
		this.setSize(1200, 800);
		mf.add(this);
		
		Font font1 = new Font("",0,18);
		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/sce/결과.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));
		this.add(label);
		label.setBounds(0, 0, 800, 800);
		
		JButton btn1 = new JButton("확인");
		btn1.setFont(font1);
		btn1.setBounds(1070, 580, 70, 70);
		label.add(btn1);
		
		
		eventController event = new eventController();
		String reward = null;
		int res;
		if(result == 1) {
			/* 캐릭터에 보상 등록 */
			res = event.chreward(battle);
			System.out.println("캐릭터 보상적용 : " + res);
			/* 보상 화면에 출력*/
			JLabel chreward1 = new JLabel("경험치 + "+battle.getmExp());
			JLabel chreward2 = new JLabel("점수 + "+battle.getmScore());
			JLabel chreward3 = new JLabel("돈 + "+battle.getmGold());
			
			chreward1.setBounds(100,110,200,100);
			label.add(chreward1);
			chreward2.setBounds(100,140,200,100);
			label.add(chreward2);
			chreward3.setBounds(100,170,200,100);
			label.add(chreward3);
			chreward1.setFont(font1);
			chreward2.setFont(font1);
			chreward3.setFont(font1);
			/* */
		}
		if(result == 0) {
			/* 목숨 - 1 */
			int hi = event.minusLife(battle);
			System.out.println("목숨잃음 : " +hi);
			JLabel life = new JLabel("목숨을 잃었습니다");
			life.setBounds(100,200,200,100);
			label.add(life);
			
			life.setFont(font1);

		}
		
		            //레벨업 조건
		SceDTO sd = event.levelUp(battle.getcNumber());
		
		JLabel lvup = new JLabel(sd.getLvupname());
		lvup.setFont(font1);
		lvup.setBounds(100,230,500,100);
		label.add(lvup);
		lvup.setFont(font1);
		
		//6레벨 최종보스 해금
		JLabel bossname = new JLabel(sd.getBossname());
		bossname.setFont(font1);
		bossname.setBounds(100,290,500,100);
		label.add(bossname);	
		
		/* 목숨이 0 이면 바로 게임종료실행 */
		life = event.life(battle.getcNumber()); //목숨조회
		/* 업적조건*/
		
		
		
		/* 동료가 1이면 동료를 얻었습니다 화면 출력*/
		if(friend == 1) {
			JLabel friendcheck = new JLabel("동료를 얻었습니다");
			friendcheck.setBounds(100,260,500,100);
			label.add(friendcheck);	
			friendcheck.setFont(font1);
		}
		
		btn1.addMouseListener(new MapActionListener());
		
	}
	private class MapActionListener extends  MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(life > 0) {
				ViewUtil.changePanel(mf, view, new SelectMapView(mf,chNum));
			} else {
				ViewUtil.changePanel(mf, view, new LufiDie(mf,chNum));
			}
	}
	}
}

package com.npng.onepiece.event.views;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.event.controller.EventController;
import com.npng.onepiece.event.model.dto.SceDTO;
import com.npng.onepiece.user.view.MainFrame;

public class EventResultView extends JPanel{
	
	private Image img;
	private Image img2;
	private MainFrame mf;
	private EventResultView view;
	private int chNum;
	private int result;
	
	public EventResultView(MainFrame mf ,int chNum,int map, int num) {
		/*선택번호 , 시나리오번호*/
		String friend = null;
		this.mf = mf;
		this.view = this;
		this.chNum = chNum;
		
		this.setSize(1200, 800);
		mf.add(this);
		
		EventController event = new EventController(); //전투결과호출
		result = event.sceresult(map, num,chNum, view); //승리1 , 패배0
		SceDTO reward = event.reward(result, num);   //보상
		String story = event.story(result, num);   //보상스토리
		int life = event.life(chNum); //목숨조회
		
		
		
		if(result == 3) {
		friend = "동료를 얻었습니다";
		story = "고맙다 덕분에 살았어";
		}
		
		String pointup = null;             //레벨업 조건
		SceDTO sd = event.levelUp(chNum);
		

		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/sce/결과.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));
		
		
		if(sd.getLvupname() == "레벨업" ) {
			JLabel label2 = new JLabel(new ImageIcon());
			this.img2 = new ImageIcon("image/sce/레벨업.PNG").getImage().getScaledInstance(480, 180, 0);
			label2.setIcon(new ImageIcon(img2));
			
			
			label2.setBounds(100, 280, 480, 180);
			label.add(label2);      //레벨업
		}
		  
		Font font1 = new Font("",0,25);
		Font font2 = new Font("",0,25);
		Font font6 = new Font("",0,18);
		
		JButton btn1 = new JButton("확인");
		btn1.setFont(font6);
		btn1.setBounds(1070, 580, 70, 70);
		label.add(btn1);
		
		btn1.addMouseListener(new OneActionListener());
	
		
		JLabel opt_story = new JLabel(""+story);
		JLabel rewardlb1 = new JLabel("경험치 + "+reward.getSceexp());
		JLabel rewardlb2 = new JLabel("점수 + "+reward.getScescore());
		JLabel rewardlb3 = new JLabel("돈+ "+reward.getScemoney());
		JLabel friendstory = new JLabel(friend);
		JLabel lvup = new JLabel(sd.getLvupname());
		JLabel bossname = new JLabel(sd.getBossname());
		/*업적조건 */
		
//		int ach = (3);  //업적 메소드 실행
//		if(ach == 1) {
//			JLabel achv = new JLabel("업적을 획득하였습니다");
//			achv.setFont(font1);
//			achv.setBounds(100,560,1000,100);
//			label.add(achv);  
//			
//		}

		opt_story.setFont(font2);
		rewardlb1.setFont(font1);
		rewardlb2.setFont(font1);
		rewardlb3.setFont(font1);
		friendstory.setFont(font1);
		lvup.setFont(font1);
		bossname.setFont(font1);
		
		opt_story.setBounds(100,110,1000,100);
		label.add(opt_story);                   //스토리
		rewardlb1.setBounds(100,140,200,100);
		label.add(rewardlb1);                   //보상1
		rewardlb2.setBounds(100,170,200,100);
		label.add(rewardlb2);					//보상2
		rewardlb3.setBounds(100,200,200,100);
		label.add(rewardlb3);					//보상3
		friendstory.setBounds(100,500,500,100);
		label.add(friendstory);					//동료획득
		bossname.setBounds(100,530,500,100);
		label.add(bossname);					//보스해금
		
		
		
	
		label.setBounds(0, 0, 800, 800);
		
		System.out.println(chNum);
		this.add(label);
	}

	private class OneActionListener extends  MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
					
			ViewUtil.changePanel(mf, view, new SelectMapView(mf, chNum));
		
			
		}
	}



}

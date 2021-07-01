package com.npng.onepiece.event.views;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.battle.view.main.BattleView;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.event.model.dto.SceDTO;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.MainFrame;

public class SelectMapView extends JPanel{

	private Image img;
	private MainFrame mf;
	private SelectMapView view;
	private SceDTO sce;
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	
	private int num1= 1;
	private int num2= 2;
	private int num3= 3;
	private int num4= 4;
	private int num5= 5;
	private int num6= 6;
	


	public SelectMapView(MainFrame mf) {
		
		this.mf = mf;
		this.view = this;
		this.setSize(1200, 800);
		mf.add(this);
		
		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/sce/지도.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));
		
		
		
		this.add(label);
		
		
		
		btn1 = new JButton(new ImageIcon("image/sce/1번섬.PNG"));
		btn1.setBounds(10, 542, 364, 190);
		label.add(btn1);
		
		btn2 = new JButton(new ImageIcon("image/sce/2번섬.PNG"));
		btn2.setBounds(10, 374, 250, 136);
		label.add(btn2);
		
		btn3 = new JButton(new ImageIcon("image/sce/3번섬.PNG"));
		btn3.setBounds(280, 195, 282, 190);
		label.add(btn3);
		
		btn4 = new JButton(new ImageIcon("image/sce/4번섬.PNG"));
		btn4.setBounds(620, 210, 300, 170);
		label.add(btn4);
		
		btn5 = new JButton(new ImageIcon("image/sce/5번섬.PNG"));
		btn5.setBounds(1002, 200, 131, 164);
		label.add(btn5);
		
		btn6 = new JButton(new ImageIcon("image/sce/6번섬.PNG"));
		btn6.setBounds(840, 487, 350, 263);
		label.add(btn6);
		
		JButton btn7 = new JButton(new ImageIcon("image/sce/7번섬.PNG"));
		btn7.setBounds(504, 418, 180, 164);
		label.add(btn7);
		
		JButton exitbtn = new JButton(new ImageIcon("image/sce/메뉴화면으로.PNG"));
		exitbtn.setBounds(517, 631, 128, 90);
		label.add(exitbtn);
//		btn1.setBorderPainted(false);
//		btn2.setBorderPainted(false);
//		btn3.setBorderPainted(false);
//		btn4.setBorderPainted(false);
//		btn5.setBorderPainted(false);
//		btn6.setBorderPainted(false);
//		btn7.setBorderPainted(false);
//		exitbtn.setBorderPainted(false);
		
		
		
//		btn.addMouseListener(new OneActionListener());
	
		int number = (int) (Math.random()*3)+1;
		 
		  //일반이벤트
	
			if(number == 0) {	
				btn1.addMouseListener(new BattleActionListener());  //전투이벤트
				btn2.addMouseListener(new BattleActionListener());  
				btn3.addMouseListener(new BattleActionListener());  
				btn4.addMouseListener(new BattleActionListener());  
				btn5.addMouseListener(new BattleActionListener());  
				btn6.addMouseListener(new BattleActionListener());  
			} if(number > 0) {

				btn1.addMouseListener(new SceActionListener());  //일반이벤트
				btn2.addMouseListener(new SceActionListener());  
				btn3.addMouseListener(new SceActionListener());  
				btn4.addMouseListener(new SceActionListener());  
				btn5.addMouseListener(new SceActionListener());  
				btn6.addMouseListener(new SceActionListener());  
			}
		
		btn7.addMouseListener(new BossActionListener()); //보스
		exitbtn.addMouseListener(new ExitActionListener()); //메인메뉴로
		
	/* 컨트롤러 호출해서 레벨6 이상일시 입장가능 불가 만들어야됨*/	
	}
	private class BossActionListener extends  MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
		 ViewUtil.changePanel(mf, view, new MapResultView(mf));
	}
		
	}
	private class ExitActionListener extends  MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			ViewUtil.changePanel(mf, view, new MainMenu(mf));
		}
	}
	
	private class SceActionListener extends  MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == btn1) {

				ViewUtil.changePanel(mf, view, new EventSceView(mf,1));}
			if(e.getSource() == btn2) {
				ViewUtil.changePanel(mf, view, new EventSceView(mf,2));}
			if(e.getSource() == btn3) {
				ViewUtil.changePanel(mf, view, new EventSceView(mf,3));}
			if(e.getSource() == btn4) {
				ViewUtil.changePanel(mf, view, new EventSceView(mf,4));}
			if(e.getSource() == btn5) {
				ViewUtil.changePanel(mf, view, new EventSceView(mf,5));}
			if(e.getSource() == btn6) {
				ViewUtil.changePanel(mf, view, new EventSceView(mf,6));}
		}
	}
	private class BattleActionListener extends MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		if(e.getSource() == btn1) {
			ViewUtil.changePanel(mf, view, new BattleView(mf,1));}
		if(e.getSource() == btn2) {
			ViewUtil.changePanel(mf, view, new BattleView(mf,2));}
		if(e.getSource() == btn3) {
			ViewUtil.changePanel(mf, view, new BattleView(mf,3));}
		if(e.getSource() == btn4) {
			ViewUtil.changePanel(mf, view, new BattleView(mf,4));}
		if(e.getSource() == btn5) {
			ViewUtil.changePanel(mf, view, new BattleView(mf,5));}
		if(e.getSource() == btn6) {
			ViewUtil.changePanel(mf, view, new BattleView(mf,6));}
	}
}
	



}



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
import com.npng.onepiece.event.controller.eventController;
import com.npng.onepiece.event.model.dto.SceDTO;
import com.npng.onepiece.user.view.MainFrame;

public class EventSceView extends JPanel{
	
	private Image img;
	private MainFrame mf;
	private EventSceView view;
	private SceDTO sce;
	public int map;
	private int num;
	
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private int chNum;
	public EventSceView(MainFrame mf,int chNum1, int map) {
		
		chNum = chNum1;
		this.mf = mf;
		this.view = this;
		this.setSize(1200, 800);
		mf.add(this);
		
		eventController co = new eventController();
		 num = co.random(map);  /* 시나리오번호*/
		 num = 3;  /* 교체해야됨*/
		
		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/sce/" + num + ".PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));
		
		

		
		this.add(label);
		
		Font font1 = new Font("",0,20);
		

		 btn1 = new JButton(new ImageIcon("image/sce/1번선택.PNG"));
		btn1.setBounds(930, 560, 120, 55);
		label.add(btn1);
		
	    btn2 = new JButton(new ImageIcon("image/sce/2번선택.PNG"));
		btn2.setBounds(930, 650, 120, 55);
		label.add(btn2);
		
		
		btn1.setBorderPainted(false);
		btn2.setBorderPainted(false);
//		btn3.setBorderPainted(false);
		
		
		
		btn1.addMouseListener(new OneActionListener());
	
		btn2.addMouseListener(new OneActionListener());
	
		
		
		
		
	}
	private class OneActionListener extends  MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e ) {
			if(e.getSource() == btn1) {
		 ViewUtil.changePanel(mf, view, new EventResultView(mf ,chNum,1 ,num));}
			if(e.getSource() == btn2) {
		 ViewUtil.changePanel(mf, view, new EventResultView(mf ,chNum,2 ,num));}

			
	}
		
	}


}

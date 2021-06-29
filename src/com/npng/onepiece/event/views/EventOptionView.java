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
import com.npng.onepiece.user.view.MainFrame;

public class EventOptionView extends JPanel{
	
	private Image img;
	private MainFrame mf;
	private EventOptionView view;
	
	public EventOptionView(MainFrame mf) {
		
		this.mf = mf;
		this.view = this;
		
		this.setSize(1200, 800);
		mf.add(this);
		
		Font font6 = new Font("",0,25);
		

		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/sce/결과.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));
		
		Font font1 = new Font("궁서체",0,18);
		
		JButton btn1 = new JButton("확인");
		btn1.setFont(font1);
		btn1.setBounds(1070, 580, 70, 70);
		label.add(btn1);
		
		btn1.addMouseListener(new OneActionListener());
	
		
	
		label.setBounds(0, 0, 800, 800);
		
		
		this.add(label);
	}

	private class OneActionListener extends  MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		 ViewUtil.changePanel(mf, view, new EventOptionView(mf));
	}
	}
	
	


}

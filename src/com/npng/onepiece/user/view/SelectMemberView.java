package com.npng.onepiece.user.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.npng.onepiece.common.ViewUtil;

public class ManagerModeView extends JPanel {
	
	private ManagerModeView managerModeView;
	
	public ManagerModeView(MainFrame mainFrame) {
		
		this.managerModeView = this;
		
		this.setSize(1200, 800);
		
		Image managerMode = new ImageIcon("image/login/managermode.PNG").getImage().getScaledInstance(1200, 800, 0);
		JLabel label = new JLabel(new ImageIcon(managerMode));
		
		Font font1 = new Font("",0,35);
		JButton btn1 = new JButton("회원조회");
		btn1.setLocation(378, 163);
		btn1.setSize(473, 83);
		btn1.setFont(font1);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, managerModeView, new SelectMemberView(mainFrame));
			}
		});

		Font font2 = new Font("",0,35);
		JButton btn2 = new JButton("회원수정");
		btn2.setLocation(378, 279);
		btn2.setSize(473, 83);
		btn2.setFont(font2);
		
		Font font3 = new Font("",0,35);
		JButton btn3 = new JButton("회원삭제");
		btn3.setLocation(378, 395);
		btn3.setSize(473, 83);
		btn3.setFont(font3);
		btn3.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, managerModeView, new DeleteMemberView(mainFrame));
			}
		});
		
		Font font5= new Font("",0,25);
		JButton btn4 = new JButton("뒤로가기");
		btn4.setLocation(500, 600);
		btn4.setSize(200, 100);
		btn4.setFont(font5);
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, managerModeView, new ManagerLoginView(mainFrame));
			}
		});
		
		label.add(btn1);
		label.add(btn2);
		label.add(btn3);
		label.add(btn4);
		this.add(label, BorderLayout.CENTER);
	}

}

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

import com.npng.onepiece.common.ViewUtil;

public class SelectMemberView extends JPanel {
	
	private SelectMemberView selectMemberView;
	
	public SelectMemberView(MainFrame mainFrame) {
		
		this.selectMemberView = this;
		
		this.setSize(1200, 800);
		
		Image selectMember = new ImageIcon("image/login/selectmember.PNG").getImage().getScaledInstance(1200, 800, 0);
		JLabel label = new JLabel(new ImageIcon(selectMember));
		
		Font font5= new Font("",0,25);
		JButton btn1 = new JButton("뒤로가기");
		btn1.setLocation(500, 600);
		btn1.setSize(200, 100);
		btn1.setFont(font5);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, selectMemberView, new ManagerModeView(mainFrame));
			}
		});
		label.add(btn1);
		this.add(label, BorderLayout.CENTER);
	}

}

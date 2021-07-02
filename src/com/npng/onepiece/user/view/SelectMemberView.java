package com.npng.onepiece.user.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.controller.MemberController;
import com.npng.onepiece.user.model.dto.MemberDTO;

public class SelectMemberView extends JPanel {
	
	private SelectMemberView selectMemberView;
	
	public SelectMemberView(MainFrame mainFrame) {
		
		MemberController mc = new MemberController();
		
		this.selectMemberView = this;
		
		this.setSize(1200, 800);
		
		Image selectMember = new ImageIcon("image/login/selectmember.PNG").getImage().getScaledInstance(1200, 800, 0);
		JLabel label = new JLabel(new ImageIcon(selectMember));
		
		Font font1 = new Font("",0,20);
		JTextArea ta1 = new JTextArea();
		ta1.setLocation(130, 190);
		ta1.setSize(943, 253);
		ta1.setFont(font1);
		
		Font font4 = new Font("",0,25);
		JButton btn1 = new JButton("뒤로가기");
		btn1.setLocation(150, 600);
		btn1.setSize(200, 100);
		btn1.setFont(font4);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, selectMemberView, new ManagerModeView(mainFrame));
			}
		});
		
		Font font5= new Font("",0,25);
		JButton btn2 = new JButton("조회");
		btn2.setLocation(850, 600);
		btn2.setSize(200, 100);
		btn2.setFont(font5);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				List<MemberDTO> memberList = mc.selectAllMember();
				for(int i = 0; i < memberList.size(); i++) {
					ta1.append(memberList + "\n");
				}
			}
		});
		
		label.add(ta1);
		label.add(btn1);
		label.add(btn2);
		this.add(label, BorderLayout.CENTER);
	}

}

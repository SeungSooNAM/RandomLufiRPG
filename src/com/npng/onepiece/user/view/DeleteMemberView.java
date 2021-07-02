package com.npng.onepiece.user.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.controller.MemberController;

public class DeleteMemberView extends JPanel {
	
	private DeleteMemberView deleteMember;
	
	public DeleteMemberView(MainFrame mainFrame) {
		
		MemberController mc = new MemberController();
		
		this.deleteMember = this;
		
		this.setSize(1200, 800);
		
		Image delete = new ImageIcon("image/login/deletemember.PNG").getImage().getScaledInstance(1200, 800, 0);
		JLabel label = new JLabel(new ImageIcon(delete));
		
		Font font1 = new Font("",0,35);
		JTextField tf1 = new JTextField();
		tf1.setLocation(405, 295);
		tf1.setSize(404, 83);
		tf1.setFont(font1);
		
		Font font5= new Font("",0,25);
		JButton btn1 = new JButton("뒤로가기");
		btn1.setLocation(500, 600);
		btn1.setSize(200, 100);
		btn1.setFont(font5);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, deleteMember, new ManagerModeView(mainFrame));
			}
		});
		
		Font font2= new Font("",0,25);
		JButton btn2 = new JButton("삭제");
		btn2.setLocation(870, 285);
		btn2.setSize(130, 100);
		btn2.setFont(font2);
		
		JFrame messageFrame = new JFrame();
		messageFrame.setLocation(750, 500);
		messageFrame.setSize(300, 160);
		
		JPanel panel2 = new JPanel();
		panel2.setSize(300,160);
		
		JLabel label2 = new JLabel("삭제 성공");
		label2.setFont(font5);
		
		JButton btn6 = new JButton("확인");
		btn6.setFont(font5);
		
		panel2.add(label2);
		panel2.add(btn6);
		messageFrame.add(panel2);
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String userId = tf1.getText();
				
				int result = mc.deleteMember(userId);
				
				if(result > 0) {
					label2.setText("삭제 성공");
					messageFrame.setVisible(true);					
				} else {
					label2.setText("등록되지 않은 아이디 입니다");
					messageFrame.setVisible(true);
				}
				
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				messageFrame.dispose();
			}
		});
		
		label.add(btn1);
		label.add(btn2);
		label.add(tf1);
		this.add(label, BorderLayout.CENTER);
	}

}

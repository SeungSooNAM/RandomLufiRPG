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
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.controller.MemberController;

public class NewPasswordView extends JPanel {
	
	private NewPasswordView newPasswordView;
	
	public NewPasswordView(MainFrame mainFrame) {
		
		MemberController mc = new MemberController();
		
		this.newPasswordView = this;
		
		this.setSize(1200, 800);
		
		Image newpwd = new ImageIcon("image/login/newpwd.PNG").getImage().getScaledInstance(1200, 800, 0);
		JLabel label = new JLabel(new ImageIcon(newpwd));
		
		Font font1 = new Font("",0,35);
		JPasswordField tf1 = new JPasswordField();
		tf1.setLocation(542, 295);
		tf1.setSize(473, 83);
		tf1.setFont(font1);
		
		Font font2 = new Font("",0,35);
		JPasswordField tf2 = new JPasswordField();
		tf2.setLocation(542, 410);
		tf2.setSize(473, 83);
		tf2.setFont(font2);
		
		Font font4 = new Font("",0,25);
		JButton btn1 = new JButton("뒤로가기");
		btn1.setLocation(150, 600);
		btn1.setSize(200, 100);
		btn1.setFont(font4);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, newPasswordView, new FindPasswordPageView(mainFrame));
			}
		});
		
		Font font5= new Font("",0,25);
		JButton btn2 = new JButton("확인");
		btn2.setLocation(850, 600);
		btn2.setSize(200, 100);
		btn2.setFont(font5);
		
		JFrame messageFrame = new JFrame();
		messageFrame.setLocation(750, 500);
		messageFrame.setSize(320, 150);
		
		JPanel panel2 = new JPanel();
		panel2.setSize(320,150);
		
		JLabel label2 = new JLabel("변경 성공");
		label2.setFont(font5);

		JButton btn6 = new JButton("확인");
		btn6.setFont(font5);
		
		panel2.add(label2);
		panel2.add(btn6);
		messageFrame.add(panel2);
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String newPwd = tf1.getText();
				String newPwd2 = tf2.getText();
				
				if(newPwd.length() >= 5) {
					if(newPwd.equals(newPwd2)) {
						int result = mc.newPassword(newPwd);
						
						if(result > 0) {
							label2.setText("변경 성공");						
							messageFrame.setVisible(true);
						}
					} else {
						label2.setText("잘못 입력 되었습니다");
						messageFrame.setVisible(true);
					}	
				} else {
					label2.setText("비밀번호가 5자 미만입니다");
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
		
		label.add(tf1);
		label.add(tf2);
		label.add(btn1);
		label.add(btn2);
		this.add(label, BorderLayout.CENTER);
	}

}

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

public class LoginPageView extends JPanel {

	private MainFrame loginView;
	private LoginPageView loginPageView;
	
	public LoginPageView(MainFrame loginView) {
		
		this.MainFrame = loginView;
		this.loginPageView = this;
		
		this.setSize(1200, 800);
		
		Image login = new ImageIcon("image/login/login.PNG").getImage().getScaledInstance(1200, 800, 0);
		JLabel label = new JLabel(new ImageIcon(login));
		
		Font font1 = new Font("",0,35);
		JTextField tf1 = new JTextField();
		tf1.setLocation(495, 295);
		tf1.setSize(473, 83);
		tf1.setFont(font1);
		
		Font font3 = new Font("",0,35);
		JTextField tf2 = new JTextField();
		tf2.setLocation(495, 410);
		tf2.setSize(473, 83);
		tf2.setFont(font3);
		
		Font font4 = new Font("",0,25);
		JButton btn1 = new JButton("로그인");
		btn1.setLocation(150, 600);
		btn1.setSize(200, 100);
		btn1.setFont(font4);
		Font font5= new Font("",0,25);
		JButton btn2 = new JButton("회원가입");
		btn2.setLocation(500, 600);
		btn2.setSize(200, 100);
		btn2.setFont(font5);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(loginView, loginPageView, new JoinPageView(loginView));
			}
		});
		
		Font font6 = new Font("",0,25);
		JButton btn3 = new JButton("비밀번호 찾기");
		btn3.setLocation(850, 600);
		btn3.setSize(200, 100);
		btn3.setFont(font6);
		
		JButton btn4 = new JButton(new ImageIcon("image/login/setting.PNG"));
		btn4.setLocation(1145, 0);
		btn4.setSize(50, 50);
		
		label.add(tf1);
		label.add(tf2);
		label.add(btn1);
		label.add(btn2);
		label.add(btn3);
		label.add(btn4);
		this.add(label, BorderLayout.CENTER);
		loginView.add(this);
	}
}

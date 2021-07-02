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
import com.npng.onepiece.gameready.view.CharacterTutorial;
import com.npng.onepiece.user.controller.MemberController;

public class LoginPageView extends JPanel {

	private MainFrame mainFrame;
	private LoginPageView loginPageView;
	
	public LoginPageView(MainFrame mainFrame) {
		
		MemberController mc = new MemberController();
		
		this.mainFrame = mainFrame;
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
		JPasswordField tf2 = new JPasswordField();
		tf2.setLocation(495, 410);
		tf2.setSize(473, 83);
		tf2.setFont(font3);
		
		Font font4 = new Font("",0,25);
		JButton btn1 = new JButton("로그인");
		btn1.setLocation(150, 600);
		btn1.setSize(200, 100);
		btn1.setFont(font4);
		
		JFrame loginMessageFrame = new JFrame();
		loginMessageFrame.setLocation(750, 500);
		loginMessageFrame.setSize(300, 170);
		
		JPanel panel2 = new JPanel();
		panel2.setSize(300,200);
		
		JLabel label2 = new JLabel("로그인 실패");
		label2.setFont(font1);
		
		JButton btn6 = new JButton("확인");
		btn6.setFont(font1);
		
		panel2.add(label2);
		panel2.add(btn6);
		loginMessageFrame.add(panel2);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String loginId = tf1.getText();
				String loginPwd = tf2.getText();
				
				int result = mc.login(loginId,loginPwd);
				
				if(result > 0) {
					int uNum = mc.userNum(loginId);
					System.out.println("uNum : " + uNum);
					ViewUtil.changePanel(mainFrame, loginPageView, new CharacterTutorial(mainFrame,uNum));					
				} else {
					loginMessageFrame.setVisible(true);
				}
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginMessageFrame.dispose();
			}
		});

		Font font5= new Font("",0,25);
		JButton btn2 = new JButton("회원가입");
		btn2.setLocation(500, 600);
		btn2.setSize(200, 100);
		btn2.setFont(font5);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, loginPageView, new JoinPageView(mainFrame));
			}
		});
		
		Font font6 = new Font("",0,25);
		JButton btn3 = new JButton("비밀번호 찾기");
		btn3.setLocation(850, 600);
		btn3.setSize(200, 100);
		btn3.setFont(font6);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, loginPageView, new FindPasswordPageView(mainFrame));
			}
		});
		
		JButton btn4 = new JButton(new ImageIcon("image/login/setting.PNG"));
		btn4.setLocation(1145, 0);
		btn4.setSize(50, 50);
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, loginPageView, new ManagerLoginView(mainFrame));
			}
		});
		
		label.add(tf1);
		label.add(tf2);
		label.add(btn1);
		label.add(btn2);
		label.add(btn3);
		label.add(btn4);
		this.add(label, BorderLayout.CENTER);
		mainFrame.add(this);
	}
}

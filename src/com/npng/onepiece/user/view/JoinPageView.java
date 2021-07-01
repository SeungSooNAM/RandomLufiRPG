package com.npng.onepiece.user.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.controller.MemberController;

public class JoinPageView extends JPanel {
	
	private JoinPageView joinPageView;

	public JoinPageView(MainFrame mainFrame) {
		
		MemberController mc = new MemberController();
		
		this.joinPageView = this;

		this.setSize(1200, 800);
		
		
		Image join = new ImageIcon("image/login/join.PNG").getImage().getScaledInstance(1200, 800, 0);
		JLabel label = new JLabel(new ImageIcon(join));
		
		Font font1 = new Font("",0,35);
		JTextField tf1 = new JTextField();
		tf1.setLocation(596, 161);
		tf1.setSize(473, 83);
		tf1.setFont(font1);
		
		Font font2 = new Font("",0,35);
		JTextField tf2 = new JTextField();
		tf2.setLocation(596, 276);
		tf2.setSize(473, 83);
		tf2.setFont(font2);
		
		Font font3 = new Font("",0,35);
		JTextField tf3 = new JTextField();
		tf3.setLocation(596, 391);
		tf3.setSize(473, 83);
		tf3.setFont(font3);
		
		Font font4 = new Font("",0,25);
		JButton btn1 = new JButton("뒤로가기");
		btn1.setLocation(150, 600);
		btn1.setSize(200, 100);
		btn1.setFont(font4);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, joinPageView, new LoginPageView(mainFrame));
			}
		});
		
		Font font5= new Font("",0,25);
		JButton btn2 = new JButton("가입하기");
		btn2.setLocation(850, 600);
		btn2.setSize(200, 100);
		btn2.setFont(font5);
		
		JFrame joinMessageFrame = new JFrame();
		joinMessageFrame.setLocation(750, 500);
		joinMessageFrame.setSize(300, 100);
		
		JPanel panel2 = new JPanel();
		panel2.setSize(300,150);
		
		JLabel label2 = new JLabel("회원가입 성공");
		label2.setFont(font5);
		
		JButton btn6 = new JButton("확인");
		btn6.setFont(font5);
		
		panel2.add(label2);
		panel2.add(btn6);
		joinMessageFrame.add(panel2);
		
		JFrame joinMessageFrame2 = new JFrame();
		joinMessageFrame2.setLocation(750, 500);
		joinMessageFrame2.setSize(300, 100);
		
		JPanel panel3 = new JPanel();
		panel3.setSize(300,150);
		
		JLabel label3 = new JLabel("회원가입 실패");
		label3.setFont(font5);
		
		JButton btn7 = new JButton("확인");
		btn7.setFont(font5);
		
		panel3.add(label3);
		panel3.add(btn7);
		joinMessageFrame2.add(panel3);
		
		Map<String, String> map = new HashMap<>();
		
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tf1.getText().length() >= 5 && tf2.getText().length() >= 5 && tf3.getText().length() >= 2) {					
					
					String userId = tf1.getText();
					String userPwd = tf2.getText();
					String userName = tf3.getText();
					
					map.put("userId", userId);
					map.put("userPwd", userPwd);
					map.put("userName", userName);
					
					mc.joinNewMember(map);
					
					joinMessageFrame.setVisible(true);
					
				} else {
					
					joinMessageFrame2.setVisible(true);
				}
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				joinMessageFrame.dispose();
			}
		});
		
		btn7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				joinMessageFrame2.dispose();
			}
		});

		label.add(tf1);
		label.add(tf2);
		label.add(tf3);
		label.add(btn1);
		label.add(btn2);
		this.add(label, BorderLayout.CENTER);
		
	}
}

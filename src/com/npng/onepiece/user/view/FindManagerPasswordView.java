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

public class FindManagerPasswordView extends JPanel {
	
	private FindManagerPasswordView findManagerPasswordView;

	public FindManagerPasswordView(MainFrame mainFrame) {
		
		MemberController mc = new MemberController();
		
		this.findManagerPasswordView = this;

		this.setSize(1200, 800);
		
		Image managerPwd = new ImageIcon("image/login/findmanagerpwd.PNG").getImage().getScaledInstance(1200, 800, 0);
		JLabel label = new JLabel(new ImageIcon(managerPwd));
		
		Font font1 = new Font("",0,35);
		
		JTextField tf1 = new JTextField();
		tf1.setLocation(596, 164);
		tf1.setSize(473, 83);
		tf1.setFont(font1);
		
		JTextField tf2 = new JTextField();
		tf2.setLocation(596, 279);
		tf2.setSize(473, 83);
		tf2.setFont(font1);
		
		JPasswordField tf3 = new JPasswordField();
		tf3.setLocation(596, 394);
		tf3.setSize(473, 83);
		tf3.setFont(font1);
		
		Font font2 = new Font("",0,25);
		
		JFrame MessageFrame = new JFrame();
		MessageFrame.setLocation(750, 500);

		MessageFrame.setSize(330, 150);
		
		JPanel panel2 = new JPanel();
		panel2.setSize(330,150);

		MessageFrame.setSize(320, 150);
		
		JPanel panel2 = new JPanel();
		panel2.setSize(320,150);

		
		JLabel label2 = new JLabel("변경 성공");
		label2.setFont(font2);
		
		JButton btn6 = new JButton("확인");
		btn6.setFont(font2);
		
		JButton btn1 = new JButton("뒤로가기");
		btn1.setLocation(150, 600);
		btn1.setSize(200, 100);
		btn1.setFont(font2);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ViewUtil.changePanel(mainFrame, findManagerPasswordView, new ManagerLoginView(mainFrame));
			}
		});
		
		JButton btn2 = new JButton("비밀번호 변경");
		btn2.setLocation(850, 600);
		btn2.setSize(200, 100);
		btn2.setFont(font2);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String userId = tf1.getText();
				String userName = tf2.getText();
				String newPwd = tf3.getText();
				

				if(newPwd.length() >= 5) {
					int result = mc.newManagerPwd(userId,userName,newPwd);
					if(result > 0) {
						label2.setText("변경 성공");
						MessageFrame.setVisible(true);						

					} else {
						label2.setText("정보를 잘못 입력하였습니다.");
						MessageFrame.setVisible(true);

					}
				} else {
					label2.setText("비밀번호가 5자 미만입니다.");
					MessageFrame.setVisible(true);
				}
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				MessageFrame.dispose();
			}
		});
		panel2.add(label2);
		panel2.add(btn6);
		MessageFrame.add(panel2);
		

		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				MessageFrame.setVisible(true);
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

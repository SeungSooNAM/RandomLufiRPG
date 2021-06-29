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

public class FindPasswordPageView extends JPanel {

	private FindPasswordPageView findPasswordPageView;
	
	public FindPasswordPageView(MainFrame mainFrame) {
		
		this.findPasswordPageView = this;
		
		this.setSize(1200, 800);
		
		Image FindPwd = new ImageIcon("image/login/findpwd.PNG").getImage().getScaledInstance(1200, 800, 0);
		JLabel label = new JLabel(new ImageIcon(FindPwd));
		
		Font font1 = new Font("",0,35);
		JTextField tf1 = new JTextField();
		tf1.setLocation(495, 295);
		tf1.setSize(473, 83);
		tf1.setFont(font1);
		
		Font font2 = new Font("",0,35);
		JTextField tf2 = new JTextField();
		tf2.setLocation(495, 410);
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
				ViewUtil.changePanel(mainFrame, findPasswordPageView, new LoginPageView(mainFrame));
			}
		});
		
		Font font5= new Font("",0,25);
		JButton btn2 = new JButton("확인");
		btn2.setLocation(850, 600);
		btn2.setSize(200, 100);
		btn2.setFont(font5);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, findPasswordPageView, new NewPasswordView(mainFrame));
			}
		});
		
		
		label.add(tf1);
		label.add(tf2);
		label.add(btn1);
		label.add(btn2);
		this.add(label, BorderLayout.CENTER);
	}
}

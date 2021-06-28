package com.npng.onepiece.user.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	public LoginView() {
		super("Random Lupi RPG");
		this.setBounds(300, 150, 1200, 800);
		
		JPanel panel = new JPanel();
		panel.setSize(1200, 800);
//		panel.setLayout(null);
		
		Image login = new ImageIcon("image/login.PNG").getImage().getScaledInstance(1200, 800, 0);
		JLabel label = new JLabel(new ImageIcon(login));
		
		JLabel lb = new JLabel("아이디 : ");
		lb.setLocation(360, 285);
		lb.setSize(250, 100);
		Font font = new Font("아이디 : ", Font.PLAIN, 25);
		lb.setFont(font);
		
		JTextField tf = new JTextField();
		tf.setLocation(495, 295);
		tf.setSize(473, 80);
		
		label.add(lb);
		label.add(tf);
		panel.add(label, BorderLayout.CENTER);
		this.add(panel);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

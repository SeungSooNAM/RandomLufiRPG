package com.npng.onepiece.ending.view;

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

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.ending.controller.EndingController;
import com.npng.onepiece.user.view.LoginPageView;
import com.npng.onepiece.user.view.MainFrame;

public class LufiDie extends JPanel{

	private MainFrame mf;  
	private Image icon;
	private LufiDie ld;
	
	public LufiDie(MainFrame mainFrame,  int chNum) {
		
		EndingController ec = new EndingController();
		this.ld = this;
		this.mf = mainFrame;
		this.setSize(1200,800);

	    
	    Image login = new ImageIcon("image/mainMenu/Lufiretire.PNG").getImage().getScaledInstance(1200, 800, 0);
		JLabel label = new JLabel(new ImageIcon(login));
	    
		
		
		Font font1 = new Font("",0,25);
		JFrame MessageFrame = new JFrame();
		MessageFrame.setLocation(750, 500);
		MessageFrame.setSize(300, 170);
		
		JPanel panel2 = new JPanel();
		panel2.setSize(300,200);
		
		JLabel label2 = new JLabel("랭킹 등록");
		label2.setFont(font1);
		
		JButton btn6 = new JButton("확인");
		btn6.setFont(font1);
		btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MessageFrame.dispose();
				ViewUtil.changePanel(mainFrame, ld, new RankingUpdateView(mainFrame));
				
			}
		});
		panel2.add(label2);
		panel2.add(btn6);
		MessageFrame.add(panel2);
		
		
		
		


	    this.add(label, BorderLayout.CENTER);
	    mainFrame.add(this);
	}
	
}

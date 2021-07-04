package com.npng.onepiece.ending.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.ending.controller.EndingController;
import com.npng.onepiece.ending.model.dto.EndingDTO;
import com.npng.onepiece.user.view.LoginPageView;
import com.npng.onepiece.user.view.MainFrame;

public class BadEnding02 extends JPanel {

	private BadEnding02 be2;
	private MainFrame mainFrame;
	private Image icon;
	private EndingController endingController;
	private int score;
	private int chNum;
	private String chName;
	private EndingDTO endingDTO;
	
	public BadEnding02(MainFrame mainFrame) {
		
		 this.mainFrame = mainFrame;
		 this.be2 = this;
		 this.setSize(1200,800);
		
		 JLabel  imgLabel = new JLabel(new ImageIcon());
	     this.icon = new ImageIcon("image/mainMenu/badending2.PNG").getImage().getScaledInstance(1200, 800, 0);
	     imgLabel.setSize(1200,800);
	     imgLabel.setIcon(new ImageIcon(icon));
	     
	     
	     this.setSize(1200, 800);
		 this.setLayout(null);
		 
	     JButton btnRankingSave = new JButton("랭킹 저장");
	     btnRankingSave.setBounds(650,700, 100, 80);
	     btnRankingSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				endingController.saveScore(endingDTO);
				
				ViewUtil.changePanel(mainFrame, be2, new LoginPageView(mainFrame));
			}
		});
	  
		
		
		

		
	}
	
	
	
}

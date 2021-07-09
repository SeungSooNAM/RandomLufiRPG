package com.npng.onepiece.ending.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.ending.model.dto.EndingDTO;
import com.npng.onepiece.user.view.LoginPageView;
import com.npng.onepiece.user.view.MainFrame;
import com.npng.onepiece.ending.controller.EndingController;

public class HappyEnding2 extends JPanel {

	private HappyEnding2 he2;
	private MainFrame mf; 
	private Image icon;
	
	public HappyEnding2(MainFrame mainFrame, int chNum) {
		
		EndingController ec = new EndingController();
		this.he2 = this;
		this.mf = mainFrame;
		this.setSize(1200,800);
		
		
		Image background = new ImageIcon("image/mainMenu/happyending2.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label1 = new JLabel(new ImageIcon(background));
		label1.setSize(1200, 800);

		JButton btnRankingSave = new JButton("랭킹 저장");
	     btnRankingSave.setBounds(650,700, 100, 80);
		
		this.setSize(1200, 800);
		this.setLayout(null);
		this.add(label1);
		
		 Image login = new ImageIcon("image/mainMenu/Lufiretire.PNG").getImage().getScaledInstance(1200, 800, 0);
	     JLabel label = new JLabel(new ImageIcon(login));
		    
		 int result = ec.updateRanking(chNum);
			
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
					ViewUtil.changePanel(mainFrame, he2, new RankingUpdateView(mainFrame));
					
				}
			});
			panel2.add(label2);
			panel2.add(btn6);
			MessageFrame.add(panel2);
			
			if(result > 0) {
				MessageFrame.setVisible(true);			
			}
			
			


		    this.add(label, BorderLayout.CENTER);
		    mainFrame.add(this);
		}
	
	
}

package com.npng.onepiece.ending.view;

import java.awt.Button;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.ending.model.dto.EndingDTO;
import com.npng.onepiece.user.view.LoginPageView;
import com.npng.onepiece.user.view.MainFrame;
import com.npng.onepiece.ending.controller.EndingController;

public class HappyEnding2 extends JPanel {

	private HappyEnding2 he2;
	private MainFrame mainFrame;
	private EndingDTO endingDTO;
	private EndingController endingController;
	public HappyEnding2(MainFrame mainFrame) {
		
		this.he2 = this;
		this.mainFrame = mainFrame;
		
		Image background = new ImageIcon("image/mainMenu/happyending1").getImage().getScaledInstance(1200, 800, 0);

		JLabel label1 = new JLabel(new ImageIcon(background));
		label1.setSize(1200, 800);

		JButton btnRankingSave = new JButton("랭킹 저장");
	     btnRankingSave.setBounds(650,700, 100, 80);
		
		this.setSize(1200, 800);
		this.setLayout(null);
		this.add(label1);
		
		 JButton btnRankingSave1 = new JButton("랭킹 저장");
	     btnRankingSave1.setBounds(650,700, 100, 80);
	     btnRankingSave1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				endingController.saveScore(endingDTO);
				
				ViewUtil.changePanel(mainFrame, he2, new LoginPageView(mainFrame));
			}
		});
		
			
	
	
	
	}
}

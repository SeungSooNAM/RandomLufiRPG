package com.npng.onepiece.ending.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.ending.controller.EndingController;
import com.npng.onepiece.gameready.view.Openning2;
import com.npng.onepiece.user.view.MainFrame;

public class HappyEnding extends JPanel{

	private HappyEnding he1;
	private MainFrame mainFrame;
	private EndingController ec = new EndingController();
	
	
	public HappyEnding(MainFrame mainframe, int chNum) {
		
		this.he1 = this;
		this.mainFrame = mainframe;
		
		Image background = new ImageIcon("image/mainMenu/happyending1.png").getImage().getScaledInstance(1200, 800, 0);
		JLabel label1 = new JLabel(new ImageIcon(background));
		label1.setSize(1200, 800);
		
		this.setSize(1200, 800);
		this.setLayout(null);
		this.add(label1);
		
		JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
		nextBtn.setBounds(940, 600, 130, 50);
		
		label1.add(nextBtn);	
		mainFrame.add(this);
		this.add(label1);
		
		
	
		nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ViewUtil.changePanel(mainFrame, he1, new RankingUpdateView(mainFrame));				
			}
		});
		
	}
}

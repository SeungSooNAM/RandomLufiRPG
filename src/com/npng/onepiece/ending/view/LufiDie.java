package com.npng.onepiece.ending.view;

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
import com.npng.onepiece.ending.controller.EndingController;
import com.npng.onepiece.ending.model.dto.EndingDTO;
import com.npng.onepiece.user.view.LoginPageView;
import com.npng.onepiece.user.view.MainFrame;

public class LufiDie extends JPanel{

	private MainFrame mainFrame;  
	private Image icon;
	private EndingDTO endingDTO;
	private EndingController endingController;  
	private LufiDie ld;
	
	public LufiDie(MainFrame mainFrame, int chNum) {
		
		this.mainFrame = mainFrame;
		this.setSize(1200,800);
		this.setLayout(null);
		
		JLabel  imgLabel = new JLabel(new ImageIcon());
	    this.icon = new ImageIcon("image/mainMenu/Lufiretire.PNG").getImage().getScaledInstance(1200, 800, 0);
	    imgLabel.setSize(1200,800);
	    imgLabel.setIcon(new ImageIcon(icon));
	    
	    JButton btnRankingSave1 = new JButton("랭킹 저장");
	     btnRankingSave1.setBounds(650,700, 100, 80);
	     
	     
	     
	     btnRankingSave1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				endingController.saveScore(endingDTO);
				
				ViewUtil.changePanel(mainFrame,ld, new LoginPageView(mainFrame));
			}
		});
		
	
	}
}

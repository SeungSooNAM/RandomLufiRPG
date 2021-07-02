package com.npng.onepiece.gameready.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.MainFrame;

public class TutorialMenu extends JPanel {

	private TutorialMenu tm;
	private MainFrame mainFrame;
	private int chNum;
	public TutorialMenu(MainFrame mainFrame ,int chNum) {
		this.chNum = chNum;
		this.tm = this;
		this.mainFrame = mainFrame;
		Image background = new ImageIcon("image/tutorial/tutoMenu.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label1 = new JLabel(new ImageIcon(background));
		label1.setSize(1200, 800);

		this.setSize(1200, 800);
		this.setLayout(null);
		this.add(label1);
		
		JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
		skipBtn.setBounds(940, 600, 150, 100);
		skipBtn.setOpaque(false);
		label1.add(skipBtn);

		JButton battleBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
		battleBtn.setBounds(190, 370, 140, 65);
		battleBtn.setOpaque(false);
		label1.add(battleBtn);
	
		JButton eventBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
		eventBtn.setBounds(190, 230, 140, 65);
		eventBtn.setOpaque(false);
		label1.add(eventBtn);
		
		eventBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, tm, new EventTutorial(mainFrame));				
			}
		});
		
		
		


		skipBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, tm, new MainMenu(mainFrame,chNum));				
			}
		});		
			
		battleBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, tm, new BattleTutorial(mainFrame));					
			}
		});
		
		
		
		
	}
}

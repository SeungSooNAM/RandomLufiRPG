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
		skipBtn.setBounds(980, 670, 150, 100);
		skipBtn.setOpaque(false);
		label1.add(skipBtn);
		skipBtn.setContentAreaFilled(false);
		skipBtn.setFocusPainted(false);

		//		JButton eventBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
		JButton eventBtn = new JButton();
		eventBtn.setBounds(365, 225, 500, 70);
		eventBtn.setOpaque(false);
		label1.add(eventBtn);
		eventBtn.setContentAreaFilled(false);
		eventBtn.setFocusPainted(false);

		//		JButton battleBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
		JButton battleBtn = new JButton();
		battleBtn.setBounds(365, 355, 500, 70);
		battleBtn.setOpaque(false);
		label1.add(battleBtn);
		battleBtn.setContentAreaFilled(false);
		battleBtn.setFocusPainted(false);

		JButton equipBtn = new JButton();
		equipBtn.setBounds(365, 480, 500, 70);
		equipBtn.setOpaque(false);
		label1.add(equipBtn);
		equipBtn.setContentAreaFilled(false);
		equipBtn.setFocusPainted(false);

		equipBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, tm, new EquipTutorial(mainFrame, chNum));						
			}
		});

		JButton shopBtn = new JButton();
		shopBtn.setBounds(365, 605, 500, 70);
		shopBtn.setOpaque(false);
		label1.add(shopBtn);
		shopBtn.setContentAreaFilled(false);
		shopBtn.setFocusPainted(false);


		eventBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, tm, new EventTutorial(mainFrame, chNum));				
			}
		});





		skipBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, tm, new MainMenu(mainFrame, chNum));				
			}
		});		

		battleBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, tm, new BattleTutorial(mainFrame, chNum));					
			}
		});

		shopBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, tm, new ShopTutorial(mainFrame, chNum));					
			}
		});


	}
}

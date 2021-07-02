package com.npng.onepiece.gameready.view;

import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.gameready.view.BattleTutorial.BattleTutorial1;
import com.npng.onepiece.gameready.view.BattleTutorial.BattleTutorial1.BattleTutorial2;
import com.npng.onepiece.user.view.MainFrame;


// 캐릭터 생성 듀토리얼 캐릭터닉네임 먼저하세요
public class CharacterTutorial extends JPanel {

	private CharacterTutorial ct;
	private MainFrame mf;
	
	public CharacterTutorial(MainFrame mf) {

	this.ct = this;
	this.mf = mf;
	
	Image background = new ImageIcon("image/tutorial/cc1.png").getImage().getScaledInstance(1200, 800, 0);
	
	JLabel label = new JLabel(new ImageIcon(background));
	label.setSize(1200, 800);
	
	this.setSize(1200, 800);
	this.setLayout(null);
	this.add(label);
	
	JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
	skipBtn.setBounds(940, 630, 150, 60);

	JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
	nextBtn.setBounds(440, 300, 120, 45);
	label.add(nextBtn);

	label.add(skipBtn);
	
	
	

	skipBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ViewUtil.changePanel(mf, ct, new CreateCharacterView(mf));
		}
	});

	nextBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ViewUtil.changePanel(mf, ct, new CharacterTutorial1(mf));
		}
	});	
	
	}		
	
	// 원하는 스탯이 나올때까지 스탯분배버튼 눌러주세요
	public class CharacterTutorial1 extends JPanel {		
		private CharacterTutorial1 bt;
		private MainFrame mainFrame;

		public CharacterTutorial1(MainFrame mainFrame) {

			this.bt = this;
			this.mainFrame = mainFrame;
			Image background = new ImageIcon("image/tutorial/cc2.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label1 = new JLabel(new ImageIcon(background));
			label1.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label1);
			JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
			skipBtn.setBounds(940, 650, 130, 50);

			label1.add(skipBtn);
			JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
			nextBtn.setBounds(430, 400, 120, 45);

			label1.add(nextBtn);

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, bt, new CreateCharacterView(mf));
				}
			});
			
			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, bt, new CharacterTutorial2(mf));
				}
			});
		}
	}
	
	public class CharacterTutorial2 extends JPanel {		
		private CharacterTutorial2 bt;
		private MainFrame mainFrame;

		public CharacterTutorial2(MainFrame mainFrame) {

			this.bt = this;
			this.mainFrame = mainFrame;
			Image background = new ImageIcon("image/tutorial/cc3.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label1 = new JLabel(new ImageIcon(background));
			label1.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label1);
			JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
			skipBtn.setBounds(940, 650, 130, 50);

			label1.add(skipBtn);
			JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
			nextBtn.setBounds(520, 280, 140, 65);

			label1.add(nextBtn);

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, bt, new CreateCharacterView(mf));
				}
			});
			
			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, bt, new CreateCharacterView(mf));
				}
			});
		}
}
	}

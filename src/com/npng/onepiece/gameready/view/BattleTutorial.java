package com.npng.onepiece.gameready.view;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.gameready.view.Tutorial.battleTutorial1;
import com.npng.onepiece.gameready.view.Tutorial.battleTutorial1.battleTutorial2;
import com.npng.onepiece.gameready.view.Tutorial.battleTutorial1.battleTutorial2.battleTutorial3;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.MainFrame;

public class BattleTutorial extends JPanel{

	private MainFrame mf;
	private BattleTutorial bt;
	
	public BattleTutorial(MainFrame mf) {
	this.bt = this;
	this.mf = mf;	
	Image background = new ImageIcon("image/tutorial/bt0.png").getImage().getScaledInstance(1200, 800, 0);

	JLabel label1 = new JLabel(new ImageIcon(background));
	label1.setSize(1200, 800);

	this.setSize(1200, 800);
	this.setLayout(null);
	this.add(label1);

	JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
	skipBtn.setBounds(940, 630, 150, 60);

	JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
	nextBtn.setBounds(470, 550, 140, 65);
	label1.add(nextBtn);

	label1.add(skipBtn);
	

	skipBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ViewUtil.changePanel(mf, bt, new MainMenu(mf));
		}
	});

	nextBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ViewUtil.changePanel(mf, bt, new BattleTutorial1(mf));
		}
	});

}
	
	public class BattleTutorial1 extends JPanel {
		private BattleTutorial1 bt;
		private MainFrame mainFrame;

		public BattleTutorial1(MainFrame mainFrame) {

			this.bt = this;
			this.mainFrame = mainFrame;
			Image background = new ImageIcon("image/tutorial/bt1.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label1 = new JLabel(new ImageIcon(background));
			label1.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label1);
			JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
			skipBtn.setBounds(940, 650, 130, 50);

			label1.add(skipBtn);
			JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
			nextBtn.setBounds(470, 550, 140, 65);

			label1.add(nextBtn);

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, bt, new BattleTutorial2(mf));
				}
			});
		}

		public class BattleTutorial2 extends JPanel {
			private BattleTutorial2 bt;
			private MainFrame mf;

			public BattleTutorial2(MainFrame mf) {

				this.bt = this;
				this.mf = mf;
				Image background = new ImageIcon("image/tutorial/bt2.png").getImage().getScaledInstance(1200, 800, 0);

				JLabel label1 = new JLabel(new ImageIcon(background));
				label1.setSize(1200, 800);

				this.setSize(1200, 800);
				this.setLayout(null);
				this.add(label1);
				JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
				skipBtn.setBounds(940, 650, 130, 50);

				label1.add(skipBtn);
				JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
				nextBtn.setBounds(470, 550, 140, 65);

				label1.add(nextBtn);

				skipBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ViewUtil.changePanel(mf, bt, new BattleTutorial3(mf));
					}
				});

			}

			public class BattleTutorial3 extends JPanel {
				private BattleTutorial3 bt;
				private MainFrame mf;

				public BattleTutorial3(MainFrame mf) {

					this.bt = this;
					this.mf = mf;
					Image background = new ImageIcon("image/tutorial/bt3.png").getImage().getScaledInstance(1200, 800,
							0);

					JLabel label1 = new JLabel(new ImageIcon(background));
					label1.setSize(1200, 800);

					this.setSize(1200, 800);
					this.setLayout(null);
					this.add(label1);
					JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
					skipBtn.setBounds(940, 650, 130, 50);

					label1.add(skipBtn);
					JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
					nextBtn.setBounds(470, 550, 140, 65);

					label1.add(nextBtn);

					skipBtn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							ViewUtil.changePanel(mf, bt, new BattleTutorial3(mf));
						}
					});

				}

			}
		}
	}
	
}
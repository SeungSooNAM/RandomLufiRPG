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

public class Tutorial extends JPanel {

	private MainFrame mf;
	private Tutorial tutorial;

	public Tutorial(MainFrame mainFrame) {
		this.mf = mainFrame;
		this.tutorial = this;
		Image background = new ImageIcon("image/tutorial/tutoMenu.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label1 = new JLabel(new ImageIcon(background));
		label1.setSize(1200, 800);

		this.setSize(1200, 800);
		this.setLayout(null);
		this.add(label1);

		JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
		skipBtn.setBounds(940, 600, 150, 100);

		JButton btBtn = new JButton("전투듀토리얼");
		btBtn.setBounds(200, 200, 100, 100);

		label1.add(skipBtn);
		label1.add(btBtn);

		skipBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, tutorial, new MainMenu(mainFrame));
			}
		});

		btBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, tutorial, new battleTutorial1(mainFrame));
			}
		});

	}

	public class battleTutorial1 extends JPanel {
		private battleTutorial1 bt;
		private MainFrame mainFrame;

		public battleTutorial1(MainFrame mainFrame) {

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
			nextBtn.setBounds(1000, 200, 130, 50);

			label1.add(nextBtn);

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mainFrame, bt, new MainMenu(mainFrame));
				}
			});
		}

		public class battleTutorial2 extends JPanel {
			private battleTutorial2 bt;
			private MainFrame mainFrame;

			public battleTutorial2(MainFrame mainFrame) {

				this.bt = this;
				this.mainFrame = mainFrame;
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
				nextBtn.setBounds(1000, 200, 130, 50);

				label1.add(nextBtn);

				skipBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ViewUtil.changePanel(mainFrame, bt, new MainMenu(mainFrame));
					}
				});

			}

			public class battleTutorial3 extends JPanel {
				private battleTutorial3 bt;
				private MainFrame mainFrame;

				public battleTutorial3(MainFrame mainFrame) {

					this.bt = this;
					this.mainFrame = mainFrame;
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
					nextBtn.setBounds(1000, 200, 130, 50);

					label1.add(nextBtn);

					skipBtn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							ViewUtil.changePanel(mainFrame, bt, new MainMenu(mainFrame));
						}
					});

				}

			}
		}
	}
	
	
}

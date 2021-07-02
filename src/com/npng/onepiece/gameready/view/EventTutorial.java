package com.npng.onepiece.gameready.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.view.MainFrame;

public class EventTutorial extends JPanel {

	private MainFrame mf;
	private EventTutorial et;

	public EventTutorial(MainFrame mf) {
		this.et = this;
		this.mf = mf;

		Image background = new ImageIcon("image/tutorial/ev1.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label = new JLabel(new ImageIcon(background));
		label.setSize(1200, 800);

		this.setSize(1200, 800);
		this.setLayout(null);
		this.add(label);

		// 중간아래 next버튼
		JButton nextBtn = new JButton(new ImageIcon("image/tutorial/next123.png"));

		nextBtn.setBounds(730, 657, 125, 40);
		label.add(nextBtn);
		nextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mf, et, new EventTutorial1(mf));
			}
		});

		// =====================================================================

		// 우측상단 스킵버튼 =========================================================
		JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
		skipBtn.setBounds(999, 30, 130, 50);
		label.add(skipBtn);

		skipBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mf, et, new TutorialMenu(mf));
			}
		});
	}

	//왼쪽아래 맵선택 듀토리얼 화면
	public class EventTutorial1 extends JPanel {
		private MainFrame mf;
		private EventTutorial1 et;

		public EventTutorial1(MainFrame mf) {
			this.et = this;
			this.mf = mf;

			Image background = new ImageIcon("image/tutorial/ev2.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label = new JLabel(new ImageIcon(background));
			label.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label);

			// 좌측하단 나미선택 버튼 ============================================================
			JButton nextBtn = new JButton(new ImageIcon("image/tutorial/yellow.png"));

			nextBtn.setBounds(128, 610, 55, 41);
			label.add(nextBtn);
			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new EventTutorial2(mf));
				}
			});

			// =====================================================================

			// 우측상단 스킵버튼 =========================================================
			JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
			skipBtn.setBounds(999, 30, 130, 50);
			label.add(skipBtn);

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new TutorialMenu(mf));
				}
			});
		}

		
		//스테이지 진행방법 1
		public class EventTutorial2 extends JPanel {
			private MainFrame mf;
			private EventTutorial2 et;

			public EventTutorial2(MainFrame mf) {
				this.et = this;
				this.mf = mf;

				Image background = new ImageIcon("image/tutorial/ev3.png").getImage().getScaledInstance(1200, 800, 0);

				JLabel label = new JLabel(new ImageIcon(background));
				label.setSize(1200, 800);

				this.setSize(1200, 800);
				this.setLayout(null);
				this.add(label);

				// 우측하단 next 버튼 ============================================================
				JButton nextBtn = new JButton(new ImageIcon("image/tutorial/next123.png"));

				nextBtn.setBounds(960, 670, 125, 41);
				label.add(nextBtn);
				nextBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ViewUtil.changePanel(mf, et, new EventTutorial3(mf));
					}
				});

				// =====================================================================

				// 우측상단 스킵버튼 =========================================================
				JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
				skipBtn.setBounds(999, 30, 130, 50);
//				label.add(skipBtn);

				skipBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ViewUtil.changePanel(mf, et, new TutorialMenu(mf));
					}
				});
			}
		}
		
		
		//스테이지 진행방법 2
				public class EventTutorial3 extends JPanel {
					private MainFrame mf;
					private EventTutorial3 et;

					public EventTutorial3(MainFrame mf) {
						this.et = this;
						this.mf = mf;

						Image background = new ImageIcon("image/tutorial/ev4.png").getImage().getScaledInstance(1200, 800, 0);

						JLabel label = new JLabel(new ImageIcon(background));
						label.setSize(1200, 800);

						this.setSize(1200, 800);
						this.setLayout(null);
						this.add(label);

						// 선택지 선택 버튼 ============================================================
						JButton nextBtn = new JButton(new ImageIcon("image/tutorial/3443.png"));

						nextBtn.setBounds(74, 625, 550, 63);
						nextBtn.setOpaque(false);
						label.add(nextBtn);
						nextBtn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								ViewUtil.changePanel(mf, et, new EventTutorial4(mf));
							}
						});

						// =====================================================================

						// 우측상단 스킵버튼 =========================================================
						JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
						skipBtn.setBounds(999, 30, 130, 50);
//						label.add(skipBtn);

						skipBtn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								ViewUtil.changePanel(mf, et, new TutorialMenu(mf));
							}
						});
					}
				}
	}
	//스테이지 선택결과(일반이멘트 듀토리얼 마지막화면)3
	public class EventTutorial4 extends JPanel {
		private MainFrame mf;
		private EventTutorial4 et;

		public EventTutorial4(MainFrame mf) {
			this.et = this;
			this.mf = mf;

			Image background = new ImageIcon("image/tutorial/ev5.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label = new JLabel(new ImageIcon(background));
			label.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label);

			// 우측하단 next 버튼 ============================================================
			JButton nextBtn = new JButton(new ImageIcon("image/tutorial/next123.png"));

			nextBtn.setBounds(910, 298, 125, 41);
			label.add(nextBtn);
			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new TutorialMenu(mf));
				}
			});

			// =====================================================================

			// 우측상단 스킵버튼 =========================================================
			JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
			skipBtn.setBounds(950, 30, 130, 50);
//			label.add(skipBtn);

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new TutorialMenu(mf));
				}
			});
		}
	}
}


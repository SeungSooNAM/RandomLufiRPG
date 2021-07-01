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

public class BattleTutorial extends JPanel{

	private MainFrame mf;
	private BattleTutorial bt;
	
	//전투 듀토리얼 시작
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
	nextBtn.setBounds(1000, 220, 140, 65);
	label1.add(nextBtn);

	label1.add(skipBtn);
	

	skipBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ViewUtil.changePanel(mf, bt, new TutorialMenu(mf));
		}
	});

	nextBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ViewUtil.changePanel(mf, bt, new BattleTutorial1(mf));
		}
	});

}
	//기본공격을 클릭하세요
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
					ViewUtil.changePanel(mf, bt, new TutorialMenu(mf));
				}
			});
			
			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, bt, new BattleTutorial2(mf));
				}
			});
		}

		//기본공격설명후 스킬공격창 넘어가기
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
			
				
				// 우측상단 넥스트 버튼 ============================================================
				JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));

				nextBtn.setBounds(1000, 220, 140, 65);
				label1.add(nextBtn);
				nextBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ViewUtil.changePanel(mf, bt, new BattleTutorial3(mf));
					}
				});
				
				//=====================================================================
				
				// 우측하단 스킵버튼 =========================================================
				JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
				skipBtn.setBounds(940, 650, 130, 50);
				label1.add(skipBtn);				

				skipBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ViewUtil.changePanel(mf, bt, new TutorialMenu(mf));
					}
				});
			
				//===============================================================================

			}

			// 스킬공격을 눌러보세요
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
					nextBtn.setBounds(770, 550, 140, 65);

					label1.add(nextBtn);

					skipBtn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							ViewUtil.changePanel(mf, bt, new TutorialMenu(mf));
						}
					});

					nextBtn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							ViewUtil.changePanel(mf, bt, new BattleTutorial4(mf));
						}
					});
					
				}

			}
		}
		
		
	}
	
	// 스킬사용할 동료이름선택 화면
	public class BattleTutorial4 extends JPanel {
		private BattleTutorial4 bt;
		private MainFrame mf;

		public BattleTutorial4(MainFrame mf) {

			this.bt = this;
			this.mf = mf;
			Image background = new ImageIcon("image/tutorial/bt4.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label1 = new JLabel(new ImageIcon(background));
			label1.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label1);
		
			
			// 좌측하단 나미선택 버튼 ============================================================
			JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));

			nextBtn.setBounds(3, 680, 120, 35);
			label1.add(nextBtn);
			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, bt, new BattleTutorial5(mf));
				}
			});
			
			//=====================================================================
			
			// 우측하단 스킵버튼 =========================================================
			JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
			skipBtn.setBounds(940, 650, 130, 50);
			label1.add(skipBtn);				

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, bt, new TutorialMenu(mf));
				}
			});
		
			//===============================================================================

		}

	}	
	
	//나미 스킬 사용 이미지 출력
	public class BattleTutorial5 extends JPanel {
		private BattleTutorial5 bt;
		private MainFrame mf;

		public BattleTutorial5(MainFrame mf) {

			this.bt = this;
			this.mf = mf;
			Image background = new ImageIcon("image/tutorial/bt5.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label1 = new JLabel(new ImageIcon(background));
			label1.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label1);
		
			
			JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));

			nextBtn.setBounds(1000, 220, 140, 65);
			label1.add(nextBtn);
			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, bt, new BattleTutorial6(mf));
				}
			});
			
			//=====================================================================
			
			// 우측하단 스킵버튼 =========================================================
			JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
			skipBtn.setBounds(940, 650, 130, 50);
			label1.add(skipBtn);				

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, bt, new TutorialMenu(mf));
				}
			});
		
			//===============================================================================

		}

	}	
	
	//도망가기 선택버튼 출력화면
		public class BattleTutorial6 extends JPanel {
			private BattleTutorial6 bt;
			private MainFrame mf;

			public BattleTutorial6(MainFrame mf) {

				this.bt = this;
				this.mf = mf;
				Image background = new ImageIcon("image/tutorial/bt6.png").getImage().getScaledInstance(1200, 800, 0);

				JLabel label1 = new JLabel(new ImageIcon(background));
				label1.setSize(1200, 800);

				this.setSize(1200, 800);
				this.setLayout(null);
				this.add(label1);
			
				
				JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));

				nextBtn.setBounds(440, 680, 120, 35);
				label1.add(nextBtn);
			
				nextBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ViewUtil.changePanel(mf, bt, new BattleTutorial7(mf));
					}
				});
				
				//=====================================================================
				
				// 우측하단 스킵버튼 =========================================================
				JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
				skipBtn.setBounds(940, 650, 130, 50);
				label1.add(skipBtn);				

				skipBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ViewUtil.changePanel(mf, bt, new TutorialMenu(mf));
					}
				});
			
				//===============================================================================

			}

		}	
		
		//도망가기 성공화면
				public class BattleTutorial7 extends JPanel {
					private BattleTutorial7 bt;
					private MainFrame mf;

					public BattleTutorial7(MainFrame mf) {

						this.bt = this;
						this.mf = mf;
						Image background = new ImageIcon("image/tutorial/bt7.png").getImage().getScaledInstance(1200, 800, 0);

						JLabel label1 = new JLabel(new ImageIcon(background));
						label1.setSize(1200, 800);

						this.setSize(1200, 800);
						this.setLayout(null);
						this.add(label1);
					
						
						JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));

						nextBtn.setBounds(940, 650, 130, 50);
						label1.add(nextBtn);
						nextBtn.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								ViewUtil.changePanel(mf, bt, new TutorialMenu(mf));
							}
						});
						
						//=====================================================================
						
						// 우측하단 스킵버튼 =========================================================
//						JButton skipBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
//						skipBtn.setBounds(940, 650, 130, 50);
//						label1.add(skipBtn);				
//
//						skipBtn.addActionListener(new ActionListener() {
//
//							@Override
//							public void actionPerformed(ActionEvent e) {
////								ViewUtil.changePanel(mf, bt, new BattleTutorial5(mf));
//							}
//						});
					
						//===============================================================================

					}

				}	
}

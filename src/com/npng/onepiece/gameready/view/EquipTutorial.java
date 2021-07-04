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

public class EquipTutorial extends JPanel {

	private MainFrame mf;
	private EquipTutorial et;

	// 무기를 선택해 장착해보세요
	public EquipTutorial(MainFrame mf, int chNum) {
		this.mf = mf;
		this.et = this;

		Image background = new ImageIcon("image/tutorial/et1.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label1 = new JLabel(new ImageIcon(background));
		label1.setSize(1200, 800);

		this.setSize(1200, 800);
		this.setLayout(null);
		this.add(label1);

		// 우측하단 스킵버튼
		JButton skipBtn = new JButton();
		skipBtn.setBounds(910, 745, 260, 45);
		skipBtn.setContentAreaFilled(false);
		skipBtn.setFocusPainted(false);
		label1.add(skipBtn);

		// 좌측상단 무기이미지 선택 버튼
		JButton nextBtn = new JButton();
		nextBtn.setContentAreaFilled(false);
		nextBtn.setFocusPainted(false);
		nextBtn.setBounds(94, 112, 160, 90);

		label1.add(nextBtn);

		skipBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mf, et, new TutorialMenu(mf, chNum));
			}
		});

		nextBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mf, et, new EquipTutorial2(mf, chNum));
			}
		});

	}

	// 튼튼한 검 설명 및 장착버튼 생성
	public class EquipTutorial2 extends JPanel {
		private MainFrame mf;
		private EquipTutorial2 et;

		public EquipTutorial2(MainFrame mf, int chNum) {
			this.mf = mf;
			this.et = this;

			Image background = new ImageIcon("image/tutorial/et2.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label1 = new JLabel(new ImageIcon(background));
			label1.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label1);

			// 우측하단 스킵버튼
			JButton skipBtn = new JButton();
			skipBtn.setContentAreaFilled(false);
			skipBtn.setFocusPainted(false);
			skipBtn.setBounds(910, 745, 260, 45);
			label1.add(skipBtn);

			// 우측하단 무기 장착버튼
			JButton nextBtn = new JButton();
			nextBtn.setContentAreaFilled(false);
			nextBtn.setFocusPainted(false);
			nextBtn.setBounds(720, 600, 160, 35);

			label1.add(nextBtn);

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new TutorialMenu(mf, chNum));
				}
			});

			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new EquipTutorial3(mf, chNum));
				}
			});

		}
	}

	// 튼튼한 검을 장착하였습니다
	public class EquipTutorial3 extends JPanel {
		private MainFrame mf;
		private EquipTutorial3 et;

		public EquipTutorial3(MainFrame mf, int chNum) {
			this.mf = mf;
			this.et = this;

			Image background = new ImageIcon("image/tutorial/et3.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label1 = new JLabel(new ImageIcon(background));
			label1.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label1);

			// 우측하단 스킵버튼
			JButton skipBtn = new JButton();
			skipBtn.setContentAreaFilled(false);
			skipBtn.setFocusPainted(false);
			skipBtn.setBounds(910, 745, 260, 45);
			label1.add(skipBtn);

			// 우측하단 장착 버튼
			JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
			nextBtn.setContentAreaFilled(false);
			nextBtn.setFocusPainted(false);

			nextBtn.setBounds(770, 390, 130, 45);

			label1.add(nextBtn);

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new TutorialMenu(mf, chNum));
				}
			});

			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new EquipTutorial4(mf, chNum));
				}
			});

		}
	}

	// 무기를 선택해 장착해제 해보세요
	public class EquipTutorial4 extends JPanel {
		private MainFrame mf;
		private EquipTutorial4 et;

		public EquipTutorial4(MainFrame mf, int chNum) {
			this.mf = mf;
			this.et = this;

			Image background = new ImageIcon("image/tutorial/et4.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label1 = new JLabel(new ImageIcon(background));
			label1.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label1);

			// 우측하단 스킵버튼
			JButton skipBtn = new JButton();
			skipBtn.setContentAreaFilled(false);
			skipBtn.setFocusPainted(false);
			skipBtn.setBounds(910, 745, 260, 45);
			label1.add(skipBtn);

			//무기아이콘 선택 버튼
			JButton nextBtn = new JButton();
			nextBtn.setContentAreaFilled(false);
			nextBtn.setFocusPainted(false);
			nextBtn.setBounds(94, 112, 160, 90);
			label1.add(nextBtn);

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new TutorialMenu(mf, chNum));
				}
			});

			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new EquipTutorial5(mf, chNum));
				}
			});

		}
	}

	// 우측하단 무기장착 해제 버튼 출력
	public class EquipTutorial5 extends JPanel {
		private MainFrame mf;
		private EquipTutorial5 et;

		public EquipTutorial5(MainFrame mf, int chNum) {
			this.mf = mf;
			this.et = this;

			Image background = new ImageIcon("image/tutorial/et5.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label1 = new JLabel(new ImageIcon(background));
			label1.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label1);

			// 우측하단 스킵버튼
			JButton skipBtn = new JButton();
			skipBtn.setContentAreaFilled(false);
			skipBtn.setFocusPainted(false);
			skipBtn.setBounds(910, 745, 260, 45);
			label1.add(skipBtn);

			// 우측하단 장착 버튼
			JButton nextBtn = new JButton();
			nextBtn.setContentAreaFilled(false);
			nextBtn.setFocusPainted(false);
			nextBtn.setBounds(720, 600, 160, 35);
			label1.add(nextBtn);

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new TutorialMenu(mf, chNum));
				}
			});

			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new EquipTutorial6(mf, chNum));
				}
			});

		}
	}

	public class EquipTutorial6 extends JPanel {
		private MainFrame mf;
		private EquipTutorial6 et;

		public EquipTutorial6(MainFrame mf, int chNum) {
			this.mf = mf;
			this.et = this;

			Image background = new ImageIcon("image/tutorial/et6.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label1 = new JLabel(new ImageIcon(background));
			label1.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label1);

			// 우측하단 스킵버튼
			JButton skipBtn = new JButton();
			skipBtn.setContentAreaFilled(false);
			skipBtn.setFocusPainted(false);
			skipBtn.setBounds(910, 745, 260, 45);
			label1.add(skipBtn);

			// 장착듀토리얼 완료 듀토리얼메뉼 돌아가기  버튼
			JButton nextBtn = new JButton();
			nextBtn.setContentAreaFilled(false);
			nextBtn.setFocusPainted(false);
			nextBtn.setBounds(278, 284, 615, 145);
			label1.add(nextBtn);

			skipBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new TutorialMenu(mf, chNum));
				}
			});

			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, et, new TutorialMenu(mf, chNum));
				}
			});

		}
	}
}

package com.npng.onepiece.character.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.character.controller.CharacterController;
import com.npng.onepiece.character.model.dto.CharacterDTO;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.gameready.view.CreateCharacterView;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.MainFrame;

public class ChInfo extends JPanel {

	private ChInfo charInfo;
	private JFrame mf;
	private CharacterDTO charDTO;
	private CharacterController cc;
	private int chNum;

	private int strPoint;
	private int dexPoint;
	private int chaPoint;
	private int haveStPoint;
	private String message;

	public ChInfo() {
		this.chNum = CreateCharacterView.chNum;
	}

	public ChInfo(MainFrame mf, int chNum) {
		this.chNum = CreateCharacterView.chNum;
		System.out.println("this.chNum : " + this.chNum);
		this.charDTO = new CharacterDTO();
		this.cc = new CharacterController();
//		this.chNum = chNum;

		charDTO = cc.lookChInfo(chNum);
		System.out.println(charDTO);

		this.charInfo = this;
		this.mf = mf;

		Image background = new ImageIcon("image/character/cinfo.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label = new JLabel(new ImageIcon(background));
		label.setSize(1200, 800);

		this.setSize(1200, 800);
		this.setLayout(null);
		this.add(label);

		// str 스탯 몇인지 알려주는 라벨
		strPoint = new Integer(charDTO.getStr());
		dexPoint = new Integer(charDTO.getDex());
		chaPoint = new Integer(charDTO.getCharisma());
		haveStPoint = new Integer(charDTO.getPoint());

		JLabel str = new JLabel(Integer.toString(strPoint));
		str.setForeground(Color.white);
		str.setFont(str.getFont().deriveFont(40.0f));
		str.setBounds(300, 99, 130, 130);
		str.setHorizontalAlignment(JLabel.CENTER);

		// 힘스탯 올려주는 버튼
		JButton upStrBtn = new JButton(new ImageIcon("image/character/upBtn.png"));
		upStrBtn.setBounds(465, 148, 47, 40);

		// dex 스탯 몇인지 알려주는 라벨
		JLabel dex = new JLabel(Integer.toString(dexPoint));
		dex.setForeground(Color.white);
		dex.setFont(str.getFont().deriveFont(40.0f));
		dex.setBounds(300, 164, 130, 130);
		dex.setHorizontalAlignment(JLabel.CENTER);

		// 덱스스탯 올려주는 버튼
		JButton upDexBtn = new JButton(new ImageIcon("image/character/upBtn.png"));
		upDexBtn.setBounds(465, 214, 47, 40);

		// cha스탯 몇인지 알려주는 라벨
		JLabel cha = new JLabel(Integer.toString(chaPoint));
		cha.setForeground(Color.white);
		cha.setFont(str.getFont().deriveFont(40.0f));
		cha.setBounds(300, 233, 130, 130);
		cha.setHorizontalAlignment(JLabel.CENTER);

		// 카리스마스탯 올려주는 버튼
		JButton upChaBtn = new JButton(new ImageIcon("image/character/upBtn.png"));
		upChaBtn.setBounds(465, 280, 47, 40);

		// 캐릭터 이름 라벨
		JLabel name = new JLabel(charDTO.getName());
		name.setForeground(Color.white);
		name.setFont(str.getFont().deriveFont(40.0f));
		name.setBounds(320, -12, 600, 130);
		name.setHorizontalAlignment(JLabel.CENTER);

		// level 라벨
		JLabel lv = new JLabel(Integer.toString(charDTO.getLevel()));
		lv.setForeground(Color.white);
		lv.setFont(str.getFont().deriveFont(40.0f));
		lv.setBounds(-137, 25, 600, 130);
		lv.setHorizontalAlignment(JLabel.CENTER);

		// 보유스탯포인트 라벨
		JLabel havePoint = new JLabel(Integer.toString(haveStPoint));
		havePoint.setForeground(Color.ORANGE);
		havePoint.setFont(str.getFont().deriveFont(40.0f));
		havePoint.setBounds(390, 355, 47, 40);
		havePoint.setHorizontalAlignment(JLabel.CENTER);

		// 현상금 라벨
		JLabel score = new JLabel(Integer.toString(charDTO.getScore()));
		score.setForeground(Color.BLACK);
		score.setFont(str.getFont().deriveFont(40.0f));
		score.setBounds(855, 305, 200, 40);
		score.setHorizontalAlignment(JLabel.CENTER);

		// 보유LIFE 라벨
		JLabel LIFE = new JLabel(Integer.toString(charDTO.getLife()));
		LIFE.setForeground(Color.PINK);
		LIFE.setFont(str.getFont().deriveFont(40.0f));
		LIFE.setBounds(-117, 400, 600, 130);
		LIFE.setHorizontalAlignment(JLabel.CENTER);

		// 캐릭터 HP라벨
		JLabel HP = new JLabel(Integer.toString(charDTO.getHp()));
		HP.setForeground(Color.GREEN);
		HP.setFont(str.getFont().deriveFont(40.0f));
		HP.setBounds(210, 470, 600, 130);
		HP.setHorizontalAlignment(JLabel.CENTER);

		// 캐릭터 HP라벨
		JLabel MP = new JLabel(Integer.toString(charDTO.getMp()));
		MP.setForeground(Color.BLUE);
		MP.setFont(str.getFont().deriveFont(40.0f));
		MP.setBounds(210, 530, 600, 130);
		MP.setHorizontalAlignment(JLabel.CENTER);

		// 캐릭터 공격력 라벨
		JLabel ATK = new JLabel(Integer.toString(charDTO.getAtk()));
		ATK.setForeground(Color.MAGENTA);
		ATK.setFont(str.getFont().deriveFont(40.0f));
		ATK.setBounds(210, 580, 600, 130);
		ATK.setHorizontalAlignment(JLabel.CENTER);

		// 캐릭터 경험치 라벨
		JLabel EXP = new JLabel(Integer.toString(charDTO.getExp()));
		EXP.setForeground(Color.WHITE);
		EXP.setFont(str.getFont().deriveFont(42.0f));
		EXP.setBounds(49, 648, 600, 130);
		EXP.setHorizontalAlignment(JLabel.CENTER);
		JLabel reqEXP = new JLabel(Integer.toString((charDTO.getLevel() * 100)));
		reqEXP.setForeground(Color.GRAY);
		reqEXP.setFont(str.getFont().deriveFont(42.0f));
		reqEXP.setBounds(220, 648, 600, 130);
		reqEXP.setHorizontalAlignment(JLabel.CENTER);

		label.add(reqEXP);

		// 캐릭터 소지금 라벨
//		JLabel GOLD = new JLabel(Integer.toString(charDTO.get));
//		GOLD.setForeground(Color.YELLOW);
//		GOLD.setFont(str.getFont().deriveFont(42.0f));
//		GOLD.setBounds(660, 550, 600, 130);
//		GOLD.setHorizontalAlignment(JLabel.CENTER);

		JButton backBtn = new JButton(new ImageIcon("image/character/back99.png"));
		backBtn.setBounds(1076, 14, 80, 80);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);

//		//보유스탯포인트가 부족합니다
//		JLabel infoMessage = new JLabel("message");
//		infoMessage.setForeground(Color.RED);
//		infoMessage.setFont(str.getFont().deriveFont(26.0f));
//		infoMessage.setBounds(200, 200, 200, 130);
//		infoMessage.setHorizontalAlignment(JLabel.CENTER);
//		
//		label.add(infoMessage);

		label.add(backBtn);
//		label.add(GOLD);
		label.add(EXP);
		label.add(ATK);
		label.add(HP);
		label.add(MP);
		label.add(LIFE);
		label.add(score);
		label.add(havePoint);
		label.add(lv);
		label.add(name);
		label.add(str);
		label.add(dex);
		label.add(cha);

		label.add(upStrBtn);
		label.add(upDexBtn);
		label.add(upChaBtn);

// ============================================================================		
		// 보유스탯포인트 부족 메세지 프레임
		JFrame messageFrame = new JFrame();
		messageFrame.setLocation(750, 500);
		messageFrame.setSize(300, 200);

		JPanel panel2 = new JPanel();
		panel2.setSize(300, 200);

		Image background1 = new ImageIcon("image/character/ms1.png").getImage().getScaledInstance(300, 110, 0);

		JLabel label2 = new JLabel(new ImageIcon(background1));

		JButton btn6 = new JButton("확인");
		btn6.setContentAreaFilled(false);
		btn6.setFocusPainted(false);
		btn6.setBounds(100, 50, 20, 30);
		
		panel2.add(label2);
		panel2.add(btn6);
		messageFrame.add(panel2);

		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				messageFrame.setVisible(false);

			}
		});
//===================================================================

		// 뒤로가기 버튼
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mf, charInfo, new MainMenu(mf, chNum));
			}
		});

		// str + 버튼
		upStrBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (haveStPoint > 0) {
					charDTO.setStr(strPoint + 1);
					charDTO.setPoint(haveStPoint - 1);

					int result = new CharacterController().CharacterStrUp(charDTO, chNum);
					if (result > 0) {
						ViewUtil.changePanel(mf, charInfo, new ChInfo(mf, chNum));
					}

				} else {
					// 보유스탯포인트가 부족합니다
					System.out.println("안내 메세지 출력");
					messageFrame.setVisible(true);
				}
			}
		});

		// Dex + 버튼
		upDexBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (haveStPoint > 0) {
					charDTO.setDex(dexPoint + 1);
					charDTO.setPoint(haveStPoint - 1);

					int result = new CharacterController().CharacterDexUp(charDTO, chNum);
					if (result > 0) {
						ViewUtil.changePanel(mf, charInfo, new ChInfo(mf, chNum));
					}

				} else {
					// 보유스탯포인트가 부족합니다
					System.out.println("안내 메세지 출력");
					messageFrame.setVisible(true);
				}
			}
		});

		// Cha + 버튼
		upChaBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (haveStPoint > 0) {
					charDTO.setCharisma(chaPoint + 1);
					charDTO.setPoint(haveStPoint - 1);

					int result = new CharacterController().CharacterChaUp(charDTO, chNum);
					if (result > 0) {
						ViewUtil.changePanel(mf, charInfo, new ChInfo(mf, chNum));
					}

				} else {
					// 보유스탯포인트가 부족합니다
					System.out.println("안내 메세지 출력");
					messageFrame.setVisible(true);

				}

			}
		});

//		if (point > 0) {
//			label.add(upStrBtn);
//			label.add(upDexBtn);
//			label.add(upChaBtn);
//			ViewUtil.changePanel(mf, charInfo, new ChInfo(mf, chNum));
//		} else {
//			label.remove(upStrBtn);
//			label.remove(upDexBtn);
//			label.remove(upChaBtn);
//			ViewUtil.changePanel(mf, charInfo, new ChInfo(mf, chNum));
//		}
	}

}

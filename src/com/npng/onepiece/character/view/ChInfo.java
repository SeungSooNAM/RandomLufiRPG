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

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.gameready.view.Openning1;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.MainFrame;

public class ChInfo extends JPanel {

	private ChInfo charInfo;
	private JFrame mf;

	public ChInfo(MainFrame mf) {
		this.charInfo = this;
		this.mf = mf;

		Image background = new ImageIcon("image/character/cinfo.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label = new JLabel(new ImageIcon(background));
		label.setSize(1200, 800);

		this.setSize(1200, 800);
		this.setLayout(null);
		this.add(label);

		// str 스탯 몇인지 알려주는 라벨
		JLabel str = new JLabel("12");
		str.setForeground(Color.white);
		str.setFont(str.getFont().deriveFont(40.0f));
		str.setBounds(300, 99, 130, 130);
		str.setHorizontalAlignment(JLabel.CENTER);

		// 힘스탯 올려주는 버튼
		JButton upStrBtn = new JButton(new ImageIcon("image/character/upBtn.png"));
		upStrBtn.setBounds(465, 148, 47, 40);
		label.add(upStrBtn);

		// dex 스탯 몇인지 알려주는 라벨
		JLabel dex = new JLabel("9");
		dex.setForeground(Color.white);
		dex.setFont(str.getFont().deriveFont(40.0f));
		dex.setBounds(300, 164, 130, 130);
		dex.setHorizontalAlignment(JLabel.CENTER);

		// 덱스스탯 올려주는 버튼
		JButton upDexBtn = new JButton(new ImageIcon("image/character/upBtn.png"));
		upDexBtn.setBounds(465, 214, 47, 40);
		label.add(upDexBtn);

		// cha스탯 몇인지 알려주는 라벨
		JLabel cha = new JLabel("9");
		cha.setForeground(Color.white);
		cha.setFont(str.getFont().deriveFont(40.0f));
		cha.setBounds(300, 233, 130, 130);
		cha.setHorizontalAlignment(JLabel.CENTER);

		// 카리스마스탯 올려주는 버튼
		JButton upChaBtn = new JButton(new ImageIcon("image/character/upBtn.png"));
		upChaBtn.setBounds(465, 280, 47, 40);
		label.add(upChaBtn);

		// 캐릭터 이름 라벨
		JLabel name = new JLabel("캐릭터이름");
		name.setForeground(Color.white);
		name.setFont(str.getFont().deriveFont(40.0f));
		name.setBounds(320, -12, 600, 130);
		name.setHorizontalAlignment(JLabel.CENTER);

		// level 라벨
		JLabel lv = new JLabel("1");
		lv.setForeground(Color.white);
		lv.setFont(str.getFont().deriveFont(40.0f));
		lv.setBounds(-137, 25, 600, 130);
		lv.setHorizontalAlignment(JLabel.CENTER);

		// 보유스탯포인트 라벨
		JLabel havePoint = new JLabel("3");
		havePoint.setForeground(Color.ORANGE);
		havePoint.setFont(str.getFont().deriveFont(40.0f));
		havePoint.setBounds(390, 355, 47, 40);
		havePoint.setHorizontalAlignment(JLabel.CENTER);

		// 현상금 라벨
		JLabel score = new JLabel("100,000");
		score.setForeground(Color.BLACK);
		score.setFont(str.getFont().deriveFont(40.0f));
		score.setBounds(855, 290, 200, 40);
		score.setHorizontalAlignment(JLabel.CENTER);

		// 보유LIFE 라벨
		JLabel LIFE = new JLabel("5");
		LIFE.setForeground(Color.PINK);
		LIFE.setFont(str.getFont().deriveFont(40.0f));
		LIFE.setBounds(-117, 400, 600, 130);
		LIFE.setHorizontalAlignment(JLabel.CENTER);

		// 캐릭터 HP라벨
		JLabel HP = new JLabel("100");
		HP.setForeground(Color.GREEN);
		HP.setFont(str.getFont().deriveFont(40.0f));
		HP.setBounds(210, 470, 600, 130);
		HP.setHorizontalAlignment(JLabel.CENTER);

		// 캐릭터 HP라벨
		JLabel MP = new JLabel("100");
		MP.setForeground(Color.BLUE);
		MP.setFont(str.getFont().deriveFont(40.0f));
		MP.setBounds(210, 530, 600, 130);
		MP.setHorizontalAlignment(JLabel.CENTER);

		// 캐릭터 공격력 라벨
		JLabel ATK = new JLabel("30");
		ATK.setForeground(Color.MAGENTA);
		ATK.setFont(str.getFont().deriveFont(40.0f));
		ATK.setBounds(210, 580, 600, 130);
		ATK.setHorizontalAlignment(JLabel.CENTER);

		// 캐릭터 경험치 라벨
		JLabel EXP = new JLabel("100");
		EXP.setForeground(Color.WHITE);
		EXP.setFont(str.getFont().deriveFont(42.0f));
		EXP.setBounds(49, 648, 600, 130);
		EXP.setHorizontalAlignment(JLabel.CENTER);

		// 캐릭터 소지금 라벨
		JLabel GOLD = new JLabel("50,000");
		GOLD.setForeground(Color.YELLOW);
		GOLD.setFont(str.getFont().deriveFont(42.0f));
		GOLD.setBounds(660, 550, 600, 130);
		GOLD.setHorizontalAlignment(JLabel.CENTER);
		
		JButton backBtn = new JButton(new ImageIcon("image/character/back99.png"));
		backBtn.setBounds(1067, 29, 68, 40);
		
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mf, charInfo, new MainMenu(mf));
			}
		});
		
		
		label.add(backBtn);
		label.add(GOLD);
		label.add(EXP);
		label.add(ATK);
		label.add(HP);
		label.add(MP);
		label.add(LIFE);
		label.add(score);
		label.add(havePoint);
		label.add(lv);
		label.add(name);

		
		
		int point = new Integer(havePoint.getText());
		
		if(point >= 1) {
			label.add(str);
			label.add(dex);
			label.add(cha);
		}
		
		
//		label.add(str);
//		label.add(dex);
//		label.add(cha);
	}
}

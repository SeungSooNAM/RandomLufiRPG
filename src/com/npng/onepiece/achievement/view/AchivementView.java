package com.npng.onepiece.achievement.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.achievement.controller.AchievementController;
import com.npng.onepiece.achievement.model.dto.AchDTO;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.MainFrame;

public class AchivementView extends JPanel {

	private JFrame mf;
	private AchivementView ach;
	private AchievementController ac = new AchievementController();
	private List<AchDTO> achList;
	private int chNum;

	public AchivementView(MainFrame mf, int chNum) {
		this.ach = this;

		this.ac = ac;
		this.achList = achList;
		this.chNum = chNum;
		this.mf = mf;

		Image background = new ImageIcon("image/achievement/ach.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label = new JLabel(new ImageIcon(background));
		label.setSize(1200, 800);

		this.setSize(1200, 800);
		this.setLayout(null);
		this.add(label);

		JLabel ach1 = new JLabel("현금부자");
		ach1.setForeground(Color.white);
		ach1.setFont(ach1.getFont().deriveFont(30.0f));
		ach1.setBounds(140, 125, 220, 200);
		ach1.setHorizontalAlignment(JLabel.CENTER);
		JLabel ach2 = new JLabel("승승장구");
		ach2.setForeground(Color.white);
		ach2.setFont(ach2.getFont().deriveFont(30.0f));
		ach2.setBounds(140, 234, 220, 200);
		ach2.setHorizontalAlignment(JLabel.CENTER);

		JLabel ach3 = new JLabel("밀짚모자해적단");
		ach3.setForeground(Color.white);
		ach3.setFont(ach3.getFont().deriveFont(30.0f));
		ach3.setBounds(140, 340, 220, 200);
		ach3.setHorizontalAlignment(JLabel.CENTER);

		JLabel ach4 = new JLabel("4번업적이름");
		ach4.setForeground(Color.white);
		ach4.setFont(ach4.getFont().deriveFont(30.0f));
		ach4.setBounds(140, 452, 220, 200);
		ach4.setHorizontalAlignment(JLabel.CENTER);
	

		JLabel achText1 = new JLabel("소지금 3000원 이상을 보유 한적이 있다.");
		achText1.setForeground(Color.BLACK);
		achText1.setFont(achText1.getFont().deriveFont(22.0f));
		achText1.setBounds(400, 124, 750, 200);
		JLabel achText2 = new JLabel("전 지역의 보스를 클리어 하였다");
		achText2.setForeground(Color.BLACK);
		achText2.setFont(achText2.getFont().deriveFont(22.0f));
		achText2.setBounds(400, 233, 750, 200);
		JLabel achText3 = new JLabel("동료를 6명 이상 획득 하였다");
		achText3.setForeground(Color.BLACK);
		achText3.setFont(achText3.getFont().deriveFont(22.0f));
		achText3.setBounds(400, 344, 750, 200);
		JLabel achText4 = new JLabel("<HTML>4번 업적 내용fsdjflsdfdsffdfsdfsdfsdfdsfsdsdf<br>" + "sdfsdfdsfdsfdsdfsdfsdfdsfsfdsfsdfsdd<HTML>");
		achText4.setForeground(Color.BLACK);
		achText4.setFont(achText4.getFont().deriveFont(22.0f));
		achText4.setBounds(400, 460, 750, 200);

		
		// 1번 업적 조회해서 달성 했으면 1번업적 이름과 내용 라벨 add
		int result1 = ac.isAchievement(chNum, 1);
		if (result1 == 1) {
			label.add(ach1);
			label.add(achText1);
		
		}	
		
		// 2번 업적 조회해서 달성 했으면 1번업적 이름과 내용 라벨 add
		int result2 = ac.isAchievement(chNum, 2);		
		if (result2 == 1) {
			label.add(ach2);
			label.add(achText2);			
		}
		
		// 3번 업적 조회해서 달성 했으면 1번업적 이름과 내용 라벨 add
		int result3 = ac.isAchievement(chNum, 3);	
		if (result3 == 1) {
			label.add(ach3);
			label.add(achText3);			
		}
		
		// 4번 업적 조회해서 달성 했으면 1번업적 이름과 내용 라벨 add
//		int result4 = ac.isAchievement(chNum, 4);	
//		if (result4 == 1) {
//			label.add(ach4);
//			label.add(achText4);			
//		}
		
		
		
		

		JButton backBtn = new JButton();
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setBounds(960, 737, 200, 40);

		label.add(backBtn);

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mf, ach, new MainMenu(mf, chNum));
			}
		});

//		achList = ac.findAchievement(chNum);
//		String achName1 =  achList.get(0).getAchName();
//		ach1.setText(achName1);

	}
}

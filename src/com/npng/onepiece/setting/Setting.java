package com.npng.onepiece.setting;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.ending.view.RankingUpdateView;
import com.npng.onepiece.gameready.view.CreateCharacterView;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.LoginPageView;
import com.npng.onepiece.user.view.MainFrame;

import net.sf.log4jdbc.sql.rdbmsspecifics.MySqlRdbmsSpecifics;

public class Setting extends JPanel{

	private Setting setting;
	private MainFrame mainFrame;  
	private Image icon;
	private int chNum;

	private JPanel sound;
	private JPanel ranking;
	private JPanel gameOff;
	private JPanel back;


	public Setting(MainFrame mainFrame) {
		this.setSize(1200,800);
		this.mainFrame = mainFrame;
		this.setting = this;

		Font font1 = new Font("Dialog",Font.BOLD, 45);    
		JLabel  imgLabel = new JLabel(new ImageIcon());
		icon = new ImageIcon("image/mainMenu/mainBackground2.png").getImage().getScaledInstance(1200, 800, 0);
		imgLabel.setIcon(new ImageIcon(icon));
		imgLabel .setLocation(0, 0);
		imgLabel.setSize(1200, 800);
		

		sound = new JPanel();
		sound.setBounds(120, 215, 330, 75);
		sound.setOpaque(false);
		imgLabel.add(sound);
		JLabel soundSetting = new JLabel("사운드 설정");
		soundSetting.setFont(font1);
		sound.add(soundSetting);

		ranking = new JPanel();
		ranking.setBounds(120, 318,  330, 75);
		ranking.setOpaque(false);
		imgLabel.add(ranking);
		JLabel rankingc = new JLabel("랭킹 확인");
		rankingc.setFont(font1);
		ranking.add(rankingc);

		gameOff = new JPanel();
		gameOff.setBounds(120, 420,  330, 75);
		gameOff.setOpaque(false);
		imgLabel.add(gameOff);
		JLabel return1 = new JLabel("게임 종료");
		return1.setFont(font1);
		gameOff.add(return1);


		back = new JPanel();
		back.setBounds(650, 690, 450, 120);
		back.setOpaque(false);
		imgLabel.add(back);
		JLabel btnback = new JLabel("뒤로가기");
		btnback.setFont(font1);
		back.add(btnback);

		this.add(imgLabel);
		mainFrame.add(this);
		
		
		sound.addMouseListener(new SettingMouseAdapter());
		ranking.addMouseListener(new SettingMouseAdapter());
		gameOff.addMouseListener(new SettingMouseAdapter());
		back.addMouseListener(new SettingMouseAdapter());
	}

	public class SettingMouseAdapter extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == sound) {
				ViewUtil.changePanel(mainFrame, setting, new Sound(mainFrame));
			}else if(e.getSource() == ranking) {
				ViewUtil.changePanel(mainFrame, setting, new Ranking(mainFrame));
			}else if(e.getSource() == gameOff) {
				ViewUtil.changePanel(mainFrame, setting, new RankingUpdateView(mainFrame));
			}else if(e.getSource() == back) {
				ViewUtil.changePanel(mainFrame, setting, new MainMenu(mainFrame, CreateCharacterView.chNum));
			}
		}

	
		
		
		
	}


}



//Sound sound = new Sound(mainFrame);
//JButton btnSound = new JButton("�� �� ��");
//btnSound.setBounds(120, 215, 330, 70);
//btnSound.addActionListener(new ActionListener() {
//
//@Override
//public void actionPerformed(ActionEvent e) {
//    ViewUtil.changePanel(mainFrame, setting, sound);
//}
//});
//
//JButton btnRanking = new JButton("�� ŷ Ȯ ��");
//btnRanking.setBounds(120, 317,  330, 80);
//btnRanking.addActionListener(new ActionListener() {
//
//@Override
//public void actionPerformed(ActionEvent e) {
//    ViewUtil.changePanel(mainFrame, setting, new Ranking(mainFrame));
//}
//});
//
//JButton btnReturnLogin = new JButton("���� ����");
//btnReturnLogin.setBounds(120, 417,  330, 80);
//btnReturnLogin.addActionListener(new ActionListener() {
//
//@Override
//public void actionPerformed(ActionEvent e) {
//     ViewUtil.changePanel(mainFrame, setting, new LoginPageView(mainFrame));
//    
//}
//});
//JButton btnBack = new JButton("�� �� �� ��");
//btnBack.setBounds(760, 680, 350, 80);
//btnBack.addActionListener(new ActionListener() {
//  
//  @Override
//  public void actionPerformed(ActionEvent e) {
//     ViewUtil.changePanel(mainFrame, setting,new MainMenu(mainFrame));            
//  }
//});
//
//
//this.add(imgLabel);
//imgLabel.add(btnSound);
//imgLabel.add(btnRanking);
//imgLabel.add(btnReturnLogin);
//imgLabel.add(btnBack);
package com.npng.onepiece.setting;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.LoginPageView;
import com.npng.onepiece.user.view.MainFrame;

public class Setting extends JPanel{
   
	 private Setting setting;
	 private MainFrame mainFrame;  
	 private Image icon;
	 
	public Setting(MainFrame mainFrame) {
		  this.setSize(1200,800);
	      this.mainFrame = mainFrame;
	      this.setting = this;
	      
	  JLabel  imgLabel = new JLabel(new ImageIcon());
	  this.icon = new ImageIcon("image/mainMenu/mainBackground1.PNG").getImage().getScaledInstance(1200, 800, 0);
	  imgLabel.setIcon(new ImageIcon(icon));
      
      Sound sound = new Sound(mainFrame);
      JButton btnSound = new JButton("사 운 드");
      btnSound.setBounds(120, 215, 330, 70);
      btnSound.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ViewUtil.changePanel(mainFrame, setting, sound);
        }
    });
      
      JButton btnRanking = new JButton("랭 킹 확 인");
      btnRanking.setBounds(120, 317,  330, 80);
      btnRanking.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            ViewUtil.changePanel(mainFrame, setting, new Ranking(mainFrame));
        }
    });
      
      JButton btnReturnLogin = new JButton("게임 종료");
      btnReturnLogin.setBounds(120, 417,  330, 80);
      btnReturnLogin.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
             ViewUtil.changePanel(mainFrame, setting, new LoginPageView(mainFrame));
            
        }
    });
      JButton btnBack = new JButton("뒤 로 가 기");
      btnBack.setBounds(760, 680, 350, 80);
      btnBack.addActionListener(new ActionListener() {
          
          @Override
          public void actionPerformed(ActionEvent e) {
             ViewUtil.changePanel(mainFrame, setting,new MainMenu(mainFrame));            
          }
       });
      
      this.add(imgLabel);
      imgLabel.add(btnSound);
      imgLabel.add(btnRanking);
      imgLabel.add(btnReturnLogin);
      imgLabel.add(btnBack);
  
	}
 
   
   
}
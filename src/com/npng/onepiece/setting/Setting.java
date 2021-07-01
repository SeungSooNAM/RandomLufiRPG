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
	  this.icon = new ImageIcon("image/mainMenu/mainBackground.PNG").getImage().getScaledInstance(1200, 800, 0);
      imgLabel.setIcon(new ImageIcon(icon));
      
      Sound sound = new Sound(mainFrame);
	
      JButton btnSound = new JButton(new ImageIcon("image/btn/sound.PNG"));
      btnSound.setBounds(120, 210, 350, 80);
      btnSound.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ViewUtil.changePanel(mainFrame, setting, sound);
		}
	});
      
      JButton btnRanking = new JButton(new ImageIcon("image/btn/ranking.PNG"));
      btnRanking.setBounds(120, 312,  350, 80);
      btnRanking.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ViewUtil.changePanel(mainFrame, setting, new Ranking(mainFrame));
		}
	});
      
      JButton btnReturnLogin = new JButton(new ImageIcon("image/btn/gameoff.PNG"));
      btnReturnLogin.setBounds(120, 412, 350, 80);
      btnReturnLogin.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 ViewUtil.changePanel(mainFrame, setting, new LoginPageView(mainFrame));
			
		}
	});
      JButton btnBack = new JButton(new ImageIcon("image/btn/back.PNG"));
      btnBack.setBounds(740, 652, 350, 80);
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
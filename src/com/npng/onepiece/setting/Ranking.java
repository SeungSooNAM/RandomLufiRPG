package com.npng.onepiece.setting;

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

public class Ranking extends JPanel {

	private Ranking ranking;
	private MainFrame mainFrame;  
	private Image icon;
	private Image icon2;
	
	public Ranking (MainFrame mainFrame) {
		
		 this.setSize(1200,800);
	     this.mainFrame = mainFrame;
	     this.ranking = this;
	     
	     JLabel  imgLabel = new JLabel(new ImageIcon());
	     icon = new ImageIcon("image/mainMenu/rankingbackground.PNG").getImage().getScaledInstance(1200, 800, 0);
	     imgLabel.setIcon(new ImageIcon(icon));
	     
	     JLabel rankingLabel = new JLabel(new ImageIcon());
	     icon2 = new ImageIcon("image/mainMenu/rankingboard.PNG").getImage().getScaledInstance(500, 400, 0);
	     rankingLabel.setIcon(new ImageIcon(icon2));
	     rankingLabel.setBounds(340, 210, 500, 400);
	     this.revalidate();
	     
	     
	     
	     JButton btnRankingConfirm = new JButton(new ImageIcon("image/btn/rankcon.PNG"));
	     btnRankingConfirm.setBounds(420, 20, 350, 80);
	     
	     JButton btnBack = new JButton(new ImageIcon("image/btn/back.PNG"));
	      btnBack.setBounds(740, 652, 350, 80);
	      btnBack.addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             ViewUtil.changePanel(mainFrame, ranking,new Setting(mainFrame));            
	          }
	       });
	      
	      this.add(imgLabel);  
	      imgLabel.add(rankingLabel);
	      imgLabel.add(btnBack);
	      imgLabel.add(btnRankingConfirm);
	}
}

package com.npng.onepiece.ending.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.user.view.MainFrame;

public class RankingConView extends JPanel{

	private MainFrame mainFrame;
	private RankingConView rankingConView;
	
	public RankingConView(MainFrame mainFrame) {
		  this.setSize(1200,800);
	      this.mainFrame = mainFrame;
	      this.rankingConView = this;
	      this.setLayout(null); 
	      
	      Image imgBackground = new ImageIcon("image/mainMenu/Ranking.png").getImage().getScaledInstance(1200, 800, 0);
	      JLabel fi = new JLabel(new ImageIcon(imgBackground));
	      fi.setLocation(0, 0);
	      fi.setSize(1200, 800);
	      this.add(fi);
	      
	      JLabel rank1 = new JLabel();
		
	      JLabel rank2 = new JLabel();
		
	      JLabel rank3 = new JLabel();
		
	      JLabel rank4 = new JLabel();
		
	      JLabel rank5 = new JLabel();
		

	}
}

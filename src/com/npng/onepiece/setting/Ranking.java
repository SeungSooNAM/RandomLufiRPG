package com.npng.onepiece.setting;

import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.setting.controller.RankingViewController;
import com.npng.onepiece.setting.model.dto.RankingDTO;
import com.npng.onepiece.user.view.MainFrame;

public class Ranking extends JPanel {

   private Ranking ranking;
   private MainFrame mainFrame;
   private Image icon;
   private Image icon2;
   private RankingViewController rankingViewController;
   private RankingDTO rankingDTO;
   private int chNum;

   public Ranking (MainFrame mainFrame) {

      RankingViewController rc = new RankingViewController();
      
      this.setSize(1200,800);
      this.mainFrame = mainFrame;
      this.ranking = this;

      //랭킹 배경 라벨
      
      Image login = new ImageIcon("image/mainMenu/rankingbackground.PNG").getImage().getScaledInstance(1200, 800, 0);
      JLabel label = new JLabel(new ImageIcon(login));
      //랭킹 보여줄 라벨
//      JLabel rankingLabel = new JLabel(new ImageIcon());
//      icon2 = new ImageIcon("image/mainMenu/rankingboard.PNG").getImage().getScaledInstance(500, 400, 0);
//      rankingLabel.setIcon(new ImageIcon(icon2));
//      rankingLabel.setBounds(340, 210, 500, 400);
//      this.revalidate();
      Image login2 = new ImageIcon("image/mainMenu/rankingboard.PNG").getImage().getScaledInstance(1200, 800, 0);
      JLabel label2 = new JLabel(new ImageIcon(login));
      //        rankingLabel.addMouseListener(new rankingMouseListener());

      Font font1 = new Font("",0,35);
      TextArea ta1 = new TextArea("", 20, 60,1);
      ta1.setLocation(290, 140);
      ta1.setSize(600, 500);
      ta1.setFont(font1);
      ta1.setEditable(false);

      JButton btnRankingConfirm = new JButton(new ImageIcon("image/btn/rankcon.PNG"));
      btnRankingConfirm.setBounds(420, 20, 200, 60);
      List<RankingDTO> rakingList = rc.selectRanking();
      for(int i = 0; i < rakingList.size(); i++) {
    	  
    	  ta1.append(rakingList.get(i) + "\n");
      }
      
      //Setting Class 로 뒤로 가기
      JButton btnBack = new JButton(new ImageIcon("image/btn/back.PNG"));
      btnBack.setBounds(740, 652, 350, 80);
      btnBack.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            ViewUtil.changePanel(mainFrame, ranking,new Setting(mainFrame));            
         }
      });
      label.add(ta1);
      label.add(label2);
      label.add(btnBack);
      label.add(btnRankingConfirm);
      this.add(label);
      mainFrame.add(this);
   }

}
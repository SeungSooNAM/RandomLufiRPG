package com.npng.onepiece.user.view;

import javax.swing.JFrame;

import com.npng.onepiece.battle.view.main.BattleView;
import com.npng.onepiece.sound.Playsound;

public class MainFrame extends JFrame {
   
   public static MainFrame mf;

   public MainFrame() {
      
      super("Random Luffy RPG");
      this.setBounds(300, 150, 1200, 850);
      this.mf = this;
      
      new Playsound().playSound("sound/12.wav");
      
      new LoginPageView(this);

      
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
}

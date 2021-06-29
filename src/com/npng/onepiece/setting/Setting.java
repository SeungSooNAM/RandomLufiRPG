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
import com.npng.onepiece.user.view.MainFrame;

public class Setting extends JPanel{
   
   private Setting setting;
   private ImageIcon icon = new ImageIcon("image/mainMenu/mainBackground");
   private Image img = icon.getImage();
   private JLabel imgLabel = new JLabel(icon);
   private MainFrame mainFrame;   
   
   public Setting(MainFrame mainFrame) {
      this.mainFrame = mainFrame;
      this.setting = setting;   
      
      
      JButton btnSound = new JButton();
      JButton btnRanking = new JButton();
      JButton btnGameOff = new JButton();
      JButton btnBack = new JButton();
      
      btnSound.setBounds(120, 195, 330, 70);
      btnSound.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            ViewUtil.changePanel(mainFrame, setting, new Sound(mainFrame));
            
         }
      });
      btnRanking.setBounds(120, 292,  330, 80);
      btnRanking.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            ViewUtil.changePanel(mainFrame, setting, new Ranking(mainFrame));            
         }
      });
      btnGameOff.setBounds(120, 392,  330, 80);
      btnGameOff.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });
      btnBack.setBounds(1050, 10,100,100);
      btnBack.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            ViewUtil.changePanel(mainFrame, setting,new MainMenu(mainFrame));            
         }
      });
      
      
      
      this.setSize(1200, 800);
      this.setLayout(null);
   }
   
   public void paintComponent(Graphics g) {
      
      g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
   }

   
   
}
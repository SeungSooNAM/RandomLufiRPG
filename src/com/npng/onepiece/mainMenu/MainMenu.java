package com.npng.onepiece.mainMenu;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.setting.Setting;
import com.npng.onepiece.user.view.MainFrame;

public class MainMenu extends JPanel{

   private MainMenu mainMenu;
   private MainFrame mainFrame;   
   
   public MainMenu(MainFrame mainFrame)  {
      
      this.setSize(1200,800);
      Image icon = new ImageIcon("image/mainMenu/mainBackground").getImage().getScaledInstance(1200, 800, 0);
      JLabel imgLabel = new JLabel(new ImageIcon(icon));
      this.mainFrame = mainFrame;
      this.mainMenu = mainMenu;
      
      
      Setting setting = new Setting(mainFrame);
      
      JButton btnCh = new JButton("image/btn/chinfo.PNG");
      btnCh.setBounds(120, 195, 330, 70);
      JButton btnInven = new JButton("image/btn/inven.PNG");
      btnInven.setBounds(120, 292,  330, 80);
      JButton btnShop = new JButton("image/btn/shop.PNG");
      btnShop.setBounds(120, 392,  330, 80);
      JButton btnFriend = new JButton("image/btn/friend.PNG");
      btnFriend.setBounds(120, 492,  330, 80);
      JButton btnAch = new JButton("image/btn/ach.PNG");
      btnAch.setBounds(120, 592,  330, 80);
      JButton btnGameready = new JButton("image/btn/ready.PNG");
      btnGameready.setBounds(740, 652, 350, 80);
      JButton btnSetting = new JButton("image/btn/setting.jpg");
      btnSetting.setBounds(1050, 10,100,100);
      btnSetting.addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            ViewUtil.changePanel(mainFrame, mainMenu, new Setting(mainFrame));
         }
      });
      
     
      
      this.add(imgLabel);
      imgLabel.add(btnCh);
      imgLabel.add(btnInven);
      imgLabel.add(btnShop);
      imgLabel.add(btnFriend);
      imgLabel.add(btnAch);
      imgLabel.add(btnGameready);
      imgLabel.add(btnSetting);
      this.setLayout(null);
   }

      

   
}
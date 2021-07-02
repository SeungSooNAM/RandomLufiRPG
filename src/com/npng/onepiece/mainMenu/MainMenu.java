package com.npng.onepiece.mainMenu;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.event.views.SelectMapView;
import com.npng.onepiece.setting.Setting;
import com.npng.onepiece.user.view.MainFrame;

public class MainMenu extends JPanel{

   private MainMenu mainMenu;
   private MainFrame mainFrame;  
   private Image icon;
   private int chNum;
   public MainMenu(MainFrame mainFrame, int chNum)  {
      this.chNum = chNum;
	  this.mainFrame = mainFrame;
	  this.mainMenu = this;
      this.setSize(1200,800);
      this.setLayout(null);      
      

      JLabel  imgLabel = new JLabel(new ImageIcon());
      this.icon = new ImageIcon("image/mainMenu/mainBackground1.PNG").getImage().getScaledInstance(1200, 800, 0);
      imgLabel.setSize(1200,800);
      imgLabel.setIcon(new ImageIcon(icon));
      
      JButton btnCh = new JButton("캐릭터 정보창");
      btnCh.setBounds(120, 215, 330, 70);
      
      JButton btnInven = new JButton("가 방");
      btnInven.setBounds(120, 317,  330, 80);
      btnInven.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
//          ViewUtil.changePanel(mainFrame, mainMenu, new InventoryView(mainFrame));
          
      }
  });
      
      JButton btnShop = new JButton("상 점");
      btnShop.setBounds(120, 417,  330, 80);
      btnShop.addActionListener(new ActionListener() {
          
          @Override
          public void actionPerformed(ActionEvent e) {
//              ViewUtil.changePanel(mainFrame, mainMenu, new ShopView(mainFrame,  inven));
          }
      });
      

      JButton btnFriend = new JButton("동 료");
      btnFriend.setBounds(120, 515,  330, 80);
      
      JButton btnAch = new JButton("업 적");
      btnAch.setBounds(120, 610,  330, 80);
      System.out.println("캐릭터번호 : = " + chNum);
      JButton btnAdventure = new JButton("모 험 시 작");
      btnAdventure.setBounds(760, 680, 350, 80);
      btnAdventure.addActionListener(new ActionListener() {
          
          @Override
          public void actionPerformed(ActionEvent e) {
              ViewUtil.changePanel(mainFrame, mainMenu, new SelectMapView(mainFrame,chNum));
          }
      });
      
      JButton btnSetting = new JButton();
      btnSetting.setBounds(1070, 10,90,80);
      btnSetting.addActionListener(new ActionListener() {
          
          @Override
          public void actionPerformed(ActionEvent e) {
             ViewUtil.changePanel(mainFrame, mainMenu, new Setting(mainFrame));
          }
       });
     
      btnCh.setOpaque(false);
      btnInven.setOpaque(false);
      btnShop.setOpaque(false);
      btnFriend.setOpaque(false);
      btnAch.setOpaque(false);
      btnAdventure.setOpaque(false);
      btnSetting.setOpaque(false);
     
      this.add(imgLabel);
      imgLabel.add(btnCh);
      imgLabel.add(btnInven);
      imgLabel.add(btnShop);
      imgLabel.add(btnFriend);
      imgLabel.add(btnAch);
      imgLabel.add(btnAdventure);
      imgLabel.add(btnSetting);
       

   }
}

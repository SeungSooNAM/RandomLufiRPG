package com.npng.onepiece.mainMenu;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.event.views.MapResultView;
import com.npng.onepiece.setting.Setting;
import com.npng.onepiece.shop.view.ShopView;
import com.npng.onepiece.user.view.MainFrame;

public class MainMenu extends JPanel{

   private MainMenu mainMenu;
   private MainFrame mainFrame;  
   private Image icon;
   
   public MainMenu(MainFrame mainFrame)  {
      
	   this.mainFrame = mainFrame;
	   this.mainMenu = this;
      this.setSize(1200,800);
      this.setLayout(null);      

      JLabel  imgLabel = new JLabel(new ImageIcon());
      this.icon = new ImageIcon("image/mainMenu/mainBackground1.PNG").getImage().getScaledInstance(1200, 800, 0);
      imgLabel.setIcon(new ImageIcon(icon));
      
      JButton btnCh = new JButton("ĳ���� ����â");
      btnCh.setBounds(120, 215, 330, 70);
      
      JButton btnInven = new JButton("�� ��");
      btnInven.setBounds(120, 317,  330, 80);
      
      JButton btnShop = new JButton("�� ��");
      btnShop.setBounds(120, 417,  330, 80);
      
      JButton btnFriend = new JButton("�� ��");
      btnFriend.setBounds(120, 515,  330, 80);
      
      JButton btnAch = new JButton("�� ��");
      btnAch.setBounds(120, 610,  330, 80);
      
      JButton btnAdventure = new JButton("�� �� �� ��");
      btnAdventure.setBounds(760, 680, 350, 80);
      
      JButton btnSetting = new JButton();
      btnSetting.setBounds(1070, 10,90,80);
     
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
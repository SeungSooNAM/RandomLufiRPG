package com.npng.onepiece.mainMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.achievement.controller.AchievementController;
import com.npng.onepiece.achievement.view.AchivementView;
import com.npng.onepiece.character.view.ChInfo;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.event.views.SelectMapView;
import com.npng.onepiece.friend.view.FriendInfoView;
import com.npng.onepiece.inventory.view.InventoryView;
import com.npng.onepiece.setting.Setting;
import com.npng.onepiece.shop.view.ShopView;
import com.npng.onepiece.user.view.MainFrame;

public class MainMenu extends JPanel{

   private MainMenu mainMenu;
   private MainFrame mf;  
   private Image icon;
   private int chNum;
   
   private JPanel chPanel;
   private JPanel invenPanel;
   private JPanel shopPanel;
   private JPanel friendPanel;
   private JPanel achPanel;
   private JPanel playPanel;
   private JPanel settingPanel;
   private String userName;
   
   public MainMenu(MainFrame mainFrame, int chNum)  {
      this.chNum = chNum;
	  this.mf = mainFrame;
	  this.mainMenu = this;
      this.setLayout(null);      
      
      
      JLabel labelAchieve1 = new JLabel("alarm : 현금부자 업적 달성!");
      JLabel labelAchieve2 = new JLabel("alarm : 승승장구 업적 달성!");
      JLabel labelAchieve3 = new JLabel("alarm : 밀짚모자 해적단 업적 달성!");
      
     
      
      
      Font font1 = new Font("Dialog",Font.BOLD, 45);
      Image imgBackground = new ImageIcon("image/mainMenu/mainBackground2.png").getImage().getScaledInstance(1200, 800, 0);
      JLabel fi = new JLabel(new ImageIcon(imgBackground));
      fi.setLocation(0, 0);
      fi.setSize(1200, 800);
      this.add(fi);
      
      
   
		Font font = new Font("맑은 고딕", Font.PLAIN, 40);
		labelAchieve1.setFont(font);
		labelAchieve1.setForeground(Color.ORANGE);
		labelAchieve1.setBounds(600, 100, 500, 100);
		
		labelAchieve2.setFont(font);
		labelAchieve2.setForeground(Color.GRAY);
		labelAchieve2.setBounds(600, 200, 500, 100);
		
		labelAchieve3.setFont(font);
		labelAchieve3.setForeground(Color.GRAY);
		labelAchieve3.setBounds(600, 300, 500, 100);
      
      AchievementController achControl = new AchievementController();
		if(achControl.isAchievement(chNum, 1) == 0) {
			if(achControl.MoneyAchievement(chNum) != 0) {
				achControl.insertAchivement(chNum, 1);
//				ViewUtil.changePanel(mf, mainMenu, new MainMenuACH(mf, chNum, 1));
				fi.add(labelAchieve1);
				System.out.println("업적1달성");
			}
			
		}
		
		if(achControl.isAchievement(chNum, 2) == 0) {
			if(achControl.bossAchievement(chNum) != 0) {
				achControl.insertAchivement(chNum, 2);
//				ViewUtil.changePanel(mf, mainMenu, new MainMenuACH(mf, chNum, 2));
				fi.add(labelAchieve2);
				System.out.println("업적2달성");
			}
		}
		
		if(achControl.isAchievement(chNum, 3) == 0) {
			if(achControl.friendAchievement(chNum) != 0) {
				achControl.insertAchivement(chNum, 3);
//				ViewUtil.changePanel(mf, mainMenu, new MainMenuACH(mf, chNum, 3));
				fi.add(labelAchieve3);
				System.out.println("업적3달성");
			}
		}
      
      
      JLabel userNameLabel = new JLabel(userName);
      userNameLabel.setBounds(5, 125, 150, 50);
      fi.add(userNameLabel);
      
      chPanel = new JPanel();
      chPanel.setBounds(120, 215, 330, 75);
      chPanel.setOpaque(false);
      fi.add(chPanel);
      JLabel character = new JLabel("캐릭터정보");
      character.setFont(font1);
      chPanel.add(character);
      
      invenPanel = new JPanel();
      invenPanel.setBounds(120, 318,  330, 75);
      invenPanel.setOpaque(false);
      fi.add(invenPanel);
      JLabel inven = new JLabel("인벤토리");
      inven.setFont(font1);
      invenPanel.add(inven);
      
      
      shopPanel = new JPanel();
      shopPanel.setBounds(120, 420,  330, 75);
      shopPanel.setOpaque(false);
      fi.add(shopPanel);
      JLabel shop = new JLabel("상점");
      shop.setFont(font1);
      shopPanel.add(shop);
      

      friendPanel = new JPanel();
      friendPanel.setBounds(120, 522,  330, 75);
      friendPanel.setOpaque(false);
      fi.add(friendPanel);
      JLabel friend = new JLabel("동료");
      friend.setFont(font1);
      friendPanel.add(friend);
      
      achPanel = new JPanel();
      achPanel.setBounds(120, 625,  330, 75);
      achPanel.setOpaque(false);
      fi.add(achPanel);
      JLabel ach = new JLabel("업적");
      ach.setFont(font1);
      achPanel.add(ach);
       
      playPanel = new JPanel();
      playPanel.setBounds(650, 690, 450, 120);
      playPanel.setOpaque(false);
      fi.add(playPanel);
      JLabel play = new JLabel("항해 시작");
      play.setFont(font1);
      playPanel.add(play);
      
      settingPanel = new JPanel();
      settingPanel.setBounds(1080, 0, 120, 120);
      settingPanel.setOpaque(false);
      fi.add(settingPanel);

      
      chPanel.addMouseListener(new MyMouseAdapter());
      invenPanel.addMouseListener(new MyMouseAdapter());
      shopPanel.addMouseListener(new MyMouseAdapter());
      friendPanel.addMouseListener(new MyMouseAdapter());
      achPanel.addMouseListener(new MyMouseAdapter());
      playPanel.addMouseListener(new MyMouseAdapter());
      settingPanel.addMouseListener(new MyMouseAdapter());
      
      
      
      
   }
   
   public class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == chPanel) {
				ViewUtil.changePanel(mf, mainMenu, new ChInfo(mf, chNum));
			} else if(e.getSource() == invenPanel){
				 ViewUtil.changePanel(mf, mainMenu, new InventoryView(mf, chNum));
			} else if(e.getSource() == shopPanel) {		
				ViewUtil.changePanel(mf, mainMenu, new ShopView(mf, chNum, 0));
			} else if(e.getSource() == friendPanel) {
				ViewUtil.changePanel(mf, mainMenu, new FriendInfoView());
			} else if(e.getSource() == achPanel) {
				ViewUtil.changePanel(mf, mainMenu, new AchivementView(mf, chNum));
			} else if(e.getSource() == playPanel) {
				ViewUtil.changePanel(mf, mainMenu, new SelectMapView(mf, chNum));
			} else if(e.getSource() == settingPanel) {
				ViewUtil.changePanel(mf, mainMenu, new Setting(mf));
			}	
		}
	}
   
//   public class MainMenuACH extends JPanel{
//
//
//		private MainMenuACH mainMenuA;
//		private MainFrame mf;  
//		private Image img;
//		
//		public MainMenuACH(MainFrame mainFrame, int chNum, int i)  {
//			this.setBounds(0, 0, 1200, 800);
//			this.mf = mainFrame;
//			this.mainMenuA = this;
//			
//			JLabel textLabel = new JLabel("현금부자 업적 달성!");
//
//			if(i ==2) {
//				textLabel = new JLabel("승승장구 업적 달성!");
//			}
//			if(i ==3) {
//				textLabel = new JLabel("밀짚모자 해적단 업적 달성!");
//			}
//			
//			
//			JLabel label = new JLabel(new ImageIcon());
//			this.img = new ImageIcon("image//achievement/ach_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
//			label.setIcon(new ImageIcon(img));
//			
//			JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));
//			
//			
//			
//			
//			
//			buttonExit.setBounds(1000, 690, 190, 65);
//			
//			
//			
//			Font font = new Font("맑은 고딕", Font.PLAIN, 30);
//			textLabel.setFont(font);
//			textLabel.setForeground(Color.WHITE);
//			textLabel.setBounds(400, 700, 500, 100);
//			
//			
//			buttonExit.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					ViewUtil.changePanel(mf, mainMenuA, new MainMenu(mf, chNum));
//				}
//
//			});
//			
//			
//			label.add(buttonExit);
//			label.add(textLabel);
//			
//			this.add(label);
//			
//		}
//	}
}

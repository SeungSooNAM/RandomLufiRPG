package com.npng.onepiece.mainMenu;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.battle.view.main.BattleView.MyMouseAdapter;
import com.npng.onepiece.character.view.ChInfo;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.event.views.SelectMapView;
import com.npng.onepiece.friend.view.FriendInfoView;
import com.npng.onepiece.friend.view.SelectInfo;
import com.npng.onepiece.inventory.controller.InventoryController;
import com.npng.onepiece.inventory.model.dto.EquipDTO;
import com.npng.onepiece.inventory.model.dto.InventoryDTO;
import com.npng.onepiece.inventory.view.InventoryView;
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
      
      Font font1 = new Font("Dialog",Font.BOLD, 45);
      Image imgBackground = new ImageIcon("image/mainMenu/mainBackground2.png").getImage().getScaledInstance(1200, 800, 0);
      JLabel fi = new JLabel(new ImageIcon(imgBackground));
      fi.setLocation(0, 0);
      fi.setSize(1200, 800);
      this.add(fi);
      
      
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
      
      chPanel.addMouseListener(new MyMouseAdapter());
      invenPanel.addMouseListener(new MyMouseAdapter());
      shopPanel.addMouseListener(new MyMouseAdapter());
      friendPanel.addMouseListener(new MyMouseAdapter());
      achPanel.addMouseListener(new MyMouseAdapter());
      playPanel.addMouseListener(new MyMouseAdapter());
      
      
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
//				ViewUtil.changePanel(mf, mainMenu, new AchivementView(mf, chNum));
			} else if(e.getSource() == playPanel) {
				ViewUtil.changePanel(mf, mainMenu, new SelectMapView(mf, chNum));
			} else if(e.getSource() == settingPanel) {
//				ViewUtil.changePanel(mf, selectInfo, new SelectInfo(mf, friendName[5]));
			}	
		}
	}
}

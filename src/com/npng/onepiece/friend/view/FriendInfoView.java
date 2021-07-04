package com.npng.onepiece.friend.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.friend.controller.FriendController;
import com.npng.onepiece.friend.model.dto.FriendDTO;
import com.npng.onepiece.gameready.view.CreateCharacterView;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.MainFrame;


public class FriendInfoView extends JPanel{
	
	private MainFrame mf;
	private FriendInfoView friendInfoView;
	private FriendController friendController = new FriendController();
	private List<FriendDTO> friendList;
	private FriendDTO friendListLabel[] = new FriendDTO[6];
	private String friendName[] = new String[6];
	private String friendGrade[] = new String[6];
	
	private JPanel firstPanel;
	private JPanel secondPanel;
	private JPanel thirdPanel;
	private JPanel fourthPanel;
	private JPanel fifthPanel;
	private JPanel sixthPanel;
	
	private JPanel backPanel;
	
	private JLabel backName;
	private JLabel goldLabel;
	private int gold;

	public FriendInfoView() {
		this.setSize(1200, 800);
		this.friendInfoView = this;
		MainFrame.mf.add(this);
		
		this.setLayout(null);
		Font font1 = new Font("Dialog",Font.BOLD, 20);
		
		Image img = new ImageIcon("image/friend/friendInfo.png").getImage().getScaledInstance(1200, 750, 0);
		JLabel fi = new JLabel(new ImageIcon(img));
		fi.setLocation(0, 0);
		fi.setSize(1200, 750);
		this.add(fi);;
		
		
		
		firstPanel = new JPanel();
		firstPanel.setLocation(712, 55);
		firstPanel.setSize(128, 66);
		firstPanel.setOpaque(false);
		fi.add(firstPanel);
		
		secondPanel = new JPanel();
		secondPanel.setLocation(866, 55);
		secondPanel.setSize(128, 66);
		secondPanel.setOpaque(false);
		fi.add(secondPanel);
		
		thirdPanel = new JPanel();
		thirdPanel.setLocation(1016, 55);
		thirdPanel.setSize(128, 66);
		thirdPanel.setOpaque(false);
		fi.add(thirdPanel);
		
		fourthPanel = new JPanel();
		fourthPanel.setLocation(712, 135);
		fourthPanel.setSize(128, 66);
		fourthPanel.setOpaque(false);
		fi.add(fourthPanel);
		
		fifthPanel = new JPanel();
		fifthPanel.setLocation(866, 135);
		fifthPanel.setSize(128, 66);
		fifthPanel.setOpaque(false);
		fi.add(fifthPanel);
		
		sixthPanel = new JPanel();
		sixthPanel.setLocation(1016, 135);
		sixthPanel.setSize(128, 66);
		sixthPanel.setOpaque(false);
		fi.add(sixthPanel);
		
		backPanel = new JPanel();
		backPanel.setLocation(1050, 10);
		backPanel.setSize(150, 30);
		backPanel.setOpaque(false);
		fi.add(backPanel);
		
		backName = new JLabel("뒤로가기");
		backName.setFont(font1);
		backPanel.add(backName);
		
		friendList = new ArrayList<>();
		friendList = friendController.friendInfo();
		gold  = friendController.checkMoney();
		
		
		if(friendList.size() != 0) {
			for(int i = 0; i < friendList.size(); i++) {
				friendListLabel[i] = friendList.get(i);
				friendName[i] = friendListLabel[i].getFrName();
				friendGrade[i] = friendListLabel[i].getFrGrade();
			}

		} 
		
		
		
		goldLabel = new JLabel(gold + "$");
		goldLabel.setLocation(1040, 450);
		goldLabel.setSize(150, 55);
		goldLabel.setFont(font1);
		fi.add(goldLabel);


		Image first = new ImageIcon("image/friend/" + friendName[0] + "_" + friendGrade[0] + ".png").getImage().getScaledInstance(128, 66, 0);
		JLabel firstLabel = new JLabel(new ImageIcon(first));
		firstPanel.add(firstLabel);
		Image second = new ImageIcon("image/friend/" + friendName[1] + "_" + friendGrade[1] + ".png").getImage().getScaledInstance(128, 66, 0);
		JLabel secondLabel = new JLabel(new ImageIcon(second));
		secondPanel.add(secondLabel);
		Image third = new ImageIcon("image/friend/" + friendName[2] + "_" + friendGrade[2] + ".png").getImage().getScaledInstance(128, 66, 0);
		JLabel thirdLabel = new JLabel(new ImageIcon(third));
		thirdPanel.add(thirdLabel);
		Image fourth = new ImageIcon("image/friend/" + friendName[3] + "_" + friendGrade[3] + ".png").getImage().getScaledInstance(128, 66, 0);
		JLabel fourthLabel = new JLabel(new ImageIcon(fourth));
		fourthPanel.add(fourthLabel);
		Image fifth = new ImageIcon("image/friend/" + friendName[4] + "_" + friendGrade[4] + ".png").getImage().getScaledInstance(128, 66, 0);
		JLabel fifthLabel = new JLabel(new ImageIcon(fifth));
		fifthPanel.add(fifthLabel);
		Image sixth = new ImageIcon("image/friend/" + friendName[5] + "_" + friendGrade[5] + ".png").getImage().getScaledInstance(128, 66, 0);
		JLabel sixthLabel = new JLabel(new ImageIcon(sixth));
		sixthPanel.add(sixthLabel);

		firstPanel.addMouseListener(new MyMouseAdapter());
		secondPanel.addMouseListener(new MyMouseAdapter());
		thirdPanel.addMouseListener(new MyMouseAdapter());
		fourthPanel.addMouseListener(new MyMouseAdapter());
		fifthPanel.addMouseListener(new MyMouseAdapter());
		sixthPanel.addMouseListener(new MyMouseAdapter());
		backPanel.addMouseListener(new MyMouseAdapter());
		
	}
	
	public class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(friendList.size() != 0) {
				if(e.getSource() == firstPanel) {
					ViewUtil.changePanel(friendInfoView, new SelectInfo(friendName[0]));
				} else if(e.getSource() == secondPanel){
					ViewUtil.changePanel(friendInfoView, new SelectInfo(friendName[1]));
				} else if(e.getSource() == thirdPanel) {
					ViewUtil.changePanel(friendInfoView, new SelectInfo(friendName[2]));
				} else if(e.getSource() == fourthPanel) {
					ViewUtil.changePanel(friendInfoView, new SelectInfo(friendName[3]));
				} else if(e.getSource() == fifthPanel) {
					ViewUtil.changePanel(friendInfoView, new SelectInfo(friendName[4]));
				} else if(e.getSource() == sixthPanel) {
					ViewUtil.changePanel(friendInfoView, new SelectInfo(friendName[5]));
				} else if(e.getSource() == backPanel) {
					ViewUtil.changePanel(friendInfoView, new MainMenu(MainFrame.mf, CreateCharacterView.chNum));
					System.out.println("메인메뉴 이동");
				}
			} else if(e.getSource() == backPanel) {
				ViewUtil.changePanel(friendInfoView, new MainMenu(MainFrame.mf, CreateCharacterView.chNum));
				System.out.println("메인메뉴 이동");
			}
			
		}
	}
}

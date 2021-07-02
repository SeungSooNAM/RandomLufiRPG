package com.npng.onepiece.friend.view;

import java.awt.Color;
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
import com.npng.onepiece.user.view.MainFrame;


public class SelectInfo extends JPanel{
	
	private MainFrame mf;
	private SelectInfo selectInfo;
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
	
	private JPanel textPanel;
	private JPanel skilPanel;
	
	private JLabel skilName;

	public SelectInfo(MainFrame mf, String name) {
		this.setSize(1200, 800);
		this.mf = mf;
		this.selectInfo = this;
		mf.add(this);
		
		this.setLayout(null);
		
		Font font1 = new Font("Dialog",Font.BOLD, 20);
		Image imgBackground = new ImageIcon("image/friend/friendInfo.png").getImage().getScaledInstance(1200, 750, 0);
		JLabel fi = new JLabel(new ImageIcon(imgBackground));
		fi.setLocation(0, 0);
		fi.setSize(1200, 750);
		this.add(fi);
		
		Image img = new ImageIcon("image/friend/" + name + "이미지.png").getImage().getScaledInstance(600, 450, 0);
		JLabel label = new JLabel(new ImageIcon(img));
		label.setLocation(50, 50);
		label.setSize(600, 450);
		fi.add(label);
		
		
		
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
		
		textPanel = new JPanel();
		textPanel.setLocation(47, 550);
		textPanel.setSize(600, 160);
		textPanel.setOpaque(false);
		fi.add(textPanel);	
		
		skilPanel = new JPanel();
		skilPanel.setLocation(710, 550);
		skilPanel.setSize(450, 160);
		skilPanel.setOpaque(false);
		fi.add(skilPanel);	
		
		skilName = new JLabel(name + " 스킬 설명");
		skilName.setLocation(760, 517);
		skilName.setSize(150, 40);
		skilName.setFont(font1);
		skilName.setForeground(Color.white);
		fi.add(skilName);
		
		
		Image text = new ImageIcon("image/friend/" + name + "설명.png").getImage().getScaledInstance(600, 160, 0);
		JLabel textLabel = new JLabel(new ImageIcon(text));
		textPanel.add(textLabel);
		
		Image skil = new ImageIcon("image/friend/" + name + "스킬설명.png").getImage().getScaledInstance(450, 160, 0);
		JLabel skilLabel = new JLabel(new ImageIcon(skil));
		skilPanel.add(skilLabel);
		
		friendList = new ArrayList<>();
		friendList = friendController.friendInfo();
		System.out.println(friendList);
		
		for(int i = 0; i < friendListLabel.length; i++) {
			friendListLabel[i] = friendList.get(i);
			friendName[i] = friendListLabel[i].getFrName();
			friendGrade[i] = friendListLabel[i].getFrGrade();
		}
		for(int i = 0; i < 6; i++) {
			System.out.println(friendListLabel[i]);
		}
		

		Image first = new ImageIcon("image/friend/" + friendName[0] + "_" + friendGrade[0] + ".png").getImage().getScaledInstance(128, 66, 0);
		JLabel firstLabel = new JLabel(new ImageIcon(first));
		firstLabel.setLocation(712, 65);
		firstLabel.setSize(1200, 800);
		firstPanel.add(firstLabel);
		Image second = new ImageIcon("image/friend/" + friendName[1] + "_" + friendGrade[0] + ".png").getImage().getScaledInstance(128, 66, 0);
		JLabel secondLabel = new JLabel(new ImageIcon(second));
		secondLabel.setLocation(128, 66);
		secondLabel.setSize(1200, 800);
		secondPanel.add(secondLabel);
		Image third = new ImageIcon("image/friend/" + friendName[2] + "_" + friendGrade[0] + ".png").getImage().getScaledInstance(128, 66, 0);
		JLabel thirdLabel = new JLabel(new ImageIcon(third));
		thirdLabel.setLocation(128, 66);
		thirdLabel.setSize(1200, 800);
		thirdPanel.add(thirdLabel);
		Image fourth = new ImageIcon("image/friend/" + friendName[3] + "_" + friendGrade[0] + ".png").getImage().getScaledInstance(128, 66, 0);
		JLabel fourthLabel = new JLabel(new ImageIcon(fourth));
		fourthLabel.setLocation(712, 150);
		fourthLabel.setSize(128, 66);
		fourthPanel.add(fourthLabel);
		Image fifth = new ImageIcon("image/friend/" + friendName[4] + "_" + friendGrade[0] + ".png").getImage().getScaledInstance(128, 66, 0);
		JLabel fifthLabel = new JLabel(new ImageIcon(fifth));
		fifthLabel.setLocation(866, 150);
		fifthLabel.setSize(128, 66);
		fifthPanel.add(fifthLabel);
		Image sixth = new ImageIcon("image/friend/" + friendName[5] + "_" + friendGrade[0] + ".png").getImage().getScaledInstance(128, 66, 0);
		JLabel sixthLabel = new JLabel(new ImageIcon(sixth));
		sixthLabel.setLocation(1016, 150);
		sixthLabel.setSize(128, 66);
		sixthPanel.add(sixthLabel);
		
		

		firstPanel.addMouseListener(new MyMouseAdapter());
		secondPanel.addMouseListener(new MyMouseAdapter());
		thirdPanel.addMouseListener(new MyMouseAdapter());
		fourthPanel.addMouseListener(new MyMouseAdapter());
		fifthPanel.addMouseListener(new MyMouseAdapter());
		sixthPanel.addMouseListener(new MyMouseAdapter());
		
		
	}
	
	public class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == firstPanel) {
				ViewUtil.changePanel(mf, selectInfo, new SelectInfo(mf, friendName[0]));
			} else if(e.getSource() == secondPanel){
				ViewUtil.changePanel(mf, selectInfo, new SelectInfo(mf, friendName[1]));
			} else if(e.getSource() == thirdPanel) {
				ViewUtil.changePanel(mf, selectInfo, new SelectInfo(mf, friendName[2]));
			} else if(e.getSource() == fourthPanel) {
				ViewUtil.changePanel(mf, selectInfo, new SelectInfo(mf, friendName[3]));
			} else if(e.getSource() == fifthPanel) {
				ViewUtil.changePanel(mf, selectInfo, new SelectInfo(mf, friendName[4]));
			} else if(e.getSource() == sixthPanel) {
				ViewUtil.changePanel(mf, selectInfo, new SelectInfo(mf, friendName[5]));
			}		
		}
	}
}

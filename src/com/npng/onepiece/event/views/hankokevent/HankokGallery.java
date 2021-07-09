package com.npng.onepiece.event.views.hankokevent;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;

import com.npng.onepiece.gameready.view.CreateCharacterView;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.MainFrame;

public class HankokGallery extends JPanel{

	private HankokGallery hankokGallery;
	
	private JButton btnFirst;
	private JButton btnSecond;
	private JButton btnThird;
	private JLabel bl;
	
	
	public HankokGallery() {
		this.hankokGallery = this;
		this.setSize(1200, 800);
		MainFrame.mf.add(this);
		
		this.setLayout(null);
		
		int random = (int)(Math.random() * 17) + 1;
		Image img = new ImageIcon("image/sce/hankok/핸콕" + random + ".png").getImage().getScaledInstance(1200, 800, 0);
		bl = new JLabel(new ImageIcon(img));
		bl.setLocation(0, 0);
		bl.setSize(1200, 800);
		this.add(bl);
		

		btnFirst = new JButton("다른 사진");
		btnFirst.setLocation(1060, 600);
		btnFirst.setSize(100, 60);
//		btnFirst.setContentAreaFilled(false);
//		btnFirst.setFocusPainted(false);
		bl.add(btnFirst);
		
		
		
		btnThird = new JButton("나가기");
		btnThird.setLocation(1060, 700);
		btnThird.setSize(100, 60);
//		btnThird.setContentAreaFilled(false);
//		btnThird.setFocusPainted(false);
		bl.add(btnThird);
		

		btnThird.addActionListener(new MyActionListener());
		btnFirst.addActionListener(new MyActionListener());
		
	}
	private class MyActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnThird) {
				ViewUtil.changePanel(hankokGallery, new MainMenu(MainFrame.mf, CreateCharacterView.chNum));
			} else if(e.getSource() == btnFirst) {
				ViewUtil.changePanel(hankokGallery, new HankokGallery());
			}
		}
	}
	
}

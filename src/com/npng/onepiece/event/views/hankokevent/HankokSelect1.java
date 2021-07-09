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

public class HankokSelect1 extends JPanel{

	private HankokSelect1 hankokSelect1;
	
	private JButton btnFirst;
	private JButton btnSecond;
	private JButton btnThird;
	
	
	public HankokSelect1() {
		this.hankokSelect1 = this;
		this.setSize(1200, 800);
		MainFrame.mf.add(this);
		
		this.setLayout(null);
		
		Image img = new ImageIcon("image/sce/hankok/핸콕선택지2.png").getImage().getScaledInstance(1200, 800, 0);
		JLabel bl = new JLabel(new ImageIcon(img));
		bl.setLocation(0, 0);
		bl.setSize(1200, 800);
		this.add(bl);
		
		btnFirst = new JButton((Icon) new ImageIcon("image/sce/hankok/핸콕버튼.png"));
		btnFirst.setLocation(1080, 600);
		btnFirst.setSize(60, 40);
		btnFirst.setContentAreaFilled(false);
		btnFirst.setFocusPainted(false);
		bl.add(btnFirst);
		
		btnSecond = new JButton((Icon) new ImageIcon("image/sce/hankok/핸콕버튼.png"));
		btnSecond.setLocation(1080, 650);
		btnSecond.setSize(60, 40);
		btnSecond.setContentAreaFilled(false);
		btnSecond.setFocusPainted(false);
		bl.add(btnSecond);
		
		btnThird = new JButton((Icon) new ImageIcon("image/sce/hankok/핸콕버튼.png"));
		btnThird.setLocation(1080, 700);
		btnThird.setSize(60, 40);
		btnThird.setContentAreaFilled(false);
		btnThird.setFocusPainted(false);
		bl.add(btnThird);
		
		btnFirst.addActionListener(new MyActionListener());
		btnSecond.addActionListener(new MyActionListener());
		btnThird.addActionListener(new MyActionListener());
		
		
	}
	private class MyActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnSecond) {
				ViewUtil.changePanel(hankokSelect1, new HankokSelect2());
			} else if(e.getSource() == btnFirst) {
				ViewUtil.changePanel(hankokSelect1, new HankokFailed());
			} else if(e.getSource() == btnThird) {
				ViewUtil.changePanel(hankokSelect1, new HankokFailed());
			}
			
		}
	}
}

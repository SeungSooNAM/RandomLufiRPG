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
import com.npng.onepiece.event.controller.EventController;
import com.npng.onepiece.gameready.view.CreateCharacterView;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.MainFrame;

public class HankokSelect3 extends JPanel{

	private HankokSelect3 hankokSelect3;
	private EventController ec = new EventController();
	
	private JButton btnFirst;
	private JButton btnSecond;
	private JButton btnThird;
	
	
	public HankokSelect3() {
		this.hankokSelect3 = this;
		this.setSize(1200, 800);
		MainFrame.mf.add(this);
		
		this.setLayout(null);
		
		Image img = new ImageIcon("image/sce/hankok/핸콕엔딩.png").getImage().getScaledInstance(1200, 800, 0);
		JLabel bl = new JLabel(new ImageIcon(img));
		bl.setLocation(0, 0);
		bl.setSize(1200, 800);
		this.add(bl);
		
		int result = 0;
		
		result = ec.updateHankok();
		
		if(result > 0) {
			System.out.println("핸콕 획득");
		}
		
		btnFirst = new JButton();
		btnFirst.setLocation(700, 600);
		btnFirst.setSize(20, 20);
		btnFirst.setContentAreaFilled(false);
		btnFirst.setFocusPainted(false);
		bl.add(btnFirst);
		
		btnThird = new JButton((Icon) new ImageIcon("image/sce/hankok/핸콕버튼.png"));
		btnThird.setLocation(1060, 700);
		btnThird.setSize(100, 60);
		btnThird.setContentAreaFilled(false);
		btnThird.setFocusPainted(false);
		bl.add(btnThird);
		

		btnThird.addActionListener(new MyActionListener());
		btnFirst.addActionListener(new MyActionListener());
		
	}
	private class MyActionListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnThird) {
				ViewUtil.changePanel(hankokSelect3, new MainMenu(MainFrame.mf, CreateCharacterView.chNum));
			} else if(e.getSource() == btnFirst) {
				ViewUtil.changePanel(hankokSelect3, new HankokGallery());
			} 
			
		}
	}
}

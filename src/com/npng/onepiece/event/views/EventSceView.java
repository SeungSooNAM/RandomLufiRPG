
package com.npng.onepiece.event.views;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.event.model.dto.SceDTO;
import com.npng.onepiece.user.view.MainFrame;

public class EventSceView extends JPanel{
	
	private Image img;
	private MainFrame mf;
	private EventSceView view;
	private SceDTO sce;

	public EventSceView(MainFrame mf) {
		
		this.mf = mf;
		this.view = this;
		
		this.setSize(1200, 800);
		
		mf.add(this);
		
		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/sce/3.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));

		
		this.add(label);
		
		Font font1 = new Font("",0,20);
        
		
		JButton btn1 = new JButton(new ImageIcon("image/sce/1번선택.PNG"));
		btn1.setBounds(930, 560, 120, 70);
		label.add(btn1);
		
		JButton btn2 = new JButton(new ImageIcon("image/sce/2번선택.PNG"));
		btn2.setBounds(930, 650, 120, 90);
		label.add(btn2);
		
		btn1.setBorderPainted(false);
		btn2.setBorderPainted(false);
		
		
		btn1.addMouseListener(new OneActionListener());
		
		
//		btn.addMouseListener(new OneActionListener());
	
		
		
		
		
	}
	private class OneActionListener extends  MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		 ViewUtil.changePanel(mf, view, new EventResultView(mf));
	}
	}


}


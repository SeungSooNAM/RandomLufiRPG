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

public class SelectMapView extends JPanel{

	private Image img;
	private MainFrame mf;
	private SelectMapView view;
	private SceDTO sce;

	public SelectMapView(MainFrame mf) {
		
		this.mf = mf;
		this.view = this;
		this.setSize(1200, 800);
		mf.add(this);
		
		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/sce/지도.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));
		
		this.add(label);
		
		
		JButton btn1 = new JButton(new ImageIcon("image/sce/상디map.PNG"));
		btn1.setBounds(620, 210, 300, 170);
		label.add(btn1);
		
		JButton btn2 = new JButton(new ImageIcon("image/sce/우솝map.PNG"));
		btn2.setBounds(10, 542, 364, 190);
		label.add(btn2);
		
		JButton btn3 = new JButton(new ImageIcon("image/sce/3map.PNG"));
		btn3.setBounds(10, 374, 250, 136);
		label.add(btn3);
		
		
		
//		btn1.setBorderPainted(false);
//		btn2.setBorderPainted(false);
//		btn3.setBorderPainted(false);
		
		
		btn1.addMouseListener(new OneActionListener());
		
		
//		btn.addMouseListener(new OneActionListener());
	
		
		
		
		
	}
	private class OneActionListener extends  MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		 ViewUtil.changePanel(mf, view, new EventSceView(mf));
	}
	}


}


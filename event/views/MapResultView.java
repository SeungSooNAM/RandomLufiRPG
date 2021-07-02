package com.npng.onepiece.event.views;

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

public class MapResultView extends JPanel{
	
	private Image img;
	private MainFrame mf;
	private MapResultView view;
	private SceDTO sce;

	public MapResultView(MainFrame mf,int chNum) {
		
		
		this.mf = mf;
		this.view = this;
		this.setSize(1200, 800);
		mf.add(this);
		
		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/sce/입장불가.PNG").getImage().getScaledInstance(1183, 756, 0);
		label.setIcon(new ImageIcon(img));
		
		this.add(label);

		
		
		this.addMouseListener(new OneActionListener());
		
		
	
		
		
		
		
	}
	private class OneActionListener extends  MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		 ViewUtil.changePanel(mf, view, new SelectMapView(mf));
	}
	}




}

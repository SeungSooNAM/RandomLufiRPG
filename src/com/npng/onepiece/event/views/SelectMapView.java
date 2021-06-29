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
		
		
		
		JButton btn1 = new JButton(new ImageIcon("image/sce/1번섬.PNG"));
		btn1.setBounds(10, 542, 364, 190);
		label.add(btn1);
		
		JButton btn2 = new JButton(new ImageIcon("image/sce/2번섬.PNG"));
		btn2.setBounds(10, 374, 250, 136);
		label.add(btn2);
		
		JButton btn3 = new JButton(new ImageIcon("image/sce/3번섬.PNG"));
		btn3.setBounds(280, 195, 282, 190);
		label.add(btn3);
		
		JButton btn4 = new JButton(new ImageIcon("image/sce/4번섬.PNG"));
		btn4.setBounds(620, 210, 300, 170);
		label.add(btn4);
		
		JButton btn5 = new JButton(new ImageIcon("image/sce/5번섬.PNG"));
		btn5.setBounds(1002, 200, 131, 164);
		label.add(btn5);
		
		JButton btn6 = new JButton(new ImageIcon("image/sce/6번섬.PNG"));
		btn6.setBounds(840, 487, 350, 263);
		label.add(btn6);
		
		JButton btn7 = new JButton(new ImageIcon("image/sce/7번섬.PNG"));
		btn7.setBounds(504, 418, 180, 164);
		label.add(btn7);
		
		JButton exitbtn = new JButton(new ImageIcon("image/sce/메뉴화면으로.PNG"));
		exitbtn.setBounds(517, 631, 128, 90);
		label.add(exitbtn);
//		btn1.setBorderPainted(false);
//		btn2.setBorderPainted(false);
//		btn3.setBorderPainted(false);
//		btn4.setBorderPainted(false);
//		btn5.setBorderPainted(false);
//		btn6.setBorderPainted(false);
//		btn7.setBorderPainted(false);
		exitbtn.setBorderPainted(false);
		
		
		btn1.addMouseListener(new OneActionListener());
		
		
//		btn.addMouseListener(new OneActionListener());
	
		
		btn7.addMouseListener(new BossActionListener());
		exitbtn.addMouseListener(new BossActionListener());
		
		
	}
	private class BossActionListener extends  MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
		 ViewUtil.changePanel(mf, view, new MapResultView(mf));
	}
		
	}
	private class OneActionListener extends  MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			ViewUtil.changePanel(mf, view, new EventSceView(mf));
		}
	}
	private class ExitActionListener extends  MouseAdapter {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			ViewUtil.changePanel(mf, view, new EventSceView(mf));
		}
	}


}


package com.npng.onepiece.gameready.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.view.MainFrame;

public class Openning2 extends JPanel {

	private Openning2 op2;
	private MainFrame mainFrame;
	private int chNum;
	public Openning2(MainFrame mainFrame, int chNum) {
		
		this.chNum = chNum;
		this.op2 = this;
		this.mainFrame = mainFrame;
		JPanel panel = new JPanel();
		Image background = new ImageIcon("image/cre_character/op2.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label1 = new JLabel(new ImageIcon(background));
		label1.setSize(1200, 800);

		this.setSize(1200, 800);
		this.setLayout(null);
		this.add(label1);

		JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));
		nextBtn.setBounds(940, 600, 130, 50);
		label1.add(nextBtn);	
	
		nextBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, op2, new Openning3(mainFrame, chNum));				
			}
		});
		
		
			
		
	}
}

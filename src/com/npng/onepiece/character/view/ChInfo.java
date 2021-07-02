package com.npng.onepiece.character.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.user.view.MainFrame;

public class ChInfo extends JPanel {

	private ChInfo charInfo;
	private JFrame mf;
	
	public ChInfo(MainFrame mf) {
		this.charInfo = this;
		this.mf = mf;		
		
		Image background = new ImageIcon("image/character/cinfo.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label = new JLabel(new ImageIcon(background));
		label.setSize(1200, 800);

		this.setSize(1200, 800);
		this.setLayout(null);
		this.add(label);
		
		JLabel str = new JLabel("10");
		str.setForeground(Color.white);
		str.setFont(str.getFont().deriveFont(40.0f));
		str.setBounds(300, 99, 130, 130);		
		
		JLabel dex = new JLabel("10");
		dex.setForeground(Color.white);
		dex.setFont(str.getFont().deriveFont(40.0f));
		dex.setBounds(300, 164, 130, 130);		
		
		JLabel cha = new JLabel("10");
		cha.setForeground(Color.white);
		cha.setFont(str.getFont().deriveFont(40.0f));
		cha.setBounds(300, 233, 130, 130);		
		
		label.add(str);
		label.add(dex);
		label.add(cha);		
		
	}
}

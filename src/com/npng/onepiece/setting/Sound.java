package com.npng.onepiece.setting;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.sound.Playsound;
import com.npng.onepiece.user.view.MainFrame;

public class Sound extends JPanel {
	
	private Sound sound;
	private MainFrame mainFrame; 
	private Image icon;
	
	public Sound(MainFrame mainFrame) {
		 this.setSize(1200,800);
		 this.mainFrame = mainFrame;
		 this.sound = this;
		 
		 JLabel  imgLabel = new JLabel(new ImageIcon());
		 this.icon = new ImageIcon("image/mainMenu/soundbackground.PNG").getImage().getScaledInstance(1200, 800, 0);
	     imgLabel.setIcon(new ImageIcon(icon));
	     
	     JButton btnSoundConfirm = new JButton(new ImageIcon("image/btn/soundsetting.PNG"));
	     btnSoundConfirm.setBounds(420, 20, 350, 80);
	     
	     
	     JButton btnOn = new JButton("ON");
	     btnOn.setFont(new Font("두꺼운",Font.BOLD,50));
	     btnOn.setBounds(150, 250, 150, 150);
	     btnOn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Playsound.clip.start();
					
				}
			});
	    
	     
	     JButton btnOff = new JButton("OFF");
	     btnOff.setFont(new Font("두꺼운", Font.BOLD,50));
	     btnOff.setBounds(900, 250, 150, 150);
	     btnOff.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Playsound.clip.stop();
					
				}
			});
	     
	     JButton btnBack = new JButton(new ImageIcon("image/btn/back.PNG"));
	      btnBack.setBounds(740, 652, 350, 80);
	      btnBack.addActionListener(new ActionListener() {
	          
	          @Override
	          public void actionPerformed(ActionEvent e) {
	             ViewUtil.changePanel(mainFrame, sound,new Setting(mainFrame));            
	          }
	       });
	     this.add(imgLabel);
	     imgLabel.add(btnSoundConfirm);
	     imgLabel.add(btnOn);
	     imgLabel.add(btnOff);
	     imgLabel.add(btnBack);
	}
}

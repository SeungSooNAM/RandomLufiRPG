package com.npng.onepiece.gameready.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.gameready.controller.GameReadyController;
import com.npng.onepiece.user.view.MainFrame;

public class CreateCharacterView extends JPanel {

	GameReadyController gc = new GameReadyController();

	private CreateCharacterView createCharacterView;
	private MainFrame mainFrame;

	public CreateCharacterView(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;
		this.createCharacterView = this; 
		System.out.println(createCharacterView);
		Image background = new ImageIcon("image/cre_character/1234.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label = new JLabel(new ImageIcon(background));
		label.setSize(1200, 800);

		this.setSize(1200, 800);
		this.setLayout(null);

		JButton stBtn = new JButton(new ImageIcon("image/cre_character/up_btn.png"));
		JButton backBtn = new JButton(new ImageIcon("image/cre_character/back_btn.png"));
		JButton createBtn = new JButton(new ImageIcon("image/cre_character/cre_btn.png"));

		stBtn.setBounds(530, 355, 30, 30);
		backBtn.setBounds(1068, 25, 67, 37);
		createBtn.setBounds(190, 550, 300, 100);

		JLabel nameLabel = new JLabel("캐릭터의 이름을 정해주세요");
		nameLabel.setBounds(390, 18, 500, 35);

		Font font1 = new Font("", 0, 35);

		JTextField chname = new JTextField();
		chname.setBounds(408, 50, 405, 35);
		nameLabel.setFont(font1);

		this.add(nameLabel);
		this.add(chname);
		this.add(stBtn);
		this.add(backBtn);
		this.add(createBtn);
		this.add(label);
		
		
		createBtn.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked (MouseEvent e) {
				ViewUtil.changePanel(mainFrame, createCharacterView, new Openning1(mainFrame));
				}
			});
		
			
			
	
		

	

	}

}
package com.npng.onepiece.gameready.view;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.npng.onepiece.gameready.controller.GameReadyController;

public class CreateCharacterView extends JFrame {

	GameReadyController gc = new GameReadyController();

	public CreateCharacterView() {
		super("캐릭터생성창");

		openning1();
//		createCharacter();

		this.setBounds(300, 150, 1200, 800);
		this.setLayout(null);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void createCharacter() {

		JPanel panel = new JPanel();
		Image background = new ImageIcon("image/cre_character/1234.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label = new JLabel(new ImageIcon(background));
		label.setSize(1200, 800);

		panel.setSize(1200, 800);
		panel.setLayout(null);
		
		
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
		
		
		panel.add(nameLabel);
		panel.add(chname);
		panel.add(stBtn);
		panel.add(backBtn);
		panel.add(createBtn);
		panel.add(label);
		add(panel);

	}
	
	public void openning1() {
		
		JPanel panel = new JPanel();
		Image background = new ImageIcon("image/cre_character/op1.png").getImage().getScaledInstance(1200, 800, 0);









		JLabel label1 = new JLabel(new ImageIcon(background));
		label1.setSize(1200, 800);

		panel.setSize(1200, 800);
		panel.setLayout(null);
		
		JButton nextBtn = new JButton(new ImageIcon("image/cre_character/skip_btn.png"));
		nextBtn.setBounds(940, 600, 150, 100);
		
		panel.add(nextBtn);
		panel.add(label1);
		add(panel);
		
	}

}
package com.npng.onepiece.gameready.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.npng.onepiece.gameready.controller.GameReadyController;

public class CreateCharacterView extends JFrame {

	GameReadyController gc = new GameReadyController();
	
	public CreateCharacterView() {
	super("캐릭터생성창");	
	this.setBounds(300, 150, 1400, 800);
	
	JPanel panel = new JPanel();
	
	}
}

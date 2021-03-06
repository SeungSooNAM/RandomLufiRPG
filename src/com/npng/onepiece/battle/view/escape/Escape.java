package com.npng.onepiece.battle.view.escape;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.battle.controller.BattleController;
import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.gameready.view.CreateCharacterView;
import com.npng.onepiece.mainMenu.MainMenu;
import com.npng.onepiece.user.view.MainFrame;

public class Escape extends JPanel{

	private Escape escape;
	private BattleController battleController = new BattleController();
	private JLabel bl;
	private BattleDTO battleInfo;

	public Escape(BattleDTO battleInfo){
		this.setSize(1200, 800);
		this.escape = this;
		this.battleInfo = battleInfo;
		this.setLayout(null);
		
		
		Image img = new ImageIcon("image/battle/도망가기.png").getImage().getScaledInstance(800, 600, 0);
		bl = new JLabel(new ImageIcon(img));
		bl.setLocation(0, 0);
		bl.setSize(1200, 800);
		this.add(bl);
		bl.addMouseListener(new MyMouseAdapter());;
	}
	




	private class MyMouseAdapter extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == bl) {
				System.out.println("도망");
				System.out.println(battleInfo.getcExp());
				ViewUtil.changePanel(escape, new MainMenu(MainFrame.mf, CreateCharacterView.chNum));   //메인메뉴 연결
			}
		}
	}

}

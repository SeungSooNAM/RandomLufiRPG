package com.npng.onepiece.battle.view.skill;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.battle.controller.BattleController;
import com.npng.onepiece.battle.model.dto.BattleDTO;
import com.npng.onepiece.battle.model.dto.FriendDTO;

public class SkillAttackView extends JPanel{
	
	private SkillAttackView skillAttackView;
	private BattleController battleController = new BattleController();
	private JLabel bl;
	private BattleDTO battleInfo;
	private FriendDTO friend[] = new FriendDTO[6];

	public SkillAttackView(BattleDTO battleInfo, int num, String grade) {
		this.setSize(1200, 800);
		this.skillAttackView = this;
		this.battleInfo = battleInfo;
		this.setLayout(null);
		
		
		int cCharisma = battleInfo.getcCharisma();
		List<FriendDTO> friendList = battleInfo.getFriendList();
		FriendDTO zoro = friendList.get(num - 1);
		int Skill = zoro.getFrSkill();
		System.out.println(Skill);
		if(grade.equals("normal")) {
			Skill += cCharisma;
		} else {
			Skill += cCharisma;
			Skill *= 1.2;
		}
		
		System.out.println(Skill + "의 데미지를 가했습니다.");
		Image img = new ImageIcon("image/battle/skill/" + num + "_" + grade + ".png").getImage().getScaledInstance(1200, 800, 0);
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
				System.out.println("스킬공격");
				System.out.println("skill" + battleInfo);
				battleController.Monsterattack(skillAttackView, battleInfo);
			}
		}
	}
}

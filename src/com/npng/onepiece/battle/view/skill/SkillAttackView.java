package com.npng.onepiece.battle.view.skill;

import java.awt.Color;
import java.awt.Font;
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
	private JPanel skillDamage;
	private JLabel damage;

	public SkillAttackView(BattleDTO battleInfo, FriendDTO friend) {
		this.setSize(1200, 800);
		this.skillAttackView = this;
		this.battleInfo = battleInfo;
		this.setLayout(null);
		
		Font font = new Font("SansSerif",Font.BOLD, 35);
		
		int cCharisma = battleInfo.getcCharisma();
		int Skill = friend.getFrSkill();
		int num = friend.getFrNum();
		String grade = friend.getFrGrade();
		String text = "";
		if(num != 6) {
			text = "Damage!";
		} else {
			text = "MP/HP Heal!";
		}
		
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
		
		skillDamage = new JPanel();
		skillDamage.setBounds(50, 700, 250, 100);
		bl.add(skillDamage);
		
		
		damage = new JLabel(Skill + " " + text);
		damage.setFont(font);
		damage.setForeground(Color.red);
		skillDamage.add(damage);
		
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

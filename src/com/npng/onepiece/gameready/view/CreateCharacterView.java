package com.npng.onepiece.gameready.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.gameready.controller.GameReadyController;
import com.npng.onepiece.gameready.model.dto.NewCharacterDTO;
import com.npng.onepiece.user.view.MainFrame;

public class CreateCharacterView extends JPanel {
	
	public static int chNum;

	GameReadyController gc = new GameReadyController();

	private NewCharacterDTO newDto;
	private CreateCharacterView createCharacterView;
	private MainFrame mainFrame;
	private int uNum;
	private String name;
	private JTextField chname;

	public CreateCharacterView(MainFrame mainFrame, int uNum) {

		this.uNum = uNum;
		
		this.newDto = new NewCharacterDTO();
		this.mainFrame = mainFrame;
		this.createCharacterView = this;
		System.out.println(createCharacterView);
		Image background = new ImageIcon("image/cre_character/cre1234.png").getImage().getScaledInstance(1200, 800, 0);

		JLabel label = new JLabel(new ImageIcon(background));
		label.setSize(1200, 800);

		this.setSize(1200, 800);
		this.setLayout(null);

		JButton stBtn = new JButton(new ImageIcon("image/cre_character/up_btn.png"));
		stBtn.setContentAreaFilled(false);
		stBtn.setFocusPainted(false);
		stBtn.setBounds(500, 355, 30, 30);		
		
		JButton backBtn = new JButton();
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setBounds(1085, 25, 75, 39);
		
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewUtil.changePanel(mainFrame, createCharacterView, new CharacterTutorial(mainFrame, uNum));				
			}
		});		
		
		
		JButton createBtn = new JButton(new ImageIcon("image/cre_character/cre_btn.png"));
		createBtn.setContentAreaFilled(false);
		createBtn.setFocusPainted(false);
		createBtn.setBounds(700, 300, 300, 100);


		JLabel str = new JLabel();
		str.setForeground(Color.white);
		str.setFont(str.getFont().deriveFont(40.0f));
		str.setBounds(360, 107, 130, 130);
		JLabel dex = new JLabel();
		dex.setForeground(Color.white);
		dex.setFont(str.getFont().deriveFont(40.0f));
		dex.setBounds(360, 165, 130, 130);
		JLabel cha = new JLabel();
		cha.setForeground(Color.white);
		cha.setFont(str.getFont().deriveFont(40.0f));
		cha.setBounds(360, 225, 130, 130);

		JLabel nameLabel = new JLabel();
		nameLabel.setBounds(660, 220, 410, 50);

		chname = new JTextField();
		chname.setSize(410, 50);
		nameLabel.add(chname);

		this.add(str);
		this.add(dex);
		this.add(cha);
		this.add(stBtn);
		this.add(backBtn);
		this.add(createBtn);
		this.add(label);

		this.repaint();
		this.revalidate();
		this.add(nameLabel);

		stBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int num = 0;

				int tstr = randomstatus();
				int tdex = randomstatus();
				int tcha = 30 - tstr - tdex;

				str.setText(tstr + "");
				dex.setText(tdex + "");
				cha.setText(tcha + "");
				
				// ??????????????? ?????? ????????? ??????????????? ????????? ??????, ?????? ??????, ????????? ??????
				int level = 1;
				int cstr = Integer.parseInt(str.getText());
				int cdex = Integer.parseInt(dex.getText());
				int ccha = Integer.parseInt(cha.getText());
				int chp = 100;
				int cmp = 100;
				int catk = 0;
				int life = 5;
				int exp = 0;
				int point = 0;
				int score = 0;
//				int userNum = uNum;

				// dto??? ??????????????? ????????? ?????? ????????????
				newDto.setUserNum(uNum);
				newDto.setLevel(level);
				newDto.setAtk(catk);
				newDto.setHp(chp);
				newDto.setLife(life);
				newDto.setExp(exp);
				newDto.setStr(cstr);
				newDto.setDex(cdex);
				newDto.setCharisma(ccha);
				newDto.setPoint(point);
				newDto.setMp(cmp);
				newDto.setScore(score);

			}
		});

		createBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				name = chname.getText();
				newDto.setName(name);
				GameReadyController gr = new GameReadyController();
				int result = new GameReadyController().insertNewCharacter(newDto);
				if (result  == 3) {
					chNum = gr.searchChNum(uNum); //??????????????? ????????????
					System.out.println("cNum : " + chNum);
					ViewUtil.changePanel(mainFrame, createCharacterView, new OkCreateCharacter(mainFrame, chNum));
				}

			}
		});
	}

	public int randomstatus() {

		int result = (int) (Math.random() * 10) + 5;

		return result;
	}

	//????????? ???????????? ??????
	public class OkCreateCharacter extends JPanel {
		private OkCreateCharacter ok;
		private MainFrame mf;
		private int chNum;
		

		public OkCreateCharacter(MainFrame mf , int chNum) {
			this.ok = this;
			this.mf = mf;
			this.chNum = chNum;

			Image background = new ImageIcon("image/tutorial/okcc.png").getImage().getScaledInstance(1200, 800, 0);

			JLabel label1 = new JLabel(new ImageIcon(background));
			label1.setSize(1200, 800);

			this.setSize(1200, 800);
			this.setLayout(null);
			this.add(label1);

			JButton nextBtn = new JButton(new ImageIcon("image/cre_character/next123.png"));

			nextBtn.setBounds(940, 650, 130, 50);
			label1.add(nextBtn);
			nextBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ViewUtil.changePanel(mf, ok, new Openning1(mf, chNum));
				}
			});
		}
	}

}
package com.npng.onepiece.gameready.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.npng.onepiece.common.ViewUtil;
import com.npng.onepiece.user.view.MainFrame;

public class ShopTutorial extends JPanel {
	private MainFrame mf;
	private ShopTutorial st;
	private Image img;
	public ShopTutorial(MainFrame mf,int cn) {
		JLabel MoneyLabel = new JLabel("소지금 : 1000G");
		
		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.st = this;
		
		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/shop/store_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));
		
		JLabel TBoard = new JLabel(new ImageIcon());
		Image img2 = new ImageIcon("image/shop/TBoard1.PNG").getImage().getScaledInstance(600, 300, 0);
		TBoard.setIcon(new ImageIcon(img2));
		
		JButton buttonItem1 = new JButton(new ImageIcon("image/shop/item/7.PNG"));
		buttonItem1.setBounds(50, 100, 90, 90);
		
		Font font = new Font("맑은 고딕", Font.PLAIN, 30);
		MoneyLabel.setFont(font); 
		MoneyLabel.setBounds(950, 5, 300, 100);
		
		TBoard.setBounds(200, 480, 600, 300);
		
		buttonItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				ViewUtil.changePanel(mf, st, new ShopTutorial1(mf, cn));

			}

		});
		
		
		
		label.add(buttonItem1);
		
		label.add(TBoard);
		label.add(MoneyLabel);
		
		this.add(label);
		this.repaint();
		this.revalidate();

		
	}
	
	public class ShopTutorial1 extends JPanel{
		private MainFrame mf;
		private ShopTutorial1 st;
		private Image img;
		public ShopTutorial1(MainFrame mf,int cn) {
			JLabel MoneyLabel = new JLabel("소지금 : 1000G");
			
			this.setBounds(0, 0, 1200, 800);
			this.mf = mf;
			this.st = this;
			
			JLabel label = new JLabel(new ImageIcon());
			this.img = new ImageIcon("image/shop/store_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
			label.setIcon(new ImageIcon(img));
			
			JLabel TBoard = new JLabel(new ImageIcon());
			Image img1 = new ImageIcon("image/shop/TBoard2.PNG").getImage().getScaledInstance(600, 300, 0);
			TBoard.setIcon(new ImageIcon(img1));
			
			JLabel labelBoard = new JLabel(new ImageIcon());
			Image img2 = new ImageIcon("image/shop/TinfoBoard.PNG").getImage().getScaledInstance(300, 615, 0);
			labelBoard.setIcon(new ImageIcon(img2));
			
			JButton buttonItem1 = new JButton(new ImageIcon("image/shop/item/7.PNG"));
			JButton buttonBuy = new JButton(new ImageIcon("image/shop/buttonBuy.PNG"));
			
			labelBoard.setBounds(780, 50, 310, 620);
			
		
			Font font = new Font("맑은 고딕", Font.PLAIN, 30);
			MoneyLabel.setFont(font);
			MoneyLabel.setBounds(950, 5, 300, 100);
			buttonItem1.setBounds(50, 100, 90, 90);
			buttonBuy.setBounds(820, 600, 100, 35);
			
			TBoard.setBounds(200, 480, 600, 300);
			
			buttonBuy.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int i = 0;
					ViewUtil.changePanel(mf, st, new ShopTutorial2(mf, cn));

				}

			});
			
			label.add(buttonItem1);
			label.add(buttonBuy);
			
			label.add(labelBoard);
			
			
			
			label.add(TBoard);
			label.add(MoneyLabel);
			
			this.add(label);
			this.repaint();
			this.revalidate();
		}
	}
	
public class ShopTutorial2 extends JPanel{
	private MainFrame mf;
	private ShopTutorial2 st;
	private Image img;
	public ShopTutorial2(MainFrame mf,int cn) {
JLabel MoneyLabel = new JLabel("소지금 : 900G");
		
		this.setBounds(0, 0, 1200, 800);
		this.mf = mf;
		this.st = this;
		
		JLabel label = new JLabel(new ImageIcon());
		this.img = new ImageIcon("image/shop/store_bg.PNG").getImage().getScaledInstance(1200, 800, 0);
		label.setIcon(new ImageIcon(img));
		
		JLabel TBoard = new JLabel(new ImageIcon());
		Image img1 = new ImageIcon("image/shop/TBoard3.PNG").getImage().getScaledInstance(600, 300, 0);
		TBoard.setIcon(new ImageIcon(img1));
	
		
		JButton buttonItem1 = new JButton(new ImageIcon("image/shop/item/7.PNG"));
		JButton buttonMyItem1 = new JButton(new ImageIcon("image/shop/item/7.PNG"));
		
		JButton buttonExit = new JButton(new ImageIcon("image/shop/buttonExit.PNG"));
		
	
		Font font = new Font("맑은 고딕", Font.PLAIN, 30);
		MoneyLabel.setFont(font);
		MoneyLabel.setBounds(950, 5, 300, 100);
		buttonItem1.setBounds(50, 100, 90, 90);
		buttonMyItem1.setBounds(50, 480, 90, 90);
		TBoard.setBounds(200, 480, 600, 300);
		buttonExit.setBounds(1000, 690, 190, 65);
		
		buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				ViewUtil.changePanel(mf, st, new TutorialMenu(mf, cn));

			}

		});
		
		label.add(buttonItem1);
		label.add(buttonMyItem1);
		label.add(TBoard);
		label.add(MoneyLabel);
		label.add(buttonExit);
		this.add(label);
		this.repaint();
		this.revalidate();
	}
	}
}

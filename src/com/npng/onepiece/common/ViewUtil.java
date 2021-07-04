package com.npng.onepiece.common;

import javax.swing.JPanel;

import com.npng.onepiece.user.view.MainFrame;

public class ViewUtil {


	public static void changePanel(MainFrame mf, JPanel op, JPanel np) {
        mf.remove(op);
        mf.add(np);
        mf.repaint();
        mf.revalidate();
    }
	
	public static void changePanel(JPanel op, JPanel np) {
        MainFrame.mf.remove(op);
        MainFrame.mf.add(np);
        MainFrame.mf.repaint();
        MainFrame.mf.revalidate();
    }
}

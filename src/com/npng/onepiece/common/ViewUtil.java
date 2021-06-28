package com.npng.onepiece.common;

import javax.swing.JPanel;

import com.npng.onepiece.user.view.LoginView;

public class ViewUtil {

haechan_0628_2
	public static void changePanel(LoginView mf, JPanel op, JPanel np) {
        mf.remove(op);
        mf.add(np);
        mf.repaint();
        mf.revalidate();
    }
}

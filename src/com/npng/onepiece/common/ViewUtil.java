package com.npng.onepiece.common;

import javax.swing.JPanel;

public class ViewUtil {

	public static void changePanel(LoginView mf, JPanel op, JPanel np) {
        mf.remove(op);
        mf.add(np);
        mf.repaint();
        mf.revalidate();
    }
}

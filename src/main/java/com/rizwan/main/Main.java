package com.rizwan.main;

import com.rizwan.action.LoginPanel;
import com.rizwan.gui.LoginForm;

public class Main {
    public static void main(String[] args)
    {
//        LoginPanel.letsLogin();

        new LoginForm().action();


        /**
         *
         * javax.swing.SwingUtilities.invokeLater(new Runnable() {
         *             public void run() {
         *                 new MainDashboard();
         *             }
         *         });
         */
    }
}

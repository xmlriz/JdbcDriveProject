package com.rizwan.gui;

import com.rizwan.service.LoginService;

import javax.swing.*;
public class LoginForm
{
    private JFrame frm;
    private JLabel usernamelb , passwordlb;
    private JTextField usernametf;
    private JPasswordField passwordtf;
    private  JButton loginbtn , clearbtn;

    public LoginForm()
    {
        frm = new JFrame("Login form");
        usernamelb = new JLabel("USername: ");
        passwordlb = new JLabel("Password: ");
        usernametf = new JTextField();
        passwordtf = new JPasswordField();
        loginbtn = new JButton("Login");
        clearbtn = new JButton("Clear");

    }

    public void action()
    {
        frm.setLayout(null);
        frm.setVisible(true);
        frm.setBounds(100,100,500,500);
        usernamelb.setBounds(50,100,100,40);
        passwordlb.setBounds(50,150,100,40);
        usernametf.setBounds(120,100,100,40);
        passwordtf.setBounds(120,150,100,40);
        loginbtn.setBounds(110,200,70,50);
        clearbtn.setBounds(200,200,70,50);

        frm.add(usernamelb);
        frm.add(passwordlb);
        frm.add(usernametf);
        frm.add(passwordtf);
        frm.add(loginbtn);
        frm.add(clearbtn);

        loginbtn.addActionListener(e ->
        {
            String username = usernametf.getText();
            String password = passwordtf.getText();

            if(username.isBlank() || password.isBlank()){
                JOptionPane.showMessageDialog(frm,"Login failed","Login status",JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(LoginService.isUserValid(username,password))
            {
                JOptionPane.showMessageDialog(frm,"Login success","login status",JOptionPane.INFORMATION_MESSAGE);
                frm.dispose();
                new Dashboard();
            }

            else
            {
                JOptionPane.showMessageDialog(frm,"Login failed","Login status",JOptionPane.ERROR_MESSAGE);
            }

        });

    }
}

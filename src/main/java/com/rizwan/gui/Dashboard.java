package com.rizwan.gui;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class Dashboard {

        private JFrame frame;
        private JDesktopPane desktopPane;

        private JMenuBar menuBar;
        private JMenu userMenu;
        private JMenu productMenu;
        private JMenu salesMenu;
        private JMenu systemMenu;

        private JMenuItem viewUsersItem;
        private JMenuItem addUsersItem;
        private JMenuItem viewProductsItem;
        private JMenuItem viewSalesItem;
        private JMenuItem logoutItem;

        private Color primaryColor = new Color(44, 62, 80);
        private Color backgroundColor = new Color(236, 240, 241);

        public Dashboard() {
            createAndShowGUI();
        }

        private void createAndShowGUI() {
            frame = new JFrame("Desktop Dashboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1024, 768);

            desktopPane = new JDesktopPane();
            desktopPane.setBackground(backgroundColor);

            menuBar = new JMenuBar();

            userMenu = new JMenu("User");
            viewUsersItem = new JMenuItem("View Users");
            addUsersItem = new JMenuItem("Add User");
            userMenu.add(viewUsersItem);
            userMenu.add(addUsersItem);

            productMenu = new JMenu("Product");
            viewProductsItem = new JMenuItem("View Products");
            productMenu.add(viewProductsItem);

            salesMenu = new JMenu("Sales");
            viewSalesItem = new JMenuItem("View Sales");
            salesMenu.add(viewSalesItem);

            systemMenu = new JMenu("System");
            logoutItem = new JMenuItem("Logout");
            systemMenu.add(logoutItem);

            menuBar.add(userMenu);
            menuBar.add(productMenu);
            menuBar.add(salesMenu);
            menuBar.add(systemMenu);

            viewUsersItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    createInternalFrame("User Management");
                }
            });

            addUsersItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    createInternalFrame("Add New User");
                }
            });

            viewProductsItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    createInternalFrame("Product Inventory");
                }
            });

            viewSalesItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    createInternalFrame("Sales Records");
                }
            });

            logoutItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });

            frame.setJMenuBar(menuBar);
            frame.add(desktopPane, BorderLayout.CENTER);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        private void createInternalFrame(String title) {
            JInternalFrame internalFrame = new JInternalFrame(title, true, true, true, true);
            internalFrame.setSize(400, 300);
            internalFrame.setLocation(30, 30);
            internalFrame.setLayout(new BorderLayout());

            JLabel label = new JLabel(title, JLabel.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            label.setForeground(primaryColor);
            internalFrame.add(label, BorderLayout.CENTER);

            desktopPane.add(internalFrame);
            internalFrame.setVisible(true);
        }

    }

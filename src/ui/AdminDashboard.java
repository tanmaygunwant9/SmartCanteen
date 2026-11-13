package ui;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    public AdminDashboard(){

        setTitle("Admin Dashboard");
        setSize(500,300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3,1,20,20));

        GradientButton menu = new GradientButton("Manage Menu");
        GradientButton orders = new GradientButton("View Orders");
        GradientButton back = new GradientButton("Back");

        add(menu);
        add(orders);
        add(back);

        menu.addActionListener(e -> new MenuManagerUI(this));
        orders.addActionListener(e -> new OrderViewerUI(this));

        back.addActionListener(e -> {
            new LoginUI();
            dispose();
        });

        setVisible(true);
    }
}
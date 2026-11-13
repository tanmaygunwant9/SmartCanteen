package ui;

import javax.swing.*;
import java.awt.*;
import model.FileManager;

public class RegisterUI extends JFrame {

    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();

    public RegisterUI(){

        setTitle("Register");
        setSize(300,200);
        setLocationRelativeTo(null);

        JButton register = new JButton("Register");
        JButton back = new JButton("Back");

        setLayout(new GridLayout(4,2));

        add(new JLabel("Username"));
        add(username);
        add(new JLabel("Password"));
        add(password);
        add(register);
        add(back);

        register.addActionListener(e -> {
            FileManager.registerStudent(
                username.getText(),
                new String(password.getPassword())
            );
            JOptionPane.showMessageDialog(this,"Registered!");
        });

        back.addActionListener(e -> {
            new LoginUI();
            dispose();
        });

        setVisible(true);
    }
}
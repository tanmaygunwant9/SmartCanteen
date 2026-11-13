package ui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

import model.FileManager;

public class LoginUI extends JFrame {

    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();

    public LoginUI() {

        setTitle("Smart Canteen Login");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(4, 2, 10, 10));

        add(label("Username"));
        add(username);
        add(label("Password"));
        add(password);

        JButton login = button("Login");
        JButton register = button("Register");
        JButton admin = button("Admin");

        add(login);
        add(register);
        add(admin);

        login.addActionListener(e -> loginUser());

        register.addActionListener(e -> {
            new RegisterUI();
            dispose();
        });

        admin.addActionListener(e -> showAdminLogin());

        setVisible(true);
    }

    JLabel label(String t) {
        JLabel l = new JLabel(t);
        l.setForeground(Color.BLACK);
        return l;
    }

    JButton button(String text){
        JButton b = new JButton(text);
        b.setBackground(new Color(41,128,185));
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Arial",Font.BOLD,14));
        b.setFocusPainted(false);
        b.setOpaque(true);
        b.setBorderPainted(false);
        return b;
    }

    void loginUser() {
        if (FileManager.loginStudent(username.getText(), new String(password.getPassword()))) {
            new StudentDashboard(username.getText());
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Login");
        }
    }

    // 🔐 ADMIN SECURITY
    void showAdminLogin() {

        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();

        Object[] msg = {
                "Admin Username:", userField,
                "Admin Password:", passField
        };

        int option = JOptionPane.showConfirmDialog(
                this, msg, "Admin Login",
                JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {

            String user = userField.getText().trim();
            String pass = new String(passField.getPassword()).trim();

            boolean isValid = false;

            try {
                BufferedReader br = new BufferedReader(new FileReader("data/admin.txt"));
                String line;

                while ((line = br.readLine()) != null) {

                    String[] parts = line.split(",");

                    if (parts.length == 2) {
                        String fileUser = parts[0].trim();
                        String filePass = parts[1].trim();

                        if (user.equals(fileUser) && pass.equals(filePass)) {
                            isValid = true;
                            break;
                        }
                    }
                }

                br.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error reading admin file");
            }

            if (isValid) {
                new AdminDashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Admin Credentials");
            }
        }
    }
}
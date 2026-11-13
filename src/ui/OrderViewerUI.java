package ui;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class OrderViewerUI extends JFrame {

    JFrame prev;

    public OrderViewerUI(JFrame p) {
        prev = p;

        setTitle("Orders");
        setSize(400, 400);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        add(new JScrollPane(area), BorderLayout.CENTER);

        JButton back = new JButton("Back");
        add(back, BorderLayout.SOUTH);

        back.addActionListener(e -> {
            prev.setVisible(true);
            dispose();
        });

        try (BufferedReader br = new BufferedReader(new FileReader("data/orders.txt"))) {
            String line;
            while ((line = br.readLine()) != null)
                area.append(line + "\n");
        } catch (Exception e) {
        }

        setVisible(true);
    }
}
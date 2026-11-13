package ui;

import javax.swing.*;
import java.awt.*;

public class GradientButton extends JButton {

    private Color c1 = new Color(52,152,219);
    private Color c2 = new Color(41,128,185);

    public GradientButton(String text){
        super(text);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 14));
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g.create();
        GradientPaint gp = new GradientPaint(0,0,c1,0,getHeight(),c2);
        g2.setPaint(gp);
        g2.fillRoundRect(0,0,getWidth(),getHeight(),15,15);
        g2.dispose();
        super.paintComponent(g);
    }
}
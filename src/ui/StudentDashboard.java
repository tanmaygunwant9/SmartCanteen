package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import model.Cart;
import model.FileManager;

public class StudentDashboard extends JFrame {

    String username;
    DefaultTableModel model;

    public StudentDashboard(String user){

        username = user;

        setTitle("Smart Canteen");
        setSize(700,400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // SIDEBAR
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(44,62,80));
        sidebar.setLayout(new GridLayout(4,1,10,10));

        GradientButton menu = new GradientButton("Menu");
        GradientButton cart = new GradientButton("Cart");
        GradientButton order = new GradientButton("Order");
        GradientButton logout = new GradientButton("Logout");

        sidebar.add(menu);
        sidebar.add(cart);
        sidebar.add(order);
        sidebar.add(logout);

        add(sidebar, BorderLayout.WEST);

        // TABLE
        model = new DefaultTableModel(new String[]{"Item","Price"},0);
        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        menu.addActionListener(e -> showMenu());
        cart.addActionListener(e -> loadCart());
        order.addActionListener(e -> placeOrder());

        logout.addActionListener(e -> {
            new LoginUI();
            dispose();
        });

        setVisible(true);
    }

    String generateToken(){
        return "TKN-" + java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss"));
    }

    void showMenu(){
    try{
        BufferedReader br = new BufferedReader(new FileReader("data/menu.txt"));
        java.util.ArrayList<String> list = new java.util.ArrayList<>();
        String line;

        while((line = br.readLine()) != null)
            list.add(line);

        br.close();

        String item = (String) JOptionPane.showInputDialog(
                this,
                "Select Food",
                "Menu",
                JOptionPane.PLAIN_MESSAGE,
                null,
                list.toArray(),
                list.get(0)
        );

        if(item != null){

            // ✅ Add item to cart
            Cart.addItem(item);

            // ✅ Calculate total
            int total = 0;
            for(String i : Cart.getItems()){
                String[] parts = i.split(",");
                total += Integer.parseInt(parts[1]);
            }

            // ✅ Show message
            String itemName = item.split(",")[0];

            JOptionPane.showMessageDialog(this,
                    "Added: " + itemName +
                    "\nCurrent Total: ₹" + total);

            // ✅ Refresh table (if using table UI)
            loadCart();
        }

    }catch(Exception e){
        e.printStackTrace();
    }
}

    void loadCart(){
        model.setRowCount(0);

        for(String i:Cart.getItems()){
            String[] p = i.split(",");
            model.addRow(new Object[]{p[0],p[1]});
        }
    }

    void placeOrder(){

        if(Cart.getItems().isEmpty()){
            JOptionPane.showMessageDialog(this,"Cart Empty");
            return;
        }

        int total = 0;
        for(String i:Cart.getItems())
            total += Integer.parseInt(i.split(",")[1]);

        String token = generateToken();

        String order = token + " | " + username + " | " + Cart.getItems() + " | ₹" + total;

        FileManager.saveOrder(order);

        JOptionPane.showMessageDialog(this,
                "Order Placed\nToken: "+token+"\nTotal ₹"+total);

        Cart.clear();
        loadCart();
    }
}
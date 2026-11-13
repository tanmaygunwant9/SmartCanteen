package ui;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class MenuManagerUI extends JFrame {

    JFrame prev;

    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> list = new JList<>(model);

    JTextField name = new JTextField();
    JTextField price = new JTextField();

    public MenuManagerUI(JFrame p){
        prev = p;

        setTitle("Menu Manager");
        setSize(400,400);
        setLocationRelativeTo(null);

        loadMenu();

        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");
        JButton back = new JButton("Back");

        setLayout(new BorderLayout());

        add(new JScrollPane(list),BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(4,2));
        panel.add(new JLabel("Name"));
        panel.add(name);
        panel.add(new JLabel("Price"));
        panel.add(price);
        panel.add(add);
        panel.add(remove);
        panel.add(back);

        add(panel,BorderLayout.SOUTH);

        add.addActionListener(e -> addFood());
        remove.addActionListener(e -> removeFood());
        back.addActionListener(e -> { prev.setVisible(true); dispose(); });

        setVisible(true);
    }

    void loadMenu(){
        model.clear();
        try(BufferedReader br = new BufferedReader(new FileReader("data/menu.txt"))){
            String line;
            while((line = br.readLine()) != null) model.addElement(line);
        }catch(Exception e){}
    }

    void addFood(){
        try(FileWriter fw = new FileWriter("data/menu.txt",true)){
            fw.write(name.getText()+","+price.getText()+"\n");
        }catch(Exception e){}
        loadMenu();
    }

    void removeFood(){
        String sel = list.getSelectedValue();
        if(sel == null) return;

        ArrayList<String> items = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("data/menu.txt"))){
            String line;
            while((line = br.readLine()) != null)
                if(!line.equals(sel)) items.add(line);
        }catch(Exception e){}

        try(FileWriter fw = new FileWriter("data/menu.txt")){
            for(String s:items) fw.write(s+"\n");
        }catch(Exception e){}

        loadMenu();
    }
}
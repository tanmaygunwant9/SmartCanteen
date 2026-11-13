
package model;

import java.util.ArrayList;

public class Cart {

    static ArrayList<String> items = new ArrayList<>();

    public static void addItem(String item){
        items.add(item);
    }

    public static void removeItem(String item){
        items.remove(item);
    }

    public static ArrayList<String> getItems(){
        return items;
    }

    public static void clear(){
        items.clear();
    }
}

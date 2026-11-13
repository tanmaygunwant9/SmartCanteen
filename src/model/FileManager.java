
package model;

import java.io.*;

public class FileManager {

    static String studentFile = System.getProperty("user.dir") + "/data/students.txt";
    static String orderFile = System.getProperty("user.dir") + "/data/orders.txt";

    public static void registerStudent(String name,String password){

        try{

            File file = new File(studentFile);

            if(!file.exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file,true);
            fw.write(name.trim() + "," + password.trim() + System.lineSeparator());
            fw.close();

            System.out.println("Student saved successfully");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean loginStudent(String name,String password){

        try{

            BufferedReader br = new BufferedReader(new FileReader(studentFile));
            String line;

            while((line = br.readLine()) != null){

                if(line.trim().isEmpty()) continue;

                String[] data = line.split(",");

                if(data.length < 2) continue;

                String fileUser = data[0].trim();
                String filePass = data[1].trim();

                if(fileUser.equals(name.trim()) && filePass.equals(password.trim())){
                    br.close();
                    return true;
                }

            }

            br.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public static void saveOrder(String order){

        try{

            FileWriter fw = new FileWriter(orderFile,true);
            fw.write(order + System.lineSeparator());
            fw.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

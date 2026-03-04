package FileReading;

import java.io.*;

class User {
    int id;
    String name;
    String email;

    User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String toString() {
        return id + " " + name + " " + email;
    }
}


public class FileReader1 {

    private static final String COMMA_DELIMITER = "," ;

    public static void main(String[] args) throws Exception {

        //Read file form the resourse
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (FileReader1.class.getClassLoader().getResourceAsStream("data.txt")));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        //Read CSV files.
        BufferedReader readercsv = new BufferedReader(new InputStreamReader
                (FileReader1.class.getClassLoader().getResourceAsStream("data1.csv")));

        String linecsv;
        String[] words;
        readercsv.readLine();

        while((linecsv=readercsv.readLine())!=null){
            words=linecsv.split(COMMA_DELIMITER);
            int id = Integer.parseInt(words[0]);
            String name= words[1];
            String email= words[2];
            if(email.contains("@")) {
                User user = new User(id, name, email);
                System.out.println(user);
            }else{
                System.out.println("enter valid email");
            }
        }



    }
}
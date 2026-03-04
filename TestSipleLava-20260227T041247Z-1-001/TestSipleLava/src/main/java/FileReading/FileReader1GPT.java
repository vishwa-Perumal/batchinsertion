
package FileReading;

import java.io.*;

class User1 {
    int id;
    String name;
    String email;

    User1(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String toString() {
        return id + " " + name + " " + email;
    }
}

public class FileReader1GPT {

    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) throws Exception {

        // -------- TEXT FILE --------
        try (BufferedReader reader = createReader("data.txt")) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        // -------- CSV FILE --------
        try (BufferedReader readerCsv = createReader("data1.csv")) {

            String line;
            readerCsv.readLine(); // skip header

            while ((line = readerCsv.readLine()) != null) {

                String[] words = line.split(COMMA_DELIMITER);

                if (words.length < 3) {
                    System.out.println("Invalid CSV line: " + line);
                    continue;
                }

                try {
                    int id = Integer.parseInt(words[0].trim());
                    String name = words[1].trim();
                    String email = words[2].trim();

                    if (!email.contains("@")) {
                        System.out.println("Invalid email: " + email);
                        continue;
                    }

                    User1 user1 = new User1(id, name, email);
                    System.out.println(user1);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID: " + line);
                }
            }
        }
    }

    private static BufferedReader createReader(String fileName) {
        InputStream is = FileReader1GPT.class
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (is == null) {
            throw new RuntimeException(fileName + " not found in classpath");
        }

        return new BufferedReader(new InputStreamReader(is));
    }
}
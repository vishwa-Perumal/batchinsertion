package FileReading.FileWrithing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCsvFile {

    public static void main(String[] args) {

        String filePath = "C:/Newfolder/users.csv";

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(filePath))) {

            // Header
            writer.write("id,name,email");
            writer.newLine();

            // Rows
            writer.write("1,Alice,alice@mail.com");
            writer.newLine();

            writer.write("2,Bob,bob@mail.com");
            writer.newLine();

            writer.write("3,Charlie,charlie@mail.com");
            writer.newLine();

            System.out.println("CSV file written successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

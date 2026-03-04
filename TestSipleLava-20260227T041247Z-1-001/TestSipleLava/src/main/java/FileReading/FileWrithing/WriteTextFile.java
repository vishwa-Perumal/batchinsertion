package FileReading.FileWrithing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFile {

    public static void main(String[] args) {

        String filePath = "C:/Newfolder/output.txt";

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(filePath))) {

            writer.write("Hello");
            writer.newLine();

            writer.write("This is a text file");
            writer.newLine();

            writer.write("Java file writing is simple");
            writer.newLine();

            System.out.println("Text file written successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

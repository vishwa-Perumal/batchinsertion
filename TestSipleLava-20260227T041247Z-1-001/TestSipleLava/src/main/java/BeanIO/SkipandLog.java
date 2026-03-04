package BeanIO;

import org.beanio.BeanReader;
import org.beanio.InvalidRecordException;
import org.beanio.StreamFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

public class SkipandLog {

        public static void main(String[] args) throws Exception {

            InputStream mappingStream =
                             SkipandLog.class
                            .getClassLoader()
                            .getResourceAsStream("mapping.xml");

            StreamFactory factory = StreamFactory.newInstance();
            factory.load(mappingStream);

            BeanReader reader = factory.createReader(
                    "userStream",
                    new File("C:/Newfolder/users.csv")
            );

            PrintWriter errorWriter =
                    new PrintWriter(new FileWriter("C:/Newfolder/error.csv"));

            int successCount = 0;
            int errorCount = 0;

            try {
                Object record;

                while (true) {
                    try {
                        record = reader.read();

                        if (record == null) {
                            break; // end of file
                        }

                        if (record instanceof User) {
                            User user = (User) record;
                            System.out.println("VALID: " + user);
                            successCount++;
                        }

                    } catch (InvalidRecordException e) {

                        errorCount++;

                        // Log raw invalid row
                        errorWriter.println(e.getRecordContext().getRecordText());

                        System.out.println("INVALID ROW SKIPPED");
                    }
                }
            } finally {
                reader.close();
                errorWriter.close();
            }

            System.out.println("SUCCESS: " + successCount);
            System.out.println("FAILED: " + errorCount);
    }

}

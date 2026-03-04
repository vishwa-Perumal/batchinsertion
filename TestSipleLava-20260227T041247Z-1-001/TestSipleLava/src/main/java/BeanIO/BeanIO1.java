package BeanIO;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class BeanIO1 {

    public static void main(String[] args) throws IOException {

        InputStream mappingStream =
                BeanIO1.class
                        .getClassLoader()
                        .getResourceAsStream("mapping.xml");

        if (mappingStream == null) {
            throw new RuntimeException("mapping.xml not found in classpath");
        }
        StreamFactory factory = StreamFactory.newInstance();
        factory.load(mappingStream);

        BeanReader reader = factory.createReader(
                "userStream",
                new File("C:/Newfolder/users.csv")
        );

        Object record;
        while ((record = reader.read()) != null) {
            User user = (User) record;
            System.out.println(user);
        }
        reader.close();
    }
}
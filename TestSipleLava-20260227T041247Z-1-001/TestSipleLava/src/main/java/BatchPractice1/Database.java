package BatchPractice1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database {

    private static Connection con;

    static {
        try {
            Properties prop = new Properties();

            InputStream io = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("application.properties");

            if (io == null) {
                throw new RuntimeException("application.properties NOT found in classpath");
            }

            prop.load(io);

            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            String driver = prop.getProperty("driver");

            System.out.println("URL = " + url);
            System.out.println("USER = " + username);
            System.out.println("DRIVER = " + driver);

            Class.forName(driver);

            con = DriverManager.getConnection(url, username, password);

            System.out.println("DB connection created successfully");

        } catch (Exception e) {
            e.printStackTrace(); //

        }
    }

    public static Connection getConnection() {
        return con;
    }
}
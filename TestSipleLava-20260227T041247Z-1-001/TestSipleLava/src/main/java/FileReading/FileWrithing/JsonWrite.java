package FileReading.FileWrithing;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

class User {
    private int id;
    private String name;
    private String email;

    public User() {}  // required

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

public class JsonWrite {


    public static void main(String[] args) throws Exception {

        User user = new User(10, "Alice", "alice@mail.com");

        ObjectMapper mapper = new ObjectMapper();

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(
                        new File("C:/Newfolder/user.json"),
                        user
                );

        System.out.println("JSON file written");
    }

}

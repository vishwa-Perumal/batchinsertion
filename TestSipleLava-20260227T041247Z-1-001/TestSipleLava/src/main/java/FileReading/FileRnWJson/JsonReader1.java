package FileReading.FileRnWJson;

import FileReading.FileReader1;
import FileReading.FileReader1GPT;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

class Address{
    String street;
    String city;
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}

class Person{
    String firstName;
    String secondName;
    List<Address> address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String toString(){
        return getFirstName()+" "+getSecondName()+" "+getAddress();
    }

}

public class JsonReader1 {

    public static void main (String[]args) throws IOException {

        ObjectMapper objMap = new ObjectMapper();
        BufferedReader reader = new BufferedReader(new InputStreamReader
                (FileReader1.class.getClassLoader().getResourceAsStream("employe.json")));

        Person person =objMap.readValue(reader, Person.class);
        System.out.println(person.getFirstName());
    }

}

package SerializationAndDeserialization;

import java.io.*;

public class SerializationPractice {
    public static void main(String[] args) throws IOException {
        User user = new User();
        FileOutputStream fos = new FileOutputStream("data.ser"); // here data is file name to store object data and create file name and its extension is .ser
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);
        oos.close();
        fos.close();
    }
}

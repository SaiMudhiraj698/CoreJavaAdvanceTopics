package SerializationAndDeserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserilizationPractice {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = null;
        FileInputStream fis = new FileInputStream("data.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        user=(User) ois.readObject();
        ois.close();
        fis.close();
        System.out.println(user.name);
        System.out.println(user.password);
    }
}
